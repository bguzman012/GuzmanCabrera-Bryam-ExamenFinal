package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.CitaMedica;

@Stateless
public class CitaFacade extends AbstractFacade<CitaMedica> {
	
	
	@PersistenceContext(unitName = "GuzmanCabrera-Bryam-ExamenFinal")
	private EntityManager em;

	public CitaFacade() {
		super(CitaMedica.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	

}
