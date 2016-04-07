package aufgabenblatt1;

public class ElementB {

  private Object element;

  private int nexIndex;

  private int prevIndex;

  public void einfuegen(int index, Object element) {
    this.element = element;
    nexIndex = index + 1;
    prevIndex = index - 1;
  }

  public Object getElement() {
    return element;
  }

  public int getNexIndex() {
    return nexIndex;
  }

  public int getPrevIndex() {
    return prevIndex;
  }
}
