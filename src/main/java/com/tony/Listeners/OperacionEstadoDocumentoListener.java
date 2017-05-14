package com.tony.Listeners;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tony.models.Documento.AuditoriaDocumento;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Documento.Operacion_EstadosDocumentos;

import tony.com.DaoImpl.Entidad;

public class OperacionEstadoDocumentoListener {

	@PrePersist
	public void setAuditoria(Operacion_EstadosDocumentos operacion) {
		EntityManager em = Entidad.getEntidad().getEntidadManager();
		Session se = (Session) em.getDelegate();
		try {
			
			
			List<Estado_documentos> estados=se.createCriteria(Documento.class).createAlias("operacionEstados", "op")
					.setProjection(Projections.property("op.estados"))
					.add(Restrictions.idEq(operacion.getDocumento().getId_documento())).list();
			AuditoriaDocumento aui=new AuditoriaDocumento();
			aui.setEstadoActual(operacion.getEstados().getEstado().toString());
			if(!estados.isEmpty() && estados.size()>=1){
				aui.setEstadoAnterior(estados.get(estados.size()-1).getEstado().toString());
			}else{
				aui.setEstadoAnterior(null);
			}
	
			operacion.AddAuditoriaDocumento(aui);
		
			System.out.println("se inserto en la Auiditoria");
			/*operacion.getDocumento().getOperacionesDocumento().size();
			em.createQuery("select Op.estados from Operacion_EstadosDocumentos Op where Op.documento.id_documento=:id")
					.setParameter("id", operacion.getDocumento().getId_documento()).getResultList().forEach(System.out::println);;
*/
			/*
			 * if (!estados.isEmpty() && estados.size() > 2) {
			 * AuditoriaDocumento aui=new
			 * AuditoriaDocumento(estados.get(estados.size() -
			 * 1).getEstado().toString(), estados.get(estados.size() -
			 * 2).getEstado().toString(),operacion); em.persist(aui);
			 * em.getTransaction().commit(); } else if (estados.size() == 1) {
			 * AuditoriaDocumento otro=new
			 * AuditoriaDocumento(estados.get(0).getEstado().toString(),
			 * operacion); em.persist(otro); em.getTransaction().commit(); }
			 */
           
		} catch (Exception e) {
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			System.out.println("Mensaje de OperacionEstadosDocumentosListener" + e.getMessage());
		} finally {
			em.close();
		}

	}

}
