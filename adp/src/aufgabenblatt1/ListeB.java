package aufgabenblatt1;

public class ListeB<T> implements IListe<T> {

  private Object[] liste = new Object[10];

  private int size = 0;

  private ElementB element = new ElementB();

  @Override
  public void insert(int index, T newElement) {
    if (index >= 0 && index <= size) {
      liste[size] = element;
      ElementB help1 = new ElementB();
      ElementB help2 = (ElementB) liste[index];
      help1.einfuegen(index, newElement);
      liste[index] = help1;
      while (!help2.equals(element)) {
        help1 = help2;
        help2 = (ElementB) liste[help1.getNexIndex()];
        liste[help1.getNexIndex()] = help1;
        help1.einfuegen(help1.getNexIndex(), help1.getElement());
      }
      size++;
      // Verdoppelt das Array
      if (size == liste.length) {
        Object[] helpListe = new Object[liste.length * 2];
        for (int i = 0; i < liste.length; i++) {
          helpListe[i] = liste[i];
        }
        liste = helpListe;
      }
      // Stoppelement einfuegen
      liste[size] = element;
    } else {
      throw new NullPointerException();
    }
  }

  @Override
  public void delete(int index) {
    if ((index == 0 && size == 1) || index == size - 1) {
      size--;
      liste[size] = element;
    } else if (index >= 0 && index < size) {
      ElementB helpElementB = (ElementB) liste[index];

      while (helpElementB.getNexIndex() < size) {
        helpElementB.einfuegen(helpElementB.getPrevIndex(),
            helpElementB.getElement());
        helpElementB = (ElementB) liste[helpElementB.getNexIndex() + 1];
        liste[helpElementB.getPrevIndex()] = helpElementB;
      }
      liste[helpElementB.getPrevIndex()] = helpElementB;
      helpElementB.einfuegen(helpElementB.getPrevIndex(),
          helpElementB.getElement());
      size--;
      liste[size] = element;
    } else {
      throw new NullPointerException();
    }

  }

  @Override
  public int find(T newElement) {
    if (size == 0) {
      return -1;
    }

    ElementB helpElementB = (ElementB) liste[0];

    while (!liste[helpElementB.getNexIndex()].equals(element)) {
      if (helpElementB.getElement().equals(newElement)) {
        return helpElementB.getNexIndex() - 1;
      }
      helpElementB = (ElementB) liste[helpElementB.getNexIndex()];
    }

    if (helpElementB.getElement().equals(newElement)) {
      return helpElementB.getNexIndex() - 1;
    }

    return -1;
  }

  @Override
  public Object retrieve(int index) {
    if (index >= 0 && index < size) {
      return ((ElementB) liste[index]).getElement();
    } else {
      throw new NullPointerException();
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public void concat(IListe<T> otherListe) {
    Object[] newListe = liste;

    if (otherListe != null && otherListe.size() > 0) {
      liste = new Object[size + otherListe.size() + 1];

      for (int i = 0; i < size; i++) {
        liste[i] = newListe[i];
      }
      int helpSize = size;
      for (int i = 0; i < otherListe.size(); i++) {

        insert(i + helpSize, (T) otherListe.retrieve(i));
      }
    }
  }

  @Override
  public int size() {
    return size;
  }
}
