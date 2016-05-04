package aufgabenblatt5;

public class Knoten {
  int sum=0;
  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum += sum;
  }
  int wert;
  Knoten links;
  Knoten rechts;
  
  Knoten(int wert,Knoten links,Knoten rechts,int sum){
    this.wert = wert;
    this.links=links;
    this.rechts=rechts;
    this.sum+=sum;
  }
  
  public Knoten getLinks() {
    return links;
  }
  public void setLinks(Knoten links) {
    this.links = links;
  }
  public Knoten getRechts() {
    return rechts;
  }
  public void setRechts(Knoten rechts) {
    this.rechts = rechts;
  }
  public int getWert() {
    return wert;
  } 
}
