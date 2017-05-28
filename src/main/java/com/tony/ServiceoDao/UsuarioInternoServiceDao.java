/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceoDao;

import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Documento.Operacion_EstadosDocumentos;
import com.tony.models.Documento.Tipo_Documento;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antony
 */
public interface UsuarioInternoServiceDao {

    boolean Registrar_usuarioExterno(UsuarioExterno usuario);

    boolean Registrar_documento(Usuario_interno usuarioInterno, Tipo_Documento tipoDocumento, Documento documento, boolean isTupac, UsuarioExterno usuarioExterno);

    boolean Enviar_area_documento(Documento documento);

    boolean Editar_documento(Documento documento);

    DefaultTableModel All_usuarios_internos(Usuario_interno Usuario_gerente);

    DefaultTableModel All_usuarios_externos(JTable tabla);

    boolean add_documentoUsuarioExterno(Documento documento, Usuario_interno usuario_interno, UsuarioExterno usuario_externo);

    boolean Derivar_documento(Usuario_interno usuario_interno);

    Estado_documentos get_estado(Documento documento);

    DefaultTableModel get_flujograma_documento(Documento documento);

}
