package dist.pers;

import static dist.gui.CostantiGUI.RISORSA_IMMAGINE_BIANCO;
import static dist.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import dist.sim.Ambiente;
import dist.sim.Coordinate;

public class Attenta extends Persona {
	
	static final private Image IMMAGINE_BIANCA = leggiImmagineOggetto(RISORSA_IMMAGINE_BIANCO);
	static private int progId = 0;


	public Attenta(Ambiente ambiente) {
		super(ambiente, progId++);
		// TODO Auto-generated constructor stub
	}

	
	public Image getImmagine() {
		return IMMAGINE_BIANCA;
	}
	
	public void mossa() {
		List<Coordinate> adiacenti = new LinkedList<>(this.getAmbiente().adiacentiA(this.getPosizione()));
		List<Coordinate> adiacentiNonLiberi = new LinkedList<>();

		for (int i=0;i<adiacenti.size();i++) {
			for ( Persona p: this.getAmbiente().getAllPersone()) {
			if (adiacenti.get(i).equals(p.getPosizione())) {
				adiacentiNonLiberi.add(adiacenti.get(i));
			}
		}
	}
		adiacenti.removeAll(adiacentiNonLiberi);
		Collections.shuffle(adiacenti);
		this.setPosizione(adiacenti.get(0));
	}
}

	
	
	
	
	
	

