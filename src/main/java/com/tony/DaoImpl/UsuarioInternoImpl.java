/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.DaoImpl;

import com.tony.Dao.IUsuarioInterno;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Documento.Operacion_EstadosDocumentos;
import com.tony.models.Documento.Tipo_Documento;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author antony
 */
public class UsuarioInternoImpl implements IUsuarioInterno {
    @Override
    public boolean Registrar_usuarioExterno(UsuarioExterno usuario) {
        boolean operacion = false;
        EntityManager em = Entidad.getEntidad().getEntidadManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            operacion = true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                System.out.println("Mensaje de UsuarioInternoImpl:Registrar_usuarioExterno");
            }
        }
        return operacion;
    }

    @Override
    public boolean Registrar_documento(Usuario_interno usuarioInterno, Tipo_Documento tipoDocumento, Documento documento, boolean isTupac, UsuarioExterno usuarioExterno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public List<Usuario_interno> All_usuarios_internos(Usuario_interno Usuario_gerente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioExterno> All_usuarios_externos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public List<Operacion_EstadosDocumentos> get_flujograma_documento(Documento documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
