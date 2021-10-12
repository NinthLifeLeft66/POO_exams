package gen.tipo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import gen.sim.Ambiente;
import gen.sim.Coordinate;

public class RossoTest {
	
	private Animale rosso;
	private Animale verde;
	private Animale giallo;
	private Animale bianco;

	private Ambiente ambient;

	@Before
	public void setUp() {
		this.ambient = new Ambiente();
		this.bianco= new Bianco(this.ambient);
		this.rosso= new Rosso(this.ambient);
		this.verde= new Verde(this.ambient);
		this.giallo= new Giallo(this.ambient);
		this.ambient.add(bianco);
		this.ambient.add(giallo);
		this.ambient.add(rosso);
		this.ambient.add(verde);
	}

	@Test
	public void testBiancoVicino() {
		
		this.rosso.setPosizione(new Coordinate(0,0));
		this.verde.setPosizione(new Coordinate(5,5));
		this.giallo.setPosizione(new Coordinate(5,5));
		this.bianco.setPosizione(new Coordinate(0,1));
		
		assertEquals( this.bianco, this.rosso.decidiProssimoObiettivo());
	}

}
