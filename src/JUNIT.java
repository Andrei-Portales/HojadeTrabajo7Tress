import static org.junit.Assert.*;

import org.junit.Test;




public class JUNIT {
	
	 

	@Test
	public void testAdd() {
		
		Tree tree = new Tree();
		tree.add("house", "casa");
		tree.add("chair", "silla");
		tree.add("mouse", "raton");
		tree.add("open", "abrir");
		tree.add("keyboard", "teclado");
		tree.add("phone", "telefono");
		
		String esp = "abrir";
		assertEquals(esp, tree.buscar("open"));
	}
	
	@Test
	public void testSearch() {
		
		Tree tree = new Tree();
		tree.add("house", "casa");
		tree.add("chair", "silla");
		tree.add("mouse", "raton");
		tree.add("open", "abrir");
		tree.add("keyboard", "teclado");
		tree.add("phone", "telefono");
		
		String esp = "abrir";
		assertEquals(esp, tree.buscar("open"));
		
		String esp1 = "telefono";
		assertEquals(esp1, tree.buscar("phone"));
		
		String esp2 = "teclado";
		assertEquals(esp2, tree.buscar("keyboard"));
		
		String esp3 = null;
		assertEquals(esp3, tree.buscar("wire"));
	}
	

}
