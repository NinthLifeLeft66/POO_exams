package ama.mezzo;
import java.awt.Image;
import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_ROSSO;

import ama.Citta;
import ama.Posizione;

public class Pendo extends Politica {
	static private int progId=0;
	public int prec = 1;


	public Pendo(Citta citta) {
		super(citta, progId++);
	}

	@Override
	public Posizione decidiDirezione(Posizione corrente) {
		
		if ( citta.sulBordo( corrente.traslazioneUnitaria(1, 0) ) ) {
			this.prec = -1;
			return corrente.traslazioneUnitaria(-1,0);
		}
		
		else {
			if ( citta.sulBordo( corrente.traslazioneUnitaria(-1, 0))) {
				this.prec = 1;
				return corrente.traslazioneUnitaria(1,0);
			}
		}
		return corrente.traslazioneUnitaria(prec,0);

	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_ROSSO;
	}

}
