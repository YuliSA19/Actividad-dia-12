package com.producto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="socatego")
public class Categoria{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long Cat_Id;
	public String Cat_Nombre;
	public Long getCat_Id() {
		return Cat_Id;
	}
	public void setCat_Id(Long cat_Id) {
		Cat_Id = cat_Id;
	}
	public String getCat_Nombre() {
		return Cat_Nombre;
	}
	public void setCat_Nombre(String cat_Nombre) {
		Cat_Nombre = cat_Nombre;
	}	
}
