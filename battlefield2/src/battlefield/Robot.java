package battlefield;

public abstract class Robot {
	
	
	protected Position posizione;
	protected int longevita;
	
	
	public Robot(Position p) {
		this.posizione = p;
		this.longevita = 0 ;
	}

	
	public Position getPosizione() {
		return this.posizione;
	}
	
	public int incrementaLongevita() {
		return ++this.longevita;
	}
	
	public int getLongevita() {
		return this.longevita;
	}

	public abstract void passo(Battlefield field) ;

	public abstract Position decidiDoveAndare(Battlefield field) ;
	
	@Override
	public boolean equals(Object obj) {
		Robot r = (Robot) obj;
		return this.getClass().equals(r.getClass()) && r.getPosizione().equals(this.getPosizione()) && this.getLongevita()== r.getLongevita();
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getClass().hashCode() + this.getPosizione().hashCode()+ this.getLongevita()*31;
	}

}
