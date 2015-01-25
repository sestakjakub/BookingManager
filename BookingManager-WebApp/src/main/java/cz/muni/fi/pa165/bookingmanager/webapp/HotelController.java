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
import javax.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;
import validators.HotelValidator;

/**
 *
 * @author Jiří Kareš
 */
@Controller
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private MessageSource messageSource;

    @InitBinder("hotelDTO")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new HotelValidator());
    }

    @RequestMapping("/")
    public String index() {

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @RequestMapping("/hotels")
    public String hotels() {

        return "hotel-list";
    }

    @RequestMapping(value = "/hotel/edit", method = RequestMethod.GET)
    public String editHotel(@RequestParam long hotelId, Model model) {
        HotelFormular hotelForm;
        if (hotelId == 0) {
            hotelForm = new HotelFormular();
        } else {
            hotelForm = new HotelFormular(hotelService.findHotel(hotelId));
        }

        model.addAttribute("hotelForm", hotelForm);
        return "hotel-edit";
    }

    @RequestMapping(value = "/hotel/edit/submit", method = RequestMethod.POST)
    public String submitHotel(@ModelAttribute HotelFormular hotelForm, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model, UriComponentsBuilder uriBuilder, Locale locale) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("hotelForm", hotelForm);
            return "hotel-edit";
        }
        if (hotelForm.getId() == 0) {
            HotelDTO hotel = new HotelDTO();
            hotelForm.modifyDTO(hotel);
            hotelService.addHotel(hotel);
            redirectAttributes.addFlashAttribute(
                    "message",
                    messageSource.getMessage("hotel.add.message", new Object[]{hotel.getId(), hotel.getAddress(), hotel.getName(), hotel.getPhoneNumber()}, Locale.US)
            );
        } else {
            HotelDTO hotel = hotelService.findHotel(hotelForm.getId());
            hotelForm.modifyDTO(hotel);
            hotelService.updateHotel(hotel);
            redirectAttributes.addFlashAttribute(
                    "message",
                    messageSource.getMessage("hotel.update.message", new Object[]{hotel.getId(), hotel.getAddress(), hotel.getName(), hotel.getPhoneNumber()}, Locale.US)
            );
        }

        return "redirect:" + uriBuilder.path("/hotels").build();
    }

    @RequestMapping(value = "/hotel/delete", method = RequestMethod.POST)
    public String deleteHotel(@RequestParam long hotelId, UriComponentsBuilder uriBuilder) {

        HotelDTO hotel = hotelService.findHotel(hotelId);
        hotelService.deleteHotel(hotel);
        return "redirect:" + uriBuilder.path("/hotels").build();
    }

    @ModelAttribute("hotels")
    public List<HotelDTO> allHotels() {
        return hotelService.getAllHotels();
    }
}
