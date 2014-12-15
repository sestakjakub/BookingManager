package cz.muni.fi.pa165.bookingmanager.webapp;

import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.HotelService;
import cz.muni.fi.pa165.bookingmanager.api.service.RoomService;
import java.util.ArrayList;
import java.util.Arrays;
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
public class HotelController {

    @Autowired
    HotelService hotelService;
    
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

    @ModelAttribute("hotels")
    public List<HotelDTO> allHotels() {
        // TESTING TESTING TESTING TESTING TESTING
        HotelDTO hotel1 = new HotelDTO();
        hotel1.setName("Testovací hotel");
        hotel1.setAddress("Ultimátní adresa");
        hotel1.setPhoneNumber("123 456 222");

        hotelService.addHotel(hotel1);
        
        return hotelService.getAllHotels();
    }
}
