package ama.simulatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ama.Posizione;
import ama.rifiuto.Rifiuto;
import ama.rifiuto.Vetro;

public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;	
	
	final static private Posizione ORIGINE = new Posizione(0, 0);
	
	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
	}

	/* N.B. E' POSSIBILE USARE I  METODI CHE SEGUONO (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */
	private Vetro creaVetroRaccoltoDaBrowniano() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaBrowniano());	
		return rifiuto;
	}

	
	private Vetro creaVetroRaccoltoDaChaser() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaChaser());	
		return rifiuto;
	}
	
	/* N.B. E' POSSIBILE USARE I METODI SOPRA (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */
	
	@Test
	public void testRaccoltoPerMezzo() {
		Set<Rifiuto> setR = new HashSet<Rifiuto>();
		
		setR.add(creaVetroRaccoltoDaBrowniano());
		setR.add(this.creaVetroRaccoltoDaChaser());
		setR.add(this.creaVetroRaccoltoDaChaser());
	
		
		assertFalse ( stats.raccoltoPerMezzo(setR).isEmpty());
	}

	
	@Test
	public void testRaccoltoPerPolitica() {
		Set<Rifiuto> setR = new HashSet<Rifiuto>();
		
		setR.add(creaVetroRaccoltoDaBrowniano());
		setR.add(this.creaVetroRaccoltoDaChaser());
		setR.add(this.creaVetroRaccoltoDaChaser());
	
		
		assertFalse ( stats.raccoltoPerPolitica(setR).isEmpty());
	}
	
	/*                              */
	/* DA COMPLETARE VEDI DOMANDA 6 */
	/*                              */

	
	@Test
	public void testRaccoltoPerMezzoSize3() {
		Set<Rifiuto> setR = new HashSet<Rifiuto>();
		
		setR.add(creaVetroRaccoltoDaBrowniano());
		setR.add(this.creaVetroRaccoltoDaChaser());
		setR.add(this.creaVetroRaccoltoDaChaser());
	
		
		assertEquals ( 3, stats.raccoltoPerMezzo(setR).size());
	}
	
	@Test
	public void testRaccoltoPerPoliticaSize2() {
		Set<Rifiuto> setR = new HashSet<Rifiuto>();
		
		setR.add(creaVetroRaccoltoDaBrowniano());
		setR.add(this.creaVetroRaccoltoDaChaser());
		setR.add(this.creaVetroRaccoltoDaChaser());
	
		
		assertEquals (2, stats.raccoltoPerPolitica(setR).size());
	}
	

	@Test
	public void testRaccoltoPerPoliticaEmpty() {
		Set<Rifiuto> setR = new HashSet<Rifiuto>();
		
		assertTrue ( stats.raccoltoPerPolitica(setR).isEmpty());
	}
	
}
