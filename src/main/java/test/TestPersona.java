package test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.print.Doc;
import javax.tools.DocumentationTool;
import javax.xml.crypto.dsig.Transform;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.FlushMode;
import org.hibernate.Hibernate;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.annotations.FlushModeType;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import com.tony.Estados.Estado_Concluido;
import com.tony.Estados.Estado_documento;
import com.tony.Estados.Tipo_Perfil_UsuarioInterno;

import com.tony.Estados.Tipos_Area;
import com.tony.HerenciaEntidades.Persona;
import com.tony.models.Documento.Concluido;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Documento.OperacionDocumento;
import com.tony.models.Documento.Operacion_EstadosDocumentos;
import com.tony.models.Documento.Tipo_Documento;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioExterrno.UsuarioExternoJuridico;
import com.tony.models.UsuarioExterrno.UsuarioExternoNatural;
import com.tony.models.UsuarioInterno.Area;
import com.tony.models.UsuarioInterno.Perfil;
import com.tony.models.UsuarioInterno.Usuario_interno;

import javassist.convert.Transformer;
import com.tony.DaoImpl.DocumentoImpl;
import com.tony.DaoImpl.Entidad;
import com.tony.DaoImpl.UsuariaosImpl;

public class TestPersona {

	private static EntityManager em = Entidad.getEntidad().getEntidadManager();

	public static void main(String[] args) {
           Session s=(Session) em.getDelegate();
            System.out.println(s.createCriteria(Area.class).add(Restrictions.eq("tipoArea", Tipos_Area._Fiscalizacion_y_Control)).uniqueResult()); 
		//DocumentoImpl funci = new DocumentoImpl();
		/*
		 * Session Se=(Session)em.getDelegate(); Documento doc=new Documento();
		 * doc.
		 * setAsunto("Recursos de Apelación contra actos administrativos realizados dentro de los procesos de selección por Subasta Inversa"
		 * ); doc.setCodigo("lol"); doc.setContenido_doc("dwdwdf");
		 * doc.setNum_foleo(4); doc.setDisconforme(true);
		 * System.out.println(funci.IsRegistradoyEnviado(3, doc, 4, false,3,1));
		 */
		/*Documento doc=new Documento();
		doc.setAsunto("Recurso de Reconsideración contra Acuerdos de Concejo");
		doc.setNum_foleo(1);
		doc.setDisconforme(true);
		doc.setCodigo("fefef");
		doc.setContenido_doc("ddfghh");
		System.out.println(funci.IsRegistradoyEnviado(3, doc, 2, true, 11,2 ));*/
		/*em.getTransaction().begin();
		Documento doc=em.find(Documento.class, 613);
		em.getTransaction().commit();
		em.close();
		doc.setDisconforme(false);*/
	
		/*em.getTransaction().begin();
		Documento doc=em.find(Documento.class, 619);
		em.getTransaction().commit();
		em.close();
		doc.setDisconforme(false);
		System.out.println(funci.EnviarArea(doc, 1));*/

		/*em.getTransaction().begin();
		Documento Doc=em.find(Documento.class,632);
		em.getTransaction().commit();
		em.close();
		Doc.setDisconforme(false);
		System.out.println(funci.EnviarArea(Doc, 1));*/
		/*Documento doc=new Documento();
		doc.setAsunto("Recurso de Reconsideración contra Acuerdos de Concejo");
		doc.setCodigo("fefefe");
		doc.setContenido_doc("ghjj");
		doc.setDisconforme(true);
		doc.setNum_foleo(1);
		System.out.println(funci.IsRegistradoyEnviado(3, doc, 1, true, 11, 2));*/



		/*em.getTransaction().begin();
		Estado_documentos es = em.find(Estado_documentos.class, 1);
		Documento doc = em.find(Documento.class, 100);

		Operacion_EstadosDocumentos op2 = new Operacion_EstadosDocumentos(es, doc);
		em.persist(op2);
		em.getTransaction().commit();
		em.close();*/
		// Se.createCriteria(Documento.class).add(Restrictions.idEq(76)).createAlias("operacionesDocumento",
		// "oper").setProjection(Projections.property("oper.usuario")).list().forEach(System.out::println);
		// Se.createCriteria(Documento.class).add(Restrictions.idEq(76)).createAlias("operacionEstados",
		// "op").setProjection(Projections.property("op.estados")).list().forEach(System.out::println);
		// Documento docu=em.find(Documento.class, 68);
		// Operacion_EstadosDocumentos op=new
		// Operacion_EstadosDocumentos(em.find(Estado_documentos.class,
		// 3),em.find(Documento.class, 68));
		// em.persist(op);

		// funci.RegistrarYEnviar(1, doc,7, false, 75, 5);
		// funci.EnviarArea(32, docu);

		// System.out.println(funci.DevolucionEstado(2));
		/*
		 * UsuarioExternoJuridico ue=new UsuarioExternoJuridico();
		 * ue.setApellido("Inga Antuga"); ue.setClave("dddd");
		 * ue.setCodigo("fsdsds"); ue.setNombre("Antony");
		 * ue.setCorreo_electronico("dfdfdf@fef"); ue.setOrganizacion("dded");
		 * ue.setRuc(222323); ue.setDni(2312); ui.Registrar(ue);
		 */

		/*
		 * em.getTransaction().begin(); Persona pe=em.find(Persona.class,1);
		 * pe.setNombre("Ej Antony"); em.flush(); MostrarTodo();
		 * pe.setApellido("termino el commit"); em.getTransaction().commit();
		 * em.close(); MostrarTodo();
		 */
		/*
		 * AllVentas(); em.getTransaction().begin(); Ventas v=new Ventas();
		 * v.setId_Ventas(1); Persona pe=em.find(Persona.class, 3);
		 * pe.EliminarVenta(v); em.getTransaction().commit(); em.close();
		 * VentasIdPersona(3);
		 */

		/*
		 * em.getTransaction().begin(); Persona per=em.find(Persona.class, 1);
		 * Session se=(Session)em.getDelegate();
		 * 
		 * se.evict(per);//detachamos la entidad persona
		 * per.setNombre("Estoy detached");
		 * 
		 * for (Ventas venta :per.getVentas()) {//para poder utlizar esta
		 * funcion es necesario que el fectType este en Eager lo que quiere
		 * decir que //se van a cargar los datos de la lista ni bien levante la
		 * aplicacion se.evict(venta);//detachamos la lista de venta
		 * venta.setVentaTotal(102); } em.merge(per);//lo volvemos a la
		 * persistence context con todos los cambios realizados
		 * em.getTransaction().commit(); em.close(); AllVentas(); MostrarTodo()
		 * ;
		 */
		/*
		 * VentasIdPersona(1); em.getTransaction().begin(); Persona
		 * pe=em.find(Persona.class, 1); em.remove(pe);
		 * em.getTransaction().commit(); em.close(); VentasIdPersona(1);
		 */
		/*
		 * em.getTransaction().begin(); Persona pe1=em.find(Persona.class,2);
		 * Session s=(Session)em.getDelegate(); s.evict(pe1);
		 * pe1.getVentas().get(0).setVentaTotal(2304); em.merge(pe1);
		 * em.getTransaction().commit(); em.close(); AllVentas();
		 */
		/*
		 * em.getTransaction().begin(); Persona pe=em.find(Persona.class,2);
		 * pe.getVentas().size();//con este pequeño "hack " como esta ventas en
		 * modo Lazy no se cargara las ventas hasta ejecutar este codigo depues
		 * de //hacerlo recien estara cargada en memoria , para asi poder
		 * detachar la entidad y cambiar sus datos com merge Session
		 * s=(Session)em.getDelegate(); s.evict(pe);
		 * pe.getVentas().get(0).setVentaTotal(455); em.merge(pe);
		 * em.getTransaction().commit(); em.close();
		 */

		/*
		 * pe.getVentas().stream().map((ventas)->ventas.getDescriptcion())
		 * .flatMap((descriptcion)->descriptcion.stream()).forEach((descripcion)
		 * ->{System.out.println(descripcion.getId()+" "+descripcion.getProducto
		 * ());});
		 */
		/*
		 * pe.getVentas().stream().map((ventas)->ventas.getDescriptcion())
		 * .flatMap((desc)->desc.stream())
		 * .distinct().forEachOrdered((descripcion)->{
		 * System.out.println(descripcion.getId()+" Producto "+descripcion.
		 * getProducto()+" Cantidad Producto"+descripcion.getCadtidadProducto()
		 * +" Precio Total "+descripcion.getPrecioTotalProducto());});
		 */

		/*
		 * pe.getVentas().stream() .map((ventas)->ventas.getDescriptcion())
		 * .flatMap((descripsion)->descripsion.stream())
		 * .forEach(System.out::println);
		 */
		/*
		 * pe.getVentas().stream().forEach((venta)->{
		 * System.out.println(venta.getId_Ventas()+" Venta Total "+venta.
		 * getVentaTotal());
		 * venta.getDescriptcion().stream().forEach((descripcion)->{System.out.
		 * println(" ID D "+descripcion.getId()+"Venta Total Producto "
		 * +descripcion.getPrecioTotalProducto()+" Total Productos"+descripcion.
		 * getCadtidadProducto()+"  Producto "+descripcion.getProducto());});
		 * });
		 */
		/*
		 * try { File file=new File("C:\\Users\\tony\\Pictures\\loba.png");
		 * FileInputStream f=new FileInputStream(file);
		 * System.out.println(file.length());//agregar Fotos byte[] buffer=new
		 * byte[(int)file.length()]; f.read(buffer); pe.setFoto(buffer);
		 * em.getTransaction().commit(); } catch (Exception e) {
		 * System.out.println("erorr"+e.getMessage());
		 * if(em.getTransaction().isActive()){ em.getTransaction().rollback(); }
		 * }finally{ em.close(); }
		 */

		/*
		 * Query q=em.createQuery("from Persona p  where p.id_Persona=?1").
		 * setFlushMode(javax.persistence.FlushModeType.COMMIT);
		 * q.setParameter(1, 1); Persona p=(Persona)
		 * q.setMaxResults(1).getSingleResult(); System.out.println(p);
		 * p.setNombre("Esto Deta"); em.merge(p);
		 * System.out.println(em.find(Persona.class,1));
		 */
		// Session s=(Session)em.getDelegate();
		/*
		 * List<Ventas> p=(List<Ventas>)s.
		 * createQuery("Select p.ventas from Persona p where p.id_Persona=:id").
		 * setInteger("id",1).list(); for (Ventas persona : p) {
		 * System.out.println(persona); } Persona
		 * pe=(Persona)s.createQuery("from Persona p where p.id_Persona=:id").
		 * setInteger("id",1).uniqueResult(); System.out.println(pe); //Unico
		 * Resultado Persona
		 * person=(Persona)s.createQuery("from Persona p").setMaxResults(1).
		 * uniqueResult(); Persona
		 * persona1=(Persona)s.createCriteria(Persona.class).add(Restrictions.eq
		 * ("id",2)).uniqueResult(); Persona
		 * persona2=(Persona)s.createCriteria(Persona.class).add(Restrictions.
		 * like("nombre", "%Es%")).uniqueResult(); System.out.println(persona1);
		 * System.out.println(persona2);
		 */
		/*
		 * System.out.println("Personas Ordenadas"); List<Persona>
		 * personas=(List<Persona>)s.createCriteria(Persona.class).addOrder(
		 * Order.asc("nombre")).list(); for (Persona persona : personas) {
		 * System.out.println(persona); }
		 */
		/*
		 * System.out.println("ventas De 1 a 152"); List<Persona>
		 * per=(List<Persona>)s.createCriteria(Persona.class).createCriteria(
		 * "ventas").add(Restrictions.between("VentaTotal",91.0,1520.0)).list();
		 * 
		 * for (Persona persona : per) { System.out.println(persona); }
		 */
		/*
		 * List<Persona>
		 * PersonaCriteria=(List<Persona>)s.createCriteria(Persona.class).
		 * createCriteria("ventas").add(Restrictions.between("VentaTotal",12.0,
		 * 1520.0)) .createCriteria("descriptcion")
		 * .createCriteria("producto").add(Restrictions.eq("IdProducto", 2)).
		 * addOrder(Order.asc("nombre")).list(); for (Persona persona :
		 * PersonaCriteria) { System.out.println("Criteria"+persona); }
		 */
		/*
		 * Persona
		 * pero=(Persona)s.createCriteria(Persona.class).createAlias("ventas",
		 * "venta").add(Restrictions.eq("venta.VentaTotal",
		 * 1520.0)).setMaxResults(1).uniqueResult();
		 * System.out.println("Persona CreateAlias"+pero);//createAlias con
		 * CreateCriteria se puede asociar La ventaja de CreateAlias esque
		 * puedes Poner un SobreNombre //Pero deben ser para un array , es algo
		 * como el FlatMap De Observable
		 */
		/*
		 * List<Object[]>
		 * personas=(List<Object[]>)s.createCriteria(Persona.class).createAlias(
		 * "ventas",
		 * "venta").add(Restrictions.not(Restrictions.eq("venta.VentaTotal",
		 * 1520.0))).addOrder(Order.desc("nombre"))
		 * .setResultTransformer(CriteriaSpecification.PROJECTION) .list();
		 * 
		 * for (Object[] persona : personas) {
		 * System.out.println("toy"+((Persona)persona[1])); }
		 */
		/*
		 * List<Persona> per=(List<Persona>)s.createCriteria(Persona.class)
		 * .createAlias("ventas", "v")
		 * .add(Restrictions.between("v.VentaTotal",92.0,1520.0)).
		 * setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list
		 * (); for (Persona persona : per)
		 * {//CriteriaSpecification.DISTINCT_ROO_ENTITY hace referencia a la
		 * clase Raiz en este ejemplo es Persona.clas
		 * System.out.println(persona); }
		 */
		/*
		 * Persona
		 * pers=(Persona)s.createCriteria(Persona.class).setFetchMode("ventas",
		 * FetchMode.LAZY).add(Restrictions.idEq(1)).uniqueResult();
		 * System.out.println(pers);//le decimos que queremos recuperar kas
		 * ventas al mismo tiempo que se recupera la persona puede ser
		 * Eager,Lazy,JOIN pers.getVentas().size(); s.evict(pers);
		 * s.disconnect(); pers.setApellido("Inga Atunga Detahs");
		 * em.merge(pers); pers.setNombre("Antony Detahs"); em.flush();
		 * System.out.println(pers+" Ventas "+pers.getVentas());
		 */
		/*
		 * Persona per=new Persona(); per.setId_Persona(1);
		 * per.setNombre("Esto Deta"); Persona
		 * perso=(Persona)s.createCriteria(Persona.class).add(Example.create(per
		 * )).uniqueResult(); System.out.println(perso); // crear un criterio a
		 * partir de una instancia dada
		 */
		/*
		 * List<Persona> personas=(List<Persona>)s.getNamedQuery("all.Persona")
		 * .setTimeout(2) .setCacheMode(CacheMode.REFRESH) .setCacheable(true)
		 * .setComment("+idex(p id_persona_name)") .list(); for (Persona persona
		 * : personas) { System.out.println(persona); }
		 */
		// Persona per=em.find(Persona.class,1);
		// System.out.println(per.getVentas().get(0).getDescriptcion().get(0).getProducto().getNombre());
		/*
		 * org.hibernate.Query
		 * q=s.createQuery("from Persona p where p.id_Persona=:id"); Persona
		 * pe=(Persona)q.setParameter("id",
		 * 1,IntegerType.INSTANCE).uniqueResult(); System.out.println(pe);
		 */
		/*
		 * List<Ventas>
		 * ve=(List<Ventas>)s.createCriteria(Ventas.class).setProjection(
		 * Projections.avg("VentaTotal")).list(); for (Ventas ventas : ve) {
		 * System.out.println(ventas); }
		 */
		/*
		 * s.createCriteria(Persona.class).add(Restrictions.and(Restrictions.eq(
		 * "id", 2), Restrictions.between("venta",1520.0 , 450))).list();
		 * List<Persona>
		 * persn=(List<Persona>)s.createQuery("from Persona p").setLockOptions(
		 * LockOptions.READ).list(); for (Persona persona : persn) {
		 * persona.setNombre("Toy"); em.merge(persona); }
		 */
		// long
		// pe=(long)s.createCriteria(Persona.class).setProjection(Projections.rowCount()).uniqueResult();//
		// PRojection.rowCount() cuenta el numero de filas en la bd;
		// el projection te carga objetos parciales en este ejemplo solo
		// cargamos el nombre y cuando hay mas de una projections el ultimo sera
		// cargado

		/*
		 * Double
		 * pro=(Double)s.createCriteria(Persona.class).createAlias("ventas",
		 * "venta").setProjection(Projections.projectionList()
		 * .add(Projections.max("venta.VentaTotal")).getProjection(0)).
		 * uniqueResult(); Persona
		 * per=(Persona)s.createCriteria(Persona.class).createAlias("ventas",
		 * "venta").add(Restrictions.eq("venta.VentaTotal",
		 * pro)).uniqueResult(); System.out.println(per);
		 */

		/*
		 * s.createCriteria(Persona.class).createAlias("ventas","venta")
		 * .setResultTransformer(CriteriaSpecification.ROOT_ENTITY)
		 * .setProjection(Projections.projectionList()
		 * .add(Projections.id()).add(Projections.sum("venta.VentaTotal")).
		 * getProjection(0)).setResultTransformer(CriteriaSpecification.
		 * DISTINCT_ROOT_ENTITY).list().stream().forEach((resu)->{
		 * System.out.println(s.createCriteria(Persona.class).createAlias(
		 * "ventas",
		 * "venta").setProjection(Projections.sum("venta.VentaTotal")).add(
		 * Restrictions.eq("venta.personaVentas.id_Persona",
		 * resu)).uniqueResult().toString());}); //por cada id de la persona que
		 * los sume la VentaTotal
		 */

		/*
		 * s.createCriteria(Persona.class).createAlias("ventas",
		 * "venta").setProjection(Projections.projectionList().add(Projections.
		 * id()).getProjection(0)).setResultTransformer(CriteriaSpecification.
		 * DISTINCT_ROOT_ENTITY).setFirstResult(1).setMaxResults(10).list()
		 * .forEach((idUsuario)-> System.out.println("ID Usuario "+idUsuario
		 * +" "+s.createCriteria(Persona.class).createAlias("ventas",
		 * "venta").setProjection(Projections.max("venta.VentaTotal")).add(
		 * Restrictions.idEq(idUsuario)).uniqueResult().toString()));
		 */
		// s.createQuery("Select p.nombre,p.apellido,p.id_Persona from Persona
		// p").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list().forEach(System.out::println);
		/*
		 * for(int i=1;i<=3;i++){
		 * s.createCriteria(Persona.class).createAlias("ventas","venta").
		 * setProjection(Projections.projectionList().add(Projections.count(
		 * "venta.personaVentas.id_Persona").as("numeroUsuarios")).getProjection
		 * (0)) .add(Restrictions.idEq(i)).setProjection(Projections.sum(
		 * "venta.VentaTotal")).list().stream().forEach(System.out::println);
		 * 
		 * }
		 */
               // Inicio();
	}

	private static void Inicio() {
		em.getTransaction().begin();
		for (Estado_Concluido es : Estado_Concluido.values()) {
			Concluido con = new Concluido();
			con.setEstadoConcluido(es);
			em.persist(con);
		}
		for (Estado_documento estado : Estado_documento.values()) {
			Estado_documentos est = new Estado_documentos();
			est.setEstado(estado);
			em.persist(est);
		}
		for (com.tony.Estados.Tipo_Documento tipo : com.tony.Estados.Tipo_Documento.values()) {
			Tipo_Documento ti = new Tipo_Documento();
			ti.setTipoDocumento(tipo);
			em.persist(ti);
		}
		for (Tipo_Perfil_UsuarioInterno tipoI : Tipo_Perfil_UsuarioInterno.values()) {
			Perfil per = new Perfil();
			per.setTipoPerfil(tipoI);
			em.persist(per);
		}
		for (Tipos_Area ar : Tipos_Area.values()) {
			Area are = new Area();
			are.setTipoArea(ar);
			em.persist(are);
		}
		em.getTransaction().commit();
		em.close();

	}

	/*
	 * private static void MostrarTodo() { EntityManager em =
	 * emf.createEntityManager(); List<Persona> personas = (List<Persona>)
	 * em.createNamedQuery("all.Persona", Persona.class).getResultList();
	 * System.out.println("hay " + personas.size() + " personas registradas");
	 * for (Persona peron : personas) { System.out.println(peron); } em.close();
	 * }
	 * 
	 * private static void CrearDatos() { EntityManager em =
	 * emf.createEntityManager(); em.getTransaction().begin(); Direccion
	 * dire1=new Direccion("bobEsponja3","Calamardo3");
	 * dire1.setId_Direccion(3); Persona pe=new Persona("Antony1",
	 * "Inga Atunga2"); pe.setId_Persona(3); pe.setDirecion(dire1);
	 * em.persist(pe); Ventas ventas=new Ventas(1,pe); em.persist(ventas);
	 * em.getTransaction().commit(); em.close(); } private static void
	 * VentasIdPersona(int id){ EntityManager em=emf.createEntityManager();
	 * Query w=em.createNamedQuery("venta.find",Ventas.class);
	 * w.setParameter(1,id); if(w.getResultList().isEmpty()){
	 * System.out.println("No hay Ventas para ese usuario"); }else{
	 * w.getResultList().stream().forEach(System.out::println); } em.close(); }
	 * private static void AllVentas(){ EntityManager
	 * em=emf.createEntityManager(); for (Ventas venta :
	 * em.createNamedQuery("all.ventas",Ventas.class).getResultList()) {
	 * System.out.println(venta); } em.close(); }
	 */
}
