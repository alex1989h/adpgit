package aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListeBTest {

  @Test
  public void testInsert() {
    ListeB<Integer> list = new ListeB<Integer>();
    assertEquals(0, list.size());
    list.insert(0, 23);
    list.insert(0, 21);
    list.insert(2, 22);
    list.insert(1, 25);
    list.insert(4, 24);
    try {
      list.insert(7, 26);
      assertTrue(false);
    } catch (IndexOutOfBoundsException e) {
      // Fuer Test ob ein NullPointerException geworfen wird
    }
    // list.delete(0);

    assertEquals(3, list.find(22));

    assertEquals(new Integer(21), list.retrieve(0));
    assertEquals(new Integer(25), list.retrieve(1));
    assertEquals(new Integer(23), list.retrieve(2));
    assertEquals(new Integer(22), list.retrieve(3));
    assertEquals(new Integer(24), list.retrieve(4));
  }

  @Test
  public void testDelete() {
    ListeB<Integer> list = new ListeB<Integer>();
    assertEquals(0, list.size());
    
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
  }

  @Test
  public void testConcat() {
    ListeB<Integer> list1 = new ListeB<Integer>();
    list1.insert(0, 23);
    list1.insert(0, 21);
    list1.insert(2, 24);

    ListeB<Integer> list2 = new ListeB<Integer>();
    list2.insert(0, 28);
    list2.insert(1, 26);

    ListeB<Integer> summeListen = new ListeB<Integer>();
    summeListen.insert(0, 21);
    summeListen.insert(1, 23);
    summeListen.insert(2, 24);
    summeListen.insert(3, 28);
    summeListen.insert(4, 26);

    list1.concat(list2);
    assertEquals(5, list1.size());
    for (int i = 0; i < summeListen.size(); i++) {
      assertEquals(summeListen.retrieve(i), list1.retrieve(i));
    }

  }

}
