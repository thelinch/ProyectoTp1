package com.tony.models.Documento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.tony.Listeners.OperacionDocumentoListener;
import com.tony.models.UsuarioInterno.AuditoriaUsuario;
import com.tony.models.UsuarioInterno.Usuario_interno;

/**
 * Entity implementation class for Entity: OperacionDocumento
 *
 */
@Entity
@Table(name="operacion_documento")
public class OperacionDocumento implements Serializable {
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
private int id_OperacionDocumento;
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="id_usuario",nullable=false)
private Usuario_interno usuario;
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="id_documento",nullable=false)
private Documento documento;
@OneToMany(mappedBy="operacioDocumento",cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE,CascadeType.DETACH},orphanRemoval=true)
private List<AuditoriaUsuario> AuditoriaUsuario=new ArrayList<>();;
	public OperacionDocumento() {
	
	}

	public OperacionDocumento(Usuario_interno usuario, Documento documento) {
		this.usuario = usuario;
		this.documento = documento;
	}
   public void AddAuditoriaUsuario(AuditoriaUsuario auidi){
	   if(this.AuditoriaUsuario.isEmpty() || !this.AuditoriaUsuario.contains(auidi)){
		   this.AuditoriaUsuario.add(auidi);
	   }
   }
	public int getId_OperacionDocumento() {
		return id_OperacionDocumento;
	}

	public void setId_OperacionDocumento(int id_OperacionDocumento) {
		this.id_OperacionDocumento = id_OperacionDocumento;
	}

	public Usuario_interno getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario_interno usuario) {
		this.usuario = usuario;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public List<AuditoriaUsuario> getAuditoriaUsuario() {
		return AuditoriaUsuario;
	}

	public void setAuditoriaUsuario(List<AuditoriaUsuario> auditoriaUsuario) {
		AuditoriaUsuario = auditoriaUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_OperacionDocumento;
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
		OperacionDocumento other = (OperacionDocumento) obj;
		if (id_OperacionDocumento != other.id_OperacionDocumento)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OperacionDocumento [id_OperacionDocumento=" + id_OperacionDocumento + ", usuario=" + "]";
	}

	
	
   
}
