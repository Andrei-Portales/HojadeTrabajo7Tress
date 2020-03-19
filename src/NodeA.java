import java.util.Map;

/**
 * 
 * @author andrei portales 19825
 * @references https://www.baeldung.com/java-binary-tree
 *
 */


public class NodeA<K extends Comparable<K>, V extends Comparable<V>>  implements Comparable<NodeA<K, V>> , Map.Entry<K,V>{

	protected K key;
	protected V value;
	protected NodeA<String,String> left, right;
	
	/**
	 * constructor
	 * @param key
	 * @param value
	 */
	public NodeA(K key, V value) {
		this.key = key;
		this.value = value;
		left = null;
		right = null;
	}
	
	/**
	 * metodo para obtener la key
	 */
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	/**
	 * metodo para obtener el value
	 */
	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	/**
	 * metodo para asignar un nuevo valor de value
	 * @param value
	 */
	@Override
	public V setValue(V value) {
		V temp = this.value;
		this.value = value;
		return temp;
	}
	
	/**
	 * metodo para asignar nuevo valor de key
	 * @param key
	 */
	public void setKey(K key) {
		// TODO Auto-generated method stub
		this.key = key;
	}

	/**
	 * Metodo compare to para compara nodos
	 */
	@Override
	public int compareTo(NodeA<K, V> node) {
		return this.key.compareTo(node.getKey());
	}

	/**
	 * metodo para signar nodo izquierdo
	 * @param node
	 */
	public void setRight(NodeA node) {
		right = node;
	}
	
	/**
	 * metodo para asignar nodo izquierdo
	 * @param node
	 */
	public void setLeft(NodeA node) {
		left = node;
	}
	
	/**Metodo para obtener el nodo derecho
	 * 
	 * @return
	 */
	public NodeA getRight() {
		return right;
	}
	
	/**
	 * metodo para obtener nodo izquierdo
	 * @return
	 */
	public NodeA getLeft() {
		return left;
	}
	
	
	
	
	
	
	
	

}
