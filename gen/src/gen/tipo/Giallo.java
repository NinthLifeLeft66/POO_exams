package gen.tipo;

import static gen.gui.CostantiGUI.RISORSA_IMMAGINE_GIALLO;
import static gen.gui.LettoreImmagini.leggiImmagineOggetto;
import static gen.sim.GeneratoreCasuale.generaNumeroSinoA;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import gen.sim.Ambiente;

public class Giallo extends Animale {


static final private Image IMMAGINE_GIALLA = leggiImmagineOggetto(RISORSA_IMMAGINE_GIALLO);
	
	static private int progId=0;
	
	public Giallo(Ambiente ambiente) {
		super(ambiente,progId++);
	
	}
	
	@Override
	public Image getImmagine() {
		return IMMAGINE_GIALLA;
	}
	
	@Override
	public Animale creaClone() {
		return new Giallo(this.getAmbiente());
	}
	
	@Override
	protected Animale decidiProssimoObiettivo() {
		 List<Animale> all = this.getAmbiente().getAllAnimali();
		 List<Animale> nonGialli = new LinkedList<>();
		
		 for (Animale a : all) {
			if (!a.getClass().equals(Giallo.class)) {
				nonGialli.add(a);
			}
		}
		return nonGialli.get(generaNumeroSinoA(nonGialli.size()));
	}

	@Override
	public String toString() {
		return Giallo.class.getSimpleName()+getId() + ":"+getGenere().name().charAt(0)+" "+getEta();
	}

}
