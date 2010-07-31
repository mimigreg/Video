package fr.michot.video.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import fr.michot.video.db.Collection;

public class CollectionServiceImpl {
	@PersistenceContext
	EntityManager em;

	@Transactional
	public Collection enregistrerNouveau(String titre) {
		Collection aCollection = new Collection();
		aCollection.setTitre(titre);
		em.persist(aCollection);
		return aCollection;
	}
	
	public Collection modifie(int idCollection, String titre) {
		return modifie(em.find(Collection.class, idCollection), titre);
	}	
	
	@Transactional
	public Collection modifie(Collection aCollection, String titre) {
		aCollection.setTitre(titre);
		em.persist(aCollection);
		return aCollection;
	}
	
	public void efface(int idCollection) {
		efface(em.find(Collection.class, idCollection));
	}

	@Transactional
	public void efface(Collection aCollection) {
		em.remove(aCollection);
	}
	
	@SuppressWarnings("unchecked")
	public List<Collection> recherche(String titre) {
		if(titre==null) return new ArrayList<Collection>();
		Query uneRequete = em.createQuery("SELECT coll FROM Collection coll WHERE coll.titre LIKE :titre%");
		uneRequete.setParameter("titre", titre);
		return uneRequete.setMaxResults(50).getResultList();		
	}
}
