package com.approyalhotel.royalhotel.services;

import com.approyalhotel.royalhotel.entities.Reserva;

public interface IServiceReservas {
	public Iterable<Reserva> listarReservas();
	public void agregarReserva(Reserva reserva);
	public void eliminarReserva(Reserva reserva);
}
