package lezione17;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class Cartella {
	
	
	//cerca dentro una directory comprese le sotto directory:
	//1: un file
	//2: tutti i file con estensione specificata
	//3: tutti i file con le estensioni fornite (si puo' fare con il metodo precedente)
	
	public static File cercaFile(File dir, String fileName) {
		//caso in cui il file che passo non è una directory ma un file 
		if(dir.isFile())
			return (dir.getName().substring(0, dir.getName().indexOf('.'))).equals(fileName)? dir: null;
		
		//altrimenti itero i vari file nella directory
		for(File file: dir.listFiles()) {
			//se è un file controllo se è quello che cerco
			if(file.isFile()) {
				if((file.getName().substring(0, file.getName().indexOf('.'))).equals(fileName)) return file;
			}
			else
				return cercaFile(file, fileName);
			
		}
		return null;
	}
	
	public static List<File> cercaPerEstensioni(File dir, String[] extensions){
		List<File> out = new ArrayList<>();
		for(String s: extensions)
			out.addAll(cercaPerEstensione(dir, s));
		return out;
	}
	
	public static List<File> cercaPerEstensione(File dir, String extension){
		List<File> out = new ArrayList<>();
		return cercaRicorsivaPerEstensione(dir, extension, out);
	}
	
	private static List<File> cercaRicorsivaPerEstensione(File file, String extension, List<File> data){
		//caso base
		if(file.isFile())
			return data;
		
		//allora è una directory
		for(File f: file.listFiles()) {
			//se è un file controllo l'estensione e se è quella che cerco lo inserisco nella lista
			if(f.isFile()) {
				if(f.getName().substring(f.getName().indexOf(".")+1).equals(extension))
					data.add(f);
			}
			else {
				//allora è una directory
				data = cercaRicorsivaPerEstensione(f, extension, data);
			}
		}
		return data;
	}
	
	public static void main(String[] args) {
		File f = new File("/home/giaco/Documenti/prova_java");
		//System.out.println(f.getName().substring(0, f.getName().indexOf('.')));
		
		File f1 = cercaFile(f, "primo_salvataggio");
		System.out.println(f1.getAbsolutePath());
		
		f1 = cercaFile(f, "file1");
		System.out.println(f1.getAbsolutePath());
		
		
		//System.out.println(cercaPerEstensione(f, "txt").toString());
		System.out.println("[stampa per estensione]");
		cercaPerEstensione(f, "txt").forEach(x->System.out.println(x.getName()));
		
		System.out.println("[stampa per estensioni]");
		String[] array = {"txt", "jpeg", "png"};
		cercaPerEstensioni(f, array).forEach(x->System.out.println(x.getName()));;
	}

}
