package aufgabenblatt4;

public class Mergesort {
  
  private int zaehlerR=0;
  public int getZaehlerR() {
    return zaehlerR;
  }
  private int zaehlerV=0;
  public int getZaehlerV() {
    return zaehlerV;
  }

  
  public void sort(int[] array,int l, int r) {
      zaehlerR++;
      int q = (l + r) / 2;
      if (l < q)sort(array,l, q);
      if (q+1 < r)sort(array,q + 1, r);
      merge(array,l, q, r);
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
        zaehlerV++;
        array[k] = hilfsArray[i];
        i++;
      } else {
        array[k] = hilfsArray[j];
        j--;
        zaehlerV++;
      }
    }
  }
}
