package aufgabenblatt1;

/**
 *
 * IList
 *
 * Eine Klasse die ein Interface darstellt
 *
 *
 * Praktikum AD, SS 2016
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de), Alexander
 *         Hoffmann (Alexander.Hoffman@haw-hamburg.de)
 *
 *         Aufgabe: Aufgabenblatt 1, Aufgabe 2
 *
 * @param <T>
 *
 */
public interface IListe<T> {

	/**
	 * Ein Object wird mindestens an die Stelle mit dem Index 0 eingefuegt und
	 * hoehstens an der naechsten freien Stelle (am Ende der Liste) DieObjecte
	 * ueberschreiben einander nicht, die Liste wird groesser
	 * 
	 * @param index
	 *            Die Stelle an der das Object eingefuegt wird
	 * @param element
	 *            Object das eingefuegt wird
	 */
	void insert(int index, T element);

	/**
	 * Wird ein Object geloescht, ruecken Objecte links und rechts (falls
	 * vorhanden) an einander. Die Liste wird kleiner
	 * 
	 * @param index
	 *            Die Stelle an der das Object geloescht wird
	 */
	void delete(int index);

	/**
	 * Wird das erste uebereinstimmende Object gefunden, dann wird der Index
	 * dieses Objects zurueckgegeben ansonsten -1
	 * 
	 * @param element
	 *            Das gesuchte Object
	 * @return index des ersten Vorkommens des gesuchten Elements
	 */
	int find(T element);

	/**
	 * Das Zurueckgeben des Objects an einer bestimmten Stelle
	 * 
	 * @param index
	 *            Die Stelle in der Liste
	 * @return Object an dieser Stelle
	 */
	Object retrieve(int index);

	/**
	 * Zusammenfuegen von Listen
	 * 
	 * @param otherListe
	 *            Eine Liste die angehaengt wird
	 */
	void concat(IListe<T> otherListe);

	/**
	 * Abfrage der groesse von der Liste
	 * 
	 * @return groesse der Liste
	 */
	int size();
}
