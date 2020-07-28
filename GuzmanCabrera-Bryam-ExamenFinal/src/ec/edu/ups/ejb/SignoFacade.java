package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.SignoVital;

@Stateless
public class SignoFacade extends AbstractFacade<SignoVital> {
	
	
	@PersistenceContext(unitName = "GuzmanCabrera-Bryam-ExamenFinal")
	private EntityManager em;

	public SignoFacade() {
		super(SignoVital.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}