package fr.michot.video.db;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt implements Serializable {
	private static final long serialVersionUID = 3173938871231656744L;

	@Column(name = "DATE")
	private Date date;

	@ManyToOne
	private Film film;

	@Id
	private int id;

	@ManyToOne
	private Personne personne;

	public Date getDate() {
		return date;
	}

	public Film getFilm() {
		return film;
	}

	public int getId() {
		return id;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
}
