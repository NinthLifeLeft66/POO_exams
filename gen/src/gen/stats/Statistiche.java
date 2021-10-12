package gen.stats;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import gen.sim.Scontro;
import gen.sim.Simulatore;
import gen.tipo.Animale;

public class Statistiche {

	synchronized public void stampaFinale(Simulatore simulatore) {
		final Set<Scontro> percorsi = simulatore.getScontri();

		System.out.println(percorsi.size() + " scontri rilevati." );
		System.out.println(simulatore.getScontri());
		System.out.println();

		// (VEDI DOMANDA 3)
		System.out.println("Scontri di ciascun animale:");
		final Map<Animale,List<Scontro>> animale2scontri = scontriPerAnimale(simulatore.getScontri());
		stampaScontriPerAnimale(animale2scontri);
		System.out.println();
	}

	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
	 * @param scontri - insieme degli scontri collezionati durante la simulazione
	 * @return una mappa che riporti per ogni animale (di qualsiasi tipo)
	 *         la lista degli scontri avuti
	 */
	public Map<Animale, List<Scontro>> scontriPerAnimale(Set<Scontro> scontri) {
		Map<Animale,List<Scontro> > animale2scontro = new HashMap<>();
		
		for (Scontro s : scontri) {
			final Animale a = s.getVincente();
			if ( animale2scontro.containsKey(a)) {
				animale2scontro.get(a).add(s);
			}
			else {
				animale2scontro.put(a, new LinkedList<Scontro>());
				animale2scontro.get(a).add(s);

			}
				
		}
		
		return animale2scontro;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 * @param animale2scontri
	 */
	private void stampaScontriPerAnimale(final Map<Animale, List<Scontro>> animale2scontri) {
		for(Animale animale : animale2scontri.keySet()) {
			final List<Scontro> scontri = animale2scontri.get(animale);
			System.out.println(animale + " ha superato " + ( scontri!=null ? scontri.size() : 0 ) +" scontri");
		}
	}


}
