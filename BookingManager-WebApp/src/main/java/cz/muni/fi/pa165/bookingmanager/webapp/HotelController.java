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

    @RequestMapping("/hotels")
    public String hotels(String name, Model model) {

        return "hotel-list";
    }

    @RequestMapping(value = "/hotel/edit/{id}", method = RequestMethod.GET)
    public String editHotel(@PathVariable long id, Model model) {
        HotelDTO hotel = hotelService.getHotelById(id);
        model.addAttribute("hotel", hotel);
        return "hotel-edit";
    }

    @RequestMapping(value = "/hotel/edit", method = RequestMethod.GET)
    public String editHotel(Model model) {
        HotelDTO hotel = new HotelDTO();
        model.addAttribute("hotel", hotel);
        return "hotel-edit";
    }
    
    @RequestMapping(value = "/hotel/edit/submit", method = RequestMethod.POST)
    public String submitHotel(@ModelAttribute HotelDTO hotel, UriComponentsBuilder uriBuilder) {
        
        if(hotel.getId() == 0)
            hotelService.addHotel(hotel);
        else
            hotelService.updateHotel(hotel);
        
        return "redirect:" + uriBuilder.path("/hotels").build();
    }

    @RequestMapping(value = "/hotel/delete/{id}", method = RequestMethod.POST)
    public String deleteHotel(@PathVariable long id, UriComponentsBuilder uriBuilder) {
        
        HotelDTO hotel = hotelService.getHotelById(id);
        hotelService.deleteHotel(hotel);
        return "redirect:" + uriBuilder.path("/hotels").build();
    }

    @ModelAttribute("hotels")
    public List<HotelDTO> allHotels() {
        return hotelService.getAllHotels();
    }
}
