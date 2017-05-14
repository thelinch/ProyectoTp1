package com.tony.models.UsuarioInterno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.tony.Estados.Tipo_Perfil_UsuarioInterno;

/**
 * Entity implementation class for Entity: Perfil
 *
 */
@Entity
@Table(name="perfil")
public class Perfil implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
@Column(name="id_perfil")
private int id_perfil;
@Enumerated(EnumType.STRING)
@Column(insertable=true,nullable=false)
private Tipo_Perfil_UsuarioInterno tipoPerfil;
private static final long serialVersionUID = 1L;
@OneToMany(mappedBy="perfil",cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval=true)
private List<Usuario_interno> UsuarioInternos;

	public Perfil() {
		this.UsuarioInternos=new ArrayList<>();
	}

	public int getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}

	public Tipo_Perfil_UsuarioInterno getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(Tipo_Perfil_UsuarioInterno tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	@Override
	public String toString() {
		return "Perfil [id_perfil=" + id_perfil + ", tipoPerfil=" + tipoPerfil + "]";
	}
	
   
}
