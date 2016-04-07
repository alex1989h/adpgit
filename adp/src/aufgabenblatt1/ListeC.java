package aufgabenblatt1;

public class ListeC<T> implements IListe<T> {
  private int size = 0;
  private ElementC element;

  @Override
  public void insert(int index, T element) {
    ElementC hilfElement = this.element;
    if (index >= 0 && index <= size) {
      if(hilfElement == null){
        this.element = new ElementC();
        this.element.einfuegen(element);
      }else{
        //while(hilfElement.getNextElement()!=)
        
      }
    }

  }

  @Override
  public void delete(int index) {
    // TODO Auto-generated method stub

  }

  @Override
  public int find(T element) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Object retrieve(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void concat(IListe<T> otherListe) {
    // TODO Auto-generated method stub

  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return 0;
  }

}
