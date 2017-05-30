/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.DaoImpl;

import com.tony.Dao.IUsuarioInterno;
import com.tony.Estados.Tipo_Perfil_UsuarioInterno;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Documento.OperacionDocumento;
import com.tony.models.Documento.Operacion_EstadosDocumentos;
import com.tony.models.Documento.Tipo_Documento;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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
        boolean proceso = false;
        EntityManager em = Entidad.getEntidad().getEntidadManager();

        try {
            em.getTransaction().begin();
            documento.setTipoDocumento(tipoDocumento);
            OperacionDocumento operacion = new OperacionDocumento(usuarioInterno, documento);
            usuarioInterno.AddOperacionDocumento(operacion);
            usuarioExterno.addDocumento(documento);
            em.persist(usuarioInterno);
            em.persist(usuarioExterno);
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error en mensaje Registrar documento" + e.getMessage());
        } finally {
            em.close();
        }
        return proceso;

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
    public List<Usuario_interno> All_usuarios_internos(Usuario_interno Usuario_gerente, int inicio, int Final) {
        EntityManager em = Entidad.getEntidad().getEntidadManager();
        List<Usuario_interno> user_internos = null;
        Session s = null;
        try {
            em.getTransaction().begin();
            s = (Session) em.getDelegate();
            Usuario_interno UsergerenteEntity = em.find(Usuario_interno.class, Usuario_gerente.getId_persona());
            if (UsergerenteEntity.getPerfil().getTipoPerfil().compareTo(Tipo_Perfil_UsuarioInterno.Administrador) == 0) {
                user_internos = (List<Usuario_interno>) s.createCriteria(Usuario_interno.class)
                        .add(Restrictions.not(Restrictions.idEq(Usuario_gerente.getId_persona()))).createAlias("area", "areatotal").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                        .add(Restrictions.eq("areatotal.tipoArea", UsergerenteEntity.getArea().getTipoArea())).createAlias("perfil", "perfiluser").setResultTransformer(Criteria.ROOT_ENTITY).add(Restrictions.eq("perfiluser.tipoPerfil", Tipo_Perfil_UsuarioInterno.Profesional))
                        .setFirstResult(inicio).list();
            }

            em.getTransaction().commit();
            System.out.println(user_internos);
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error en mensaje All_usuarios_internos" + e.getMessage());
        } finally {
            em.close();
        }
        return user_internos;
    }

    @Override
    public List<UsuarioExterno> All_usuarios_externos(int Inicio, int Final) {
        EntityManager em = Entidad.getEntidad().getEntidadManager();
        List<UsuarioExterno> userExterno = null;
        try {
            em.getTransaction().begin();
            userExterno = em.createNamedQuery("UsuarioExterno.all", UsuarioExterno.class).setFirstResult(Inicio).setMaxResults(Final + Inicio).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return userExterno;
    }

    @Override
    public boolean add_documentoUsuarioExterno(Documento documento, Usuario_interno usuario_interno, UsuarioExterno usuario_externo) {
        EntityManager em = Entidad.getEntidad().getEntidadManager();
        try {
            em.getTransaction().begin();
            UsuarioExterno userEntidad = em.find(UsuarioExterno.class, usuario_externo.getId_persona());
            userEntidad.addDocumento(documento);
            OperacionDocumento oper = new OperacionDocumento(usuario_interno, documento);
            usuario_interno.AddOperacionDocumento(oper);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Mensaje de UsuarioInterImpl:add_documentoUsuarioExtern" + e.getMessage());
        } finally {
            em.close();
        }
        return true;
    }

    @Override
    public boolean Derivar_documento(Usuario_interno usuario_interno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado_documentos get_estado(Documento documento) {
        EntityManager em = Entidad.getEntidad().getEntidadManager();
        Estado_documentos estado = null;
        Session sesionHibernate = (Session) em.getDelegate();
        List<Estado_documentos> lista = new ArrayList<>();
        try {
            em.getTransaction().begin();
            lista = (List<Estado_documentos>) sesionHibernate.createCriteria(Operacion_EstadosDocumentos.class).createAlias("documento", "documentoBuscar")
                    .add(Restrictions.eq("documentoBuscar.id_documento", documento.getId_documento())).setProjection(Projections.property("estados"))
                    .list();
            lista.forEach(System.out::println);
            lista.stream().sorted(new Comparator<Estado_documentos>() {
                @Override
                public int compare(Estado_documentos o1, Estado_documentos o2) {
                    if (o1.getId_estadoDocumento() >= o2.getId_estadoDocumento()) {
                        return 0;
                    }
                    return 1;
                }
            });
            //////////PRGUNTAR AL PROFE //////////////
            lista.stream().forEach(System.out::println);
            estado = new Estado_documentos();
            estado.setEstado(lista.get(lista.size() - 1).getEstado());
            estado.setId_estadoDocumento(lista.get(lista.size() - 1).getId_estadoDocumento());
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Mensja de get_estado:usuarioInternoImpl" + e.getMessage());
        } finally {
            em.close();

        }
        System.out.println(estado);
        return estado;
    }

    @Override
    public List<Operacion_EstadosDocumentos> get_flujograma_documento(Documento documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
