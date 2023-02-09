package it.beije.neumann.mercuri.roomFeeler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class RoomFeeler {

	public static int tabCounter = 0;
	public static void roomFeeler (String filePath) {
		
		File dir = new File(filePath);
		Writer writeFile = null;
		StringBuilder sb = new StringBuilder();	
		
		try {
			
			writeFile = new BufferedWriter(new FileWriter("/temp/tree.txt", true));
	
			String [] files = dir.list();
			String path = dir.getPath();
	
			for (String file: files) {
				
				sb.setLength(0);
				
				for (int i = 0; i < tabCounter ; i++) {
					sb.append("\t");
					System.out.print("\t");
				}
				System.out.println(file);
	
				String newFilePath = path + "\\" + file;
							
				sb.append(file);
				
				writeFile.append(sb.toString());
				writeFile.append('\n');
				
				writeFile.flush();
			
				if (new File(newFilePath).isDirectory()) {
					
					tabCounter++;				
					roomFeeler(newFilePath);
				}
			}
			
			writeFile.close();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
		
		tabCounter--;

	}
	
	
	public static void main(String[] args) {

		roomFeeler("/temp");
	}

}
