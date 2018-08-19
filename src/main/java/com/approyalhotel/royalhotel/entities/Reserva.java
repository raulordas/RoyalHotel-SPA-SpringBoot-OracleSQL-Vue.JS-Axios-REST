package com.approyalhotel.royalhotel.entities;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_reserva")
	private int id_Reserva;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="dni")
	private String dni;
	
	@Column(name="fecha_entrada")
	private Date fecha_Entrada;
	
	@Column(name="fecha_salida")
	private Date fecha_Salida;
	
	@Column(name="habitacion")
	private int num_habitacion;
	
	@Column(name="precio") 
	private double precio;

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getId_Reserva() {
		return id_Reserva;
	}

	public void setId_Reserva(int id_Reserva) {
		this.id_Reserva = id_Reserva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFecha_Entrada() {
		return fecha_Entrada;
	}

	public void setFecha_Entrada(Date fecha_Entrada) {
		this.fecha_Entrada = fecha_Entrada;
	}

	public Date getFecha_Salida() {
		return fecha_Salida;
	}

	public void setFecha_Salida(Date fecha_Salida) {
		this.fecha_Salida = fecha_Salida;
	}

	public int getNum_habitacion() {
		return num_habitacion;
	}

	public void setNum_habitacion(int num_habitacion) {
		this.num_habitacion = num_habitacion;
	}

}
