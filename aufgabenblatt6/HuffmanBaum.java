package aufgabenblatt6;

import java.util.ArrayList;

public class HuffmanBaum {
  Knoten root;
  int[] array = new int[256];
  ArrayList<Knoten> knoten;
  int anzahlKnoten = 0;
  
  public void codiere(String string){
    zaehleHaefigkeit(string);
    baue();
  }
  
  
  public void zaehleHaefigkeit(String string) {
    knoten = new ArrayList<Knoten>();
    for (int i = 0; i < string.length(); i++) {
      if (array[string.charAt(i)] == 0) {
        knoten.add(new Knoten(string.charAt(i),null,null));
        anzahlKnoten++;
      }
      array[string.charAt(i)]++;
    }
    
    for (int i = 0; i < knoten.size(); i++) {
      knoten.get(i).count(array[knoten.get(i).getZeichen()]);
    }
  }
  
  public void print(){
    printR(root,"");
  }
  
  
  public void printR(Knoten hilf,String t) {
    String z=t;
    if(hilf==null){
      
    }else{
      printR(hilf.getLinks(),z+"0");
      printR(hilf.getRechts(),z+"1");
      System.out.println(hilf.getZeichen()+" "+hilf.getCounter()+" "+z);
    }
  }
  
  
  
  public void baue(){
    while(anzahlKnoten>1){
      baueBaum();
    }
  }
  public void baueBaum(){
    Knoten knoten1 = new Knoten(' ',null,null);
    knoten1.setLinks(sucheKleinstenKnoten());
    knoten1.setRechts(sucheKleinstenKnoten());
    knoten1.count(knoten1.getLinks().getCounter()+knoten1.getRechts().getCounter());
    for (int i = 0; i < knoten.size(); i++) {
      if(knoten.get(i)==null){
        knoten.set(i, knoten1);
        root=knoten1;
        anzahlKnoten++;
        break;
      }
    }
    
  }
  
  public Knoten sucheKleinstenKnoten(){
    Knoten hilfsKnoten=null;
    for (int i = 0; i < knoten.size(); i++) {
      if(hilfsKnoten==null){
        hilfsKnoten = knoten.get(i);
      }else if(knoten.get(i)!=null&&knoten.get(i).getCounter()<hilfsKnoten.getCounter()){
        hilfsKnoten=knoten.get(i);
      }
    }
    if(hilfsKnoten!=null){knoten.set(knoten.indexOf(hilfsKnoten), null);
    anzahlKnoten--;
    }
    return hilfsKnoten;
  }
}
