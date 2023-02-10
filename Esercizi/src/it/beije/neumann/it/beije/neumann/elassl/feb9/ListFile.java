package it.beije.neumann.elassl.feb9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import it.beije.neumann.elassl.feb8.Contatto;

public class ListFile {
	
	public StringBuilder list(String path) {
		StringBuilder out = new StringBuilder();
		return list(path, "", out);
	}
    private StringBuilder list(String path, String depth, StringBuilder out) {
    	
        File dir = new File(path);
        File[] list = dir.listFiles();
        if (list == null) {
    		return null;
        }
        for (File elem : list) {
            if (elem.isDirectory()) {
            	out = list(elem.getAbsolutePath(), depth+"\t", out);
                out.append("\n"+depth+elem.getName()+"(dir)");
            }
            else out.append("\n"+depth+elem.getName());
        }
		System.out.println("exit"+out);
		return out;
    }

    public static void saveFile(String pathfile, StringBuilder rows) throws FileNotFoundException, IOException {
    	try (FileWriter fileWriter = new FileWriter(pathfile);){
    		fileWriter.write(rows.toString());
    	}
		catch (FileNotFoundException fnfEx) {
			fnfEx.printStackTrace();
		} 
		catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
    	ListFile ls = new ListFile();
    	final String PATH_NAME="/home/mm/git/AcademyJavaXVI/Esercizi/src/it/beije/neumann/it/beije/neumann/elassl";
    	StringBuilder str = ls.list(PATH_NAME);
    	saveFile("/home/mm/git/AcademyJavaXVI/Esercizi/src/it/beije/neumann/it/beije/neumann/elassl/feb9/ls.txt",str);
    }

}
