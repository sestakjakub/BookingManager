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
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/bookings")
    public String bookings(@RequestParam long roomId, Model model) {
        model.addAttribute("room", roomService.find(roomId));
        return "booking-list";
    }

    @RequestMapping("/booking/edit")
    public String editBooking(@RequestParam long roomId, @RequestParam long bookingId, Model model) {
        
        model.addAttribute("roomId", roomId);
        model.addAttribute("bookingId", bookingId);
        return "booking-edit";
    }

    @RequestMapping(value = "/booking/edit/submit", method = RequestMethod.POST)
    public String submitBooking(@RequestParam long bookingId, @RequestParam long roomId,
            @RequestParam long customerId, @RequestParam int dateFrom,
            @RequestParam int dateTo, UriComponentsBuilder uriBuilder) {

        BookingDTO booking = new BookingDTO();
        booking.setId(bookingId);
        booking.setRoom(roomService.find(roomId));
        booking.setCustomer(customerService.findCustomer(customerId));
        booking.setDateFrom(new Date(dateFrom));
        booking.setDateTo(new Date(dateTo));

        if (bookingId == 0) {
            bookingService.addBooking(booking);
        } else {
            bookingService.updateBooking(booking);
        }

        return "redirect:" + uriBuilder.path("/bookings").queryParam("roomId", roomId).build();
    }

    @RequestMapping("/booking/delete/{id}")
    public String deleteBooking(@PathVariable long id, UriComponentsBuilder uriBuilder, Model model) {
        System.out.println("Deleting booking with id: " + id);
        BookingDTO booking = bookingService.findBooking(id);
        
        if (booking != null)
            System.out.println("Booking found");
        
        RoomDTO room = booking.getRoom();
        
        if (room != null)
            System.out.println("Corresponding room found with id: " + room.getId());
        
        bookingService.deleteBooking(booking);
        return "redirect:" + uriBuilder.path("/bookings").queryParam("roomId", room.getId()).build();
    }
}
