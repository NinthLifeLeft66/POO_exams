package bici.tipo;

import static bici.gui.LettoreImmagini.leggiImmagineBici;

import java.awt.Image;
import java.util.Collections;
import java.util.List;

import bici.sim.Coordinate;
import bici.sim.Percorso;
import bici.sim.Zona;

public class Gialla extends Bici {

	static final private Image IMMAGINE_BICI_GIALLA = leggiImmagineBici(java.awt.Color.YELLOW);

	private static int progId = 0;


	
	private static List<Coordinate> destinazioniPossibili;

	private Coordinate destinazionAtt;

	public Gialla(Zona zona) {		
		super (zona, progId  ++);
		Gialla.destinazioniPossibili = bici.sim.GeneratoreCasuale.generaNposizioniCasuali(bici.sim.CostantiSimulazione.N_DESTINAZIONI);
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
		Collections.shuffle(destinazioniPossibili);
		this.destinazionAtt = Gialla.destinazioniPossibili.get(0);
		return Gialla.destinazioniPossibili.get(0);
	}

	public Image getImmagine() {
		return IMMAGINE_BICI_GIALLA;
	}
	
	public Coordinate  getDestinazioneAttuale(){
		return this.destinazionAtt;
	}

}
