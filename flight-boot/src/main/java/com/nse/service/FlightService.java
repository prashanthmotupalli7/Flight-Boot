package com.nse.service;

import java.util.List;

import com.nse.entity.Flight;

public interface FlightService {
	void save(Flight f);

	Flight fetch(int code);

	List<Flight> list();

	void delete(int code);
	
	List<Flight> listByCarrier(String carrier);
	
	
	List<Flight> listByRoute(String source, String destiny);
}
