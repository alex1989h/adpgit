package aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListeATest {

  @Test
  public void testInsert() {
    ListeA<Integer> list1 = new ListeA<Integer>();
    assertEquals(0, list1.size());
    list1.insert(0, 23);
    list1.insert(0, 21);
    list1.insert(2, 24);
    assertEquals(3, list1.size());
    assertEquals(-1, list1.find(22));
    assertEquals(1, list1.find(23));
    assertEquals(new Integer(21), list1.retrieve(0));
    assertEquals(new Integer(23), list1.retrieve(1));
    assertEquals(new Integer(24), list1.retrieve(2));
    try {
      list1.insert(4, 24);
      assertTrue(false);
    } catch (NullPointerException e) {
      // Fuer Test ob ein NullPointerException geworfen wird
    }
    try {
      list1.retrieve(3);
      assertTrue(false);
    } catch (NullPointerException e) {
      // Fuer Test ob ein NullPointerException geworfen wird
    }
    ListeA<Integer> list2 = new ListeA<Integer>();
    list2.insert(0, 28);
    list2.insert(1, 26);
  }

  @Test
  public void testDelete() {
    ListeA<Integer> list = new ListeA<Integer>();
    list.insert(0, 23);
    list.insert(0, 21);
    list.insert(2, 24);
    list.insert(3, 25);
    list.delete(2);
    assertEquals(3, list.size());
    assertEquals(new Integer(21), list.retrieve(0));
    assertEquals(new Integer(23), list.retrieve(1));
    assertEquals(new Integer(25), list.retrieve(2));
    try {
      list.delete(3);
      assertTrue(false);
    } catch (NullPointerException e) {
      // Fuer Test ob ein NullPointerException geworfen wird
    }
  }
  @Test
  public void testConcat() {
    ListeA<Integer> list1 = new ListeA<Integer>();
    list1.insert(0, 23);
    list1.insert(0, 21);
    list1.insert(2, 24);

    ListeA<Integer> list2 = new ListeA<Integer>();
    list2.insert(0, 28);
    list2.insert(1, 26);
    
    ListeA<Integer> summeListen = new ListeA<Integer>();
    summeListen.insert(0, 21);
    summeListen.insert(1, 23);
    summeListen.insert(2, 24);
    summeListen.insert(3, 28);
    summeListen.insert(4, 26);
    
    list1.concat(list2);
    assertEquals(5, list1.size());
    for (int i = 0; i < summeListen.size(); i++) {
      assertEquals(summeListen.retrieve(i),list1.retrieve(i));
    }
    
  }
}
