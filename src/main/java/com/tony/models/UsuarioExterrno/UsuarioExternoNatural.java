package com.tony.models.UsuarioExterrno;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UsuarioExternoNatural
 *
 */
@Entity
public class UsuarioExternoNatural extends UsuarioExterno implements Serializable {

    private static final long serialVersionUID = 1L;

    public UsuarioExternoNatural() {

    }

    public UsuarioExternoNatural(String nombre, String apellido, int dni, String Correo, String telefono) {
        super(nombre, apellido, dni, Correo, telefono);
    }

}
