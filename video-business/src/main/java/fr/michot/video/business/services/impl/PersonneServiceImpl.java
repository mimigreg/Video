package fr.michot.video.business.services.impl;

import java.io.StringWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import fr.michot.video.db.Film;
import fr.michot.video.db.Personne;
import fr.michot.video.db.Role;

public class PersonneServiceImpl {
	@PersistenceContext
	EntityManager em;

	public void effacePersonne(int idPersonne) {
		Personne aPersonne = em.find(Personne.class, idPersonne);
		effacePersonne(aPersonne);
	}

	public Personne modifiePersonne(int idPersonne, String nom, String prenom,
			Boolean homme, Boolean prive, String photoUrl, String annotations) {
		Personne aPersonne = em.find(Personne.class, idPersonne);
		return modifiePersonne(aPersonne, nom, prenom, homme, prive, photoUrl,
				annotations);
	}

	@SuppressWarnings("unchecked")
	public List<Personne> recherchePersonne(String nom, String prenom, Boolean homme, Boolean prive) {
		boolean wherePresent = false;
		StringWriter qlStringWriter = new StringWriter();
		qlStringWriter.write("SELECT pers FROM Personne pers");
		if(nom !=null) qlStringWriter.write(wherePresent?" WHERE ":" "+"pers.nom LIKE :nom%");
		if(prenom !=null) qlStringWriter.write(wherePresent?" WHERE ":" AND "+"pers.prenom LIKE :prenom%");
		if(homme !=null) qlStringWriter.write(wherePresent?" WHERE ":" AND "+"pers.homme = :homme");
		if(prive !=null) qlStringWriter.write(wherePresent?" WHERE ":" AND "+"pers.prive = :prive");
		qlStringWriter.write(" ORDER BY pers.nom ascending");
		
		Query uneRequete = em.createQuery(qlStringWriter.toString());
		if(nom !=null) uneRequete.setParameter("nom", nom);
		if(prenom !=null) uneRequete.setParameter("prenom", prenom);
		if(homme !=null) uneRequete.setParameter("homme", homme);
		if(prive !=null) uneRequete.setParameter("prive", prive);
		return uneRequete.setMaxResults(50).getResultList();
	}
	
	public List<Personne> recherchePersonneParFilm(int idFilm) {
		return recherchePersonne(em.find(Film.class, idFilm));
	}
	
	public List<Personne> recherchePersonneParRole(int idRole) {
		return recherchePersonne(em.find(Role.class, idRole));
	}
	
	@SuppressWarnings("unchecked")
	public List<Personne> recherchePersonne(Film aFilm) {
		if(aFilm==null) return recherchePersonne(null, null, null, null);
		Query uneRequete = em.createQuery("SELECT pers FROM Personne pers, Participation part WHERE pers = part.personne and part.film = :film");
		uneRequete.setParameter("film", aFilm);
		return uneRequete.setMaxResults(50).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Personne> recherchePersonne(Role aRole) {
		if(aRole==null) return recherchePersonne(null, null, null, null);
		Query uneRequete = em.createQuery("SELECT pers FROM Personne pers, Participation part WHERE pers = part.personne and part.role = :role");
		uneRequete.setParameter("role", aRole);
		return uneRequete.setMaxResults(50).getResultList();
	}
	
	@Transactional
	public Personne ajoutePersonne(String nom, String prenom, Boolean homme,
			Boolean prive, String photoUrl, String annotations) {
		Personne aPersonne = new Personne();
		aPersonne.setNom(nom);
		aPersonne.setPrenom(prenom);
		aPersonne.setHomme(homme);
		aPersonne.setPrive(prive);
		aPersonne.setPhotoUrl(photoUrl);
		aPersonne.setAnnotations(annotations);
		em.persist(aPersonne);
		return aPersonne;
	}

	@Transactional
	public Personne modifiePersonne(Personne aPersonne, String nom,
			String prenom, Boolean homme, Boolean prive, String photoUrl,
			String annotations) {
		if (aPersonne == null)
			return aPersonne;
		if (nom != null)
			aPersonne.setNom(nom);
		if (prenom != null)
			aPersonne.setPrenom(prenom);
		if (homme != null)
			aPersonne.setHomme(homme);
		if (prive != null)
			aPersonne.setPrive(prive);
		if (photoUrl != null)
			aPersonne.setPhotoUrl(photoUrl);
		if (annotations != null)
			aPersonne.setAnnotations(annotations);
		if (!(annotations == null && photoUrl == null && prive == null
				&& homme == null && prenom == null && nom == null))
			em.persist(aPersonne);
		return aPersonne;
	}

	@Transactional
	public void effacePersonne(Personne personne) {
		em.remove(personne);
	}

}
