package aufgabenblatt6;

public class Knoten implements INode {

	/**
	 * Summe der Häufigkeit
	 */
	private int counter = 0;

	@Override
	public int getCounter() {
		return counter;
	}

	@Override
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	private INode links;
	private INode rechts;

	public Knoten(Knoten links, Knoten rechts) {
		this.links = links;
		this.rechts = rechts;
	}

	public INode getLinks() {
		return links;
	}

	public void setLinks(INode links) {
		if(links!=null){
			this.links = links;
			counter+=links.getCounter();
		}
	}

	public INode getRechts() {
		return rechts;
	}

	public void setRechts(INode rechts) {
		if(rechts!=null){
			this.rechts = rechts;
			counter+=rechts.getCounter();
		}
	}
}
