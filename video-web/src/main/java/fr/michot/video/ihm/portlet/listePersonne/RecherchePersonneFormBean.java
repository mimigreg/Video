package fr.michot.video.ihm.portlet.listePersonne;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class RecherchePersonneFormBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8408198943536874069L;

	private boolean rechercheAvancee=false;
	
	@Size(max=100)
	private String nom;
	
	@Size(max=100)
	private String prenom;
	
	private Boolean homme;

	private Boolean prive;

	public boolean isRechercheAvancee() {
		return rechercheAvancee;
	}

	public void setRechercheAvancee(boolean rechercheAvancee) {
		this.rechercheAvancee = rechercheAvancee;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((homme == null) ? 0 : homme.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((prive == null) ? 0 : prive.hashCode());
		result = prime * result + (rechercheAvancee ? 1231 : 1237);
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
		RecherchePersonneFormBean other = (RecherchePersonneFormBean) obj;
		if (homme == null) {
			if (other.homme != null)
				return false;
		} else if (!homme.equals(other.homme))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
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
		if (rechercheAvancee != other.rechercheAvancee)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecherchePersonneFormBean [rechercheAvancee=" + rechercheAvancee + ", nom=" + nom + ", prenom=" + prenom + ", homme=" + homme + ", prive="
				+ prive + "]";
	}
	
}
