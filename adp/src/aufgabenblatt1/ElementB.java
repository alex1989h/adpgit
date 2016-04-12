package aufgabenblatt1;

/**
 * Hilfsklasse fuer ListeB zur abspechert von Objekten
 */
public class ElementB {

  /**
   * Das abgespeicherter Object
   */
  private Object element;

  /**
   * Hier wird der Index der naechsten Stelle abgespeichert
   */
  private int nexIndex;

  /**
   * Hier wird der Index der vorigen Stelle abgespeichert
   */
  private int prevIndex;

  /**
   * Hier wird ein Object abgespeichert und Indizes gesetzt
   * 
   * @param index
   *          Um prevIndex und nexIndex zu bestimmen
   * @param element
   *          eigentlicher eingefueger Object
   */
  public void einfuegen(int index, Object element) {
    this.element = element;
    nexIndex = index + 1;
    prevIndex = index - 1;
  }

  /**
   * Getter
   * 
   * @return
   */
  public Object getElement() {
    return element;
  }

  /**
   * Getter
   * 
   * @return
   */
  public int getNexIndex() {
    return nexIndex;
  }

  /**
   * Getter
   * 
   * @return
   */
  public int getPrevIndex() {
    return prevIndex;
  }
}
