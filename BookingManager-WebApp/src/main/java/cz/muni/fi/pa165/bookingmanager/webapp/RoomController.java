package cz.muni.fi.pa165.bookingmanager.webapp;

import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.HotelService;
import cz.muni.fi.pa165.bookingmanager.api.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Jiří Kareš
 */
@Controller
public class RoomController {

    @Autowired
    RoomService roomService;
    @Autowired
    HotelService hotelService;

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public String rooms(@RequestParam long hotelId, Model model) {
        model.addAttribute("hotel", hotelService.findHotel(hotelId));
        return "room-list";
    }

    @RequestMapping(value = "/room/edit", method = RequestMethod.GET)
    public String edit(@RequestParam long hotelId, @RequestParam long roomId, Model model) {

        model.addAttribute("roomId", roomId);
        model.addAttribute("hotelId", hotelId);
        return "room-edit";
    }

    @RequestMapping(value = "/room/edit/submit", method = RequestMethod.POST)
    public String submit(@RequestParam long roomId, @RequestParam long hotelId,
            @RequestParam int roomNumber, @RequestParam int capacity,
            @RequestParam float price, UriComponentsBuilder uriBuilder) {
        
        RoomDTO room = new RoomDTO();
        room.setId(roomId);
        room.setCapacity(capacity);
        room.setPrice(price);
        room.setRoomNumber(roomNumber);
        room.setHotel(hotelService.findHotel(hotelId));
        
        if (roomId == 0) {
            roomService.addRoom(room);
        } else {
            roomService.updateRoom(room);
        }
        
        return "redirect:" + uriBuilder.path("/rooms").queryParam("hotelId", room.getHotel().getId()).build();
    }

    @RequestMapping(value = "/room/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, UriComponentsBuilder uriBuilder) {
        roomService.deleteRoom(roomService.find(id));
        return "redirect:" + uriBuilder.path("/rooms").build();
    }
}
