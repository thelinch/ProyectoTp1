package com.tony.models.Documento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.tony.Listeners.OperacionEstadoDocumentoListener;

/**
 * Entity implementation class for Entity: Operacion_Estados
 *
 */
@Entity
@Table(name="operacion_EstadosDocumentos")
@EntityListeners(value=OperacionEstadoDocumentoListener.class)
public class Operacion_EstadosDocumentos implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
private int id_operacioEstados;
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="id_estados",nullable=false)
private Estado_documentos estados;
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="id_documento",nullable=false)
private Documento documento;
@OneToMany(mappedBy="Operacion_estadoDocumento",cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE,CascadeType.DETACH},orphanRemoval=true)
private List<AuditoriaDocumento> auditoriaDocumentos=new ArrayList<>();
	private static final long serialVersionUID = 1L;

	public Operacion_EstadosDocumentos() {
		
	}
	public void AddAuditoriaDocumento(AuditoriaDocumento auditoria){
		if(this.auditoriaDocumentos.isEmpty() || !this.auditoriaDocumentos.contains(auditoria)){
			this.auditoriaDocumentos.add(auditoria);
			auditoria.setOperacion_estadoDocumento(this);
		}
	}

	public Operacion_EstadosDocumentos(Estado_documentos estados, Documento documento) {
		this.estados = estados;
		this.documento = documento;
		}

	public int getId_operacioEstados() {
		return id_operacioEstados;
	}

	public void setId_operacioEstados(int id_operacioEstados) {
		this.id_operacioEstados = id_operacioEstados;
	}

	public Estado_documentos getEstados() {
		return estados;
	}

	public void setEstados(Estado_documentos estados) {
		this.estados = estados;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public List<AuditoriaDocumento> getAuditoriaDocumentos() {
		return auditoriaDocumentos;
	}

	public void setAuditoriaDocumentos(List<AuditoriaDocumento> auditoriaDocumentos) {
		this.auditoriaDocumentos = auditoriaDocumentos;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_operacioEstados;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operacion_EstadosDocumentos other = (Operacion_EstadosDocumentos) obj;
		if (id_operacioEstados != other.id_operacioEstados)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Operacion_EstadosDocumentos [id_operacioEstados=" + id_operacioEstados + ", estados=" + estados + "]";
	}

	

	

	
   
}
