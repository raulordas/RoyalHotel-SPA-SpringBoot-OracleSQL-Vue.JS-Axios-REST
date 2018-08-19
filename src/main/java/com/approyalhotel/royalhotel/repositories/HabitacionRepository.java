package com.approyalhotel.royalhotel.repositories;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.approyalhotel.royalhotel.entities.Habitacion;

@Repository
public interface HabitacionRepository extends CrudRepository<Habitacion, Integer> {
	
	@Query(value="select distinct r.num_habitacion from Reserva r where (r.fecha_Entrada between ?1 and ?2 or r.fecha_Salida between ?1 and ?2 or (r.fecha_Entrada < ?1 and r.fecha_Salida >= ?2))")
	public Iterable<Integer> listarHabitacionesDisponibles(Date fechaEntrada, Date fechaSalida);

	@Query(value = "select h from Habitacion h where h.num_Hab = ?1")
	public Habitacion findAllHabsByNum(Integer numHab);
}
