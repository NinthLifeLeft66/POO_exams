package carnivoro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TerritorioTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Territorio terr = new Territorio(50);
		terr.getAnimali().clear();
		
		assertEquals(0,terr.anno2erbivori().size());
	}

	
	@Test
	public void test2erbivori() {
		
		Territorio terr = new Territorio(50);
		terr.getAnimali().clear();
		Animale erb1 = new Erbivoro();
		Animale erb2 = new Erbivoro();
		terr.setAnimale(erb1, new Posizione(1, 2));
		terr.setAnimale(erb2, new Posizione(3, 2));
		erb1.incrementaAnni();
		erb1.incrementaAnni();
		
		erb2.incrementaAnni();
		
		assertFalse(terr.anno2erbivori().isEmpty());
		assertEquals(2,terr.anno2erbivori().size());

	}
	
	@Test
	public void test2Carnivori() {
		Territorio terr = new Territorio(50);
		terr.getAnimali().clear();
		Animale carn1 = new Carnivoro();
		Animale carn2 = new Carnivoro();
		terr.setAnimale(carn1, new Posizione(1, 2));
		terr.setAnimale(carn2, new Posizione(3, 2));
		carn1.incrementaAnni();
		carn1.incrementaAnni();
		
		carn2.incrementaAnni();
		
		assertTrue(terr.anno2erbivori().isEmpty());
		assertEquals(0,terr.anno2erbivori().size());

	}


}
