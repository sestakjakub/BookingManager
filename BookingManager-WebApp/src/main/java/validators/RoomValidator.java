/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Jana
 */
public class RoomValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return RoomDTO.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RoomDTO room = (RoomDTO) o;
        
        ValidationUtils.rejectIfEmpty(errors, "roomNumber", "room.number.empty");
        ValidationUtils.rejectIfEmpty(errors, "capacity", "room.capacity.empty");
        ValidationUtils.rejectIfEmpty(errors, "price", "room.price.empty");
                
        if(room.getRoomNumber() < 0){
            errors.rejectValue("roomNumber", "room.roomNumber.negative");            
        }
        
        if(room.getCapacity() < 0){
            errors.rejectValue("capacity", "room.capacity.negative");            
        }
        
        if(room.getPrice() < 0){
            errors.rejectValue("price", "room.price.negative");            
        }
        
    }
    
    
}