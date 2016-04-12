package aufgabenblatt1;

/**
 * Interface fuer Listen
 * 
 * @param <T>
 */
public interface IListe<T> {

  /**
   * Ein Object wird mindestens an die Stelle mit dem Index 0 eingefuegt und
   * hoestens an der naechsten freien Stelle ( Ender der Liste) Objecte
   * ueberschreiben einander nicht, die Liste wird einfach groesser
   * 
   * @param index
   *          Stelle an der das Object eingefuegt wird
   * @param element
   *          Object, dass eingefuegt wird
   */
  void insert(int index, T element);

  /**
   * Wird ein Object geloescht ruecken Objecte link und rechts (falls vorhanden)
   * an einander. Liste wird kleiner
   * 
   * @param index
   *          Stelle an der das Object geloescht wird
   */
  void delete(int index);

  /**
   * Wird das erste uebereinstimmende Object gefunden, wird der Index diesen
   * Objects zurueckgegeben ansonsten -1
   * 
   * @param element
   *          Das gesuchte Object
   * @return index des ersten Vorkommens des gesuchten Elements
   */
  int find(T element);

  /**
   * Das Zurueckgeben des Objects an einer bestimmten Stelle
   * 
   * @param index
   *          Stelle in der Liste
   * @return Object an dieser Stelle
   */
  Object retrieve(int index);

  /**
   * Zusammenfuegen von Listen
   * 
   * @param otherListe
   *          Liste, die angehaengt wird
   */
  void concat(IListe<T> otherListe);

  /**
   * Abfrage wie gross die Liste ist
   * 
   * @return groesse der Liste
   */
  int size();
}
