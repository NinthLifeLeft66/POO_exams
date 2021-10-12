package dist.pers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dist.sim.Ambiente;

/** 
 * Suggerimento: Controllare che questi test abbiano successo sia
 * prima che dopo aver operato le modifiche suggerite<BR/>
 * RIVEDERE {@link #testIdProgressiviPerSani()}<BR/>
 * COMPLETARE {@link #testIdProgressiviPerSaniEInfetti()}<BR/>
 * <B>(VEDI DOMANDA 2)</B>
 */
public class PersonaTest {

	private Ambiente ambiente;
	
	@Before
	public void setUp() throws Exception {
		this.ambiente = new Ambiente();
	}

	@Test
	public void testIdProgressiviPerPersoneStessoTipo() {
		// DA RIVEDERE VEDI DOMANDA 2a
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 0, new Attenta(this.ambiente).getId());
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 1, new Attenta(this.ambiente).getId());
	}

	@Test
	public void testIdProgressiviPerPersoneTipoDiverso() {
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 0, new Distratta(this.ambiente).getId());
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 1, new Distratta(this.ambiente).getId());
	}


}
