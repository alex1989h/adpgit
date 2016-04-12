package aufgabenblatt1;

/**
 *
 * ListeC
 *
 * Eine Klasse zu Realisierung einer Liste anhand eines einfach verketteten
 * ElementC
 *
 *
 * Praktikum AD, SS 2016
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 *  	   Alexander Hoffmann (Alexander.Hoffman@haw-hamburg.de)
 *
 *         Aufgabe: Aufgabenblatt 1, Aufgabe 2a)
 *
 * @param <T>
 *
 */
public class ListeC<T> implements IListe<T> {

	/**
	 * hier wird die groesse der Liste abgespeichert
	 */
	private int size = 0;

	/**
	 * Zum anhängen der Elemente, selbst aber kein Element der Liste
	 */
	private ElementC element = new ElementC();

	@Override
	public void insert(int index, T element) {
		if (index >= 0 && index <= size) {
			ElementC hilfElement = this.element;
			ElementC newElement = new ElementC();
			newElement.einfuegen(element);
			for (int i = 0; i < index; i++) {
				hilfElement = hilfElement.getNextElement();
			}
			newElement.setNextElement(hilfElement.getNextElement());
			hilfElement.setNextElement(newElement);
			size++;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void delete(int index) {
		if (index >= 0 && index < size) {
			ElementC hilfElement = this.element;
			for (int i = 0; i < index; i++) {
				hilfElement = hilfElement.getNextElement();
			}
			hilfElement.setNextElement(hilfElement.getNextElement()
					.getNextElement());
			size--;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int find(T element) {
		if (size > 0) {
			int index = 0;
			ElementC hilfElement = this.element.getNextElement();
			while (hilfElement != null) {
				if (hilfElement.getElement().equals(element)) {
					return index;
				}
				hilfElement = hilfElement.getNextElement();
				index++;
			}
		}
		return -1;
	}

	@Override
	public Object retrieve(int index) {
		if (index >= 0 && index < size) {
			ElementC hilfElement = this.element;
			for (int i = 0; i <= index; i++) {
				hilfElement = hilfElement.getNextElement();
			}
			return hilfElement.getElement();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void concat(IListe<T> otherListe) {
		if (otherListe != null) {
			while (otherListe.size() > 0) {
				insert(size, (T) otherListe.retrieve(0));
				otherListe.delete(0);
			}
		}
	}

	@Override
	public int size() {
		return size;
	}

}
