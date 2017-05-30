package com.tony.models.UsuarioInterno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.tony.HerenciaEntidades.Persona;
import com.tony.models.Documento.OperacionDocumento;

/**
 * Entity implementation class for Entity: Usuario_interno
 *
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Usuario_interno.all", query = "Select a from Usuario_interno a"),
    @NamedQuery(name = "Usuario_interno.find.Perfil", query = "Select a from Usuario_interno a WHERE a.perfil.tipoPerfil=:perfil"),
    @NamedQuery(name = "Usuario_interno.find.Area", query = "SELECT  a from Usuario_interno a where a.area.tipoArea=:area")})
public class Usuario_interno extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id_perfil", nullable = false)
    private Perfil perfil;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id_area", nullable = false)
    private Area area;
    //@ManyToMany(targetEntity=Documento.class)
    /*@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REMOVE})
 @JoinTable(name="operacion_documento",
 joinColumns={@JoinColumn(name="usuario")},
 inverseJoinColumns={@JoinColumn(name="documento")})
 private List<Documento> documentos=new ArrayList<>();*/
    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REMOVE}, orphanRemoval = true)
    private List<OperacionDocumento> operacionUsuarioInterno = new ArrayList<>();

    public Usuario_interno() {
    }

    public void AddOperacionDocumento(OperacionDocumento opera) {
        if (this.operacionUsuarioInterno.isEmpty() || !this.operacionUsuarioInterno.contains(opera)) {
            this.operacionUsuarioInterno.add(opera);
            opera.setUsuario(this);
        }
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<OperacionDocumento> getOperacionUsuarioInterno() {
        this.operacionUsuarioInterno.size();
        return operacionUsuarioInterno;
    }

    public void setOperacionUsuarioInterno(List<OperacionDocumento> operacionUsuarioInterno) {
        this.operacionUsuarioInterno = operacionUsuarioInterno;
    }
        
    @Override
    public String getCodigo() {
        return super.getCodigo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getClave() {
        return super.getClave(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getApellido() {
        return super.getApellido(); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario_interno(String nombre, String apellido, int dni, String codigo, String clave, Perfil perfil, Area area) {
        super(nombre, apellido, dni, codigo, clave);
        this.perfil = perfil;
        this.area = area;
    }

    @Override
    public String toString() {
        return "Usuario_interno [perfil=" + perfil + ", area=" + area + ", operacionUsuarioInterno="
                + operacionUsuarioInterno + "]";
    }

}
