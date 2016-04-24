package aufgabenblatt4;

public class Mergesort {

  private int zaehlerR = 0;

  public int getZaehlerR() {
    return zaehlerR;
  }

  private int zaehlerV = 0;

  public int getZaehlerV() {
    return zaehlerV;
  }
  
  int[] hilfsArray = null;
  
  public void sort(int[] array){
    if(array != null && array.length > 1){
      hilfsArray = new int[array.length];
      int links = 0;
      int rechts = array.length - 1;
      sortR(array,links,rechts);
    }
  }
  
  private void sortR(int[] array, int links, int rechts) {
    zaehlerR++;
    int mitte = (links + rechts) / 2;
    if (links < mitte)sortR(array, links, mitte);
    if (mitte + 1 < rechts)sortR(array, mitte + 1, rechts);
    if (links < rechts) merge(array, links, mitte, rechts);
  }

  private void merge(int[] array, int links, int mitte, int rechts) {
    int i, j;
    for (i = links; i <= mitte; i++) {
      hilfsArray[i] = array[i];
    }
    for (j = mitte + 1; j <= rechts; j++) {
      hilfsArray[rechts + mitte + 1 - j] = array[j];
    }
    i = links;
    j = rechts;

    for (int k = links; k <= rechts; k++) {
      zaehlerV++;
      if (hilfsArray[i] <= hilfsArray[j]) {
        array[k] = hilfsArray[i];
        i++;
      } else {
        array[k] = hilfsArray[j];
        j--;
      }
    }
  }
}
