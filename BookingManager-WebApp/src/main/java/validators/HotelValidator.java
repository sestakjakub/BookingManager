/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.webapp.HotelFormular;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Jana
 */
public class HotelValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return HotelFormular.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        HotelFormular hotel = (HotelFormular) o;
        
        ValidationUtils.rejectIfEmpty(errors, "name", "hotel.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "address", "hotel.address.empty");
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "hotel.phoneNumber.empty");
        
        
        if(hotel.getPhoneNumber().length() < 5){
            errors.rejectValue("phoneNumber", "hotel.phoneNumber.short");            
        }
        
        
    }
    
}
