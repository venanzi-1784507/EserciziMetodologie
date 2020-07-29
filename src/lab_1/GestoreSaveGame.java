package lab_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestoreSaveGame {

	public static final String PATH = "/home/giaco/Documenti/prova_java/";
	/**
	 * 
	 * @param nome con cui e' stata salvata la configurazione
	 * @return stringa che corrisponde alla configurazione
	 */
	public static String caricaPartita(String nome) {
		String out = "";
		try{
			FileReader reader = new FileReader(PATH + nome);
			BufferedReader bufferReader = new BufferedReader(reader);
			
			int character;
			while((character = bufferReader.read()) != -1) {
				out += (char)character;
			}
			bufferReader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return out;
	}
	
	/**
	 * 
	 * @param nome con cui salvare la stringa
	 * @param config stringa da salvare
	 * @return true se il salvataggio è andato a buon fine
	 */
	public static boolean salvaPartita(String nome, String config) {
		
		try  {
			FileWriter writer = new FileWriter(PATH + nome);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			bufferedWriter.write(config);
			
			bufferedWriter.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return true;
	}
}
