import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


/**
 * 
 * @author andrei portales 19825
 *
 */

public class Controlador {

	private Tree arbol;
	
	public Controlador() {
		arbol = new Tree();
	}
	
	/**
	 * metodo para crear diccionario, los valores son leidos en el txt
	 */
	public void crearDiccionario() {
		ArrayList<String> palabras = ArchivoTXT.leerTXT(ArchivoTXT.getPath());
		int pos = 0;
		
		for (String p: palabras) {
			String[] temp = p.split(",");
			arbol.add(temp[0].trim(), temp[1].trim());
		}
		
	}
	
	/**
	 * metodo para retornar el stack de el arbol en In-Order
	 * @return
	 */
	public Stack<String> inOrder(){
		return arbol.inOrder();
	}
	
	/**
	 * Metodo que traduce el texto ingresado
	 * @param texto
	 * @return
	 */
	public String traducir(String texto) {
		String temp = "";
		String[] temparray = texto.split("");
		ArrayList<String> exceptiones = new ArrayList<String>();
		exceptiones.add(".");
		exceptiones.add(",");
		for (String t: temparray) {
			if (!exceptiones.contains(t)) {
				temp += t;
			}
		}
		
		temparray = temp.split(" ");
		
		temp = "";
		for (String x: temparray) {

			String ta = arbol.buscar(x.toLowerCase().trim());
			if (ta == null) {
				x = "*" + x + "*";
			}else {
				x = ta;
			}
			
			temp += x + " ";	
		}
		
		
		return temp;
	}
	
	
	
}
