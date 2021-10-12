package ant;

import ant.formica.Formica;

public class Cibo {

	private Coordinate posizione;
	
	/* DA CAMBIARE: VEDI DOMANDA 2 */

	private Formica formica;
	
	public Cibo(Coordinate p) {
		this.posizione = p;
	}

	public Coordinate getPosizione() {
		return this.posizione;
	}
	
	public void setRaccoglitrice(Formica formica) {
		this.setFormica(formica);
	}

	public Formica getFormica() {
		return formica;
	}

	public void setFormica(Formica formica) {
		this.formica = formica;
	}

	public Formica getRaccoglitrice() {
		return this.getFormica();
	}
	
	@Override
	public boolean equals(Object obj) {
		Cibo c = (Cibo) obj;
		return (this.getFormica().equals(c.getFormica()));
	}
	
	@Override
	public int hashCode() {
		return this.getFormica().hashCode();
	}
}
