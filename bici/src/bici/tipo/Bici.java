package bici.tipo;

import static bici.sim.GeneratoreCasuale.posizioneCasuale;

import java.awt.Image;
import java.util.Set;

import bici.sim.Coordinate;
import bici.sim.Direzione;
import bici.sim.Zona;

public abstract class Bici {
	
	private Zona zona;
	
	private Coordinate posizione; // posizione corrente

	private Direzione direzione;  // direzione corrente

	protected Coordinate origine;

	protected Coordinate destinazione;

	private int id;

	public Bici(Zona zona, int i) {
		this.zona = zona;
		final Coordinate posizioneIniziale = posizioneCasuale();
		this.posizione = posizioneIniziale;
		this.setOrigine(posizioneIniziale);
		this.destinazione = null;
		this.direzione = null;
		this.id = i;
	}

	
	public Zona getZona() {
		return this.zona;
	}

	protected void setPosizione(Coordinate nuova) {
		this.posizione = nuova;
	}

	public Coordinate getPosizione() {
		return this.posizione;
	}

	public Direzione getDirezione() {
		return this.direzione;
	}

	protected void setDirezione(Direzione nuova) {
		this.direzione = nuova;
	}
	
	protected boolean destinazioneRaggiunta() {
		return this.getPosizione().equals(this.destinazione);
	}

	protected void direzionaVerso(Coordinate dest) {
		final Direzione verso = Direzione.verso(this.getPosizione(),dest);
		final Set<Direzione> possibili = getPossibiliDirezioni();
		if (possibili.contains(verso)) 
			this.setDirezione(verso);
		else this.setDirezione(Direzione.scegliAcasoTra(possibili));
	}

	protected void eseguiSpostamento() {
		this.setPosizione(this.getPosizione().trasla(this.getDirezione()));
	}

	private Set<Direzione> getPossibiliDirezioni() {
		return this.getZona().getPossibiliDirezioni(this.getPosizione());
	}

	public abstract Image getImmagine() ;

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

	public abstract void simula(int passo) ;
	
	public abstract Coordinate decidiProssimaDestinazione() ;

	/**
	 * <B>DA CORREGGERE (VEDI DOMANDA 2)</B> 
	 * @return un id progressivo (per tipologia) associato a
	 *         questo oggetto
	 */
	public int getId() {
		return this.id;
	}


	public Coordinate getOrigine() {
		return origine;
	}


	public void setOrigine(Coordinate origine) {
		this.origine = origine;
	}
}
