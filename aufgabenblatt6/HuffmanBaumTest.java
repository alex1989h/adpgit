package aufgabenblatt6;

import static org.junit.Assert.*;

import org.junit.Test;

public class HuffmanBaumTest {

	@Test
	public void test() {
		HuffmanBaum baum = new HuffmanBaum();
		String beispiel = "If you give someone a program you will frustrate them for a day? If you teach them how to program, you will frustrate them for a lifetime. The computing scientist?s main challenge is not to get confused by the complexities of his own making. Beauty is more important in computing than anywhere else in technology because software is so complicated. Beauty is the ultimate defence against complexity.";
		String code = baum.kodiere(beispiel);
		
		System.out.println("Codiert\n" + code);
		code = baum.dekodiere(code);
		assertEquals("Wurde nicht richtig dekodiert",beispiel, code);
		System.out.println("Decodiert\n" + code);
		baum.print();

		code = baum.kodiere("MISSISSIPPI");
		System.out.println("Codiert\n" + code);
		code = baum.dekodiere(code);
		System.out.println("Decodiert\n" + code);
		baum.print();
	}

}
