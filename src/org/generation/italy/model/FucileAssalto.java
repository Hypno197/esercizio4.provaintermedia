package org.generation.italy.model;

public class FucileAssalto extends ArmaDaFuoco {
	private String sottocanna, mirino, calcio, canna;
	private int selettoreFuoco;
	private boolean sicura;

	@Override
	public String toString() {
		return "Fucile D'Assalto "+ modello +", calibro=" + calibro +". Accessori: Sottocanna: " + sottocanna + ", mirino: " + mirino + ", calcio: " + calcio + ", canna: "
				+ canna + ", capienza caricatore: " + capienzaCaricatore + "colpi.";
	}

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

	public String getCalcio() {
		return calcio;
	}

	public void setCalcio(String calcio) {
		this.calcio = calcio;
	}

	public String getCanna() {
		return canna;
	}

	public void setCanna(String canna) {
		this.canna = canna;
	}


	public String getSelettoreFuoco() {//selettore di fuoco per l'arma, 0 non spara, 1 spara un solo colpo, 2 spara quanti colpi si vuole
		if (selettoreFuoco == 0)
			return "sicura";
		else if (selettoreFuoco == 1)
			return "Semiautomatico";
		else
			return "Automatico";
	}

	public String setSelettoreFuoco(int selettoreFuoco) {//posizione del selettore, può essere 0/1/2
		if (selettoreFuoco < 3) {
			this.selettoreFuoco = selettoreFuoco;
			return getSelettoreFuoco();
		} else
			return "Posizione non valida!";

	}

	public void mettiSicura(boolean sicura) {
		this.sicura = sicura;
		selettoreFuoco = 0;
	}

	public String premiGrilletto(int colpi) {//prova a sparare 
		if (this.selettoreFuoco==2)
			return spara(colpi);
		else if (this.selettoreFuoco==1)
			return spara(1);
		else
			return "Devi prima togliere la sicura!";
	}
}
