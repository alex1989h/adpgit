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
  int[] hilfsArray;
  
  public void sort(int[] array,int l, int r) {
      zaehlerR++;
      int q = (l + r) / 2;
      if (l < q)sort(array,l, q);
      if (q+1 < r)sort(array,q + 1, r);
      merge(array,l, q, r);
  }

  private void merge(int[] array,int l, int q, int r) {
    
    hilfsArray = new int[array.length];
    int i, j,k;
    for (i = l; i <= r; i++) {
      hilfsArray[i] = array[i];
    }
    for (j = q + 1; j <= r; j++) {
      hilfsArray[r + q + 1 - j] = array[j];
    }
    i = l;
    j = r;
    k = l;
    while(i<j){
      if(hilfsArray[i]<=hilfsArray[j]){
        array[k]=hilfsArray[i];
        i++;
      }else {
        array[k]=hilfsArray[j];
        j--;
      }
    }
  }
}
