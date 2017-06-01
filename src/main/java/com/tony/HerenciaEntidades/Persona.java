package com.tony.HerenciaEntidades;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries(
        {
            @NamedQuery(name = "Persona.all", query = "select p from Persona p"),
            @NamedQuery(name = "Persona.findDni", query = "select per from Persona per where per.dni=:dni")}
)
public abstract class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_persona")
    protected int id_persona;
    @Column(name = "nombre", insertable = true, nullable = false)
    protected String nombre;
    @Column(name = "apellido", insertable = true, nullable = false)
    protected String apellido;
    @Column(name = "dni", length = 8, nullable = false)
    protected int dni;
    @Column(name = "codigo", nullable = false)
    protected String codigo;
    @Column(name = "correo_electronico")
    protected String correo_electronico;
    @Column(name = "telefono")
    protected String telefono;
    @Column(name = "sesion", nullable = false)
    protected boolean IsSesion = false;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public void setIsSesion(boolean IsSesion) {
        this.IsSesion = IsSesion;
    }

    public boolean getIsSesion() {
        return this.IsSesion;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona [id_persona=" + id_persona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
                + ", codigo=" + codigo + ", correo_electronico=" + correo_electronico
                + ", telefono=" + telefono + "]";
    }

}
