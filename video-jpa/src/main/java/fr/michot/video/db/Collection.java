package fr.michot.video.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COLLECTION")
public class Collection implements Serializable {
	private static final long serialVersionUID = 1211143841698565469L;

	@Id
    @GeneratedValue(generator = "collection_seq")
    @SequenceGenerator(sequenceName="collection_sequence", name="collection_seq")
	private int id;

	@Column(name = "TITRE", length = 100)
	private String titre;

	public int getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}
