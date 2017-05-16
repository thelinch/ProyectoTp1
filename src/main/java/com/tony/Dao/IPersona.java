/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Dao;

import com.tony.HerenciaEntidades.Persona;
import com.tony.models.Documento.Documento;
import java.util.List;

/**
 *
 * @author antony
 */
public interface IPersona {
    List<Documento> All_documentos(Persona usuario );
    boolean Inicio_Session(Persona usuario);
}
