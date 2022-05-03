package com.webServices.stayIn.stayInwebservices.Hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webServices.stayIn.stayInwebservices.beans.Hotel;

@RestController
public class HotelController {
	
	@Autowired
	private HotelDAOService hotelDAO ;
	
	@GetMapping(path = "/Hotels")
	public List<Hotel> getHotels(){
		return hotelDAO.getHotels();
	}

}
