package gen.stats;

import static org.junit.Assert.assertFalse;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import gen.sim.Ambiente;
import gen.sim.Scontro;
import gen.tipo.Animale;
import gen.tipo.Bianco;
import gen.tipo.Giallo;
import gen.tipo.Rosso;
import gen.tipo.Verde;

public class StatisticheTest {

	private Statistiche stats;
	
	private Rosso rosso;
	private Verde verde;
	private Giallo giallo;
	private Bianco bianco;

	private Ambiente ambient;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
		this.ambient = new Ambiente();
		this.bianco= new Bianco(ambient);
		this.rosso= new Rosso(ambient);
		this.verde= new Verde(ambient);
		this.giallo= new Giallo(ambient);
		this.ambient.add(bianco);
		this.ambient.add(giallo);
		this.ambient.add(rosso);
		this.ambient.add(verde);
	}
	
	@Test
	public void testScontriPerAnimale() {
		Set<Animale> setAnimale1 = new HashSet<>(); 
		Set<Animale> setAnimale2 = new HashSet<>(); 
		
		setAnimale1.add(verde);
		setAnimale1.add(bianco);
		setAnimale2.add(giallo);
		setAnimale2.add(rosso);
		
		Scontro scontro1 = new Scontro(setAnimale1);
		Scontro scontro2 = new Scontro(setAnimale2);
		
		Set<Scontro> setScontro = new HashSet<>();

		setScontro.add(scontro1);
		setScontro.add(scontro2);
		
		assertFalse(this.stats.scontriPerAnimale(setScontro).isEmpty());
		
	}

}