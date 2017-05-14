package tony.com.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tony.Dao.IDocumento;
import com.tony.Estados.Tipo_Perfil_UsuarioInterno;
import com.tony.Estados.Tipos_Area;
import com.tony.models.Tupa;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Documento.OperacionDocumento;
import com.tony.models.Documento.Operacion_EstadosDocumentos;
import com.tony.models.Documento.Tipo_Documento;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioInterno.Usuario_interno;

public class DocumentoImpl implements IDocumento {

	@Override
	public boolean Registrar(int IdusuaInterno, Documento documento, int idTipoDocumento, boolean isTupac,
			int idUsuaraioExterno) {
		boolean OperacionExitosa = false;
		EntityManager em = Entidad.getEntidad().getEntidadManager();
		Session se = (Session) em.getDelegate();
		try {
			em.getTransaction().begin();
			Usuario_interno UsuarioInterno = (Usuario_interno) em.find(Usuario_interno.class, IdusuaInterno);
			UsuarioExterno UsuarioExterno = (UsuarioExterno) em.find(UsuarioExterno.class, idUsuaraioExterno);
			if (UsuarioInterno.getArea().getTipoArea().compareTo(Tipos_Area.Tramite_Documentario_y_Archivo_Central) == 0
					&& UsuarioInterno.getPerfil().getTipoPerfil()
							.compareTo(Tipo_Perfil_UsuarioInterno.Profesional) == 0) {
				// si esque no tiene Tupac va a venir de la vista el Asunto7
				System.out.println("entro aal if");
				documento.setTipoDocumento(em.find(Tipo_Documento.class, idTipoDocumento));
				if (isTupac) {
					Tupa tupa = (Tupa) se.createCriteria(Tupa.class)
							.add(Restrictions.eq("procedimiento", documento.getAsunto())).setMaxResults(1)
							.uniqueResult();
					documento.setTupa(tupa);
				}
				OperacionDocumento operacionDocuemento = new OperacionDocumento(UsuarioInterno, documento);
				documento.AddOperacionDocumentos(operacionDocuemento);
				UsuarioExterno.addDocumento(documento);
				em.getTransaction().commit();
				OperacionExitosa = true;
			}

		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				System.out.println("Mensaje de registrarYEnviar" + e.getMessage());
			}
		} finally {
			em.close();
		}
		return OperacionExitosa;
	}

	public boolean IsRegistradoyEnviado(int IdusuaInterno, Documento documento, int idTipoDocumento, boolean isTupac,
			int idUsuaraioExterno) {
		EntityManager em = Entidad.getEntidad().getEntidadManager();
		boolean isTodo = false;
		try {
			em.getTransaction().begin();
			Estado_documentos estadoDocumento = null;
			if (this.Registrar(IdusuaInterno, documento, idTipoDocumento, isTupac, idUsuaraioExterno)
					&& EnviarArea(documento, 2)) {
				estadoDocumento = DevolucionEstado(2);

			} else {
				estadoDocumento = DevolucionEstado(1);
			}
			Operacion_EstadosDocumentos operacionEstadosDocuementos = new Operacion_EstadosDocumentos(estadoDocumento,
					documento);
			em.persist(operacionEstadosDocuementos);
			em.getTransaction().commit();
			isTodo = true;
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println("mensaje de IsRegistradoYEnviado" + e.getMessage());
		} finally {
			em.close();
		}
		return isTodo;
	}

	@Override
	public boolean EnviarArea(Documento doc, int tipo) {
		EntityManager em = Entidad.getEntidad().getEntidadManager();
		Session s = (Session) em.getDelegate();
		boolean isEnvio = false;
		try {
			if (!doc.isDisconforme()) {
				System.out.println("entro a la funcion");
				em.getTransaction().begin();
				int idArea = (int) s.createCriteria(Tupa.class).add(Restrictions.eq("procedimiento", doc.getAsunto()))
						.createAlias("area", "ar").setProjection(Projections.property("ar.id_area")).setMaxResults(1)
						.uniqueResult();
				System.out.println(idArea);

				List<Usuario_interno> usuarioInterno = (List<Usuario_interno>) s.createCriteria(Usuario_interno.class)
						.add(Restrictions.eq("area.id_area", idArea)).list();
				if (!usuarioInterno.isEmpty() && usuarioInterno != null) {
					usuarioInterno.stream()
							.filter((user) -> (user.getPerfil().getTipoPerfil()
									.compareTo(Tipo_Perfil_UsuarioInterno.Punto_de_Control) == 0
									&& user.getArea().getTipoArea()
											.compareTo(Tipos_Area.Tramite_Documentario_y_Archivo_Central) != 0))
							.forEach((usuario) -> {

								OperacionDocumento op = new OperacionDocumento(usuario, doc);
								usuario.AddOperacionDocumento(op);
								if (tipo == 1) {// si es uno se va a encargar de
												// enviar al area y cambiar de
												// estado al documento
									Operacion_EstadosDocumentos EstadoDocumento = new Operacion_EstadosDocumentos(
											em.find(Estado_documentos.class, 2), doc);
									em.persist(EstadoDocumento);
								}
								em.merge(usuario);
								em.getTransaction().commit();

							});
					isEnvio = true;

				}
			} else {
				return false;
			}
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				System.out.println("Mensaje de EnviarArea" + e.getMessage());
			}
		} finally {
			em.close();
		}
		return isEnvio;
	}

	private Estado_documentos DevolucionEstado(int Id_estado) {
		Estado_documentos es = null;
		EntityManager em = Entidad.getEntidad().getEntidadManager();
		Session s = (Session) em.getDelegate();
		try {
			em.getTransaction().begin();
			es = (Estado_documentos) s.createCriteria(Estado_documentos.class).add(Restrictions.idEq(Id_estado))
					.setMaxResults(1).uniqueResult();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("mensaje de Devolucion Estado" + e.getMessage());
		} finally {
			em.close();
		}
		if (es != null) {
			es.getOperacionEstados().size();
			return es;

		}
		return null;
	}

	public List<Documento> DocumentoPorEnviar(int idArea) {
		EntityManager em = Entidad.getEntidad().getEntidadManager();
		List<Documento> documentos = new ArrayList<>();
		Session se = (Session) em.getDelegate();
		try {
			em.getTransaction().begin();
			se.createCriteria(Documento.class).createAlias("operacionesDocumento", "opeDo")
					.createAlias("opeDo.usuario", "user").add(Restrictions.eq("user.area.id_area", idArea))
					.createAlias("operacionEstados", "op").add(Restrictions.eq("op.estados.id_estadoDocumento", 1))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list().forEach(System.out::println);
			;
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println("Mensaje de DocumnetoPorEnviar" + e.getMessage());
		} finally {
			em.close();
		}
		return documentos;

	}

	@Override
	public boolean EditarDocumento(Documento doc) {

		return false;
	}

}
