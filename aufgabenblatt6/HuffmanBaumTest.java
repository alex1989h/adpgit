package aufgabenblatt6;

import static org.junit.Assert.*;

import org.junit.Test;

public class HuffmanBaumTest {

	@Test
	public void test() {
		HuffmanBaum baum = new HuffmanBaum();
		baum.codiere("MISSISSIPPI");
		baum.print();
		baum.codiere("\0    ");
		baum.print();
	}

}
