package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_GIALLO;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public class Brown extends Politica{

	static private int progId=0;	
	
	public Brown(Citta citta ) {
		super ( citta ,progId++ ) ;
		
	}


	public Posizione decidiDirezione(Posizione p) {
		return p.traslazioneUnitaria(deltaCasuale(),deltaCasuale());
	}


	
	public Image getImmagine() {
		return IMMAGINE_CAMION_GIALLO;
	}


}
