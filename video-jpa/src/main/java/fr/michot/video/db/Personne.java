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
	
	@Column(name="ANNOTATIONS", length=1000)
	private String annotations;

	@Id
	private int id;
	
	@Column(name="NOM", length=100)
	private String nom;

	@Column(name="PHOTOURL", length=255)
	private String photoUrl;

	@Column(name="PRENOM", length=100)
	private String prenom;

	@Column(name="PRIVE")
	private boolean prive;

	@Column(name="SEXE")
	private boolean sexe;

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

	public boolean isPrive() {
		return prive;
	}

	public boolean isSexe() {
		return sexe;
	}

	public void setAnnotations(String annotations) {
		this.annotations = annotations;
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

	public void setPrive(boolean prive) {
		this.prive = prive;
	}

	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}
}
