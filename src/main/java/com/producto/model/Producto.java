package com.producto.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="soproduc")
public class Producto {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long Pro_Id;
	public String Pro_Nombre;
	public String Pro_Serie;
	public int Pro_Catego;
	
	public Long getPro_Id() {
		return Pro_Id;
	}

	public void setPro_Id(Long pro_Id) {
		Pro_Id = pro_Id;
	}

	public String getPro_Nombre() {
		return Pro_Nombre;
	}

	public void setPro_Nombre(String pro_Nombre) {
		Pro_Nombre = pro_Nombre;
	}

	public String getPro_Serie() {
		return Pro_Serie;
	}

	public void setPro_Serie(String pro_Serie) {
		Pro_Serie = pro_Serie;
	}

	public int getPro_Catego() {
		return Pro_Catego;
	}

	public void setPro_Catego(int pro_Catego) {
		Pro_Catego = pro_Catego;
	}

	public Producto(String nombre) {
		super();
		this.Pro_Nombre = nombre;
	}
	
	public Producto() {
	}
}
