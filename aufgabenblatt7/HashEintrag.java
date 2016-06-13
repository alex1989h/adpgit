package aufgabenblatt7;

public class HashEintrag {
	private HashEintrag next=null;
	private Status status = Status.FREI;
	private long wert=-1;
	private String daten;
	
	/**
	 * Defaul Konstruktor
	 */
	public HashEintrag(){
	}
	
	/**
	 * Konstruktor,
	 * @param wert
	 * @param data
	 */
	public HashEintrag(long wert,String daten,Status status){
		this.wert=wert;
		this.daten=daten;
		this.status=status;
	}
	/**
	 * Getter
	 * @return
	 */
	public Status getStatus() {
		return status;
	}
	
	/**
	 * Setter
	 * @param status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	/**
	 * Getter
	 * @return
	 */
	public long getWert() {
		return wert;
	}
	
	/**
	 * Setter
	 * @param wert
	 */
	public void setWert(long wert) {
		this.wert = wert;
	}
	
	/**
	 * Getter
	 * @return
	 */
	public String getDaten() {
		return daten;
	}
	
	/**
	 * Setter
	 * @param daten
	 */
	public void setDaten(String daten) {
		this.daten = daten;
	}
	
	/**
	 * Getter
	 * @return
	 */
	public HashEintrag getNext() {
		return next;
	}
	
/**
 * Setter
 * @param eintrag
 */
	public void setNext(HashEintrag next) {
		this.next = next;
	}
}
