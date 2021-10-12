package battlefield;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RobotOrdinatiPerPosizioneTest {
	
	// (vedi DOMANDA 5)
	// scrivere dei test-case minimali per il metodo
	// Battlefield.getRobotOrdinatiPerPosizione()
	
//	(i) campo vuoto
//
//	(ii) campo contenente un singolo robot
//
//	(iii) campo contenente due robot in posizioni di X diversa
//
//	(iv) campo contenente due robot in posizione di pari X ma Y diversa
//
//	(v) campo contenente quattro robot
//

	
	
	private Battlefield field;
	
	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(10);
	}

	@Test
	public void testCampoVuoto() {
	
		assertTrue(this.field.getRobotOrdinatiPerPosizione().isEmpty());
	}
	
	@Test
	public void testSingleTon() {
		this.field.addRobot(new Walker(new Position(0,0)));
		assertFalse(this.field.getRobotOrdinatiPerPosizione().isEmpty());
		assertEquals(1 ,this.field.getRobotOrdinatiPerPosizione().size());
		
	
	}
	
	
	@Test
	public void test2RxDiversa() {
		this.field.addRobot(new Walker(new Position(0,0)));
		this.field.addRobot(new Walker(new Position(1,0)));

		assertFalse(this.field.getRobotOrdinatiPerPosizione().isEmpty());
		assertEquals(2 ,this.field.getRobotOrdinatiPerPosizione().size());

	}
	@Test
	public void test2RxUgualeyDiversa() {
		this.field.addRobot(new Walker(new Position(1,0)));
		this.field.addRobot(new Walker(new Position(1,4)));

		assertFalse(this.field.getRobotOrdinatiPerPosizione().isEmpty());
		assertEquals(2 ,this.field.getRobotOrdinatiPerPosizione().size());

	}
	@Test
	public void test4Robot() {
		this.field.addRobot(new Walker(new Position(1,0)));
		this.field.addRobot(new Walker(new Position(1,4)));
		this.field.addRobot(new Walker(new Position(4,0)));
		this.field.addRobot(new Chaser(new Position(4,4)));

		assertFalse(this.field.getRobotOrdinatiPerPosizione().isEmpty());
		assertEquals(4 ,this.field.getRobotOrdinatiPerPosizione().size());

	}
}
