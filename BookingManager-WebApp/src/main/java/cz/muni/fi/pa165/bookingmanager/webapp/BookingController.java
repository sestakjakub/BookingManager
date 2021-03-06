package cz.muni.fi.pa165.bookingmanager.webapp;

import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.BookingService;
import cz.muni.fi.pa165.bookingmanager.api.service.CustomerService;
import cz.muni.fi.pa165.bookingmanager.api.service.HotelService;
import cz.muni.fi.pa165.bookingmanager.api.service.RoomService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Jiří Kareš
 */
@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;
    @Autowired
    RoomService roomService;
    @Autowired
    CustomerService customerService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/bookings")
    public String bookings(@RequestParam long roomId, Model model) {
        model.addAttribute("room", roomService.find(roomId));
        return "booking-list";
    }

    @RequestMapping("/booking/edit")
    public String editBooking(@RequestParam long roomId, @RequestParam long bookingId, Model model) {
        BookingFormular bookingForm;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomerDTO customerDTO = customerService.findCustomer(auth.getName());
        if (bookingId == 0) {
            bookingForm = new BookingFormular();
            bookingForm.setRoomId(roomId);
            bookingForm.setCustomerId(customerDTO.getId());
        }
        else
        {
            bookingForm = new BookingFormular(bookingService.findBooking(bookingId));
        }
        model.addAttribute("bookingForm", bookingForm);
        return "booking-edit";
    }

    @RequestMapping(value = "/booking/edit/submit", method = RequestMethod.POST)
    public String submitBooking(@Valid @ModelAttribute BookingFormular bookingForm, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        BookingDTO bookingDTO;
        if (bookingForm.getId() == 0) {
            bookingDTO = new BookingDTO();
            bookingForm.modifyDTO(bookingDTO, roomService, customerService);
            if (roomService.isAvailable(bookingDTO.getDateFrom(), bookingDTO.getDateTo(), bookingDTO.getRoom()))
            {
                bookingService.addBooking(bookingDTO);
                redirectAttributes.addFlashAttribute("message", messageSource.getMessage("booking.add.message", new Object[]{}, Locale.US));
            }
            else
                redirectAttributes.addFlashAttribute("error", messageSource.getMessage("booking.add.error", new Object[]{}, Locale.US));
        } else {
            bookingDTO = bookingService.findBooking(bookingForm.getId());
            bookingForm.modifyDTO(bookingDTO, roomService, customerService);
            if (roomService.isAvailable(bookingDTO.getDateFrom(), bookingDTO.getDateTo(), bookingDTO.getRoom()))
            {
                bookingService.updateBooking(bookingDTO);
                redirectAttributes.addFlashAttribute("message", messageSource.getMessage("booking.add.message", new Object[]{}, Locale.US));
            }
            else
                redirectAttributes.addFlashAttribute("error", messageSource.getMessage("booking.add.error", new Object[]{}, Locale.US));
        }

        return "redirect:" + uriBuilder.path("/bookings").queryParam("roomId", bookingForm.getRoomId()).build();
    }

    @RequestMapping("/booking/delete/{id}")
    public String deleteBooking(@PathVariable long id, UriComponentsBuilder uriBuilder, Model model) {
        BookingDTO booking = bookingService.findBooking(id);
        RoomDTO room = booking.getRoom();
        bookingService.deleteBooking(booking);
        return "redirect:" + uriBuilder.path("/bookings").queryParam("roomId", room.getId()).build();
    }
}
