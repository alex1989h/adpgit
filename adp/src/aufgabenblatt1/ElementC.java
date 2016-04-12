package aufgabenblatt1;

/**
 *
 * ElementC
 *
 * Eine Hilfsklasse für die ListeC, zur abspeicherung von Objekten
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
public class ElementC {

	/**
	 * Das abgespeicherte Object
	 */
	private Object element;

	/**
	 * Ein Zeiger auf das naechste Element vom Typ ElementC
	 */
	private ElementC nextElement;

	/**
	 * Ein Object wird eingefuegt
	 * 
	 * @param element
	 *            Typ: Object
	 */
	public void einfuegen(Object element) {
		this.element = element;
	}

	/**
	 * Getter
	 * 
	 * @return Typ: Object
	 */
	public Object getElement() {
		return element;
	}

	/**
	 * Getter
	 * 
	 * @return Typ: ElementC
	 */
	public ElementC getNextElement() {
		return nextElement;
	}

	/**
	 * Setter
	 * 
	 * @param nextElement
	 *            Typ: ElementC
	 */
	public void setNextElement(ElementC nextElement) {
		this.nextElement = nextElement;
	}
}
