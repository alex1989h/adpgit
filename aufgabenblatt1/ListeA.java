package aufgabenblatt1;

/**
 *
 * ListeA
 *
 * Eine Klasse zu Realisierung einer Liste anhand eines Arrays
 *
 *
 * Praktikum AD, SS 2016
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de), Alexander
 *         Hoffmann (Alexander.Hoffman@haw-hamburg.de)
 *
 *         Aufgabe: Aufgabenblatt 1, Aufgabe 2a)
 *
 * @param <T>
 *
 */
public class ListeA<T> implements IListe<T> {

	/**
	 * Array in dem, die eingefuegten Objekte, abgespeichert werden
	 */
	private Object[] liste = new Object[10];

	/**
	 * Groesse der Liste
	 */
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
			throw new IndexOutOfBoundsException();
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
			throw new IndexOutOfBoundsException();
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
			throw new IndexOutOfBoundsException();
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
