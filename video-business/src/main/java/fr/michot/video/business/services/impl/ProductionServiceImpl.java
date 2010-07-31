package fr.michot.video.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import fr.michot.video.db.Production;

public class ProductionServiceImpl {
	@PersistenceContext
	EntityManager em;

	@Transactional
	public Production enregistrerNouveau(String nom, String logoUrl) {
		Production aProduction = new Production();
		aProduction.setNom(nom);
		aProduction.setLogoUrl(logoUrl);
		em.persist(aProduction);
		return aProduction;
	}
	
	public Production modifie(int idProduction, String nom, String logoUrl) {
		return modifie(em.find(Production.class, idProduction), nom, logoUrl);
	}	
	
	@Transactional
	public Production modifie(Production aProduction, String nom, String logoUrl) {
		aProduction.setNom(nom);
		aProduction.setLogoUrl(logoUrl);
		em.persist(aProduction);
		return aProduction;
	}
	
	public void efface(int idProduction) {
		efface(em.find(Production.class, idProduction));
	}

	@Transactional
	public void efface(Production aProduction) {
		em.remove(aProduction);
	}
	
	@SuppressWarnings("unchecked")
	public List<Production> recherche(String nom) {
		if(nom==null) return new ArrayList<Production>();
		Query uneRequete = em.createQuery("SELECT coll FROM Production coll WHERE coll.nom LIKE :nom%");
		uneRequete.setParameter("nom", nom);
		return uneRequete.setMaxResults(50).getResultList();		
	}
}
