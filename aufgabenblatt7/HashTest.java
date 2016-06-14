package aufgabenblatt7;

import org.junit.Test;

public class HashTest {

	@Test
	public void test() {
		Hash hash = new Hash();
		hash.initHt();
//		for (int i = 0; i < 10E5; i++) {
//			hash.einfuegen(i, "Trala"+i);
//		}
		hash.einfuegen(17, "17");
		hash.einfuegen(32, "32");
		hash.einfuegen(24, "24");
		hash.einfuegen(15, "17");
		hash.einfuegen(31, "32");
		hash.einfuegen(23, "24");
		hash.einfuegen(16, "17");
		hash.einfuegen(30, "32");
		hash.ausgabe();
		hash.einfuegen(25, "25");
		hash.ausgabe();
		hash.einfuegen(7, "7");
		hash.ausgabe();
		hash.einfuegen(24, "5");
		hash.ausgabe();
	}

}
