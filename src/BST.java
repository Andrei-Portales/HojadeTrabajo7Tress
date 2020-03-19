import java.util.LinkedList;
import java.util.Stack;


/**
 * 
 * @author andrei portales 19825
 * @references https://www.baeldung.com/java-binary-tree
 *
 */
public class BST {

	/**
	 * metodo para crear nuevo nodo
	 * @param key
	 * @param value
	 * @return
	 */
	public NodeA<String, String> createNewNode(String key,String value) {
		NodeA<String, String> node = new NodeA<String, String>(key, value);
		return node;
	}
	
	/**
	 * meoto recursivo para recorrido inorden
	 * @param nodo
	 * @param data
	 */
	//
    public void ayudanteInorden( NodeA<String,String> nodo, Stack<String> data)
    {
        if(nodo == null)
            return;
        
        
        ayudanteInorden(nodo.getLeft(),data);
        data.add("("+ nodo.getKey() + "," +nodo.getValue()+")\n");
        ayudanteInorden(nodo.getRight(),data);
    }
	
	
	

	
	/**
	 * Metodo para insertar nodo en el arbol
	 * @param node
	 * @param key
	 * @param value
	 * @return
	 */
	public NodeA<String, String> insert(NodeA<String, String> node,String key, String value) {
	
		if (node == null) {
			return createNewNode(key,value);
		}
		
		if (node.compareTo(new NodeA<String, String>(key, value)) < 0) {
			node.setLeft(insert(node.getLeft(),key,value));
		}else if(node.compareTo(new NodeA<String, String>(key, value)) > 0) {
			node.setRight(insert(node.getRight(),key,value));
		}
		return node;
	}
	
	/**
	 * Metodo para buscar en el mapa
	 * @param node
	 * @param key
	 * @return
	 */
	public String buscar(NodeA node, String key) {
		if (node == null) {
			return null;
		}
		
		if (node.compareTo(new NodeA<String, String>(key, null)) == 0) {
			return  node.getValue().toString();
		}else if (node.compareTo(new NodeA<String, String>(key, null)) < 0) {
			if (node.getLeft() != null) {
				return buscar(node.getLeft(),key);
			}else {
				return null;
			}
		}else if(node.compareTo(new NodeA<String, String>(key, null)) > 0) {
			
			if (node.getRight() != null) {
				return buscar(node.getRight(),key);
			}else {
				return null;
			}
		}
		
		
		return "";
	}
	


}
