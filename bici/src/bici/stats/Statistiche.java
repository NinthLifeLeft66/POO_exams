package bici.stats;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import bici.sim.Coordinate;
import bici.sim.Percorso;
import bici.sim.Zona;
import bici.tipo.Bici;

public class Statistiche {

	synchronized public void stampaFinale(Zona zona) {
		final Set<Percorso> percorsi = zona.getPercorsi();

		System.out.println(percorsi.size() + " percorsi collezionati." );
		System.out.println(zona.getPercorsi());
		System.out.println();

		// (VEDI DOMANDA 3)
		System.out.println("Percorsi di ciascuna bicicletta:");
		final Map<Bici,List<Percorso>> bici2percorsi = percorsiPerBici(percorsi);
		stampaPercorsiPerBici(bici2percorsi);
		System.out.println();

		// (VEDI DOMANDA 4)
		System.out.println("Classifica finale delle posizioni piu' battute:");
		final SortedMap<Coordinate,Integer> pos2utilizzi = utilizzi(bici2percorsi);
		stampaUtilizzi(pos2utilizzi);
		System.out.println();
	}

	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
	 * @param percorsi - insieme dei percorsi collezionati durante la simulazione
	 * @return una mappa che riporti per ogni bici (di qualsiasi tipo)
	 *         la lista dei percorsi coperti
	 */
	public Map<Bici, List<Percorso>> percorsiPerBici(Set<Percorso> percorsi) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		Map<Bici, List<Percorso>> b2p = new HashMap<>();

		for (Percorso p : percorsi) {
			if ( b2p.containsKey(p.getBici())) {
				b2p.get(p.getBici()).add(p);
			}else {
				b2p.put(p.getBici(), new ArrayList<Percorso>());
				b2p.get(p.getBici()).add(p);

			}
		}
		return b2p;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 * @param bici2percorsi
	 */
	private void stampaPercorsiPerBici(final Map<Bici, List<Percorso>> bici2percorsi) {
		for(Bici bici : bici2percorsi.keySet()) {
			List<Percorso> percorsi = bici2percorsi.get(bici);
			System.out.println("La bicicletta "+bici+" ha coperto "+( percorsi!=null ? percorsi.size() : 0 ) +" corse");
		}
	}

	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 4)</B>
	 * 	@param bici2percorsi - insiemi dei percorsi collezionati durante la simulazione
	 *                         e raggruppati per bici
	 * @return una mappa ordinata decrescente in cui figurano come chiavi 
	 *         le posizioni piu' battute come origine o destinazione di un 
	 *         percorso, come valori il numero di tali percorsi
	 */
	public SortedMap<Coordinate,Integer> utilizzi(Map<Bici, List<Percorso>> b2p) {
		// DA COMPLETARE (VEDI DOMANDA 4)
		SortedMap<Coordinate,Integer> c2i = new TreeMap<Coordinate,Integer>(new Comparator<Coordinate>() {
			
			@Override
			public int compare(Coordinate c1, Coordinate c2) {
				int res = c1.getX()-c2.getX();
				if ( res==0)
					res= c1.getY()-c2.getY();
				return res;
			}
			
		});
		
		for (Bici b : b2p.keySet()) {
			for ( Percorso p : b2p.get(b) ) {
				if (c2i.containsKey(p.getOrigine())) {
					int vecchiaOccorrenza = c2i.get(p.getOrigine());
					c2i.put(p.getOrigine(), vecchiaOccorrenza+1);
				}else {
					c2i.put(p.getOrigine(), 1);
				}
				
				if (c2i.containsKey(p.getDestinazione())) {
					int vecchiaOccorrenza = c2i.get(p.getDestinazione());
					c2i.put(p.getDestinazione(), vecchiaOccorrenza+1);
				}else {
					c2i.put(p.getDestinazione(), 1);
				}
			}
		}
		return c2i;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 4</EM>
	 * @param classifica delle posizioni piu' usate
	 */
	private void stampaUtilizzi(SortedMap<Coordinate,Integer> classifica) {
		int i = 0;
		for(Map.Entry<Coordinate, Integer> entry : classifica.entrySet()) {
			final Coordinate posizione = entry.getKey();
			final Integer numeri = entry.getValue();
			System.out.println(i+") "+posizione+" con "+numeri+" utilizzi");
			i++;
		}
	}

}
