package aufgabenblatt5;

public class Knoten {
	
	/**
	 * Summe aller Werte der Kindknoten linkss
	 */
	private int sumLeft = 0;

	public int getSumLeft() {
		return sumLeft;
	}

	public void setSumLeft(int sumRight) {
		this.sumLeft += sumRight;
	}

	/**
	 * Summe aller Werte der Kindknoten rechts
	 */
	private int sumRight = 0;

	public int getSumRight() {
		return sumRight;
	}

	public void setSumRight(int sumRight) {
		this.sumRight += sumRight;
	}

	private int wert;
	private Knoten links;
	private Knoten rechts;

	public Knoten(int wert, Knoten links, Knoten rechts) {
		this.wert = wert;
		this.links = links;
		this.rechts = rechts;
	}

	public Knoten getLinks() {
		return links;
	}

	public void setLinks(Knoten links) {
		this.links = links;
	}

	public Knoten getRechts() {
		return rechts;
	}

	public void setRechts(Knoten rechts) {
		this.rechts = rechts;
	}

	public int getWert() {
		return wert;
	}
}
