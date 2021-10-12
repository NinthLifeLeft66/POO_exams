package gen.tipo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import gen.sim.Ambiente;

/** 
 * Controllare che questi test abbiano successo sia
 * prima che dopo aver operato le modifiche suggerite<BR/>
 * RIVEDERE {@link #testIdProgressiviPerBianche()}<BR/>
 * COMPLETARE {@link #testIdProgressiviPerGialle()}<BR/>
 * <B>(VEDI DOMANDA 2)</B>
 */
public class AnimaleTest {

	private Ambiente ambiente;
	
	private Ambiente ambiente2;
	
	@Before
	public void setUp() throws Exception {
		this.ambiente = new Ambiente();
		this.ambiente2 = new Ambiente();
	}

	@Test
	public void testIdProgressiviPerBianchi() {
		// DA RIVEDERE VEDI DOMANDA 2a ????????????????????????????????????????????
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 0, new Bianco(this.ambiente).getId());
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 1, new Bianco(this.ambiente).getId());
	}

	@Test
	public void testIdProgressiviPerAltroColore() {
		// DA COMPLETARE VEDI DOMANDA 2bcd
		
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 0, new Giallo(this.ambiente2).getId());
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 1, new Giallo(this.ambiente2).getId());
		
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 0, new Verde(this.ambiente2).getId());
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 1, new Verde(this.ambiente2).getId());
		
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 0, new Rosso(this.ambiente2).getId());
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 1, new Rosso(this.ambiente2).getId());
	

	}

}
