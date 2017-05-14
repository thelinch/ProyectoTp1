package com.tony.models.UsuarioInterno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.tony.Estados.Tipos_Area;
import com.tony.models.Tupa;

/**
 * Entity implementation class for Entity: Area
 *
 */
@Entity
@Table(name="area")
public class Area implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
private int id_area;
@Enumerated(EnumType.STRING)
@Column(insertable=true,nullable=false)
private Tipos_Area tipoArea;
@OneToMany(mappedBy="area",cascade={CascadeType.REMOVE,CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST},orphanRemoval=true)
private List<Usuario_interno> usuarioInterno;
@OneToMany(mappedBy="area",cascade={CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REMOVE},orphanRemoval=true)	
private List<Tupa> tupa;

private static final long serialVersionUID = 1L;

	public Area() {
		this.usuarioInterno=new ArrayList<>();
	this.tupa=new ArrayList<>();	
	}

	public int getId_area() {
		return id_area;
	}

	public void setId_area(int id_area) {
		this.id_area = id_area;
	}

	public Tipos_Area getTipoArea() {
		return tipoArea;
	}

	public void setTipoArea(Tipos_Area tipoArea) {
		this.tipoArea = tipoArea;
	}

	@Override
	public String toString() {
		return "Area [id_area=" + id_area + ", tipoArea=" + tipoArea + "]";
	}
	
	
   
}
