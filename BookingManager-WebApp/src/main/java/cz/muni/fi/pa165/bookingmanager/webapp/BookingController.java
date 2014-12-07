package cz.muni.fi.pa165.bookingmanager.webapp;

import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.BookingService;
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

    //list bookings of room
    @RequestMapping("/room-booking/{id}")
    public String roomBooking(String name, Model model) {

        return "booking-list";
    }

    //add booking to room with specific id
    @RequestMapping("/room-booking/add/{id}")
    public String addBooking(String name, Model model) {

        return "booking-edit";
    }

    //edit booking with specific id
    @RequestMapping("/room-booking/edit/{id}")
    public String editBooking(String name, Model model) {

        return "booking-edit";
    }

    //delete booking with specific id
    @RequestMapping("/room-booking/delete/{id}")
    public String deleteBooking(String name, Model model) {

        return "redirect:";
    }
    
    @ModelAttribute("bookings")
    public List<BookingDTO> allBookings() {
        // TESTING TESTING TESTING TESTING TESTING
        List<BookingDTO> bookings = new ArrayList<BookingDTO>();
        BookingDTO booking = new BookingDTO();
        booking.setDateFrom(new Date(1000));
        booking.setDateTo(new Date(1200));
        bookings.add(booking);
        bookings.add(booking);
        bookings.add(booking);
        bookings.add(booking);
        bookings.add(booking);
        bookings.add(booking);
        bookings.add(booking);
        bookings.add(booking);
        // TESTING TESTING TESTING TESTING TESTING
        return bookings;//roomService.getAllRooms();
    }
}
