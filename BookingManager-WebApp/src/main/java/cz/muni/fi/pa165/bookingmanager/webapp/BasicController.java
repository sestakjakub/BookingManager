package cz.muni.fi.pa165.bookingmanager.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Jiří Kareš
 */
@Controller
public class BasicController {

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false, defaultValue = ">>>>>>>>co takhle: /?name=cokoliv") String name, Model model) {
        model.addAttribute("name", name);
        return "helloworld";
    }
}
