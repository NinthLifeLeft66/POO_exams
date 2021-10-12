package carnivoro;

import java.util.List;

public class Carnivoro extends Animale{
	private static int FORZA_CARNIVORO = 5;


	public Carnivoro(){
		this(FORZA_CARNIVORO);	
	}
	
	private Carnivoro(int forza){
		super(forza);
	}

	@Override
	public void agisci(Territorio territorio) {
		if (this.isMorto()) {
			territorio.rimuoviAnimale(this);
			return;
		}
		this.riproduci(territorio);	
		
		Posizione nuovaPosizione;
		Animale vittimaErbivoro;
		vittimaErbivoro = cercaVittimaErbivoro(territorio);
		if (vittimaErbivoro != null) {		
			this.incrementaCibo(1);
			territorio.rimuoviAnimale(vittimaErbivoro);
			nuovaPosizione = vittimaErbivoro.getPosizione();
		} else {
			Animale vittimaCarnivoro;
			vittimaCarnivoro = cercaVittimaCarnivoro(territorio);
			if (vittimaCarnivoro != null) {		
				this.incrementaCibo(1);
				territorio.rimuoviAnimale(vittimaCarnivoro);
				nuovaPosizione = vittimaCarnivoro.getPosizione();
			} else {
				this.incrementaCibo(-1);
				nuovaPosizione = territorio.posizioneLiberaVicino(this.getPosizione());
			}
		}
		if (nuovaPosizione!=null){
			territorio.sposta(this, nuovaPosizione);
		}		
		this.incrementaAnni();
	}
	

	private Animale cercaVittimaErbivoro(Territorio territorio) {
		List<Posizione> adiacenti = territorio.adiacenti(this.getPosizione()); 
		for(Posizione p : adiacenti) {
			Animale a = territorio.getAnimale(p);
			if ((a!=null) && (this.getForza()>a.getForza())) {
				return a;
			}
		}
		return null;
	}

	
	private Animale cercaVittimaCarnivoro(Territorio territorio) {
		List<Posizione> adiacenti = territorio.adiacenti(this.getPosizione()); 
		for(Posizione p : adiacenti) {
			Animale a = territorio.getAnimale(p);
			if ((a!=null) && (this.getForza()>a.getForza())) {
				return a;
			}
		}
		return null;
	}

	@Override
	public Animale creaFiglio() {
		return new Carnivoro();
	}


}

