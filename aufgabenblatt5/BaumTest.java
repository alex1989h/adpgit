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
    
    assertEquals(9, baum.aufsummieren(9,9));
    
  }
}
