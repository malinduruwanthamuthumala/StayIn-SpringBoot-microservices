package com.webServices.stayIn.stayInwebservices.Hotel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.webServices.stayIn.stayInwebservices.beans.Hotel;
import com.webServices.stayIn.stayInwebservices.exception.UserNotFoundException;

@Component
public class HotelDAOService {

	private static int hotelCounter = 3;
	private static List<Hotel> hotelList = new ArrayList<Hotel>();
	
	static {
		hotelList.add(new Hotel(1,"Savonra","Beach Hotel",23));
		hotelList.add(new Hotel(2,"Savonra2","Beach Hotel",23));
		hotelList.add(new Hotel(3,"Savonra3","Beach Hotel",23));
		
	}
	
	public List<Hotel> getHotels(){
		return hotelList;
	}
	
	public Hotel Save(Hotel hotel) {
		if (hotel.getId()== null ) {
			hotel.setId(++hotelCounter);
			hotelList.add(hotel);
		}
		return hotel;
	}

	public Hotel findHotel(int id) throws UserNotFoundException {

		try {
			Hotel requestedHotel = hotelList.stream().filter(hotel -> hotel.getId().equals(Integer.valueOf(id)))
					.collect(Collectors.toList()).get(0);
			return requestedHotel;

		} catch (IndexOutOfBoundsException e) {
			throw new UserNotFoundException();
		}

	}
	
	public Hotel deleteHotel(int id) {

		Iterator<Hotel> hotelIterator = hotelList.listIterator();

		while (hotelIterator.hasNext()) {
			Hotel hotel = hotelIterator.next();
			if (id == hotel.getId()) {
				hotelIterator.remove();
				return hotel;
			}
		}
		return null;

	}

}
