package aufgabenblatt3;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuicksortTest {

	@Test
	public void testSort() {
		int[] zahlen = { 4, 5, 8, 1, 2, 3, 0, -1, 4, 20, 15, 11};
		int[] erwarteteZahl = { - 1, 0, 1, 2, 3, 4, 4, 5, 8, 11, 15, 20};
		Quicksort sort = new Quicksort();
		assertArrayEquals(erwarteteZahl, sort.sort(zahlen, 0, 11) );
	}

}
