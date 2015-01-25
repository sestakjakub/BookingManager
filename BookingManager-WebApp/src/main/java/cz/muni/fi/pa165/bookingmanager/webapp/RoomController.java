package cz.muni.fi.pa165.bookingmanager.webapp;

import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.HotelService;
import cz.muni.fi.pa165.bookingmanager.api.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        RoomFormular roomForm = new RoomFormular();
        roomForm.setId(roomId);
        roomForm.setHotelId(hotelId);
        model.addAttribute("roomForm", roomForm);
        return "room-edit";
    }

    @RequestMapping(value = "/room/edit/submit", method = RequestMethod.POST)
    public String submit(@ModelAttribute RoomFormular roomForm, UriComponentsBuilder uriBuilder) {
        if (roomForm.getId() == 0) {
            RoomDTO room = new RoomDTO();
            room.setHotel(hotelService.findHotel(roomForm.getHotelId()));
            roomForm.modifyDTO(room);
            roomService.addRoom(room);
        } else {
            RoomDTO room = roomService.find(roomForm.getId());
            roomForm.modifyDTO(room);
            roomService.updateRoom(room);
        }
        
        return "redirect:" + uriBuilder.path("/rooms").queryParam("hotelId", roomForm.getHotelId()).build();
    }

    @RequestMapping(value = "/room/delete", method = RequestMethod.POST)
    public String delete(@RequestParam long roomId, UriComponentsBuilder uriBuilder, Model model) {
        RoomDTO room = roomService.find(roomId);
        System.out.println(room.getId());
        model.addAttribute("hotelId", room.getHotel().getId());
        roomService.deleteRoom(room);
        System.out.println(roomService.getAllRooms().size());
        return "redirect:" + uriBuilder.path("/rooms").build();
    }
}
