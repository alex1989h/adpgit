package aufgabenblatt1;

public class ListeB<T> implements IListe<T> {

  private Object[] liste = new Object[10];

  private int size = 0;

  private ElementB elementB = new ElementB();

  private ElementB stop = new ElementB();

  @Override
  public void insert(int index, T element) {

    if (index == 0 && size == 0) {

      elementB.einfuegen(index, element);
      liste[index] = elementB;
      size++;
      liste[size] = stop;

    } else if (index >= 0 && index <= size) {

      ElementB helpElementB = (ElementB) liste[size - 1];
      ElementB NeuElementB = new ElementB();

      if (helpElementB.getNexIndex() == index) {
        NeuElementB.einfuegen(index, element);
        liste[index] = NeuElementB;
        size++;
        liste[size] = stop;
      } else {

        while (helpElementB.getPrevIndex() >= index) {
          helpElementB = (ElementB) liste[helpElementB.getPrevIndex()];
          ((ElementB) liste[helpElementB.getNexIndex()])
              .setIndex(helpElementB.getNexIndex() + 1);
          liste[helpElementB.getNexIndex() + 1] = liste[helpElementB
              .getNexIndex()];
        }
        liste[helpElementB.getNexIndex()] = helpElementB;
        helpElementB.setIndex(index + 1);
        NeuElementB.einfuegen(index, element);
        liste[helpElementB.getPrevIndex()] = NeuElementB;
        size++;
        liste[size] = stop;
      }
    } else {
      throw new NullPointerException();
    }
  }

  @Override
  public void delete(int index) {
    if ((index == 0 && size == 1) || index == size - 1) {
      size--;
      liste[size] = stop;
    } else if (index >= 0 && index < size) {
      ElementB helpElementB = (ElementB) liste[index];

      while (helpElementB.getNexIndex() < size) {

        helpElementB.setIndex(helpElementB.getPrevIndex());
        helpElementB = (ElementB) liste[helpElementB.getNexIndex() + 1];
        liste[helpElementB.getPrevIndex()] = helpElementB;
      }
      liste[helpElementB.getPrevIndex()] = helpElementB;
      helpElementB.setIndex(helpElementB.getPrevIndex());
      size--;
      liste[size] = stop;
    } else {
      throw new NullPointerException();
    }

  }

  @Override
  public int find(T element) {
    if (size == 0) {
      return -1;
    }

    ElementB helpElementB = (ElementB) liste[0];

    while (!liste[helpElementB.getNexIndex()].equals(stop)) {
      if (helpElementB.getElement().equals(element)) {
        return helpElementB.getNexIndex() - 1;
      }
      helpElementB = (ElementB) liste[helpElementB.getNexIndex()];
    }

    if (helpElementB.getElement().equals(element)) {
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
