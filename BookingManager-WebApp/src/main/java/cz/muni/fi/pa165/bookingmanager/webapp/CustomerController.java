package cz.muni.fi.pa165.bookingmanager.webapp;

import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.CustomerService;
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
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/customers")
    public String customers() {

        return "customer-list";
    }
    
    @RequestMapping(value = "/customer/register", method = RequestMethod.GET)
    public String registerCustomer(@RequestParam long customerId, Model model) {
        CustomerFormular customerForm = new CustomerFormular();
        model.addAttribute("customerForm", customerForm);
        return "customer-edit";
    }

    @RequestMapping(value = "/customer/edit", method = RequestMethod.GET)
    public String editCustomer(@RequestParam long customerId, Model model) {
        
        model.addAttribute("customerId", customerId);
        return "customer-edit";
    }

    @RequestMapping(value = "/customer/edit/submit", method = RequestMethod.POST)
    public String submitCustomer(@ModelAttribute CustomerFormular customerForm,
            UriComponentsBuilder uriBuilder) {
        CustomerDTO customer = customerService.findCustomer(customerForm.getId());
        if (customer == null) {
            customer = new CustomerDTO();
            customer.setEnabled(true);
            if (customerService.getAllCustomers() == null)
                customer.setRole("ROLE_ADMIN");
            else
                customer.setRole("ROLE_USER");
            customerForm.modifyDTO(customer);
            customerService.addCustomer(customer);
        } else {
            customerForm.modifyDTO(customer);
            customerService.updateCustomer(customer);
        }
        
        return "redirect:" + uriBuilder.path("/").build();
    }

    @RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.POST)
    public String deleteHotel(@PathVariable long id, UriComponentsBuilder uriBuilder) {

        try {
            customerService.deleteCustomer(customerService.findCustomer(id));
        } catch (IllegalArgumentException ex) {
            //Show some error
        }

        return "redirect:" + uriBuilder.path("/customers").build();
    }

    @ModelAttribute("customers")
    public List<CustomerDTO> allCustomers() {
        return customerService.getAllCustomers();
    }
}
