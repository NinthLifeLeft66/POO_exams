package carnivoro;

public class Erbivoro extends Animale{
	private static int FORZA_ERBIVORO = 2;

	public Erbivoro(){
		this(FORZA_ERBIVORO);	
	}
	
	private Erbivoro(int forza){
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
		nuovaPosizione = territorio.posizioneLiberaVicino(this.getPosizione());
		if (nuovaPosizione!=null){
			this.incrementaCibo(1);
			territorio.sposta(this, nuovaPosizione);
		} else {
			this.incrementaCibo(-1);
		}
		this.incrementaAnni();
	}
	
	public void riproduci(Territorio territorio) {
		Double random = Math.random();
		Posizione posizioneFiglio = territorio.posizioneLiberaVicino(this.posizione);
		
		if ((posizioneFiglio!= null) && (PROBABILITA_RIPRODUZIONE > random)) {
			Animale figlio = this.creaFiglio();
			territorio.setAnimale(figlio, posizioneFiglio);
		}
	}
	
	@Override
	public Animale creaFiglio() {
		return new Erbivoro();
	}

}

