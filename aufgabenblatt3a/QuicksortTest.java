package aufgabenblatt3a;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuicksortTest {

  @Test
  public void testSort() {
    Quicksort quick = new Quicksort();
    int[] actualArray = { 23, 3, 65, 43, 12, 67, 23, 11, 101, 0 };
    int[] expectedArray = { 0, 3, 11, 12, 23, 23, 43, 65, 67, 101 };
    quick.sort(actualArray);
    assertArrayEquals(expectedArray, actualArray);

    int[] actualArray2 = { 23, 3 };
    int[] expectedArray2 = { 3, 23 };
    quick.sort(actualArray2);
    assertArrayEquals(expectedArray2, actualArray2);

    int[] actualArray3 = { 3, 23, 5 };
    int[] expectedArray3 = { 3, 5, 23 };
    quick.sort(actualArray3);
    assertArrayEquals(expectedArray3, actualArray3);
  }

  @Test
  public void testSortRandom() {
    Quicksort quick = new Quicksort();
    int[] actualArray = { 23, 3, 65, 43, 12, 67, 23, 11, 101, 0 };
    int[] expectedArray = { 0, 3, 11, 12, 23, 23, 43, 65, 67, 101 };
    quick.sortRandom(actualArray);
    assertArrayEquals(expectedArray, actualArray);

    int[] actualArray2 = { 23, 3 };
    int[] expectedArray2 = { 3, 23 };
    quick.sortRandom(actualArray2);
    assertArrayEquals(expectedArray2, actualArray2);

    int[] actualArray3 = { 23, 3, 5 };
    int[] expectedArray3 = { 3, 5, 23 };
    quick.sortRandom(actualArray3);
    assertArrayEquals(expectedArray3, actualArray3);
  }

  @Test
  public void testSortMedian() {
    Quicksort quick = new Quicksort();
    int[] actualArray = { 23, 3, 65, 43, 12, 67, 23, 11, 101, 0 };
    int[] expectedArray = { 0, 3, 11, 12, 23, 23, 43, 65, 67, 101 };
    quick.sortMedian(actualArray);
    assertArrayEquals(expectedArray, actualArray);

    int[] actualArray2 = { 23, 3 };
    int[] expectedArray2 = { 3, 23 };
    quick.sortMedian(actualArray2);
    assertArrayEquals(expectedArray2, actualArray2);

    int[] actualArray3 = { 23, 3, 5 };
    int[] expectedArray3 = { 3, 5, 23 };
    quick.sortMedian(actualArray3);
    assertArrayEquals(expectedArray3, actualArray3);
  }
}
