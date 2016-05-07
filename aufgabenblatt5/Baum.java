package aufgabenblatt5;

public class Baum {

	private Knoten wurzel;
	private int summe = 0;

	public void einfuegen(int wert) {
		if(wert < 0) throw new IllegalArgumentException("Nur positive Zahlen erlaubt");
		wurzel = einfuegenR(wurzel, wert);
	}

	private Knoten einfuegenR(Knoten hilfKnoten, int wert) {
		if (hilfKnoten == null) {
			return new Knoten(wert, null, null);
		} else if (wert == hilfKnoten.getWert()) {
			return hilfKnoten;
		} else if (wert < hilfKnoten.getWert()) {
			hilfKnoten.setSumLeft(wert);
			hilfKnoten.setLinks(einfuegenR(hilfKnoten.getLinks(), wert));
			return hilfKnoten;
		} else {
			hilfKnoten.setSumRight(wert);
			hilfKnoten.setRechts(einfuegenR(hilfKnoten.getRechts(), wert));
			return hilfKnoten;
		}
	}

	/**
	 * Zuerst wird die Gesammtsumme berechnet und dann wird alles was rechts von
	 * der rechtenSchranke und links von der linkenSchranke steht von der
	 * Gesammtsumme abgezogen. So erhält man die Summe zwischen den Schranken
	 * 
	 * @param ersteSchranke
	 * @param zweiteSchranke
	 * @return
	 */
	public int aufsummieren(int ersteSchranke, int zweiteSchranke) {
		if (wurzel != null) {
			summe = wurzel.getSumLeft() + wurzel.getWert() + wurzel.getSumRight();
		} else {
			summe = 0;
		}
		int linkeSchranke, rechteSchranke;

		// hier wird entschieden welche die linke und welche die rechte Schranke ist
		if (ersteSchranke <= zweiteSchranke) {
			linkeSchranke = ersteSchranke;
			rechteSchranke = zweiteSchranke;
		} else {
			linkeSchranke = zweiteSchranke;
			rechteSchranke = ersteSchranke;
		}
		entferneRechts(rechteSchranke);
		entferneLinks(linkeSchranke);
		return summe;
	}

	/**
	 * Ist der Wert des aktuell betrachtetet Knotens kleine als die linke Schranke
	 * wird sein Wert plus die Summe aller Werte der Kindknoten links von ihm von
	 * der Gesammtssumme abgezogen und man geht in den rechten Kindknoten. Ist der Wert genau die linke Schranke wird nur
	 * die Summe aller Werte der Kindknoten links von ihm von der Gesammtssumme
	 * abgezogen.
	 * 
	 * @param linkeSchranke
	 */
	private void entferneLinks(int linkeSchranke) {
		Knoten hilfKnoten = wurzel;
		while (hilfKnoten != null && hilfKnoten.getWert() != linkeSchranke) {
			if (linkeSchranke < hilfKnoten.getWert()) {
				hilfKnoten = hilfKnoten.getLinks();
			} else {
				summe -= hilfKnoten.getSumLeft() + hilfKnoten.getWert();
				hilfKnoten = hilfKnoten.getRechts();
			}
		}
		if (hilfKnoten != null && hilfKnoten.getWert() == linkeSchranke)
			summe -= hilfKnoten.getSumLeft();
	}

	/**
	 * Ist der Wert des aktuell betrachtetet Knotens groesse als die rechte Schranke
	 * wird sein Wert plus die Summe aller Werte der Kindknoten rechts von ihm von
	 * der Gesammtssumme abgezogen und man geht in den linken Kindknoten. Ist der Wert genau die rechte Schranke wird nur
	 * die Summe aller Werte der Kindknoten rechts von ihm von der Gesammtssumme
	 * abgezogen.
	 * 
	 * @param rechteSchranke
	 */
	private void entferneRechts(int rechteSchranke) {
		Knoten hilfKnoten = wurzel;
		while (hilfKnoten != null && hilfKnoten.getWert() != rechteSchranke) {
			if (rechteSchranke < hilfKnoten.getWert()) {
				summe -= hilfKnoten.getSumRight() + hilfKnoten.getWert();
				hilfKnoten = hilfKnoten.getLinks();
			} else {
				hilfKnoten = hilfKnoten.getRechts();
			}
		}
		if (hilfKnoten != null && hilfKnoten.getWert() == rechteSchranke)
			summe -= hilfKnoten.getSumRight();
	}

}
