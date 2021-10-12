package gen.tipo;


import static gen.gui.CostantiGUI.RISORSA_IMMAGINE_BIANCO;
import static gen.gui.LettoreImmagini.leggiImmagineOggetto;
import static gen.sim.GeneratoreCasuale.generaNumeroSinoA;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import gen.sim.Ambiente;

public class Bianco extends Animale{
	
	static final private Image IMMAGINE_BIANCA = leggiImmagineOggetto(RISORSA_IMMAGINE_BIANCO);
	
	static private int progId=0;
	

	
	public Bianco(Ambiente ambiente) {
		super(ambiente,progId++);
		
	}

	
	@Override
	public Image getImmagine() {
		return IMMAGINE_BIANCA;
	}
	
	@Override
	public Animale creaClone() {
		return new Bianco(this.getAmbiente());
	}
	
	@Override
	protected Animale decidiProssimoObiettivo() {
		 List<Animale> all = this.getAmbiente().getAllAnimali();
		 List<Animale> soloBianchi = new LinkedList<>();
		
		 for (Animale a : all) {
			if (a.getClass().equals(Bianco.class)) {
				soloBianchi.add(a);
			}
		}
		return soloBianchi.get(generaNumeroSinoA(soloBianchi.size()));
	}

	@Override
	public String toString() {
		return Bianco.class.getSimpleName()+getId() + ":"+getGenere().name().charAt(0)+" "+getEta();
	}

}
