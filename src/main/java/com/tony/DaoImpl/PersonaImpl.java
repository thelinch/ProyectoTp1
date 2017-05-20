/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.DaoImpl;

import com.tony.Dao.IPersona;
import com.tony.HerenciaEntidades.Persona;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.OperacionDocumento;
import com.tony.models.Documento.Operacion_EstadosDocumentos;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author antony
 */
public class PersonaImpl implements IPersona {
    
    @Override
    public List<Documento> All_documentos(Persona usuario) {
        List<Documento> Documentos = new ArrayList<>();
        EntityManager em = Entidad.getEntidad().getEntidadManager();
        Session se=(Session) em.getDelegate();
        try {
            em.getTransaction().begin();
            if (usuario instanceof UsuarioExterno) {
                System.out.println("Entro en Usuario Externo");
                Documentos = em.find(UsuarioExterno.class, usuario.getId_persona()).getDocumentos();
            } else if (usuario instanceof Usuario_interno) {
             Documentos=se.createCriteria(OperacionDocumento.class).createAlias("id_documento", "documentos").add(Restrictions.eq("id_usuario", usuario)).list();
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Mensaje de PersonaImpl:All_Documentos" + e.getMessage());
        } finally {
            em.close();
        }
        return Documentos;
    }
    
    @Override
    public Persona Inicio_Session(Persona usuario) {
        
        EntityManager em = Entidad.getEntidad().getEntidadManager();
        Persona perons = null;
        try {
            em.getTransaction().begin();
            perons = em.find(Persona.class, usuario.getId_persona());
            if (perons != null) {
                perons.setIsSesion(true);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                
            }
            System.out.println("mensaje de PersonaImpl:Inicio_Session" + e.getMessage());
        } finally {
            em.close();
        }
        
        return perons;
        
    }
    
}
