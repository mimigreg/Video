package fr.michot.video.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Film
 * 
 */
@Entity
@Table(name = "FILM")
public class Film implements Serializable {

	private static final long serialVersionUID = -2188784921590896242L;

	@ManyToOne
	private Collection collection;

	@Id
	private int id;

	@Column(name = "IMAGEURL",length=255)
	private String imageUrl;

	@Column(name="NOTE")
	private int note;

	@ManyToOne
	private Production production;

	@Column(name ="RESUME",length=4000)
	private String resume;

	@Column(name = "TITRE", length=100)
	private String titre;

	public Film() {
		super();
	}
	
	public Collection getCollection() {
		return collection;
	}
	
	public int getId() {
		return id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public int getNote() {
		return note;
	}
	
	public Production getProduction() {
		return production;
	}

	public String getResume() {
		return resume;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}
