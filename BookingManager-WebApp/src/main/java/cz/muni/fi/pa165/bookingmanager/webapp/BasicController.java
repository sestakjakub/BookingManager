package cz.muni.fi.pa165.bookingmanager.webapp;

import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
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
public class BasicController {

//    @Autowired
//    HotelService hotelService;
    
//    @Autowired
//    RoomService roomService;
    
    //list all hotels
    @RequestMapping("/hotels")
    public String hotels(String name, Model model) {

        return "hotel-list";
    }
    
    //edit hotel with specific id
    @RequestMapping(value = "/hotel/edit/{id}", method = RequestMethod.GET)
    public String update_form(@PathVariable long id, Model model) {
        HotelDTO hotel1 = new HotelDTO();
        hotel1.setName("Testovací hotel");
        hotel1.setAddress("Ultimátní adresa");
        hotel1.setPhoneNumber("123 456 222");
        model.addAttribute("hotel", hotel1);
        return "hotel-edit";
    }
    
    //new hotel
    @RequestMapping("/hotel/add")
    public String editHotel(String name, Model model) {
        
        return "hotel-edit";
    }
    
    //delete hotel by id
    @RequestMapping(value = "/hotel/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, RedirectAttributes redirectAttributes, Locale locale, UriComponentsBuilder uriBuilder) {
//        Book book = bookService.getBook(id);
//        bookService.deleteBook(book);
//        redirectAttributes.addFlashAttribute(
//                "message",
//                messageSource.getMessage("book.delete.message", new Object[]{book.getTitle(), book.getAuthor(), book.getId()}, locale)
//        );
        return "redirect:" + uriBuilder.path("/hotel").build();
    }

    
    //list rooms of hotel with specific id
    @RequestMapping("/rooms/{id}")
    public String rooms(String name, Model model) {

        return "room-list";
    }

    
    //new room to hotel with specific id
    @RequestMapping("/room/add/{id}")
    public String addRoom(String name, Model model) {
        
        return "room-edit";
    }
    
    //edit room with specific id
    @RequestMapping("/room/edit/{id}")
    public String editRoom(String name, Model model) {
        
        return "room-edit";
    }
    
    //delete room with specific id
    @RequestMapping("/room/delete/{id}")
    public String deleteRoom(String name, Model model) {
        return "redirect:";
    }

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
    
    @ModelAttribute("hotels")
    public List<HotelDTO> allHotels() {
        // TESTING TESTING TESTING TESTING TESTING
        List<HotelDTO> hotels = new ArrayList<HotelDTO>();
        HotelDTO hotel1 = new HotelDTO();
        hotel1.setName("Testovací hotel");
        hotel1.setAddress("Ultimátní adresa");
        hotel1.setPhoneNumber("123 456 222");
        hotels.add(hotel1);
        hotels.add(hotel1);
        hotels.add(hotel1);
        hotels.add(hotel1);
        hotels.add(hotel1);
        hotels.add(hotel1);
        hotels.add(hotel1);
        hotels.add(hotel1);
        // TESTING TESTING TESTING TESTING TESTING
        return hotels;//hotelService.getAllHotels();
    }

    @ModelAttribute("rooms")
    public List<RoomDTO> allRooms() {
        // TESTING TESTING TESTING TESTING TESTING
        List<RoomDTO> rooms = new ArrayList<RoomDTO>();
        RoomDTO room = new RoomDTO();
        room.setCapacity(2);
        room.setPrice(600);
        room.setRoomNumber(303);
        rooms.add(room);
        rooms.add(room);
        rooms.add(room);
        rooms.add(room);
        rooms.add(room);
        rooms.add(room);
        rooms.add(room);
        rooms.add(room);
        // TESTING TESTING TESTING TESTING TESTING
        return rooms;//roomService.getAllRooms();
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
