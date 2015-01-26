/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.ws.endpoint;

import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.HotelService;
import cz.muni.fi.pa165.bookingmanager.api.service.impl.HotelServiceImpl;
import cz.muni.fi.pa165.bookingmanager.ws.generated.AddHotelRequest;
import cz.muni.fi.pa165.bookingmanager.ws.generated.EditHotelRequest;
import cz.muni.fi.pa165.bookingmanager.ws.generated.GetAllHotelRequest;
import cz.muni.fi.pa165.bookingmanager.ws.generated.GetAllHotelResponse;
import cz.muni.fi.pa165.bookingmanager.ws.generated.Hotel;
import cz.muni.fi.pa165.bookingmanager.ws.generated.Hotels;
import cz.muni.fi.pa165.bookingmanager.ws.generated.RemoveHotelRequest;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author Robert
 */
@Endpoint
public class HotelEndpoint {

    private static final String NAMESPACE_URI = "myTargetNamespace";
    
    @Autowired
    HotelService hotelService;

    public HotelService getHotelService() {
        return hotelService;
    }

    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddHotelRequest")
    public void handleAddHotelRequest(@RequestPayload AddHotelRequest addHotelRequest){
        
        System.out.println("Processing handle add hotel request");
        
        Hotel hotel = addHotelRequest.getHotel();
        
        String hotelName = hotel.getName();
        String hotelAddress = hotel.getAddress();
        String hotelPhoneNumber = hotel.getPhoneNumber();

        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setName(hotelName);
        hotelDTO.setAddress(hotelAddress);
        hotelDTO.setPhoneNumber(hotelPhoneNumber);
        
        if (hotelService == null){
            System.out.println("Hotel service is null");
        } else {
        
            System.out.println("Hotel service isn't null");
        }
        hotelService.addHotel(hotelDTO);
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllHotelRequest")
    public @ResponsePayload GetAllHotelResponse handleGetAllHotels(@RequestPayload GetAllHotelRequest getAllHotelsRequest){

        List<HotelDTO> hotelDTOList = hotelService.getAllHotels();

        Hotels hotels = new Hotels();
        
        for (HotelDTO hotelDTO: hotelDTOList){
            
            Hotel hotel = new Hotel();
            hotel.setId(BigInteger.valueOf(hotelDTO.getId()));
            hotel.setName(hotelDTO.getName());
            hotel.setAddress(hotelDTO.getAddress());
            hotel.setPhoneNumber(hotelDTO.getPhoneNumber());
            
            hotels.getHotel().add(hotel);
        }
        GetAllHotelResponse getAllHotelResponse = new GetAllHotelResponse();
        getAllHotelResponse.setHotels(hotels);
        
        return getAllHotelResponse;
    }
    
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EditHotelRequest")
    public void handleEditHotelRequest(@RequestPayload EditHotelRequest editHotelRequest){

        long hotelId = editHotelRequest.getHotel().getId().longValue();
        
        HotelDTO hotelDTO = hotelService.findHotel(hotelId);
        
        Hotel hotel = editHotelRequest.getHotel();
        
        String hotelName = hotel.getName();
        String hotelAddress = hotel.getAddress();
        String hotelPhoneNumber = hotel.getPhoneNumber();

        hotelDTO.setName(hotelName);
        hotelDTO.setAddress(hotelAddress);
        hotelDTO.setPhoneNumber(hotelPhoneNumber);

        hotelService.updateHotel(hotelDTO);
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RemoveHotelRequest")
    public void handleDeleteHotelRequest(@RequestPayload RemoveHotelRequest removeHotelRequest){

        long hotelId = removeHotelRequest.getHotel().getId().longValue();
        
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setId(hotelId);
        
        hotelService.deleteHotel(hotelDTO);
    }
    
}
