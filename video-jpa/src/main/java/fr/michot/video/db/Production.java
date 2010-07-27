package fr.michot.video.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTION")
public class Production implements Serializable {

	private static final long serialVersionUID = 7982565164429271186L;

	@Id
	private int id;

	@Column(name="NOM", length=100)
	private String nom;

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
