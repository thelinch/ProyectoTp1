package com.tony.models.Documento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.tony.Estados.Estado_documento;

/**
 * Entity implementation class for Entity: Estado_documento
 *
 */
@Entity
@Table(name = "estado_documento")
public class Estado_documentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_estadoDocumento;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado_documento estado;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estados", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Operacion_EstadosDocumentos> OperacionEstados = new ArrayList<>();

    public Estado_documentos() {

    }

    public void AddOperaciEstadoDocumento(Operacion_EstadosDocumentos op) {
        if (this.OperacionEstados.isEmpty() || !this.OperacionEstados.contains(op)) {
            this.OperacionEstados.add(op);
            op.setEstados(this);
        }
    }

    public int getId_estadoDocumento() {
        return id_estadoDocumento;
    }

    public void setId_estadoDocumento(int id_estadoDocumento) {
        this.id_estadoDocumento = id_estadoDocumento;
    }

    public Estado_documento getEstado() {
        return estado;
    }

    public void setEstado(Estado_documento estado) {
        this.estado = estado;
    }

    public List<Operacion_EstadosDocumentos> getOperacionEstados() {
        return OperacionEstados;
    }

    public void setOperacionEstados(List<Operacion_EstadosDocumentos> operacionEstados) {
        OperacionEstados = operacionEstados;
    }

    @Override
    public String toString() {
        return "Estado_documentos [id_estadoDocumento=" + id_estadoDocumento + ", estado=" + estado + "]";
    }

}
