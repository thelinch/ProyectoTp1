package com.tony.models.Documento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tipo_Documento
 *
 */
@Entity
@Table(name="tipo_documento")
public class Tipo_Documento implements Serializable {
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
private int id_tipo_documento;
@Enumerated(EnumType.STRING)
@Column(nullable=false,name="TipoDocumento")
private com.tony.Estados.Tipo_Documento TipoDocumento;
@OneToMany(mappedBy="tipoDocumento",cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
private List<Documento> documentos;
	public Tipo_Documento() {
	this.documentos=new ArrayList<>();
	}

	public int getId_tipo_documento() {
		return id_tipo_documento;
	}

	public void setId_tipo_documento(int id_tipo_documento) {
		this.id_tipo_documento = id_tipo_documento;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}
	public com.tony.Estados.Tipo_Documento getTipoDocumento() {
		return TipoDocumento;
	}
	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
	public void setTipoDocumento(com.tony.Estados.Tipo_Documento tipoDocumento) {
		TipoDocumento = tipoDocumento;
	}

	@Override
	public String toString() {
		return "Tipo_Documento [id_tipo_documento=" + id_tipo_documento + ", TipoDocumento=" + TipoDocumento + "]";
	}
	
   
}
