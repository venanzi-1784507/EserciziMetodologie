package lezione17;

import java.io.File;

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
	
	public static void main(String[] args) {
		File f = new File("/home/giaco/Documenti/prova_java");
		//System.out.println(f.getName().substring(0, f.getName().indexOf('.')));
		
		File f1 = cercaFile(f, "primo_salvataggio");
		System.out.println(f1.getAbsolutePath());
		
		f1 = cercaFile(f, "file1");
		System.out.println(f1.getAbsolutePath());
	}

}
