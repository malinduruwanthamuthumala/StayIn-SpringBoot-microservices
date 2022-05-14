package com.webServices.stayIn.stayInwebservices.Hotel;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webServices.stayIn.stayInwebservices.beans.Hotel;
import com.webServices.stayIn.stayInwebservices.exception.UserNotFoundException;

@RestController
public class HotelController {
	
	@Autowired
	private HotelDAOService hotelDAO ;
	
	@GetMapping(path = "/Hotels")
	public List<Hotel> getHotels(){
		return hotelDAO.getHotels();
	}
	
	@GetMapping(path = "/Hotels/{id}")
	public Hotel findHotel(@PathVariable String id) throws NumberFormatException, UserNotFoundException {
		return hotelDAO.findHotel(Integer.valueOf(id).intValue());
	}
	
	@PostMapping("/Hotels")
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		Hotel savedHotel = hotelDAO.Save(hotel);
		
		URI location =ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedHotel.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	@DeleteMapping(path = "/Hotels/{id}")
	public void deleteHotel(@PathVariable String id) throws UserNotFoundException  {
		Hotel hotel = hotelDAO.deleteHotel(Integer.valueOf(id));
		if (hotel == null) {
			throw new UserNotFoundException();
		}	
	}

}
