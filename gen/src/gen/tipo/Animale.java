package gen.tipo;

import static gen.sim.GeneratoreCasuale.posizioneCasuale;

import java.awt.Image;
import java.util.Set;

import gen.sim.Ambiente;
import gen.sim.Coordinate;
import gen.sim.Direzione;
import gen.sim.Genere;

public abstract class Animale {

	private Ambiente ambiente;

	private Coordinate posizione; // posizione corrente

	private Direzione direzione;  // direzione corrente
	
	private Animale obiettivo;    // per un incontro (ora VEDI domanda 2a) od un incontro (poi, VEDI domanda 2bcd)
		
	private Genere genere;
	
	private int eta;
	
	private final int id;
	
	public Animale (Ambiente ambiente, int id) {		
		this.ambiente = ambiente;
		this.posizione = posizioneCasuale();
		this.eta = 0;
		this.obiettivo = null;
		this.direzione = null;
		this.genere = Genere.casuale();
		this.id = id;
	}
	
	public Ambiente getAmbiente() {
		return this.ambiente;
	}

	public void setPosizione(Coordinate nuova) {
		this.posizione = nuova;
	}

	public Coordinate getPosizione() {
		return this.posizione;
	}

	public Direzione getDirezione() {
		return this.direzione;
	}

	public void setDirezione(Direzione nuova) {
		this.direzione = nuova;
	}

	private void setObiettivo(Animale animale) {
		this.obiettivo = animale;
	}
	
	public Animale getObiettivo() {
		return this.obiettivo;
	}
	
	public int getEta() {
		return this.eta;
	}
	
	public Genere getGenere() {
		return this.genere;
	}

	public void simula(int passo) {
		this.eta++;

		/* target gia' deciso? */
		if (this.getObiettivo()==null || isObiettivoRaggiunto()) {
			this.setObiettivo(decidiProssimoObiettivo());
		}
		
		final Direzione versoObiettivo = direzionaVerso(this.getObiettivo().getPosizione());
		this.setDirezione(versoObiettivo);
		
		this.setPosizione(calcolaNuovaPosizione());
	}
	
	public abstract Animale creaClone() ;
	
	protected abstract Animale decidiProssimoObiettivo() ;
	
	private boolean isObiettivoRaggiunto() {
		return this.getPosizione().equals(this.getObiettivo().getPosizione());
	}

	private Direzione direzionaVerso(Coordinate dest) {
		final Direzione verso = Direzione.verso(this.getPosizione(),dest);
		final Set<Direzione> possibili = getPossibiliDirezioni();
		if (possibili.contains(verso)) 
			return verso;
		else return Direzione.scegliAcasoTra(possibili);
	}

	private Coordinate calcolaNuovaPosizione() {
		return (this.getPosizione().trasla(this.getDirezione()));
	}

	private Set<Direzione> getPossibiliDirezioni() {
		return this.getAmbiente().getPossibiliDirezioni(this.getPosizione());
	}

	public abstract Image getImmagine() ;
	
	/**
	 * <B>DA CORREGGERE (VEDI DOMANDA 2)</B> 
	 * @return un id progressivo (per tipologia) associato a
	 *         questo oggetto
	 */

	public int getId() {
		return this.id;
	}
	public abstract String toString() ;

}
