package fr.michot.video.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REGISTRE")
public class Registre implements Serializable {
	private static final long serialVersionUID = 1544069804411977572L;

	@ManyToOne
	private Film film;

	@Id
	private int id;

	@Column(name = "POIDS")
	private int poids;

	@ManyToOne
	private Type type;

	public Film getFilm() {
		return film;
	}

	public int getId() {
		return id;
	}

	public int getPoids() {
		return poids;
	}

	public Type getType() {
		return type;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
