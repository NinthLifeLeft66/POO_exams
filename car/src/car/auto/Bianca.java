package car.auto;

import static car.gui.LettoreImmagini.leggiImmagineVettura;
import static car.sim.GeneratoreCasuale.posizioneCasuale;

import java.awt.Image;

import car.sim.Coordinate;
import car.sim.Zona;

public class Bianca extends Auto{
	
	static final private Image IMMAGINE_VETTURA_BIANCA = leggiImmagineVettura(java.awt.Color.WHITE);

	static private int progId = 0;
	
	public Bianca (Zona zona ) {
		super (zona, progId++);
	}
	
	public Image getImmagine() {
		return IMMAGINE_VETTURA_BIANCA;
	}
	
	public Coordinate decidiProssimaDestinazione() {
		return posizioneCasuale();
	}

}
