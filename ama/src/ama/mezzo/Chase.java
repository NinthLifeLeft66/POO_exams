package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_VERDE;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public class Chase extends Politica{

	static private int progId=0;

	
	
	public Chase(Citta citta) {
			super(citta, progId++);
	}

	public Posizione decidiDirezione(Posizione corrente) {
		final Posizione posizioneRifiutoNelleVicinanze = 
				this.getCitta().getRifiutoVicinoA(corrente);
		if (posizioneRifiutoNelleVicinanze==null) 
			return corrente.traslazioneUnitaria(deltaCasuale(),deltaCasuale());
		else return posizioneRifiutoNelleVicinanze;
	}


	public Image getImmagine() {
		return IMMAGINE_CAMION_VERDE;
	}


}
