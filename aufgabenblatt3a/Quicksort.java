package aufgabenblatt3a;

public class Quicksort {
  
  private int zaehlerR=0;
  public int getZaehlerR() {
    return zaehlerR;
  }
  private int zaehlerV=0;
  public int getZaehlerV() {
    return zaehlerV;
  }
  
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public void sort(int[] array, int links, int rechts) {
      zaehlerR++;
      int i = links;
      int j = rechts;
      int p = array[(links+rechts)/2];
      while (i <= j) {
        
        while (array[i] < p) {
          zaehlerV++;
          i++;
        }
        while (array[j] > p) {
          zaehlerV++;
          j--;
        }
        if (i <= j) {
          zaehlerV++;
          swap(array, i, j);
          i++;
          j--;
        }
      }
      if (links < j)sort(array, links, j);
      if (i < rechts)sort(array, i, rechts);
  }

  public void sortRandom(int[] array, int links, int rechts) {
    if (links < rechts) {
      int i = links;
      int j = rechts;
      int p = array[(int) (Math.random() * (rechts - links)) + links];
      while (i <= j) {
        while (array[i] < p) {
          i++;
        }
        while (array[j] > p) {
          j--;
        }
        if (i <= j) {
          swap(array, i, j);
          i++;
          j--;
        }
      }
      sort(array, links, j);
      sort(array, i, rechts);
    }
  }

  public void sortMedian(int[] array, int links, int rechts) {
    if (links < rechts) {
      int i = links;
      int j = rechts;
      int p = findMedian(array[links], array[(rechts + links) / 2],
          array[rechts]);
      while (i <= j) {
        while (array[i] < p) {
          i++;
        }
        while (array[j] > p) {
          j--;
        }
        if (i <= j) {
          swap(array, i, j);
          i++;
          j--;
        }
      }
      sort(array, links, j);
      sort(array, i, rechts);
    }
  }

  private int findMedian(int l, int m, int r) {
    if ((m < l && l < r) || (r < l && l < m))
      return l;
    if ((l < r && r < m) || (m < r && r < l))
      return r;
    return m;
  }
}
