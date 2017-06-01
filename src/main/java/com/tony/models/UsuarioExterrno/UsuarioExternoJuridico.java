package com.tony.models.UsuarioExterrno;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UsuarioExternoJuridico
 *
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "UsuarioExternoJuridico.all", query = "Select ex from UsuarioExternoJuridico ex"),
    @NamedQuery(name = "UsuarioExternoJuridico.find.Ruc", query = "select uej from UsuarioExternoJuridico uej where uej.ruc=:ruc")
})
public class UsuarioExternoJuridico extends UsuarioExterno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ruc", length = 11, nullable = false)
    private int ruc;
    @Column(name = "orgaizacion", nullable = false)
    private String organizacion;

    public UsuarioExternoJuridico() {

    }

    public UsuarioExternoJuridico(String nombre, String apellido, int dni, String Correo, String telefono, int ruc, String Organizacion) {
        super(nombre, apellido, dni, Correo, telefono);
        this.ruc = ruc;
        this.organizacion = Organizacion;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    @Override
    public String toString() {
        return "UsuarioExternoJuridico [ruc=" + ruc + ", organizacion=" + organizacion + "]";
    }

}
