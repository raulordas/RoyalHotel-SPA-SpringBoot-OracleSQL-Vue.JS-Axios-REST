package com.approyalhotel.royalhotel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Habitaciones")
public class Habitacion {
	
	@Id
	@Column(name="id_hab")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id_hab;
	
	@Column(name="num_hab")
	private int num_Hab;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="precio")
	private double precio;

	public int getId_hab() {
		return id_hab;
	}

	public void setId_hab(int id_hab) {
		this.id_hab = id_hab;
	}

	public int getNum_Hab() {
		return num_Hab;
	}

	public void setNum_Hab(int num_Hab) {
		this.num_Hab = num_Hab;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
