package fr.michot.video.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TYPE")
public class Type implements Serializable {

	private static final long serialVersionUID = 890592249506797869L;

	@Id
	private int id;

	@Column(name = "LIBELLE", length = 100)
	private String libelle;

	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
