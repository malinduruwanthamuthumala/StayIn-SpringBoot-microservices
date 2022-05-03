package com.webServices.stayIn.stayInwebservices.Hotel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.webServices.stayIn.stayInwebservices.beans.Hotel;

@Component
public class HotelDAOService {

	private static int hotelCounter = 3;
	private static List<Hotel> hotelList = new ArrayList<Hotel>();
	
	static {
		hotelList.add(new Hotel(1,"Savonra","Beach Hotel",23));
	}
	
	public List<Hotel> getHotels(){
		return hotelList;
	}
	
	public Hotel Save(Hotel hotel) {
		if (hotel.getId() == null) {
			hotel.setId(++hotelCounter);
			hotelList.add(hotel);
		}
		return hotel;
	}
	
	public Hotel findHotel(int id) {
	 Hotel requestedHotel = hotelList.stream()
	  .filter(hotel -> hotel.getId().equals(Integer.valueOf(id)))
	  .collect(Collectors.toList()).get(0);
	 
	 return requestedHotel;
	}
}
