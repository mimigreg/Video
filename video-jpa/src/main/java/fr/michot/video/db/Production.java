package fr.michot.video.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTION")
public class Production implements Serializable {

	private static final long serialVersionUID = 7982565164429271186L;

	@Id
    @GeneratedValue(generator = "production_seq")
    @SequenceGenerator(sequenceName="production_sequence", name="production_seq")
	private int id;

	@Column(name = "LOGOURL", length = 255)
	private String logoUrl;

	@Column(name = "NOM", length = 100)
	private String nom;

	public int getId() {
		return id;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public String getNom() {
		return nom;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
