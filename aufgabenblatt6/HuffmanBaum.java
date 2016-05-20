package aufgabenblatt6;

public class HuffmanBaum {
  int[] array = new int[256];
  Knoten[] knoten;
  public void zaehleHaefigkeit(String string){
    for (int i = 0; i < string.length(); i++) {
        array[string.charAt(i)]++;
    }
    
  }
  
 public void print(){
   for (int i = 0; i < array.length; i++) {
     if(array[i]>0)System.out.println((char)i+" = "+array[i]);
  }
 }
}
