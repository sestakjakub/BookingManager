package cz.muni.fi.pa165.bookingmanager.webapp;

import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.HotelService;
import cz.muni.fi.pa165.bookingmanager.api.service.RoomService;
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
    
//    @Autowired
//    RoomService roomService;
    
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
}
