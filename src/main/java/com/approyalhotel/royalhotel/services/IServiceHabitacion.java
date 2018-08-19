package com.approyalhotel.royalhotel.services;

import java.sql.Date;
import com.approyalhotel.royalhotel.entities.Habitacion;

public interface IServiceHabitacion {
	public Iterable<Habitacion> listarHabitaciones();
	public Iterable<Integer> listarHabitacionesDisponibles(Date FechaEntrada, Date FechaSalida);
	public Habitacion listarHabitacionesPorNumero(Integer numHab);
}
