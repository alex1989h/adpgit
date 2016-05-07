package aufgabenblatt5;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaumTest {

	@Test
	public void test() {
		Baum baum = new Baum();
		baum.einfuegen(13);
		baum.einfuegen(1);
		baum.einfuegen(45);
		baum.einfuegen(9);
		baum.einfuegen(31);
		baum.einfuegen(7);
		baum.einfuegen(20);

		try {
			baum.einfuegen(-1);
			assertTrue("Exception wegen negativen Zahl nicht geworfen", false);
		} catch (IllegalArgumentException e) {
		}

		assertEquals(9, baum.aufsummieren(9, 9));
		assertEquals(126, baum.aufsummieren(-1, 100));
		assertEquals(17, baum.aufsummieren(1, 9));

	}
}
