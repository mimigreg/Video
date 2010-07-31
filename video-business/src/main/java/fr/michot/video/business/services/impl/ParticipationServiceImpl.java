package fr.michot.video.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import fr.michot.video.constantes.Role;
import fr.michot.video.db.Film;
import fr.michot.video.db.Participation;
import fr.michot.video.db.Personne;

public class ParticipationServiceImpl {
	@PersistenceContext
	EntityManager em;

	public List<Participation> rechercheParFilm(int idFilm) {		
		return rechercheParFilm(em.find(Film.class, idFilm));
	}
		
	public List<Participation> rechercheParPersonne(int idPersonne) {		
		return rechercheParPersonne(em.find(Personne.class, idPersonne));
	}
	
	@SuppressWarnings("unchecked")
	public List<Participation> rechercheParFilm (Film aFilm) {
		if(aFilm==null) return new ArrayList<Participation>();
		Query uneRequete = em.createQuery("SELECT part FROM Participation part WHERE part.film = :film");
		uneRequete.setParameter("film", aFilm);
		return uneRequete.setMaxResults(50).getResultList();		
	}
	
	@SuppressWarnings("unchecked")
	public List<Participation> rechercheParRole (Role aRole) {
		if(aRole==null) return new ArrayList<Participation>();
		Query uneRequete = em.createQuery("SELECT part FROM Participation part WHERE part.role = :role");
		uneRequete.setParameter("role", aRole);
		return uneRequete.setMaxResults(50).getResultList();		
	}
	
	@SuppressWarnings("unchecked")
	public List<Participation> rechercheParPersonne (Personne aPersonne) {
		if(aPersonne==null) return new ArrayList<Participation>();
		Query uneRequete = em.createQuery("SELECT part FROM Participation part WHERE part.personne = :personne");
		uneRequete.setParameter("personne", aPersonne);
		return uneRequete.setMaxResults(50).getResultList();		
	}
	
	@Transactional
	public Participation ajouteParticipation(Film film, Personne personne,
			Role role, String precision) {
		Participation aParticipation = new Participation();
		aParticipation.setFilm(film);
		aParticipation.setPersonne(personne);
		aParticipation.setRole(role);
		aParticipation.setPrecision(precision);
		em.persist(aParticipation);
		return aParticipation;
	}

	public Participation ajouteParticipation(int idFilm, int idPersonne, Role aRole, String precision){
		Film aFilm = em.find(Film.class, idFilm);
		Personne aPersonne = em.find(Personne.class, idPersonne);
		return ajouteParticipation(aFilm, aPersonne, aRole, precision);
	}

	@Transactional
	public void effaceParticipation(Participation Participation) {
		em.remove(Participation);
	}

	public void effacePparticipation(int idParticipation) {
		Participation aParticipation = em.find(Participation.class,
				idParticipation);
		effaceParticipation(aParticipation);
	}

	public Participation modifieParticipation(int idParticipation, Film film,
			Personne personne, Role role, String precision) {
		Participation aParticipation = em.find(Participation.class,
				idParticipation);
		return modifieParticipation(aParticipation, film, personne, role,
				precision);
	}

	@Transactional
	public Participation modifieParticipation(Participation aParticipation,
			Film film, Personne personne, Role role, String precision) {
		if (aParticipation == null)
			return aParticipation;
		if (film != null)
			aParticipation.setFilm(film);
		if (personne != null)
			aParticipation.setPersonne(personne);
		if (role != null)
			aParticipation.setRole(role);
		if (precision != null)
			aParticipation.setPrecision(precision);
		if (!(film == null && personne == null && role == null && precision == null))
			em.persist(aParticipation);
		return aParticipation;
	}

}
