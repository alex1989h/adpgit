package aufgabenblatt7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Weblog {
	
	/**
	 * Weblog erstellen
	 * @param fileName
	 * @param size
	 */
	public static void erstelleWeblog(String filename, long size){
		String log = null;
    GregorianCalendar cal = new GregorianCalendar();
    PrintWriter writer = openWriter(filename);
    
			for (int i = 0; i < size; i++) {
				log = ((int)(Math.random()*256) + "." + (int)(Math.random()*256)+ "." + (int)(Math.random()*256)+ "." +  (int)(Math.random()*256) + "$ - - ");
				log += "[" +  cal.getTime()+":"+i+ "]" ;
				log += " \"" + "GET /" + "FILENR" + i +  "\"" + "\n";
				writer.println(log);
			}
			
		closeWriter(writer);
	}
	
	/**
	 * 
	 * @param filename
	 * @return
	 */
	public static List<String> leseWeblog(String filename){
		List<String> list = new ArrayList<String>();
		String zeile=null;
		BufferedReader reader = openReader(filename);
		try {
			while((zeile=reader.readLine())!=null){
				if(!zeile.equals("")){
					list.add(zeile);
				}
			}
		} catch (Exception e) {
			closeReader(reader);
			e.printStackTrace();
		}
		closeReader(reader);
		return list;
	}
	
	/**
	 * Writer oeffnen
	 * @param filename
	 * @return
	 */
	private static PrintWriter openWriter(String filename){
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
		} catch (IOException e) {
			closeWriter(writer);
			e.printStackTrace();
		}
		return writer;
	}
	/**
	 * Writer schliessen
	 * @param writer
	 */
	private static void closeWriter(PrintWriter writer){
		if(writer != null){
			writer.close();
		}
	}
	
	/**
	 * Reader oeffnen
	 * @param filename
	 * @return
	 */
	private static BufferedReader openReader(String filename){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			closeReader(reader);
			e.printStackTrace();
		}
		return reader;
	}
	
	/**
	 * Reader schliessen
	 * @param reader
	 */
	private static void closeReader(BufferedReader reader){
		try {
			if(reader != null){
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
