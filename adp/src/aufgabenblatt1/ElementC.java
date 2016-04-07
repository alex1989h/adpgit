package aufgabenblatt1;

public class ElementC {
  private Object element;
  private ElementC nextElement;
  
  public void einfuegen(Object element){
    this.element = element;
  }
  
  public Object getElement() {
    return element;
  }
  
  public ElementC getNextElement(){
    return nextElement;
  }
  
  public void setNextElement(ElementC nextElement){
    this.nextElement = nextElement;
  }
}
