package com.approyalhotel.royalhotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.approyalhotel.royalhotel.entities.Reserva;
import com.approyalhotel.royalhotel.repositories.ReservaRepository;

@Service
public class ServiceReservas implements IServiceReservas {
	
	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public Iterable<Reserva> listarReservas() {
		return reservaRepository.findAll();
	}

	@Override
	public void agregarReserva(Reserva reserva) {
		reservaRepository.save(reserva);
	}

	@Override
	public void eliminarReserva(Reserva reserva) {

		reservaRepository.delete(reserva.getId_Reserva());
	}

}
