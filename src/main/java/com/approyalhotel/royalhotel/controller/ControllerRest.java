package com.approyalhotel.royalhotel.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.approyalhotel.royalhotel.entities.Habitacion;
import com.approyalhotel.royalhotel.entities.Reserva;
import com.approyalhotel.royalhotel.services.ServiceHabitaciones;
import com.approyalhotel.royalhotel.services.ServiceReservas;

@RestController
public class ControllerRest {
	
	@Autowired
	private ServiceHabitaciones serviceHabitaciones;
	
	@Autowired
	private ServiceReservas serviceReservas;
	
	
	@CrossOrigin
	@RequestMapping(value="/listarHabitaciones", method=RequestMethod.GET)
	public ResponseEntity<Iterable<Integer>> listarHabitaciones(Date fechaEntrada, Date fechaSalida) {
		return new ResponseEntity<Iterable<Integer>>(serviceHabitaciones.listarHabitacionesDisponibles(fechaEntrada, fechaSalida), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/listarHabitacionesDisponibles", method=RequestMethod.GET)
	public ResponseEntity<Iterable<Habitacion>> listarHabitacionesDisp(@RequestParam List<Integer> numeroHabitaciones) {

		
		return new ResponseEntity<Iterable<Habitacion>>(serviceHabitaciones.allHabs(numeroHabitaciones), HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@RequestMapping(value="/duracion", method=RequestMethod.GET)
	public ResponseEntity<Integer> duracion(Date fechaEntrada, Date fechaSalida) {
		return new ResponseEntity<Integer>(restarFechas(fechaEntrada, fechaSalida), HttpStatus.OK);
		
	}
	
	
	@CrossOrigin
	@RequestMapping(value="/reservar", method=RequestMethod.POST)
	public ResponseEntity<Void> realizarReserva(@RequestBody Reserva reserva) {
		serviceReservas.agregarReserva(reserva);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value="/eliminar", method=RequestMethod.POST)
	public ResponseEntity<Void> eliminarReserva(@RequestBody Reserva reserva) {
		serviceReservas.eliminarReserva(reserva);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/listadoreservas", method=RequestMethod.GET)
	public ResponseEntity<Iterable<Reserva>> listadoReservas() {
		return new ResponseEntity<Iterable<Reserva>>(serviceReservas.listarReservas(), HttpStatus.CREATED);
	}
	
	private int restarFechas(Date fechaEntrada, Date fechaSalida) {
		long startTime = fechaEntrada.getTime();
	     long endTime = fechaSalida.getTime();
	     long diffTime = endTime - startTime;
	     long diffDays = diffTime / (1000 * 60 * 60 * 24);
	     return (int) diffDays;
	}
}
