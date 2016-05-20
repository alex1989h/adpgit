package aufgabenblatt6;

import static org.junit.Assert.*;

import org.junit.Test;

public class HuffmanBaumTest {

  @Test
  public void test() {
    HuffmanBaum baum = new HuffmanBaum();
    baum.zaehleHaefigkeit("AAsdsjhhahhsghAABbBB");
    baum.print();
  }

}
