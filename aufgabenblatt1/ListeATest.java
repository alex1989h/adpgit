package aufgabenblatt1;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * ListeATest
 *
 * Eine Testklasse von die ListeA
 *
 *
 * Praktikum AD, SS 2016
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de), 
 * 		   Alexander Hoffmann (Alexander.Hoffman@haw-hamburg.de)
 *
 *         Aufgabe: Aufgabenblatt 1, Aufgabe 3
 *
 * @param <T>
 *
 */
public class ListeATest {

  @Test
  public void testSize() {
    ListeA<Integer> list = new ListeA<Integer>();
    assertEquals(0, list.size());
    list.insert(0, 23);
    
    assertEquals(1, list.size());
    list.insert(0, 21);
    
    assertEquals(2, list.size());
    list.insert(2, 22);
    
    assertEquals(3, list.size());
    list.insert(1, 25);
    
    assertEquals(4, list.size());
    list.insert(4, 24);
    
    assertEquals(5, list.size());
  }
  
	@Test
	public void testInsert() {
	  
		ListeA<Long> list1 = new ListeA<Long>();
		assertEquals(0, list1.size());
		list1.insert(0, (long)23);
		list1.insert(0, (long)21);
		assertEquals(2, list1.size());
		list1.insert(2, (long)24);
		
		assertEquals(3, list1.size());
		assertEquals(-1, list1.find((long)22));
		assertEquals(1, list1.find((long)23));
		assertEquals(new Long(21), list1.retrieve(0));
		assertEquals(new Long(23), list1.retrieve(1));
		assertEquals(new Long(24), list1.retrieve(2));
		try {
			list1.insert(-1, (long)24);
			assertTrue(false);
		} catch (IndexOutOfBoundsException e) {
			// Fuer Test ob ein NullPointerException geworfen wird
		}
		try {
			list1.retrieve(3);
			assertTrue(false);
		} catch (IndexOutOfBoundsException e) {
			// Fuer Test ob ein NullPointerException geworfen wird
		}
	}

	@Test
	public void testDelete() {
		ListeA<Long> list = new ListeA<Long>();
		list.insert(0, (long)23);
		list.insert(0, (long)21);
		list.insert(2, (long)24);
		list.insert(3, (long)25);
		list.delete(2);
		assertEquals(3, list.size());
		assertEquals(new Long(21), list.retrieve(0));
		assertEquals(new Long(23), list.retrieve(1));
		assertEquals(new Long(25), list.retrieve(2));
		try {
			list.delete(3);
			assertTrue(false);
		} catch (IndexOutOfBoundsException e) {
			// Fuer Test ob ein NullPointerException geworfen wird
		}
	}

	@Test
	public void testConcat() {
		ListeA<Long> list1 = new ListeA<Long>();
		list1.insert(0, (long)23);
		list1.insert(0, (long)21);
		list1.insert(2, (long)24);

		ListeA<Long> list2 = new ListeA<Long>();
		list2.insert(0, (long)28);
		list2.insert(1, (long)26);

		ListeA<Long> summeListen = new ListeA<Long>();
		summeListen.insert(0, (long)21);
		summeListen.insert(1, (long)23);
		summeListen.insert(2, (long)24);
		summeListen.insert(3, (long)28);
		summeListen.insert(4, (long)26);

		list1.concat(list2);
		assertEquals(5, list1.size());
		for (int i = 0; i < summeListen.size(); i++) {
			assertEquals(summeListen.retrieve(i), list1.retrieve(i));
		}
	}
	
	@Test
  public void testFind() {
    ListeA<Integer> list = new ListeA<Integer>();
    assertEquals(-1, list.find(23));
    
    list.insert(0, 23);
    assertEquals(-1, list.find(22));
    assertEquals(0, list.find(23));
    assertEquals(-1, list.find(null));
    list.insert(1, 21);
    list.insert(2, 22);
    assertEquals(-1, list.find(25));
    assertEquals(0, list.find(23));
    assertEquals(1, list.find(21));
    assertEquals(2, list.find(22));
  }
}
