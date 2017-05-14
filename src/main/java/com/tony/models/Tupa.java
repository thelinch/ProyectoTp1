package com.tony.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.tony.models.Documento.Documento;
import com.tony.models.UsuarioInterno.Area;

/**
 * Entity implementation class for Entity: Tupa
 *
 */
@Entity
@Table(name="tupa")
public class Tupa implements Serializable {
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
private int id_tupa;
@Column(nullable=false)
private String procedimiento;
@Column(nullable=false)
private int proceso;
@Column(nullable=false)
private int plazo;
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="id_area",nullable=false)
private Area area;
@OneToMany(mappedBy="tupa",cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REMOVE})
private List<Documento> documentos;
	
	public Tupa() {
		this.documentos=new ArrayList<>();
	}

	public int getId_tupa() {
		return id_tupa;
	}

	public void setId_tupa(int id_tupa) {
		this.id_tupa = id_tupa;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}



	public int getProceso() {
		return proceso;
	}

	public void setProceso(int proceso) {
		this.proceso = proceso;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	
   
	
}
