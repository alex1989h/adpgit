package aufgabenblatt6;

import static org.junit.Assert.*;

import org.junit.Test;

public class HuffmanBaumTest {

	@Test
	public void test() {
		HuffmanBaum baum = new HuffmanBaum();
		String code = baum.codiere("MISSISSIPPI");
		System.out.println("Codiert\n"+code);
		baum.print();
		code = baum.codiere("MISSISSIPPI");
		System.out.println("Codiert\n"+code);
		baum.print();
	}

}
