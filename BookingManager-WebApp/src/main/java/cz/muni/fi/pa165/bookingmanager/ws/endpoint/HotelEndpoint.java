/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.ws.endpoint;

import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.HotelService;
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

    private static final String NAMESPACE_URI = "http://muni.cz/pa165/soa";
    private XPath hotelsExpression;
    private XPath hotelExpression;
    private XPath hotelIdExpression;
    private XPath hotelNameExpression;
    private XPath hotelAddressExpression;
    private XPath hotelPhoneNumberExpression;
    @Autowired
    HotelService hotelService;

    public HotelEndpoint()
            throws JDOMException {

        Namespace namespace = Namespace.getNamespace("ns1", NAMESPACE_URI);

        hotelsExpression = XPath.newInstance("ns1:Hotels");
        hotelsExpression.addNamespace(namespace);

        hotelExpression = XPath.newInstance(hotelsExpression.getXPath() + "/Hotel");
        hotelExpression.addNamespace(namespace);

        hotelIdExpression = XPath.newInstance(hotelExpression.getXPath() + "/Id");
        hotelIdExpression.addNamespace(namespace);

        hotelNameExpression = XPath.newInstance(hotelExpression.getXPath() + "/Name");
        hotelNameExpression.addNamespace(namespace);

        hotelAddressExpression = XPath.newInstance(hotelExpression.getXPath() + "/Address");
        hotelAddressExpression.addNamespace(namespace);

        hotelPhoneNumberExpression = XPath.newInstance(hotelExpression.getXPath() + "/PhoneNumber");
        hotelPhoneNumberExpression.addNamespace(namespace);

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addHotelRequest")
    public void handleAddHotelRequest(@RequestPayload AddHotelRequest addHotelRequest)
            throws JDOMException {

        String hotelName = hotelNameExpression.valueOf(addHotelRequest);
        String hotelAddress = hotelAddressExpression.valueOf(addHotelRequest);
        String hotelPhoneNumber = hotelPhoneNumberExpression.valueOf(addHotelRequest);

        HotelDTO hotel = new HotelDTO();
        hotel.setName(hotelName);
        hotel.setAddress(hotelAddress);
        hotel.setPhoneNumber(hotelPhoneNumber);

        hotelService.addHotel(hotel);
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllHotels")
    @ResponsePayload
    public GetAllHotelResponse handleGetAllHotels(@RequestPayload GetAllHotelRequest getAllHotelsRequest)
            throws JDOMException {

        List<HotelDTO> hotelDTOList = hotelService.getAllHotels();

        Hotels hotels = new Hotels();
        
        for (HotelDTO hotelDTO: hotelDTOList){
            List<Hotel> hotelList = new ArrayList<>();
            
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
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "editHotelRequest")
    public void handleEditHotelRequest(@RequestPayload EditHotelRequest editHotelRequest)
            throws JDOMException {

        long hotelId = Long.parseLong(hotelIdExpression.valueOf(editHotelRequest));
        
        HotelDTO hotelDTO = hotelService.findHotel(hotelId);
        
        String hotelName = hotelNameExpression.valueOf(editHotelRequest);
        String hotelAddress = hotelNameExpression.valueOf(editHotelRequest);
        String hotelPhoneNumber = hotelNameExpression.valueOf(editHotelRequest);

        hotelDTO.setName(hotelName);
        hotelDTO.setAddress(hotelAddress);
        hotelDTO.setPhoneNumber(hotelPhoneNumber);

        hotelService.updateHotel(hotelDTO);
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeHotelRequest")
    public void handleDeleteHotelRequest(@RequestPayload RemoveHotelRequest removeHotelRequest)
            throws JDOMException {

        long hotelId = Long.parseLong(hotelIdExpression.valueOf(removeHotelRequest));
        
        HotelDTO hotelDTO = hotelService.findHotel(hotelId);
        
        hotelService.deleteHotel(hotelDTO);
    }
}
