package com.tony.models.UsuarioInterno;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.tony.models.Documento.OperacionDocumento;

/**
 * Entity implementation class for Entity: AuditoriaUsuario
 *
 */
@Entity
@Table(name="auditoria_usuario")
public class AuditoriaUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
private int id_auditoria;

@Temporal(TemporalType.DATE)
private Date fecha;

@Column(nullable=false)
private String accion;
	
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="id_operacion_documento",nullable=false)
private OperacionDocumento operacioDocumento;

	public AuditoriaUsuario() {
		
	}

	public AuditoriaUsuario(OperacionDocumento operacioDocumento) {
		this.operacioDocumento = operacioDocumento;
	}

	public int getId_auditoria() {
		return id_auditoria;
	}

	public void setId_auditoria(int id_auditoria) {
		this.id_auditoria = id_auditoria;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
	
   
}
