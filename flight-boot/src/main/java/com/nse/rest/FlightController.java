package com.nse.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nse.entity.Flight;
import com.nse.service.FlightService;

@RestController
public class FlightController {
	@Autowired
	private FlightService service;

	@PostMapping(value="/flight", consumes="application/json")
	public String addFlight(@RequestBody Flight f) {
		service.save(f);
		return "Flight saved";
	}
	
	@GetMapping(value="/flight/{code}",produces="application/json")
	public Flight getFlight(@PathVariable int code) {
		return service.fetch(code);
	}
	
	@GetMapping(value="/flights",produces="application/json")
	public List<Flight> getAll() {
		return service.list();
	}
	@GetMapping(value="/carrier/{carrier}",produces="application/json")
	public List<Flight> getByCarrier(@PathVariable String carrier){
		return service.listByCarrier(carrier);
	}
	
	@GetMapping(value="/route/{source}/{destiny}",produces="application/json")
	public List<Flight> getBySnC(@PathVariable String source, @PathVariable String destiny){
		return service.listByRoute(source,destiny);
	}
	
	@GetMapping(value="/route",produces="application/json")
	public List<Flight> getBySnCparam(@RequestParam String source, @RequestParam String destiny){
		return service.listByRoute(source,destiny);
	}
	
	@DeleteMapping(value="/flight/{code}")
	public String delFlight(@PathVariable int code) {
		service.delete(code);
		return "Flight deleted";
	}
}
