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
 *         Aufgabe: Aufgabenblatt 1, Aufgabe 2c)
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
	 * Zum anhaengen der Elemente, selbst aber kein Element der Liste
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
	  if(element==null)throw new IndexOutOfBoundsException();
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

	@Override
	public void concat(IListe<T> otherListe) {
    ElementC hilfElement = this.element.getNextElement();
		if (otherListe != null) {
			while (hilfElement.getNextElement()!=null) {
			  hilfElement = hilfElement.getNextElement();
			}
			hilfElement.setNextElement(((ListeC<T>) otherListe).getElement());
			size+= otherListe.size();
		}
	}
	
	public ElementC getElement(){
    return element.getNextElement();
  }

	@Override
	public int size() {
		return size;
	}

}
