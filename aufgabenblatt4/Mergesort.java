package aufgabenblatt4;

public class Mergesort {

  public void sort(int[] array,int l, int r) {

    if (l < r) {
      int q = (l + r) / 2;

      sort(array,l, q);
      sort(array,q + 1, r);
      merge(array,l, q, r);
    }
  }

  private void merge(int[] array,int l, int q, int r) {
    
    int[] hilfsArray = new int[array.length];
    int i, j;
    for (i = l; i <= q; i++) {
      hilfsArray[i] = array[i];
    }
    for (j = q + 1; j <= r; j++) {
      hilfsArray[r + q + 1 - j] = array[j];
    }
    i = l;
    j = r;
    for (int k = l; k <= r; k++) {
      if (hilfsArray[i] <= hilfsArray[j]) {
        array[k] = hilfsArray[i];
        i++;
      } else {
        array[k] = hilfsArray[j];
        j--;
      }
    }
  }

  public static void main(String[] args) {
    int[] array = { 16, 23, 14, 7, 21, 20, 6, 1, 17, 13, 12, 9, 3,
        19 };
    Mergesort ms = new Mergesort();
    ms.sort(array,0, array.length - 1);
    for (int i = 0; i < array.length; i++) {
      System.out.println(i + 1 + ": " + array[i]);
    }
  }
}
