package gen.sim;


import static gen.sim.CostantiSimulazione.DIMENSIONE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import gen.tipo.Animale;


public class Ambiente {

	final private int dimensione;
	
	final private Set<Coordinate> ostacoli;

	final private List<Animale> animali;

	/**
	 * Crea un ambiente (quadrato) delle dimensioni prefissate
	 */
	public Ambiente() {
		this.dimensione = DIMENSIONE;
		this.ostacoli = new HashSet<>();
		this.inizializzaBordi(this.dimensione);
		this.animali = new ArrayList<>();
	}
	
	private void inizializzaBordi(int dim) {
		for(int i=0; i<dim; i++) {
			addOstacolo(0,i);
			addOstacolo(i,0);
			addOstacolo(dim-1,i);
			addOstacolo(i,dim-1);
		}
	}
	
	public int getDimensione() {
		return this.dimensione;
	}
	
	public void addOstacolo(int x, int y) {
		this.ostacoli.add(new Coordinate(x, y));
	}

	public Set<Coordinate> getOstacoli() {
		return this.ostacoli;
	}

	public boolean collideConOstacolo(Coordinate pos) {
		return this.getOstacoli().contains(pos);
	}

	/**
	 * Restituisce l'insieme degli oggetti {@link Direzione} che possono
	 * essere seguite a partire dalla posizione passata come riferimento,
	 * oppure l'insieme vuoto se nessuna direzione e' possibile.<BR/>
	 * @param riferimento - la posizione di partenza
	 * @return l'insieme delle direzioni lecite (senza colpire ostacoli)
	 */
	public Set<Direzione> getPossibiliDirezioni(Coordinate riferimento) {
		/* seleziona solo direzioni verso posizioni adiacenti 
		 * al riferimento che non siano occupate da un ostoacolo */		
		final Set<Direzione> possibili = new HashSet<>();
		possibili.addAll(Arrays.asList(Direzione.values()));
		final Iterator<Direzione> it = possibili.iterator();
		while (it.hasNext()) {
			final Coordinate destinazione = riferimento.trasla(it.next());
			if (this.collideConOstacolo(destinazione))
				it.remove();
		}
		return possibili;
	}

	public void add(Animale a) {
		this.animali.add(a);
	}

	public List<Animale> getAllAnimali() {
		return this.animali;
	}

	
	public Set<Animale> getAnimali(Coordinate posizione) {
		final Set<Animale> risultato = new HashSet<>();
		for(Animale animale : getAllAnimali())
			if (animale.getPosizione().equals(posizione))
				risultato.add(animale);
		return risultato;
	}

	public void rimuoviAnimali(Set<Animale> stessaPosizione) {
		this.animali.removeAll(stessaPosizione);
	}

	public void rimuoviAnimale(Animale animale) {
		this.animali.remove(animale);
	}

}
