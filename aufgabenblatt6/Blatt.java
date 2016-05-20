package aufgabenblatt6;

public class Blatt implements INode {

	/**
	 * Summe der Häufigkeit
	 */
	private int counter = 0;

	/**
	 * Zeichen das abgespeichert wird
	 */
	private char zeichen;

	/**
	 * Konstruktor
	 * 
	 * @param zeichen
	 */
	public Blatt(char zeichen) {
		this.zeichen = zeichen;
	}

	/**
	 * Getter
	 * 
	 * @return Abgespeicherter Zeichen
	 */
	public char getZeichen() {
		return zeichen;
	}

	@Override
	public int getCounter() {
		return counter;
	}

	@Override
	public void setCounter(int counter) {
		this.counter = counter;

	}

}
