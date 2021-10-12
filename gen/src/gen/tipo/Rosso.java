package gen.tipo;

import static gen.gui.CostantiGUI.RISORSA_IMMAGINE_ROSSO;
import static gen.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import gen.sim.Ambiente;
import gen.sim.Coordinate;

public class Rosso extends Animale {
	static final private Image IMMAGINE_ROSSA = leggiImmagineOggetto(RISORSA_IMMAGINE_ROSSO);

	static private int progId = 0;

	public Rosso(Ambiente ambiente) {
		super(ambiente, progId++);
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_ROSSA;
	}

	@Override
	public Animale creaClone() {
		return new Rosso(this.getAmbiente());
	}

	@Override
	protected Animale decidiProssimoObiettivo() {
		List<Animale> all = this.getAmbiente().getAllAnimali();
		List<Animale> nonRossi = new LinkedList<>();

		for (Animale a : all) {
			if (!a.getClass().equals(Rosso.class)) {
				nonRossi.add(a);
			}
		}
		Animale piuVicino = null;
		int bestRis = 100;
		for (Animale a1: nonRossi) {
			double distanza1 = Coordinate.distanza(this.getPosizione(), a1.getPosizione());
			
			for ( Animale b : nonRossi) {
				double distanza2 = Coordinate.distanza(this.getPosizione(), b.getPosizione());
			
				int ris = Double.compare( distanza1, distanza2 );
				
				if( ris > 0) {
					if (bestRis>ris) {
						piuVicino = b;
						bestRis=ris;
						}
				}
				else { 
					if(bestRis>ris){ 
					piuVicino = a1;
					bestRis=ris;
					}
				}
			}
		}
		if(piuVicino == null)
			return all.get(0);

		return piuVicino;
	}

	@Override
	public String toString() {
		return Rosso.class.getSimpleName()+getId() + ":"+getGenere().name().charAt(0)+" "+getEta();
	}
}
