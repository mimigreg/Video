package fr.michot.video.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONNE")
public class Personne implements Serializable {

	private static final long serialVersionUID = 8741884661901970147L;

	@Column(name = "ANNOTATIONS", length = 1000)
	private String annotations;

	@Column(name = "HOMME")
	private Boolean homme;

	@Id
	private int id;

	@Column(name = "NOM", length = 100)
	private String nom;

	@Column(name = "PHOTOURL", length = 255)
	private String photoUrl;

	@Column(name = "PRENOM", length = 100)
	private String prenom;

	@Column(name = "PRIVE")
	private Boolean prive;

	public String getAnnotations() {
		return annotations;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public String getPrenom() {
		return prenom;
	}

	public Boolean isHomme() {
		return homme;
	}

	public Boolean isPrive() {
		return prive;
	}

	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}

	public void setHomme(Boolean homme) {
		this.homme = homme;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setPrive(Boolean prive) {
		this.prive = prive;
	}
}
