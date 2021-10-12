package carnivoro;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Territorio {


	synchronized public void stampaFinale(Territorio zona) {


		// (VEDI DOMANDA 3)
		System.out.println(" anno 2 erbivori:");		
		final Map<Integer, Set<Animale>> a2e = anno2erbivori() ;

		//		final Map<Auto,Set<Tragitto>> auto2tragitti = tragittoPerAuto(tragitti);
		stampaTragittiPerAuto(a2e);
		System.out.println();

		// (VEDI DOMANDA 4)
		System.out.println(" piu' vecchi:");
		 Set<Posizione> posizioniErbivoriVecchi = posizioniErbivoriVecchi() ;

		stampaUtilizzi(posizioniErbivoriVecchi);
		System.out.println();
	}

	private void stampaUtilizzi(Set<Posizione> posizioniErbivoriVecchi) {
		// TODO Auto-generated method stub
		for(Posizione p : posizioniErbivoriVecchi) {
			System.out.println(" Posizione erb" + p.getX()+ " "+ p.getY());

		}

		
	}

	private void stampaTragittiPerAuto(final Map<Integer, Set<Animale>> auto2tragitti) {
		for(Integer auto : auto2tragitti.keySet()) {
			Set<Animale> tragitti = auto2tragitti.get(auto);
			System.out.println("L'auto "+auto+" ha fatto "+( tragitti!=null ? tragitti.size() : 0 ) +" corse");
		}
	}



	private static final int NUM_INIZIALE_ANIMALI = 15;
	private static final double PROBABILITA_CARNIVORO = 0.2;

	private int dimensione;	
	private Map<Posizione, Animale> posizione2Animale;	


	public Territorio(int dimensione){
		this.dimensione = dimensione;
		this.posizione2Animale = new HashMap<Posizione, Animale>();
		this.popolaTerritorio();
	}

	public Animale getAnimale(Posizione posizione){
		return posizione2Animale.get(posizione);
	}

	public void rimuoviAnimale(Animale animale) {
		this.posizione2Animale.remove(animale.getPosizione());
	}

	public void setAnimale(Animale animale, Posizione posizione) {
		if (this.getAnimale(posizione)==null){
			this.posizione2Animale.put(posizione, animale);
			animale.setPosizione(posizione);
		} 
	}

	public Collection<Animale> getAnimali(){
		return this.posizione2Animale.values();
	}

	public void sposta(Animale animale, Posizione nuovaPosizione) {
		this.rimuoviAnimale(animale);
		this.setAnimale(animale, nuovaPosizione);		
	}	

	public List<Posizione> adiacenti(Posizione posizione) {
		List<Posizione> adiacenti = new LinkedList<Posizione>();
		int x = posizione.getX();
		int y = posizione.getY();

		for(int i = -1; i<2; i++) {
			for(int j = -1; j<2; j++) {
				adiacenti.add(new Posizione(x+i, y+j));
			}
		}
		Iterator<Posizione> it = adiacenti.iterator();
		while(it.hasNext()){
			Posizione p = it.next();
			if ((p.getX()<0) || (p.getX()>=this.dimensione) || (p.getY()<0) || 
					(p.getY()>=this.dimensione) || (p.equals(posizione)))
				it.remove();
		}
		Collections.shuffle(adiacenti);
		return adiacenti;
	} 

	public Posizione posizioneLiberaVicino(Posizione posizione) {
		for(Posizione p : this.adiacenti(posizione)) {
			if (this.isLibera(p)) {
				return p;
			}
		}
		return null;
	}

	public boolean isLibera(Posizione posizione) {
		if ((this.getAnimale(posizione)==null) ) {
			return true;
		} else
			return false;
	}

	public int getDimensione() {
		return this.dimensione;
	}

	private void popolaTerritorio(){

		int numeroAnimali = 0;

		while (numeroAnimali < NUM_INIZIALE_ANIMALI) {
			int x = (int)(Math.random()*this.dimensione);
			int y = (int)(Math.random()*this.dimensione);
			Posizione posizione = new Posizione(x, y);
			if (this.isLibera(posizione)) {
				if(Math.random() < PROBABILITA_CARNIVORO) {
					Animale nuovoAnimale = new Carnivoro();
					this.setAnimale(nuovoAnimale, posizione);
				} else {
					Animale nuovoAnimale = new Erbivoro();
					this.setAnimale(nuovoAnimale, posizione);
				}
				numeroAnimali++;
			}
		}
	}


	public Map<Integer, Set<Animale>> anno2erbivori() {
		Map<Integer, Set<Animale>> i2e = new HashMap<>();

		for ( Animale a : this.getAnimali()) {
			if ( a.getClass()==Erbivoro.class) {
				if (i2e.containsKey(a.getAnni())){
					i2e.get(a.getAnni()).add(a);
				}else {
					i2e.put(a.getAnni(),new HashSet<Animale>());
					i2e.get(a.getAnni()).add(a);

				}

			}
		}


		return i2e;

	}

	public Set<Posizione> posizioniErbivoriVecchi(){
		SortedMap<Animale,Posizione> erb2pos = new TreeMap<Animale,Posizione>(new Comparator<Animale>() {

			@Override
			public int compare(Animale a1, Animale a2) {

				int res = a2.getAnni()-a1.getAnni();
				if (res==0)
					res=1;
				return res ;
			}

		});

		for ( Animale a : this.getAnimali()) {
			if ( a.getClass()==Erbivoro.class) {
				if ( !erb2pos.containsKey(a)){
					erb2pos.put(a,new Posizione(a.getPosizione().getX(), a.getPosizione().getY()));
				}}}

		Set<Posizione> posErbVecchi = new HashSet<Posizione>();
		posErbVecchi.addAll(erb2pos.values());

		return posErbVecchi ;
	}
}
