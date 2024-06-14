package org.generation.italy.model;

public class Pistola extends ArmaDaFuoco {
	private String sottocanna, mirino;
	private boolean estratta;

	public String getSottocanna() {
		return sottocanna;
	}

	public void setSottocanna(String sottocanna) {
		this.sottocanna = sottocanna;
	}

	public String getMirino() {
		return mirino;
	}

	public void setMirino(String mirino) {
		this.mirino = mirino;
	}

	public String premiGrilletto() {//prova a sparare se la pistola è estratta
		if (this.isEstratta())
			return spara(1);
		else
			return "Devi prima estrarre l'arma dalla fondina!";
	}

	public boolean isEstratta() {
		return estratta;
	}

	public void estrazione() {//se la pistola è estratta la ripone o viceversa
		if(this.estratta)
		this.estratta = false;
		else 
			this.estratta = true;
	}

	@Override
	public String toString() {
		return "Pistola"+ modello +", calibro:"+ calibro +". Sottocanna: " + sottocanna + ", mirino: " + mirino +", capienza caricatore: " + capienzaCaricatore + "colpi.";
	}
}
