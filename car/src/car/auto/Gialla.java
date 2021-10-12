package car.auto;

import static car.gui.LettoreImmagini.leggiImmagineVettura;

import java.awt.Image;
import java.util.Collections;
import java.util.List;

import car.sim.Coordinate;
import car.sim.Zona;

public class Gialla extends Auto {
	
	static final private Image IMMAGINE_VETTURA_GIALLA = leggiImmagineVettura(java.awt.Color.YELLOW);

	static private int progId = 0;
	
	private static List<Coordinate> destinazioni = car.sim.GeneratoreCasuale.generaNposizioniCasuali(car.sim.CostantiSimulazione.N_DESTINAZIONI_GIALLE);

	public Gialla(Zona zona) {
		super(zona, progId++);
	}

	@Override
	public Coordinate decidiProssimaDestinazione() {
	Collections.shuffle(destinazioni);
	return destinazioni.get(0);
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_VETTURA_GIALLA;
	}

	public static List<Coordinate> getDestinazioni() {
		return destinazioni;
	}

}
