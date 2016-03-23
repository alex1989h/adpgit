package aufgabenblatt1;

public interface IListe<T> {
  
  void insert(int index, T element);

  void delete(int index);

  int find(T element);

  Object retrieve(int index);

  void concat(IListe<T> otherListe);

  int size();
}
