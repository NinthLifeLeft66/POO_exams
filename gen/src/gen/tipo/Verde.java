package gen.tipo;

import static gen.gui.CostantiGUI.RISORSA_IMMAGINE_VERDE;
import static gen.gui.LettoreImmagini.leggiImmagineOggetto;
import static gen.sim.GeneratoreCasuale.generaNumeroSinoA;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import gen.sim.Ambiente;

public class Verde extends Animale {

	static final private Image IMMAGINE_VERDE = leggiImmagineOggetto(RISORSA_IMMAGINE_VERDE);

	static private int progId=0;


	public Verde(Ambiente ambiente) {
		super(ambiente,progId++);
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_VERDE;
	}

	@Override
	public Animale creaClone() {
		return new Verde(this.getAmbiente());
	}

	@Override
	protected Animale decidiProssimoObiettivo() {
		List<Animale> all = this.getAmbiente().getAllAnimali();
		List<Animale> listaPrede = new LinkedList<>();

		if (this.getEta() < gen.sim.CostantiSimulazione.MIN_ETA_RIPRODUZIONE) {
			for (Animale a : all) {
				if (!a.getClass().equals(Verde.class)) {
					listaPrede.add(a);
				}
			}
		}else {

			for (Animale a : all) {
				if (a.getClass().equals(Verde.class)) {
					listaPrede.add(a);
				}
			}
		}
		if(listaPrede.isEmpty())
			return all.get(0);
		
		return listaPrede.get(generaNumeroSinoA(listaPrede.size()));
	}

	@Override
	public String toString() {
		return Verde.class.getSimpleName()+getId() + ":"+getGenere().name().charAt(0)+" "+getEta();
	}

}
