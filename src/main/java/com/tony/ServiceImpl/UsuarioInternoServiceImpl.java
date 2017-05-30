/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceImpl;

import com.tony.DaoImpl.Entidad;
import com.tony.DaoImpl.UsuarioInternoImpl;
import com.tony.ServiceoDao.UsuarioInternoServiceDao;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Documento.Tipo_Documento;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antony
 */
public class UsuarioInternoServiceImpl implements UsuarioInternoServiceDao {

    private UsuarioInternoImpl usuariImpl = new UsuarioInternoImpl();

    @Override
    public boolean Registrar_usuarioExterno(UsuarioExterno usuario) {

        return this.usuariImpl.Registrar_usuarioExterno(usuario);
    }

    @Override
    public boolean Registrar_documento(Usuario_interno usuarioInterno, Tipo_Documento tipoDocumento, Documento documento, boolean isTupac, UsuarioExterno usuarioExterno) {
        return this.usuariImpl.Registrar_documento(usuarioInterno, tipoDocumento, documento, isTupac, usuarioExterno);
    }

    @Override
    public boolean Enviar_area_documento(Documento documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Editar_documento(Documento documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel All_usuarios_internos(Usuario_interno Usuario_gerente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel All_usuarios_externos(JTable tabla,int inicio,int Final) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        List<UsuarioExterno> usuariosExternos=this.usuariImpl.All_usuarios_externos(inicio,Final);
        return modelo;

    }

    @Override
    public boolean add_documentoUsuarioExterno(Documento documento, Usuario_interno usuario_interno, UsuarioExterno usuario_externo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Derivar_documento(Usuario_interno usuario_interno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado_documentos get_estado(Documento documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel get_flujograma_documento(Documento documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
