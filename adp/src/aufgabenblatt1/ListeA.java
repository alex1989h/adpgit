package aufgabenblatt1;

public class ListeA<T> implements IListe<T> {

  private Object[] liste = new Object[10];

  private int size = 0;

  @Override
  public void insert(int index, T element) {

    if (index >= 0 && index <= size) {
      Object[] newListe = new Object[liste.length];

      for (int i = 0; i < index; i++) {
        newListe[i] = liste[i];
      }
      newListe[index] = element;
      for (int i = index; i < size; i++) {
        newListe[i + 1] = liste[i];
      }
      liste = newListe;
      size++;
    } else {
      throw new NullPointerException();
    }

    if (size == liste.length) {
      Object[] helpListe = new Object[liste.length * 2];
      for (int i = 0; i < liste.length; i++) {
        helpListe[i] = liste[i];
      }
      liste = helpListe;
    }
  }

  @Override
  public void delete(int index) {
    if (index >= 0 && index < size) {
      Object[] newListe = new Object[liste.length];

      for (int i = 0; i < index; i++) {
        newListe[i] = liste[i];
      }
      for (int i = index + 1; i < size; i++) {
        newListe[i - 1] = liste[i];
      }
      liste = newListe;
      size--;
    } else {
      throw new NullPointerException();
    }
  }

  @Override
  public int find(T element) {
    for (int i = 0; i < size; i++) {
      if (liste[i].equals(element)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public Object retrieve(int index) {
    if (index >= 0 && index < size) {
      return liste[index];
    } else {
      throw new NullPointerException();
    }
  }

  @Override
  public void concat(IListe<T> otherListe) {
    if (otherListe != null && otherListe.size() > 0) {
      Object[] newListe = new Object[size + otherListe.size() + 1];
      for (int i = 0; i < size; i++) {
        newListe[i] = liste[i];
      }
      for (int i = 0; i < otherListe.size(); i++) {
        newListe[i + size] = otherListe.retrieve(i);
      }
      liste = newListe;
      size = size + otherListe.size();
    }
  }

  @Override
  public int size() {
    return size;
  }

}
