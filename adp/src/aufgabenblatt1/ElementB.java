package aufgabenblatt1;

/**
 *
 * ElementB
 *
 * Eine Hilfsklasse für die ListeB, zur abspeicherung von Objekten
 *
 *
 * Praktikum AD, SS 2016
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de), Alexander
 *         Hoffmann (Alexander.Hoffman@haw-hamburg.de)
 *
 *         Aufgabe: Aufgabenblatt 1, Aufgabe 2
 *
 */
public class ElementB {

	/**
	 * Das abgespeicherte Object
	 */
	private Object element;

	/**
	 * Hier wird der Index der naechsten Stelle abgespeichert
	 */
	private int nexIndex;

	/**
	 * Hier wird der Index der vorherigen Stelle abgespeichert
	 */
	private int prevIndex;

	/**
	 * Hier wird ein Object abgespeichert und Indizes gesetzt
	 * 
	 * @param index
	 *            Um prevIndex und nexIndex zu bestimmen
	 * @param element
	 *            eingefügtes Object
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
