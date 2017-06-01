/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.models.Documento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

@Entity
@Table(name = "tipo_peticion")
public class Tipo_peticion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_peticion;
    @Column(nullable = false, name = "tipoPeticion")
    private String Tipo_peticion;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = Documento.class)
    private List<Documento> documentos;

    public Tipo_peticion() {
        documentos = new ArrayList<>();
    }

    public int getId_peticion() {
        return id_peticion;
    }

    public void setId_peticion(int id_peticion) {
        this.id_peticion = id_peticion;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setTipo_peticion(String Tipo_peticion) {
        this.Tipo_peticion = Tipo_peticion;
    }

    public String getTipo_peticion() {
        return Tipo_peticion;
    }

}
