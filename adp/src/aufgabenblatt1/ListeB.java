package aufgabenblatt1;

/**
 *
 * ListeB
 *
 * Eine Klasse zu Realisierung einer Liste anhand eines Arrays und in das Array
 * abgespecherten Elementen (Hilfsklassen) die jeweils auf den vorherigen Index
 * und naechsten Index zeigen (zwei einfache abgespeicherte Integers in der
 * Hilfsklasse)
 *
 * Praktikum AD, SS 2016
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de), 
 * 		   Alexander Hoffmann (Alexander.Hoffman@haw-hamburg.de)
 *
 *         Aufgabe: Aufgabenblatt 1, Aufgabe 2b)
 *
 * @param <T>
 *
 */
public class ListeB<T> implements IListe<T> {

	/**
	 * Array zum Abspeichern von ElementB (Hilfsklasse)
	 */
	private Object[] liste = new Object[10];

	/**
	 * Groesse des Arrays
	 */
	private int size = 0;

	/**
	 * Unser Stop-Element fuer die Abbrueche in den Schleifen
	 */
	private ElementB element = new ElementB();

	@Override
	public void insert(int index, T newElement) {
		if (index >= 0 && index <= size) {
			liste[size] = element;
			ElementB help1 = new ElementB();
			ElementB help2 = (ElementB) liste[index];
			help1.einfuegen(index, newElement);
			liste[index] = help1;
			while (!help2.equals(element)) {
				help1 = help2;
				help2 = (ElementB) liste[help1.getNexIndex()];
				liste[help1.getNexIndex()] = help1;
				help1.einfuegen(help1.getNexIndex(), help1.getElement());
			}
			size++;
			// Verdoppelt das Array
			if (size == liste.length) {
				Object[] helpListe = new Object[liste.length * 2];
				for (int i = 0; i < liste.length; i++) {
					helpListe[i] = liste[i];
				}
				liste = helpListe;
			}
			// Stoppelement einfuegen
			liste[size] = element;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void delete(int index) {
		if (index >= 0 && index < size) {
			ElementB help = (ElementB) liste[index + 1];
			while (!help.equals(element)) {
				liste[help.getPrevIndex()] = help;
				help.einfuegen(help.getPrevIndex(), help.getElement());
				help = (ElementB) liste[help.getNexIndex() + 1];
			}
			size--;
			liste[size] = element;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int find(T newElement) {
		if (size > 0) {
			ElementB help = (ElementB) liste[0];
			while (!help.equals(element)) {
				if (help.getElement().equals(newElement)) {
					return help.getNexIndex() - 1;
				}
				help = (ElementB) liste[help.getNexIndex()];
			}
		}
		return -1;
	}

	@Override
	public Object retrieve(int index) {
		if (index >= 0 && index < size) {
			return ((ElementB) liste[index]).getElement();
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
