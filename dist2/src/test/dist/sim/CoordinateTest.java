package dist.sim;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


/** 
 * Modificare la classe {@link Coordinate} affinche'
 * questi test abbiano successo 
 * <B>(VEDI DOMANDA 1)</B>
 */
public class CoordinateTest {

	@Test
	public void testEquals() {
		assertEquals(new Coordinate(0,0), new Coordinate(0,0));
	}
	
	@Test
	public void testSetDiCoordinate() {
		final Set<Coordinate> insieme = new HashSet<>();
		final Coordinate origine = new Coordinate(0,0);
		final Coordinate zeroZero = new Coordinate(0,0);
		assertNotSame(origine, zeroZero);
		insieme.add(origine);
		insieme.add(zeroZero);
		assertEquals("due oggetti distinti di stesse coordinate dovrebbero contare 1!",
					 1, insieme.size());
	}

}
