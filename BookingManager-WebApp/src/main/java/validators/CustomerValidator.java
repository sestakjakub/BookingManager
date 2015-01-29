/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import cz.muni.fi.pa165.bookingmanager.webapp.CustomerFormular;
import cz.muni.fi.pa165.bookingmanager.webapp.RoomFormular;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Jana
 */
public class CustomerValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return CustomerFormular.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CustomerFormular customer = (CustomerFormular) o;
        
        ValidationUtils.rejectIfEmpty(errors, "name", "customer.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "address", "customer.address.empty");
        ValidationUtils.rejectIfEmpty(errors, "username", "customer.username.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "customer.password.empty");
                
        if(customer.getPassword().length() < 6){
            errors.rejectValue("customer", "room.password.tooShort");            
        }
    }
    
    
    
}
