package tony.com.DaoImpl;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;

import com.tony.Dao.IUsuarios;
import com.tony.Estados.Tipo_Perfil_UsuarioInterno;
import com.tony.HerenciaEntidades.Persona;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioInterno.Usuario_interno;

public class UsuariaosImpl implements IUsuarios {
	private static EntityManager em = Entidad.getEntidad().getEntidadManager();
	private static Session se = (Session) em.getDelegate();

	@Override
	public boolean Registrar(Persona persona) {
		boolean isRegistrado = false;
		try {
			// System.out.println(s.createCriteria(Persona.class).add(Restrictions.eq("dni",
			// 1233)).setMaxResults(1).uniqueResult());
			Persona pe = (Persona) se.createCriteria(Persona.class).add(Restrictions.eq("dni", persona.getDni()))
					.setMaxResults(1).uniqueResult();
			if (pe == null) {
				em.getTransaction().begin();
				em.persist(persona);
				em.getTransaction().commit();
				isRegistrado = true;
			}
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println("mensaje" + e.getMessage());

		} finally {
			em.close();

		}
		return isRegistrado;
	}

	public List<Persona> AllPersona() {
		List<Persona> personas = null;
		try {
			em.getTransaction().begin();
			personas = (List<Persona>) em.createNamedQuery("Persona.all").getResultList();
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return personas;
	}

	@Override
	public int NumeroDocumentos(int DniUsuarioExterno) {
		int NumeroDocumentos = 0;
		try {
			em.getTransaction().begin();
			NumeroDocumentos = ((UsuarioExterno) em.createNamedQuery("UsuarioExterno.documentos.findDni")
					.setParameter("dni", DniUsuarioExterno).setMaxResults(1).getSingleResult()).getDocumentos().size();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println("mensaje de NumeroDocumentos " + e.getMessage());
		} finally {
			em.close();
		}
		return NumeroDocumentos;
	}
	@Override
	public List<Documento> DocumentosPersona(Persona person) {
		List<Documento> docu = (List<Documento>) se.createCriteria(Documento.class).createAlias("persona", "p")
				.add(Restrictions.eq("p.dni", person.getDni())).list();
		return docu;
	}
	@Override
	public boolean AddDocumentosPersona(Persona PersonaActual, Documento docunmento,Persona Derivada) {
		boolean idAddDocumento = false;
		
		return idAddDocumento;
	}

}
