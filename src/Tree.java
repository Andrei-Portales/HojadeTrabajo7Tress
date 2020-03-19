import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * @author andrei portales 19825
 * @references https://www.baeldung.com/java-binary-tree
 *
 */

public class Tree {

	BST bst;
	NodeA<String,String> root;
	
	public Tree() {
		root = null;
		bst = new BST();
	}
	
	/**
	 * metodo para agregar un nuevo nodo
	 * @param key
	 * @param value
	 */
	public void add(String key, String value) {
		root = bst.insert(root, key, value);
	}
	
	/**
	 * metodo para buscar un nodo
	 * @param key
	 * @return
	 */
	public String buscar(String key) {
		return bst.buscar(root, key);
	}
	
	/**
	 * metodo que devuelve el arbon en orden In-Order
	 * @return
	 */
	public Stack<String> inOrder() {
		Stack<String> data = new Stack<String>();
		bst.ayudanteInorden(root, data);
		return data;
	}
	
}
