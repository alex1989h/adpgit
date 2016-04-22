package aufgabenblatt4;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergesortTest {

  @Test
  public void testSort() {
    Mergesort ms = new Mergesort();

    for (int k = 6; k <= 6; k++) {
      int[] array = new int[(int) Math.pow(10, k)];
      for (int i = 0; i < (int) Math.pow(10, k); i++) {
        array[i] = (int) (Math.random() * (int) Math.pow(10, k) * 100)
            + (700 * (int) Math.pow(10, k));
      }
      ms.sort(array, 0, array.length - 1);

      for (int i = 0; i < array.length - 1; i++) {
        if (array[i] <= array[i + 1]) {
          assertTrue(true);
        } else {
          assertTrue(false);
        }
      }

    }
  }

}
