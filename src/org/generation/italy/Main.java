package org.generation.italy;

import java.util.ArrayList;
import java.util.Scanner;

import org.generation.italy.model.ArmaDaFuoco;
import org.generation.italy.model.FucileAssalto;
import org.generation.italy.model.Pistola;

public class Main {

	public static void main(String[] args) {
		ArrayList<ArmaDaFuoco> poligono = new ArrayList<ArmaDaFuoco>();
		ArmaDaFuoco arma;
		Scanner sc = new Scanner(System.in);
		int scelta;
		boolean esci;
		do {
		System.out.println("Benvenuto nell'armeria beretta!");
		do {
			System.out.println("Scegli un'arma da provare");
			System.out.println("1) Pistola \n2) Fucile D'Assalto");
			scelta = sc.nextInt();
			sc.nextLine();
		} while (scelta > 2 || scelta == 0);
		if (scelta == 1) {
			arma = new Pistola();
		} else {
			arma = new FucileAssalto();
		}
		System.out.println("Modello dell'arma: ");
		arma.setModello(sc.nextLine());
		System.out.println("Calibro dell'arma: ");
		arma.setCalibro(sc.nextLine());
		if (arma instanceof Pistola) {
			Pistola pistola = (Pistola) arma;
			arma.setCapienzaCaricatore(11);
			System.out.println("Aggiungi accessorio sottocanna: ");
			pistola.setSottocanna(sc.nextLine());
			System.out.println("Aggiungi mirino: ");
			pistola.setMirino(sc.nextLine());
			poligono.add(pistola);
			System.out.println(arma.toString());
		} else if (arma instanceof FucileAssalto) {
			FucileAssalto fucile = (FucileAssalto) arma;
			arma.setCapienzaCaricatore(30);
			System.out.println("Aggiungi accessorio sottocanna: ");
			fucile.setSottocanna(sc.nextLine());
			System.out.println("Aggiungi mirino: ");
			fucile.setMirino(sc.nextLine());
			System.out.println("Aggiungi calcio: ");
			fucile.setCalcio(sc.nextLine());
			System.out.println("Aggiungi canna: ");
			fucile.setCanna(sc.nextLine());
			poligono.add(fucile);
			System.out.println(arma.toString());
		}
		do {
			esci = false;
			System.out.println("Cosa vuoi fare con l'arma?");
			System.out.println("0) Esci");
			System.out.println("1) Spara");
			System.out.println("2) Ricarica");
			if (arma instanceof Pistola) {
				System.out.println("3) Estrai/riponi l'arma");
			}
			if (arma instanceof FucileAssalto) {
				System.out.println("3) Sposta selettore di fuoco(0= sicura, 1=semi, 2=auto)");
				System.out.println("4) Metti sicura");
			}
			scelta = sc.nextInt();
			sc.nextLine();
			switch (scelta) {
			case 1: {
				if (arma instanceof Pistola) {
					Pistola pistola = (Pistola) arma;
					System.out.println(pistola.premiGrilletto());
				} else {
					System.out.println("Quanti colpi vuoi sparare?");
					int colpi = sc.nextInt();
					sc.nextLine();
					System.out.println( ((FucileAssalto) arma).premiGrilletto(colpi));
				}

				break;
			}
			case 2: {
				System.out.println(arma.ricarica());
				break;
			}
			case 3 :{
				if (arma instanceof Pistola) {
				((Pistola)arma).estrazione();
				if (((Pistola) arma).isEstratta()) {
					System.out.println("Pistola estratta!");
				}else System.out.println("Pistola riposta.");
				} else if (arma instanceof FucileAssalto) {
					System.out.println("Scegli posizione del selettore: ");
					int pos=sc.nextInt();
					sc.nextLine();
					System.out.println( ((FucileAssalto) arma).setSelettoreFuoco(pos));
				}
				break;
			}
			case 4 :{
				if (arma instanceof FucileAssalto) {
					((FucileAssalto) arma).mettiSicura(true);
					System.out.println("Sicura inserita.");
				}
				break;
			}
			case 0: {
				esci = true;
				break;
			}
			default:
				System.out.println("Selezione non valida!");
			}
		} while (!esci);
		}while(true);
	}
}
