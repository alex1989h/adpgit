package aufgabenblatt4;

public class MergesortB extends Thread{
  static int flop=0;
  MergesortB m1;
  MergesortB m2;
  
  int linksB;
  int rechtsB;
  int[] arrayB;
  int[] hilfsArray;
  
  private void set(int[]array,int links,int rechts){
    arrayB=array;
    linksB=links;
    rechtsB=rechts;
    hilfsArray = new int[array.length];
  }
  
  MergesortB() {
    if(flop==0){
      flop++;
      m1 = new MergesortB();
      m2 = new MergesortB();
    }
  }
  
  @Override
  public void run() {
    sortR(arrayB,linksB,rechtsB);
  }
  
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
  
  private void sortB(int[] array, int links, int rechts) {
    int i = links;
    int j = rechts;
    int p = array[(links+rechts)/2];
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
 
    m1.set(array, links, j);
    m2.set(array, i, rechts);
    
    if (links < j)m1.start();
    if (i < rechts)m2.start();
    try {
      m1.join();
    m2.join();
    } catch (Exception e) {
      // TODO: handle exception
    }
    
}
  
  public void sort(int[] array){
    if(array != null && array.length > 1){
      hilfsArray = new int[array.length];
      int links = 0;
      int rechts = array.length - 1;
      sortB(array,links,rechts);
    }
  }
  
  private void sortR(int[] array, int links, int rechts) {
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
