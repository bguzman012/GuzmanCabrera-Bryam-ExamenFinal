package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Paciente;

@Stateless
public class PacienteFacade extends AbstractFacade<Paciente> {
	
	
	@PersistenceContext(unitName = "GuzmanCabrera-Bryam-ExamenFinal")
	private EntityManager em;

	public PacienteFacade() {
		super(Paciente.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<Paciente> readPacienteByCedula(String cedula) {
		System.out.println("LLega la cedula al facade" +  cedula);
		Query query = em.createNamedQuery("getByCedula");
		query.setParameter("cedula", cedula);
		List result = query.getResultList();
		if (result.isEmpty()) {
			System.out.println("No se ha realizado la busqueda todavia o no hay registros");
		}
		return result;
	}
	

}