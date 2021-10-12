package ama.mezzo;

import java.awt.Image;
import java.util.Random;

import ama.Citta;
import ama.Posizione;

public abstract class Politica {

private int id;
	
	final private Random rnd;
	protected Citta citta;

	
	public Politica(Citta citta, int i) {
		this.id = i;
		this.citta = citta;
		this.rnd = new Random();
	}

	public int getId() {
		return this.id;
	}
	public abstract Posizione decidiDirezione(Posizione p) ;

	protected int deltaCasuale() {
		return this.rnd.nextInt(3)-1;
	}

	public abstract Image getImmagine() ;

	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}
	
	public Citta getCitta() {
		return this.citta;
	}
	
}
