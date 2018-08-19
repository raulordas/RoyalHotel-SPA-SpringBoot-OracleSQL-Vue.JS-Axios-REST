package com.approyalhotel.royalhotel.services;

import java.sql.Date;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.approyalhotel.royalhotel.entities.Habitacion;
import com.approyalhotel.royalhotel.repositories.HabitacionRepository;

@Service
public class ServiceHabitaciones implements IServiceHabitacion {
	
	@Autowired
	private HabitacionRepository repositoryHabitacion;

	@Override
	public Iterable<Habitacion> listarHabitaciones() {
		return repositoryHabitacion.findAll();
	}

	@Override
	public Iterable<Integer> listarHabitacionesDisponibles(Date fechaEntrada, Date fechaSalida) {
		return repositoryHabitacion.listarHabitacionesDisponibles(fechaEntrada, fechaSalida);
	}

	@Override
	public Habitacion listarHabitacionesPorNumero(Integer numHab) {
		return repositoryHabitacion.findOne(numHab);
	}
	
	public Iterable<Habitacion> allHabs(Iterable<Integer> num){
		ArrayList<Habitacion> listHabs = new ArrayList<Habitacion>();
		for (Integer aux: num) {
			System.out.println(aux);
			listHabs.add(repositoryHabitacion.findAllHabsByNum(aux));
		}
		return listHabs;
	}
	
}
