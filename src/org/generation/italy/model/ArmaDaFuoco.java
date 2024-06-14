package org.generation.italy.model;

public abstract class ArmaDaFuoco {
	protected String modello, calibro;
	protected int capienzaCaricatore, colpiRimasti=0;
	
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getCalibro() {
		return calibro;
	}
	public void setCalibro(String calibro) {
		this.calibro = calibro;
	}
	public int getCapienzaCaricatore() {
		return capienzaCaricatore;
	}
	public void setCapienzaCaricatore(int capienzaCaricatore) {
		this.capienzaCaricatore = capienzaCaricatore;
	}
	public int getColpiRimasti() {
		return colpiRimasti;
	}
	public void setColpiRimasti(int colpiRimasti) {
		this.colpiRimasti = colpiRimasti;
	}
	public String ricarica() {
		colpiRimasti = capienzaCaricatore;
		return ("Caricatore cambiato! Colpi rimanenti: "+colpiRimasti);
	}
	
	protected String spara(int colpi) {//metodo che spara se i colpi nel caricatore ci sono
		for (int i=0; i<colpi; i++)
		{
			if (colpiRimasti>0)
				colpiRimasti--;
			else {
				return ("Siamo a secco! Abbiamo sparato "+ i +" colpi!");
			}
		}
		return ("BANG! Hai sparato "+colpi+" colpi!");
	}
	
}
