package carnivoro;

public abstract class Animale {

	private int anni;
	private int forza;
	private int livelloCibo;
	
	protected Posizione posizione;

	protected static double PROBABILITA_RIPRODUZIONE = 0.45;

	public Animale(int forza) {
		// TODO Auto-generated constructor stub
		this.forza = forza;
		this.livelloCibo = 2;
		this.anni = 0;
	}
	public abstract void agisci(Territorio territorio) ;

	
	public void riproduci(Territorio territorio) {
		Double random = Math.random();
		Posizione posizioneFiglio = territorio.posizioneLiberaVicino(this.posizione);
		
		if ((posizioneFiglio!= null) && (PROBABILITA_RIPRODUZIONE > random)) {
			Animale figlio = this.creaFiglio();
			territorio.setAnimale(figlio, posizioneFiglio);
		}
	}
	
	public void setPosizione(Posizione posizione){
		this.posizione = posizione;
	}

	public Posizione getPosizione() {
		return this.posizione;
	}

	public int getForza() {
		return this.forza;
	}
	
	public int getAnni() {
		return this.anni;
	}
	
	public boolean isMorto(){
		return (this.livelloCibo==0)||(this.anni==5);
	}
	
	public void incrementaAnni(){
		this.anni++;
	}
	
	public void incrementaCibo(int cibo){
		this.livelloCibo+=cibo;
	}	
	
	public abstract Animale creaFiglio() ;
	
	@Override
	public boolean equals(Object obj) {
		Animale that = (Animale) obj;
		return this.getAnni() == that.getAnni() && this.getClass() == that.getClass()&&
				this.getPosizione().equals(that.getPosizione());
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getAnni()+this.getClass().hashCode()+
				this.getPosizione().hashCode();
	}
}
