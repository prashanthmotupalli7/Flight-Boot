package com.nse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nse.entity.Flight;
import com.nse.repo.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightRepository repo;

	@Override
	public void save(Flight f) {
		repo.save(f);

	}

	@Override
	public Flight fetch(int code) {

		return repo.findById(code).get();
	}

	@Override
	public void delete(int code) {
		repo.deleteById(code);

	}

	@Override
	public List<Flight> list() {

		return repo.findAll();
	}

	@Override
	public List<Flight> listByCarrier(String carrier) {
		
		return repo.findByCarrier(carrier);
	}

	@Override
	public List<Flight> listByRoute(String source, String destiny) {
		
		return repo.findByRoute(source, destiny);
	}

}
