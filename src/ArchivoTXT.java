import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ArchivoTXT {
	
	/**
	 * Funcion para obtener la ruta de el archivo txt
	 * @return
	 */
	public static String getPath()  {
		
		JFileChooser chooser = new JFileChooser();
	 	FileNameExtensionFilter filtroImagen =new FileNameExtensionFilter("*.TXT", "txt");
	 	chooser.setFileFilter(filtroImagen);
	 	File f = null;
	 	
		try {
			f = new File(new File(".").getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String path = "";
		
		try {
			chooser.setCurrentDirectory(f);
			chooser.setCurrentDirectory(null);
			chooser.showOpenDialog(null);
	    
			path = chooser.getSelectedFile().toString();
		}catch(Exception e) {
			
		}
	    return path;
	}
	
	
	
	/**
	 * Funcion para leer el txt
	 * @return
	 */
	public static ArrayList<String> leerTXT(String path) {
		
		File archivo = new File(path);
		FileReader fr;
		BufferedReader br;
		ArrayList<String> lineas = new ArrayList<String>();
		
		try {
			
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			
			String linea = "";
			
			while((linea = br.readLine()) != null) {
				String temp = "";
				String[] split = linea.split("");
				
				for (String a: split) {
					if (!a.equals("(")) {
						if (!a.equals(")")) {
							temp += a;
						}
					}
				}
				lineas.add(temp);
				
			}
			
			
			br.close();
			fr.close();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha sucedido un error leyendo el archivo " + e);
		}
		
		return lineas;
	}

}