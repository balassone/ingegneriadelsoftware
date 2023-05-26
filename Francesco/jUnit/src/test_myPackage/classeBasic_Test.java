package test_myPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import myPackage.classeBasic;

public class classeBasic_Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testClasseBasic() {
		int atteso=0;
		classeBasic c = new classeBasic();
		assertEquals(atteso,c.getTot());
	}

	@Test
	public void testIncrementa() {
		int atteso=2;
		classeBasic c = new classeBasic();
		c.incrementa();
		c.incrementa();
		int valore_osservato=c.getTot();
		assertEquals(atteso,valore_osservato);
	}

	@Test
	public void testDecrementa() {
		fail("Not yet implemented");
	}

}
