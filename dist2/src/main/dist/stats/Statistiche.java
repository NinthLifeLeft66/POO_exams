package dist.stats;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import dist.pers.Persona;
import dist.sim.Contatto;
import dist.sim.Simulatore;

/**
 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
 */
public class Statistiche {

	synchronized public void stampaFinale(Simulatore simulatore) {
		final Set<Contatto> contatti = simulatore.getContatti();

		System.out.println(contatti.size() + " contatti rilevati." );
		System.out.println(simulatore.getContatti());
		System.out.println();

		final Map<Persona, List<Contatto>> mappa = produciStatistiche(simulatore.getContatti());
		System.out.println("Statistica:");
		stampaStatistiche(mappa);
		System.out.println();
	}

	public Map<Persona, List<Contatto>> produciStatistiche(Set<Contatto> contatti) {
		Map<Persona, List<Contatto>> p2c = new HashMap<>();
		SortedSet<Contatto> contattiOrdinati= new TreeSet<Contatto>(new Comparator<Contatto>() {

			@Override
			public int compare(Contatto c1, Contatto c2) {
				int res = c1.getCoinvolti().size() - c2.getCoinvolti().size();
				if ( res == 0) {
					res = c1.getPassoSimulazione()-c2.getPassoSimulazione();
				}
				return res;
			}
		});

		contattiOrdinati.addAll(contatti);

		for ( Contatto c: contattiOrdinati) {
			for ( Persona p: c.getCoinvolti()) {
				if (p2c.containsKey(p)) {
					p2c.get(p).add(c);
				}else {
					p2c.put(p, new ArrayList<Contatto>());
					p2c.get(p).add(c);
				}
			}
		}
		return p2c;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 */
	private void stampaStatistiche(final Map<Persona, List<Contatto>> mappa) {
		for(Persona key : mappa.keySet()) {
			final List<Contatto> l = mappa.get(key);
			System.out.print(key + " e' stato coinvolto in :");
			for(Contatto c : l) 
				System.out.print(c.toString() + " ");
			System.out.println();
		}
	}
}
