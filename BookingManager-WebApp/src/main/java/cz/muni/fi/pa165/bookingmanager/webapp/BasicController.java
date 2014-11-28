package cz.muni.fi.pa165.bookingmanager.webapp;

import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.HotelService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Jiří Kareš
 */
@Controller
public class BasicController {
    
//    @Autowired
//    HotelService hotelService;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false, defaultValue = ">>>>>>>>co takhle: /?name=cokoliv") String name, Model model) {
        model.addAttribute("name", name);
        return "helloworld";
    }
    
    @RequestMapping("/hotels")
    public String hotels(String name, Model model) {
        
        return "hotels";
    }
    
    @RequestMapping("/hotel")
    public String hotel(String name, Model model) {
  
        return "hotel";
    }
    
    @RequestMapping("/room")
    public String roomBooking(String name, Model model) {
  
        return "roomBooking";
    }
    
    @ModelAttribute("hotels")
    public List<HotelDTO> allHotels() {
        // TESTING TESTING TESTING TESTING TESTING
        List<HotelDTO> hotels = new ArrayList<HotelDTO>();
        hotels.add(new HotelDTO());
        hotels.add(new HotelDTO());
        hotels.add(new HotelDTO());
        hotels.add(new HotelDTO());
        hotels.add(new HotelDTO());
        hotels.add(new HotelDTO());
        hotels.add(new HotelDTO());
        hotels.add(new HotelDTO());
        return hotels;//hotelService.getAllHotels();
    }
}
