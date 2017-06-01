package com.tony.models.UsuarioExterrno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.tony.HerenciaEntidades.Persona;
import com.tony.models.Documento.Documento;

@Entity
@Table(name = "usuario_externo")
@PrimaryKeyJoinColumn(name = "id_persona")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
    @NamedQuery(name = "UsuarioExterno.documentos.findDni", query = "Select UE from UsuarioExterno UE where UE.dni=:dni"),
    @NamedQuery(name = "UsuarioExterno.all", query = "Select UE from UsuarioExterno UE")
})
public class UsuarioExterno extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE, CascadeType.DETACH}, orphanRemoval = true)
    private List<Documento> documentos = new ArrayList<>();

    public UsuarioExterno() {

    }

    public UsuarioExterno(String nombre, String apellido, int dni, String Correo, String telefono) {
        super(nombre, apellido, dni);
        this.correo_electronico = Correo;
        this.telefono = telefono;
    }

    public void addDocumento(Documento doc) {
        if (this.documentos.isEmpty() || !this.documentos.contains(doc)) {
            this.documentos.add(doc);
            doc.setUsuario(this);
        }
    }

    public List<Documento> getDocumentos() {
        this.documentos.size();
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

}
