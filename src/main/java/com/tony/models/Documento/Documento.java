package com.tony.models.Documento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tony.models.Tupa;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "documento")
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_documento;
    @Column(nullable = false)
    private String codigo;
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(nullable = false)
    private String asunto;
    private String contenido_doc;
    private String Observaciones;
    @Column(nullable = false)
    private boolean Disconforme;
    @Column(name = "num_foleo", nullable = false)
    private int num_foleo;
    @Lob()
    @Basic(fetch = FetchType.LAZY)
    private byte[] copia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipoDocumento", nullable = false)
    private Tipo_Documento tipoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tupa")
    private Tupa tupa;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_UsuarioExterno", nullable = false)
    private UsuarioExterno usuario;
//@ManyToMany(targetEntity=Usuario_interno.class)
//private List<Usuario_interno> usuariointerno=new ArrayList<>();
/*@ManyToMany(mappedBy="documentos",cascade={CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE})
private List<Usuario_interno> usuarios;*/
    @OneToMany(mappedBy = "documento", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<OperacionDocumento> operacionesDocumento = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_concluido")
    private Concluido concluido;

    @OneToMany(mappedBy = "documento", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE, CascadeType.DETACH}, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Operacion_EstadosDocumentos> operacionEstados = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = Tipo_peticion.class)
    private List<Tipo_peticion> tipo_peticions;

    public Documento() {
        this.tipo_peticions = new ArrayList<>();

    }

    public Documento(String codigo, String asunto, Tipo_Documento tipoDocumento, Estado_documentos estado) {
        this.tipo_peticions = new ArrayList<>();
        this.codigo = codigo;
        this.asunto = asunto;
        this.tipoDocumento = tipoDocumento;

    }

    public void AddTipo_peticions(Tipo_peticion peticion) {
        if (this.tipo_peticions.isEmpty() || !this.tipo_peticions.contains(peticion)) {
            this.tipo_peticions.add(peticion);
        }
    }

    public void AddOperacionDocumentos(OperacionDocumento doc) {
        if (this.operacionesDocumento.isEmpty() || !this.operacionesDocumento.contains(doc)) {
            this.operacionesDocumento.add(doc);
            doc.setDocumento(this);
        }
    }

    public void AddOperacioEstados(Operacion_EstadosDocumentos o) {
        if (this.operacionEstados.isEmpty() || !this.operacionEstados.contains(o)) {
            this.operacionEstados.add(o);
            o.setDocumento(this);

        }
    }

    public UsuarioExterno getUsuario() {
        return usuario;
    }

    public List<OperacionDocumento> getOperacionesDocumento() {
        return operacionesDocumento;
    }

    public void setOperacionesDocumento(List<OperacionDocumento> operacionesDocumento) {
        this.operacionesDocumento = operacionesDocumento;
    }

    public void setUsuario(UsuarioExterno usuario) {
        this.usuario = usuario;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido_doc() {
        return contenido_doc;
    }

    public void setContenido_doc(String contenido_doc) {
        this.contenido_doc = contenido_doc;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

    public int getNum_foleo() {
        return num_foleo;
    }

    public void setNum_foleo(int num_foleo) {
        this.num_foleo = num_foleo;
    }

    public byte[] getCopia() {
        return copia;
    }

    public void setCopia(byte[] copia) {
        this.copia = copia;
    }

    public Tipo_Documento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Tipo_Documento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Tupa getTupa() {
        return tupa;
    }

    public void setTupa(Tupa tupa) {
        this.tupa = tupa;
    }

    public Concluido getConcluido() {
        return concluido;
    }

    public void setConcluido(Concluido concluido) {
        this.concluido = concluido;
    }

    public boolean isDisconforme() {

        return Disconforme;
    }

    public boolean OperacionDisconforme() {
        if (this.getTupa() != null) {
            return (this.num_foleo < this.getTupa().getProceso()) ? false : true;
        }
        return this.Disconforme;
    }

    public void setDisconforme(boolean disconforme) {
        Disconforme = disconforme;
    }

    public List<Operacion_EstadosDocumentos> getOperacionEstados() {
        this.operacionEstados.size();
        return operacionEstados;
    }

    public void setOperacionEstados(List<Operacion_EstadosDocumentos> operacionEstados) {
        this.operacionEstados = operacionEstados;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_documento;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Documento other = (Documento) obj;
        if (id_documento != other.id_documento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Documento{" + "id_documento=" + id_documento + ", codigo=" + codigo + ", fecha=" + fecha + ", asunto=" + asunto + ", contenido_doc=" + contenido_doc + ", Observaciones=" + Observaciones + ", Disconforme=" + Disconforme + ", num_foleo=" + num_foleo ;
    }

    

}
