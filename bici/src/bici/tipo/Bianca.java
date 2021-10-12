package bici.tipo;

import static bici.gui.LettoreImmagini.leggiImmagineBici;
import static bici.sim.GeneratoreCasuale.posizioneCasuale;

import java.awt.Image;

import bici.sim.Coordinate;
import bici.sim.Percorso;
import bici.sim.Zona;

/**
 * Modella le fasi del ciclo di vista di una bicicletta {@link Bianca}.
 * <B>(VEDI DOMANDA 2)</B>
 */
public class Bianca extends Bici{

	static final private Image IMMAGINE_BICI_BIANCA = leggiImmagineBici(java.awt.Color.WHITE);

	private static int progId = 0;


	public Bianca(Zona zona) {		
		super (zona, progId  ++);
	}

	

	public void simula(int passo) {
		int passoIniziale = -1;
		/* destinazione iniziale gia' fissata? */
		if (this.destinazione==null) {
			this.destinazione = decidiProssimaDestinazione();
			passoIniziale = passo;
		} else if (destinazioneRaggiunta()) {
			/* registra il percorso coperto */
			final Percorso percorso = new Percorso(this,this.origine,this.destinazione);
			percorso.setPassoIniziale(passoIniziale);
			percorso.setPassoFinale(passo);
			this.getZona().add(percorso);
			this.origine = this.destinazione;
			this.destinazione = decidiProssimaDestinazione();			
		}
		direzionaVerso(this.destinazione);
		eseguiSpostamento();
	}

	public Coordinate decidiProssimaDestinazione() {
		return posizioneCasuale();
	}

	public Image getImmagine() {
		return IMMAGINE_BICI_BIANCA;
	}


}
