package fr.michot.video.ihm.portlet.personne;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class PersonneViewModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4551802319723789789L;
	@Size(max=100,min=1)
	private String nom;
	@Size(max=255)
	private String photoUrl;
	@Size(max=100)
	private String prenom;
	private Boolean prive;
	private Boolean homme;
	@Size(max=1000)
	private String annotations;
	private int id;
	private boolean editMode;
	
	public PersonneViewModel() {
		super();
		this.id=-1;
	}
	
	public PersonneViewModel(int id, String nom, String photoUrl, String prenom,
			Boolean prive, Boolean homme, String annotations, boolean editMode) {
		super();
		this.id=id;
		this.nom = nom;
		this.photoUrl = photoUrl;
		this.prenom = prenom;
		this.prive = prive;
		this.homme = homme;
		this.annotations = annotations;
		this.editMode = editMode;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Boolean getPrive() {
		return prive;
	}
	public void setPrive(Boolean prive) {
		this.prive = prive;
	}
	public Boolean getHomme() {
		return homme;
	}
	public void setHomme(Boolean homme) {
		this.homme = homme;
	}
	public String getAnnotations() {
		return annotations;
	}
	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}
	public boolean isEditMode() {
		return editMode;
	}
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((annotations == null) ? 0 : annotations.hashCode());
		result = prime * result + (editMode ? 1231 : 1237);
		result = prime * result + ((homme == null) ? 0 : homme.hashCode());
		result = prime * result + id;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result
				+ ((photoUrl == null) ? 0 : photoUrl.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((prive == null) ? 0 : prive.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonneViewModel other = (PersonneViewModel) obj;
		if (annotations == null) {
			if (other.annotations != null)
				return false;
		} else if (!annotations.equals(other.annotations))
			return false;
		if (editMode != other.editMode)
			return false;
		if (homme == null) {
			if (other.homme != null)
				return false;
		} else if (!homme.equals(other.homme))
			return false;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (photoUrl == null) {
			if (other.photoUrl != null)
				return false;
		} else if (!photoUrl.equals(other.photoUrl))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (prive == null) {
			if (other.prive != null)
				return false;
		} else if (!prive.equals(other.prive))
			return false;
		return true;
	}

}
