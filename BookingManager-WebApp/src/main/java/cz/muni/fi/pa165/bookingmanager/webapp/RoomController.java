package cz.muni.fi.pa165.bookingmanager.webapp;

import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.HotelService;
import cz.muni.fi.pa165.bookingmanager.api.service.RoomService;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;
import validators.RoomValidator;

/**
 *
 * @author Jiří Kareš
 */
@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private MessageSource messageSource;

    @InitBinder("roomFormular")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new RoomValidator());
    }
    
    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public String rooms(@RequestParam long hotelId, Model model) {
        model.addAttribute("hotel", hotelService.findHotel(hotelId));
        return "room-list";
    }

    @RequestMapping(value = "/room/edit", method = RequestMethod.GET)
    public String edit(@RequestParam long hotelId, @RequestParam long roomId, Model model) {
        RoomDTO room = roomService.find(roomId);
        RoomFormular roomForm;
        if (room == null) {
            roomForm = new RoomFormular();
            roomForm.setId(roomId);
            roomForm.setHotelId(hotelId);
        } else {
            roomForm = new RoomFormular(room);
        }
        model.addAttribute("roomForm", roomForm);
        return "room-edit";
    }

    @RequestMapping(value = "/room/edit/submit", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute RoomFormular roomForm, BindingResult bindingResult, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Model model, Locale locale) {
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("roomForm", roomForm);
            return "room-edit";
        }
        
        if (roomForm.getId() == 0) {
            RoomDTO room = new RoomDTO();
            room.setHotel(hotelService.findHotel(roomForm.getHotelId()));
            roomForm.modifyDTO(room);
            roomService.addRoom(room);
            redirectAttributes.addFlashAttribute(
                    "message",
                    messageSource.getMessage("hotel.add.message", new Object[]{room.getId(), room.getCapacity(), room.getPrice(), room.getRoomNumber()}, Locale.US)
            );
        } else {
            RoomDTO room = roomService.find(roomForm.getId());
            roomForm.modifyDTO(room);
            roomService.updateRoom(room);
            redirectAttributes.addFlashAttribute(
                    "message",
                    messageSource.getMessage("hotel.add.message", new Object[]{room.getId(), room.getCapacity(), room.getPrice(), room.getRoomNumber()}, Locale.US)
            );
        }

        return "redirect:" + uriBuilder.path("/rooms").queryParam("hotelId", roomForm.getHotelId()).build();
    }

    @RequestMapping(value = "/room/delete", method = RequestMethod.POST)
    public String delete(@RequestParam long roomId, UriComponentsBuilder uriBuilder, Model model) {
        RoomDTO room = roomService.find(roomId);
        System.out.println(room.getId());
        model.addAttribute("hotelId", room.getHotel().getId());
        roomService.deleteRoom(room);
        return "redirect:" + uriBuilder.path("/rooms").build();
    }
}
