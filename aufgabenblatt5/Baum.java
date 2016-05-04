package aufgabenblatt5;

public class Baum {
  Knoten wurzel;
  int summe=0;
  void einfuegen(int wert){
    wurzel=einfuegenR(wurzel, wert,0);
  }
  
  private Knoten einfuegenR(Knoten hilfKnoten,int wert,int sum){
    if (hilfKnoten==null) {
      return new Knoten(wert,null,null,wert+sum);
    } else if (wert==hilfKnoten.getWert()) {
      return hilfKnoten;
    } else if (wert<hilfKnoten.getWert()){
      hilfKnoten.setSum(wert);
      hilfKnoten.setLinks(einfuegenR(hilfKnoten.getLinks(), wert,sum));
      return hilfKnoten;
    } else{
      hilfKnoten.setRechts(einfuegenR(hilfKnoten.getRechts(), wert,hilfKnoten.getSum()));
      return hilfKnoten;
    } 
  }
  int linkeSchranke;
  int rechteSchranke;
  
  int aufsummieren(int linkeSchranke,int rechteSchranke){
    return sucheRechts(rechteSchranke)-sucheLinks(linkeSchranke);
  }
  
  int sucheLinks(int key){
    Knoten hilfKnoten=wurzel;
    Knoten temp=null;
    while (hilfKnoten!=null&&hilfKnoten.getWert()!=key) {
      if(key<hilfKnoten.getWert()){
        temp=hilfKnoten;
        hilfKnoten=hilfKnoten.getLinks();
      }else {
        hilfKnoten=hilfKnoten.getRechts();
      }
    }
    if(hilfKnoten==null){
      return temp.getSum()-temp.getWert();
    }else{
      return hilfKnoten.getSum()-hilfKnoten.getWert();
    }
  }
  
  int sucheRechts(int key){
    Knoten hilfKnoten=wurzel;
    Knoten temp=null;
    while (hilfKnoten!=null&&hilfKnoten.getWert()!=key) {
      if(key<hilfKnoten.getWert()){
        hilfKnoten=hilfKnoten.getLinks();
      }else {
        temp=hilfKnoten;
        hilfKnoten=hilfKnoten.getRechts();
      }
    }
    if(hilfKnoten==null){
      return temp.getSum();
    }else{
      return hilfKnoten.getSum();
    }
  }
}
