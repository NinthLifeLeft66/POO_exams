package gen.sim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Questa classe modella il genere di una specie
 * 
 * <B>(DA COMPLETARE VEDI DOMANDA 1)</B>
 */
public enum Genere {

	   MASCHIO() {
		@Override public Genere opposto() { return FEMMINA; }
	}, FEMMINA() {
		@Override public Genere opposto() { return MASCHIO; }
	};
	
	static private final Random rnd = new Random();
		
	static public List<Genere> tuttiAcaso() {
		final List<Genere> risultato = new ArrayList<>(Arrays.asList(values()));
		Collections.shuffle(risultato);
		return risultato;
	}

	
	static public Genere casuale() {
		final int indiceDirezioneAcaso = rnd.nextInt(values().length);
		return values()[indiceDirezioneAcaso];
	}

	/**
	 * @return il genere opposto al presente
	 */
	public abstract Genere opposto();


}
