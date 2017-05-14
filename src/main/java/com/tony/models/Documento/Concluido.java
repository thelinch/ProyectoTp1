package com.tony.models.Documento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.tony.Estados.Estado_Concluido;

/**
 * Entity implementation class for Entity: Concluido
 *
 */
@Entity
@Table(name="concluido")
public class Concluido implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
private int id_concluido;
@Enumerated(EnumType.STRING)
@Column(nullable=false)
private Estado_Concluido estadoConcluido; 
	
	private static final long serialVersionUID = 1L;
@OneToMany(mappedBy="concluido",cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
private List<Documento> documentos;

	public Concluido() {
		this.documentos=new ArrayList<>();
	}

	public int getId_concluido() {
		return id_concluido;
	}

	public void setId_concluido(int id_concluido) {
		this.id_concluido = id_concluido;
	}

	public Estado_Concluido getEstadoConcluido() {
		return estadoConcluido;
	}

	public void setEstadoConcluido(Estado_Concluido estadoConcluido) {
		this.estadoConcluido = estadoConcluido;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
	
   
}
