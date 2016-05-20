package aufgabenblatt6;

public class Knoten {
	
	/**
	 * Summe der Häufigkeit
	 */
	private int counter = 0;
	
	public int getCounter() {
    return counter;
  }

  public void count() {
		this.counter++;
	}
	
	private char zeichen;
	private Knoten links;
	private Knoten rechts;

	public Knoten(char zeichen, Knoten links, Knoten rechts) {
		this.zeichen = zeichen;
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

	public int getZeichen() {
		return zeichen;
	}
}
