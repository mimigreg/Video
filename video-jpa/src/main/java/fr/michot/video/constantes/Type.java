package fr.michot.video.constantes;

public enum Type {
	EMISSION("Emission"),
	MUSIQUE("Musique"),
	DOCUMENTAIRE("Documentaire"),
	SPORT("Sport"),
	DESSINANIME("Dessin Animé"),
	HUMOUR("Humour"),
	BURLESQUE("Burlesque"),
	PARODIE("Parodie"),
	ACTION("Action"),
	GUERRE("Guerre"),
	TRILLER("Triller"),
	POLICIER("Policier"),
	SCIFI("Science Fiction"),
	FANTASTIQUE("Fantastique"),
	DRAME("Drame"),
	AMOUR("Amour"),
	HORREUR("Horreur"),
	EROTIQUE("Erotique"),
	PORNO("Pornographique"),
	NUDITE("Contient des scènes de nudité"),
	GORE("Contient des scènes gore"),
	VIOLENCE("Contient des scènes de violence");
	
	String libelle;
	
	Type(String libelle) {
		this.libelle = libelle;
	}
	
}
