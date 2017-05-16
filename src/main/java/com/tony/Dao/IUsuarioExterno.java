/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Dao;

import com.tony.models.Documento.Documento;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import java.util.List;

/**
 *
 * @author antony
 */
public interface IUsuarioExterno {
    List<Documento> All_documentos(UsuarioExterno usuario);
}
