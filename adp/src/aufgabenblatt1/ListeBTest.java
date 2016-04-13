package aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * ListeBTest
 *
 * Eine Testklasse für die ListeB
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
public class ListeBTest {
  
  @Test
  public void testSize() {
    ListeB<Integer> list = new ListeB<Integer>();
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
		ListeB<Long> list = new ListeB<Long>();
		
		assertEquals(0, list.size());
		list.insert(0, 23l);
		list.insert(0, (long)21);
		list.insert(2, (long)22);
		list.insert(1, 25l);
		assertEquals(4, list.size());
		list.insert(4, (long)24);
		try {
			list.insert(-1, (long)26);
			assertTrue(false);
		} catch (IndexOutOfBoundsException e) {
			// Fuer Test ob ein NullPointerException geworfen wird
		}
		assertEquals(new Long(21), list.retrieve(0));
		assertEquals(new Long(25), list.retrieve(1));
		assertEquals(new Long(23), list.retrieve(2));
		assertEquals(new Long(22), list.retrieve(3));
		assertEquals(new Long(24), list.retrieve(4));
	}

	@Test
	public void testDelete() {
		ListeB<Integer> list = new ListeB<Integer>();

		list.insert(0, 23);
		list.insert(1, 21);
		list.insert(2, 22);
		list.insert(3, 25);
		list.insert(4, 24);

		list.delete(0);
		assertEquals(new Integer(21), list.retrieve(0));
		assertEquals(new Integer(22), list.retrieve(1));
		assertEquals(new Integer(25), list.retrieve(2));
		assertEquals(new Integer(24), list.retrieve(3));

		list.delete(3);
		assertEquals(new Integer(21), list.retrieve(0));
		assertEquals(new Integer(22), list.retrieve(1));
		assertEquals(new Integer(25), list.retrieve(2));

		list.delete(1);
		assertEquals(new Integer(21), list.retrieve(0));
		assertEquals(new Integer(25), list.retrieve(1));
		
		try {
      list.delete(6);
      assertTrue(false);
    } catch (IndexOutOfBoundsException e) {
      // Fuer Test ob ein NullPointerException geworfen wird
    }
	}

	@Test
	public void testConcat() {
		ListeB<Integer> list1 = new ListeB<Integer>();
		list1.insert(0, 23);
		list1.insert(1, 21);
		list1.insert(2, 24);

		ListeB<Integer> list2 = new ListeB<Integer>();
		list2.insert(0, 28);
		list2.insert(1, 26);

		ListeB<Integer> summeListen = new ListeB<Integer>();
		summeListen.insert(0, 23);
		summeListen.insert(1, 21);
		summeListen.insert(2, 24);
		summeListen.insert(3, 28);
		summeListen.insert(4, 26);

		list1.concat(list2);
		assertEquals(5, list1.size());
		for (int i = 0; i < summeListen.size(); i++) {
			assertEquals(summeListen.retrieve(i), list1.retrieve(i));
		}
	}

	@Test
	public void testFind() {
		ListeB<Integer> list = new ListeB<Integer>();
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
