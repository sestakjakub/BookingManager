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
public class RoomController {

    @Autowired
    RoomService roomService;

    //list rooms of hotel with specific id
    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.GET)
    public String rooms(@PathVariable long id, Model model) {
        model.addAttribute("hotelId", id);
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

    @ModelAttribute("rooms")
    public List<RoomDTO> allRooms() {
        return roomService.getAllRooms();
    }
}
