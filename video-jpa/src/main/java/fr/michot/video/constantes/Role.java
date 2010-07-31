package fr.michot.video.constantes;

public enum Role {
	ACTEUR("Acteur", "Actrice"), REALISATEUR("Réalisateur", "Réalisatrice"), PRODUCTEUR(
			"Producteur", "Productrice"), SCENARISTE("Scénariste", "Scénariste");

	private String libelleMasculin;
	private String libelleFeminin;

	Role(String libelleMasculin, String libelleFeminin) {
		this.libelleMasculin = libelleMasculin;
		this.libelleFeminin = libelleFeminin;
	}

	String libelle(Boolean estHomme) {
		if (estHomme)
			return libelleMasculin;
		else
			return libelleFeminin;
	}
}
