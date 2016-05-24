package aufgabenblatt6;

import java.util.ArrayList;

public class HuffmanBaum {

	/**
	 * Anzahl der moeglichen Kombinationen aus 8 Bit
	 */
	private final int ANZAHL_16BIT_KOMBI = 65536;

	/**
	 * Wurzelknoten
	 */
	private INode root;

	/**
	 * Hier wird die Haeufigkeit jedes Zeichens abgespeichert Das Zeichen selbst
	 * dient als Index Jedes Zeichen ist 8 Bit gross also muss das Array 2 hoch 8
	 * = 256 gross sein
	 */
	private int[] array;

	/**
	 * Dient zur Abspeicherung von Knoten und Blaettern
	 */
	private ArrayList<INode> knotenList;

	/**
	 * Anzahl der Knoten und Blaettern im knotenList siehe oben
	 */
	private int anzahlKnoten = 0;

	/**
	 * Konstruktor
	 */
	public HuffmanBaum() {

	}
	int anzahlBits=0;
	public String codiere(String string) {
		array = new int[ANZAHL_16BIT_KOMBI];
		initialisiere(string);
		baueBaum();
		for (int i = 0; i < string.length(); i++) {
			gefunden=false;
			codiereR(root, temp, temZaehler, string.charAt(i));
			if(charBereit){
				codeWort+=tempCode;
				charBereit=false;
				charNichtBereit=true;
			}else{
				charNichtBereit=false;
			}
		}
		anzahlBits=temZaehler;
		while(temZaehler%16!=0){
			temZaehler++;
			temp<<=1;
		}
		codeWort+=temp;
		String returnString=codeWort;
		codeWort="";
		temZaehler=0;
		charNichtBereit=true;
		array=null;
		return returnString;
	}
	
	/**
	 * 
	 * @param string Codierter Text
	 * @return dekodierter text;
	 */
	public String necode(String string){
		
		return "";
	}
	
	
	
	
	private void initialisiere(String string) {
		knotenList = new ArrayList<INode>();
		root = null;
		Blatt blatt;
		anzahlKnoten = 0;
		char zeichen;
		for (int i = 0; i < string.length(); i++) {
			zeichen = string.charAt(i);

			/*
			 * Wenn ein neuer Zeichen gefunden wurde soll ein neues Blatt erzeugt
			 * werden. Also hier wenn das gefundene Zeichen 0 Mal vorkommt
			 */
			if (array[zeichen] == 0) {
				knotenList.add(new Blatt(zeichen));
				anzahlKnoten++;
			}
			array[zeichen]++;
		}

		for (int i = 0; i < knotenList.size(); i++) {
			blatt = (Blatt) knotenList.get(i);
			blatt.setCounter(array[blatt.getZeichen()]);
			array[blatt.getZeichen()] = 0;
		}
	}

	/**
	 * Gibt auf der Konsole das Zeichen seine Haeufigkeit und Huffman Codierung
	 * aus
	 */
	public void print() {
		System.out.println("Zeichen	H�ufigkeit	Code");
		printR(root, "");
	}

	/**
	 * siehe public void print()
	 * 
	 * @param node
	 *          Der gerade betrachteter Knoten oder Blatt
	 * @param code
	 *          Huffman Codierung als string von 0 und 1sen
	 */
	private void printR(INode node, String code) {
		if (node instanceof Blatt) {
			Blatt b = (Blatt) node;
			System.out.println(b.getZeichen() + "	" + b.getCounter() + "		" + code);
		} else if (node instanceof Knoten) {
			Knoten k = (Knoten) node;
			printR(k.getLinks(), code + "0");
			printR(k.getRechts(), code + "1");
		}
	}

	/**
	 * Baut einen Baum auf nach der Huffmann Codierung
	 */
	private void baueBaum() {
		while (anzahlKnoten > 0) {
			erstelleTeilBaeume();
		}
	}
	/**
	 * siehe private void baueBaum
	 */
	private void erstelleTeilBaeume() {
		Knoten knoten1 = new Knoten(null, null);
		knoten1.setLinks(sucheKleinstenKnoten());
		knoten1.setRechts(sucheKleinstenKnoten());

		for (int i = 0; i < knotenList.size(); i++) {
			if (knotenList.get(i) == null) {
				root = knoten1;

				/*
				 * Wenn die Liste leer ist gibt es keine Knoten oder Blaetter mehr um
				 * weiterzubauen also return
				 */
				if (anzahlKnoten == 0) {
					return;
				}
				knotenList.set(i, knoten1);
				anzahlKnoten++;
				break;
			}
		}
	}

	/**
	 * Sucht der Knoten oder Blatt mit der kleisten Haeufigkeit
	 * 
	 * @return Knoten oder Blatt
	 */
	private INode sucheKleinstenKnoten() {
		INode kleinserKnoten = null;
		for (int i = 0; i < knotenList.size(); i++) {
			if (kleinserKnoten == null) {
				kleinserKnoten = knotenList.get(i);
			} else if (knotenList.get(i) != null
					&& knotenList.get(i).getCounter() < kleinserKnoten.getCounter()) {
				kleinserKnoten = knotenList.get(i);
			}
		}
		if (kleinserKnoten != null) {
			knotenList.set(knotenList.indexOf(kleinserKnoten), null);
			anzahlKnoten--;
		}
		return kleinserKnoten;
	}
	int temZaehler = 0;
	String codeWort = "";
	char temp = '\u0000';
	char tempCode;
	boolean gefunden=false;
	boolean charBereit = false;
	boolean charNichtBereit = true;
	/**
	 * 
	 * @param node
	 * @param code
	 */
	private void codiereR(INode node, char code, int zaehler, char zeichen) {
		if (!gefunden) {
			if(zaehler%16==0&&!charNichtBereit){
				tempCode=code;
				charBereit=true;
			}
			if (node instanceof Blatt) {
				Blatt b = (Blatt) node;
				if (b.getZeichen() == zeichen) {
					gefunden=true;
					temp = code;
					temZaehler=zaehler;
				}
			} else if (node instanceof Knoten) {
				Knoten k = (Knoten) node;
				
				codiereR(k.getLinks(), (char) ((code<<1) + 0), zaehler+1, zeichen);
				codiereR(k.getRechts(), (char) ((code<<1)+ 1), zaehler+1, zeichen);
			}
			
		}
	}
}
