package aufgabenblatt1;

/**
 * Hilfsklasse fuer ListeC zur abspechert von Objekten
 */
public class ElementC {

  /**
   * Das abgespeicherter Object
   */
  private Object element;

  /**
   * Ein Zeiger auf das naechste Element vom Typ ElementC
   */
  private ElementC nextElement;

  /**
   * Ein Object wird eingefuegt
   * 
   * @param element
   *          Typ: Object
   */
  public void einfuegen(Object element) {
    this.element = element;
  }

  /**
   * Getter
   * 
   * @return Typ: Object
   */
  public Object getElement() {
    return element;
  }

  /**
   * Getter
   * 
   * @return Typ: ElementC
   */
  public ElementC getNextElement() {
    return nextElement;
  }

  /**
   * Setter
   * 
   * @param nextElement
   *          Typ: ElementC
   */
  public void setNextElement(ElementC nextElement) {
    this.nextElement = nextElement;
  }
}
