package aufgabenblatt7;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import hashing.Entry;

public class Hash {
	
	/**
	 * Hash Tabelle
	 */
	private HashEintrag ht[] = new HashEintrag[15];
	private int anzahl=0;
	public void initHt(){
		for (int i = 0; i < ht.length; i++) {
			ht[i]= new HashEintrag();
		}
	}
	
	public void erstelleHashTabelle(String filename){
		List<String> list = Weblog.leseWeblog(filename);
		String ipString=null;
		long wert=0;
		for (String string : list) {
			ipString=string.split("\\$")[0];
			ipString=ipString.replace(".", "");
			try {
				wert=(long)Long.parseLong(ipString);
				einfuegen(wert,string);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
	}
	long zeit=0;
	public List<String> sucheDaten(String ip){
		zeit=System.nanoTime();
		long key = Long.parseLong(ip.replace(".", ""));
		System.out.println(System.nanoTime()-zeit);
		return finde(key);
	}
	
	private int getHashWert(long wert, int j) {
		int hashWert = (int) (wert % ht.length);
		if (hashWert < 0) hashWert += ht.length;
		hashWert += sond(wert, j);
		hashWert = hashWert % ht.length;
		if (hashWert < 0) hashWert += ht.length;
		return hashWert;
	}
	
	HashEintrag temp;
	public void einfuegen(long wert, String daten){
		int j=0;
		int i=getHashWert(wert,j);
		int index = i;
		while(ht[i].getWert()!=wert&&ht[i].getStatus()!=Status.FREI){
			j++;
			i = getHashWert(wert,j);
				if (ht[i].getStatus()!=Status.BELEGT&&ht[index].getStatus()==Status.BELEGT) {
				index=i;
			}
		}
		if(ht[i].getWert()==wert){
			temp = ht[i];
			while(temp.getNext()!=null){
				temp=temp.getNext();
			}
			temp.setNext(new HashEintrag(wert,daten,Status.BELEGT));
			
		}else{
			if(ht[index].getStatus()==Status.FREI&&anzahl>(0.6*ht.length)){
				vergrAndRehash();
				einfuegen(wert, daten);
			} else {
				anzahl++;
				ht[index].setWert(wert);
				ht[index].setDaten(daten);
				ht[index].setStatus(Status.BELEGT);
			}
		}
	}
	
	/**
	 * Finde Data zur Ip Adresse
	 * @param wert
	 * @return
	 */
	public List<String> finde(long wert){
		List<String> list = new ArrayList<String>();
		String data="";
		int j=0;
		int i=getHashWert(wert,j);
		int index = i;
		while(ht[i].getWert()!=wert&&ht[i].getStatus()!=Status.FREI){
			j++;
			i = getHashWert(wert,j);
			if (ht[i].getStatus()!=Status.BELEGT&&ht[index].getStatus()==Status.BELEGT) {
				index=i;
			}
		}
		if(ht[i].getWert()==wert){
			temp = ht[i];
			while(temp!=null){
				list.add(temp.getDaten());
				temp=temp.getNext();
			}
		}else{
			data ="Ip Adresse nicht gefunden";
		}
		return list;
	}
	/**
	 * Sordierungsfunktion
	 * @param wert
	 * @param j
	 * @return
	 */
	private int sond(long wert,int j){
		int modulo =(int)(wert%(ht.length-2));
		if(modulo < 0)modulo+=(ht.length-2);
		return (j*(1+modulo));
	}
	
	private void vergrAndRehash(){
		anzahl=0;
		HashEintrag htAlt[];
		htAlt=ht;
		ht = new HashEintrag[ht.length*2];
		initHt();
		
		for (int i = 0; i < htAlt.length; i++) {
			if(htAlt[i].getStatus()==Status.BELEGT){
				einfuegen(htAlt[i].getWert(), htAlt[i].getDaten());
			}
		}
	}
	
/**
 * Alle Werte ausgeben
 */
	public void ausgabe(){
		for (int i = 0; i < ht.length; i++) {
			if (ht[i].getStatus()==Status.BELEGT) {
				temp = ht[i];
				while(temp!=null){
					System.out.println("HashWert: "+i+" HashCode: "+temp.getWert()+" Daten: "+temp.getDaten());
					temp=temp.getNext();
				}
			}
		}
		System.out.println("--------------------------");
	}
	
	/**
	 * 
	 */
	public Set<String> getIps(){
		Set<String> set = new HashSet<String>();
    for(HashEintrag eintrag: ht){
        if(eintrag != null && eintrag.getDaten() != null){
            set.add(eintrag.getDaten().split("\\$")[0]);
        }
    }
    return set;
	}
}
