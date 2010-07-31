package fr.michot.video.business.services.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import fr.michot.video.constantes.Type;
import fr.michot.video.db.Collection;
import fr.michot.video.db.Emprunt;
import fr.michot.video.db.Film;
import fr.michot.video.db.Personne;
import fr.michot.video.db.Production;
import fr.michot.video.db.Registre;

public class FilmServiceImpl {
	@PersistenceContext
	EntityManager em;

	public Emprunt emprunter(int idFilm, int idPersonne) {
		Film aFilm = em.find(Film.class, idFilm);
		Personne aPersonne = em.find(Personne.class, idPersonne);
		return emprunter(aFilm, aPersonne);
	}
	
	public Film enregistrerNouveau(String titre, String resume, String imageUrl, int idProduction, int idCollection){
		Production aProduction = em.find(Production.class, idProduction);
		Collection aCollection = em.find(Collection.class, idCollection);
		return enregistrerNouveau(titre, resume, imageUrl, aProduction, aCollection);
	}
	
	public Registre ajoutQualificatif(int idFilm, int poids, Type type){
		Film aFilm = em.find(Film.class, idFilm);
		return ajoutQualificatif(aFilm, poids, type);
	}
	
	@Transactional
	public Emprunt emprunter(Film film, Personne personne) {
		Emprunt anEmprunt = new Emprunt();
		anEmprunt.setFilm(film);
		anEmprunt.setPersonne(personne);
		anEmprunt.setDate(new Date());
		em.persist(anEmprunt);
		return anEmprunt;
	}
	
	@Transactional
	public Film enregistrerNouveau(String titre, String resume, String imageUrl, Production production, Collection collection) {
		Film aFilm = new Film();
		aFilm.setTitre(titre);
		aFilm.setResume(resume);
		aFilm.setProduction(production);
		aFilm.setImageUrl(imageUrl);
		aFilm.setCollection(collection);
		em.persist(aFilm);
		return aFilm;
	}
	
	@Transactional
	public Registre ajoutQualificatif(Film film, int poids, Type type) {
		Registre aRegistre = new Registre();
		aRegistre.setFilm(film);
		aRegistre.setPoids(poids);
		aRegistre.setType(type);
		em.persist(aRegistre);
		return aRegistre;
	}
}
