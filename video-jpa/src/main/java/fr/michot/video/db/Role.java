package fr.michot.video.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

	private static final long serialVersionUID = 1343365665643958338L;

	@Id
	private int id;

	@Column(name="NOM",length=100)
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
