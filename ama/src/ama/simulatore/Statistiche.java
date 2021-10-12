package ama.simulatore;


import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import ama.CentroDiRaccolta;
import ama.Citta;
import ama.mezzo.Mezzo;
import ama.rifiuto.Rifiuto;

public class Statistiche {

	public void stampaStatisticheFinali(Citta citta) {
		final CentroDiRaccolta centro = citta.getCentroDiRaccolta();

		final Set<Rifiuto> smaltiti = centro.getRifiutiSmaltiti();
		System.out.println("Rifiuti smaltiti in totale: " + smaltiti.size());
		System.out.println();
		
		// (VEDI DOMANDA 3 - metodo da completare a seguire)
		System.out.println("Quantita' raccolta da ciascun mezzo impegnato:");
		final Map<Mezzo,Integer> mezzo2quantita = raccoltoPerMezzo(smaltiti);
		stampaRaccoltoPerMezzo(mezzo2quantita);
		System.out.println();
		
		// (VEDI DOMANDA 4 - metodo da completare a seguire)
		System.out.println("Quantita' raccolta per ogni politica:");
		final Map<Class<?>,Integer> politica2quantita = raccoltoPerPolitica(smaltiti);
		stampaRaccoltoPerPolitica(politica2quantita);
		System.out.println();
		
		// (VEDI DOMANDA 5 - metodo da completare a seguire)
		System.out.println("Classifica finale delle politiche raccolta:");
		final List<Class<?>> classificaTipo = ordinaPolitichePerRaccolta(politica2quantita);
		stampaClassificaPolitiche(classificaTipo);
		System.out.println();

		// (VEDI DOMANDA 7 - metodo da completare a seguire)
		System.out.println("Classifica finale dei mezzi per raccolta:");
		final SortedSet<Mezzo> classificaMezzi = ordinaMezziPerRaccolta(mezzo2quantita);
		stampaClassificaMezzi(classificaMezzi);
		System.out.println();
		
	}

	public Map<Mezzo, Integer> raccoltoPerMezzo(Set<Rifiuto> smaltiti) {
		final Map<Mezzo,Integer> m2q = new HashMap<>();
		
		for ( Rifiuto r : smaltiti) {
			if (m2q.containsKey(r.getRaccoglitore()) ) {
				int prec = m2q.get(r.getRaccoglitore());
				m2q.put(r.getRaccoglitore(), prec+1);
			}else {
				m2q.put(r.getRaccoglitore(), 1);
			}
			
		}
		
		return m2q;
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 3
	private void stampaRaccoltoPerMezzo(final Map<Mezzo, Integer> mezzo2quantita) {
		for(Mezzo mezzo : mezzo2quantita.keySet()) {
			Integer quantita = mezzo2quantita.get(mezzo);
			if (quantita==null)
				quantita = 0;
			System.out.println("Il mezzo "+mezzo+" ha raccolto "+quantita);
		}
	}

	public Map<Class<?>, Integer> raccoltoPerPolitica(Set<Rifiuto> smaltiti) {
		final Map<Class<?>,Integer> p2q = new HashMap<>();
		// DA COMPLETARE (VEDI DOMANDA 4)
		
		for ( Rifiuto r : smaltiti) {
			if (p2q.containsKey(r.getRaccoglitore().getPolitica().getClass()) ) {
				Integer prec = p2q.get(r.getRaccoglitore().getPolitica().getClass());
				p2q.put(r.getRaccoglitore().getPolitica().getClass(), prec+1);
			}else {
				p2q.put(r.getRaccoglitore().getPolitica().getClass(), 1);
			}
			
		}
		
		return p2q;
	}

	// UTILE PER STAMPARE RISULTATI DOMANDA 4
	private void stampaRaccoltoPerPolitica(final Map<Class<?>, Integer> tipo2quantita) {
		for(Class<?> tipo : tipo2quantita.keySet()) {
			Integer q = tipo2quantita.get(tipo);
			if (q==null)
				q = 0;
			System.out.println("La politica "+tipo.getSimpleName()+" ha raccolto "+q);
		}
	}
	
	public List<Class<?>> ordinaPolitichePerRaccolta(final Map<Class<?>, Integer> p2q) {
		// DA COMPLETARE (VEDI DOMANDA 5)
		List< Class<?>> p2rOrdinata = new LinkedList<>();
		SortedMap<Class<?>, Integer> mOrdin = new TreeMap<Class<?>, Integer>
		(new Comparator<Class<?>>(){

			@Override
			public int compare(Class<?> c1, Class<?> c2) {
				// TODO Auto-generated method stub
				int res = p2q.get(c2) - p2q.get(c1);
				if (res== 0)
					return 1;
				return res;
			}
			
			
			
		}) ;
		
		mOrdin.putAll(p2q);
		
		p2rOrdinata.addAll(mOrdin.keySet());
		
		return p2rOrdinata;
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 5
	private void stampaClassificaPolitiche(List<Class<?>> classifica) {
		for(int i=1; i<classifica.size()+1; i++)
			System.out.println(i+") "+classifica.get(i-1).getSimpleName());
	}
	
	public SortedSet<Mezzo> ordinaMezziPerRaccolta(final Map<Mezzo, Integer> m2q) {
		SortedSet< Mezzo> setOrdin = new TreeSet<>(new Comparator<Mezzo>() {

			@Override
			public int compare(Mezzo o1, Mezzo o2) {
				int res = o2.totRifiuti -o1.totRifiuti;
				if (res == 0)
					return 1;
				return res;
			}
			
		});
		
		setOrdin.addAll(m2q.keySet());
				
		return setOrdin;
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 7
	private void stampaClassificaMezzi(SortedSet<Mezzo> classifica) {
		int posto = 1;
		for(Mezzo mezzo : classifica) {
			System.out.println(posto+") "+mezzo+" che ha raccolto "+mezzo.totRifiuti+" rifiuti.");
			posto++;
		}
	}
}
