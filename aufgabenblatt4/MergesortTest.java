package aufgabenblatt4;

import static org.junit.Assert.*;

import org.junit.Test;

import aufgabenblatt3a.Quicksort;

public class MergesortTest {

  @Test
  public void testSort() {
    Mergesort ms = new Mergesort();
    MyMergeSort ma = new MyMergeSort();
    Quicksort qs = new Quicksort();
    for (int l = 0; l < 1; l++) {
      for (int k = 6; k <= 6; k++) {

        int[] array = new int[(int) Math.pow(10, k)];
        for (int i = 0; i < (int) Math.pow(10, k); i++) {
          array[i] = (int) (Math.random() * (int) Math.pow(10, k) * 100)
              + (700 * (int) Math.pow(10, k));

        }
        qs.sort(array,0,array.length-1);
        for (int i = 0; i < array.length - 1; i++) {
          //System.out.println(array[i]);
          if (array[i] <= array[i + 1]) {
            assertTrue(true);
          } else {
            assertTrue(false);
          }
        }
      }
    }
    // System.out.println("Mergesort:rekrusiver Aufruf: "+ms.getZaehlerR());
    // System.out.println("Mergesort:Anzahl vergleiche: "+ms.getZaehlerV());
    System.out.println("Mergesort:rekrusiver Aufruf: " + qs.getZaehlerR());
    System.out.println("Mergesort:Anzahl vergleiche: " + qs.getZaehlerV());
  }

}
