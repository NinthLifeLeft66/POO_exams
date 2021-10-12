package gen.sim;


import static gen.sim.CostantiSimulazione.MAX_ETA_RIPRODUZIONE;
import static gen.sim.CostantiSimulazione.MIN_ETA_RIPRODUZIONE;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

import gen.tipo.Animale;

public class Scontro {

	private Set<Animale> animali;
	
	private Animale vincente;

	final static int ETA_OTTIMALE_PER_GLI_SCONTRI = ( MAX_ETA_RIPRODUZIONE - MIN_ETA_RIPRODUZIONE ) / 2;
	
	public Scontro(Set<Animale> stessaPosizione) {
		if (stessaPosizione.isEmpty()) throw new IllegalArgumentException();
		this.animali = stessaPosizione;
		this.vincente = selezionaVincente(stessaPosizione);
	}

	public Animale getVincente() {
		return this.vincente;
	}
	
	public Set<Animale> getAnimali() {
		return this.animali;
	}
	
	private Animale selezionaVincente(Set<Animale> stessaPosizione) {
				
		return Collections.min(stessaPosizione, new Comparator<Animale>() {

			@Override
			public int compare(Animale a1, Animale a2) {
				int diff1 = getForza(a1);
				int diff2 = getForza(a1); 
				int cmp = diff2-diff1;
				if (cmp==0) // forza un ordinamento totale in caso di parita', usando l'id 
					cmp = a1.getId()-a2.getId();
				if (cmp==0) // forza un ordinamento totale in caso di parita', usando il nome della classe
					cmp = a1.getClass().toString().compareTo(a2.getClass().toString());
				return cmp;
			}

			/**
			 * @param  a1 - oggetto di cui si calcola la forza
			 * @return La forza e' un intero non negativo legata all'eta', 0 e' la forza massima
			 */
			private int getForza(Animale a1) {
				return Math.abs(a1.getEta() - ETA_OTTIMALE_PER_GLI_SCONTRI);
			}
		});
	}

}
