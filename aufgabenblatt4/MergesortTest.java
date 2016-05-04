package aufgabenblatt4;

import static org.junit.Assert.*;

import org.junit.Test;

import aufgabenblatt3.Quicksort;

public class MergesortTest {

  @Test
  public void testSort() {
    long time;
    //Mergesort ms = new Mergesort();
//    MergesortB ms = new MergesortB();
    Quicksort ms = new Quicksort();
        int k=2;
        int[] array = new int[(int) Math.pow(10, k)];
        for (int i = 0; i < (int) Math.pow(10, k); i++) {
          array[i] = (int) (Math.random() * (int) Math.pow(10, k) * 100)
              + (700 * (int) Math.pow(10, k));

        }
        
        time = System.nanoTime();
        ms.sort(array);
        time = (System.nanoTime()-time)/1000;
        System.out.println(time+" micro seconds");
        
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
