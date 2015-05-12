package test;

import static org.junit.Assert.*;
import doublylinkedlist.DoublyLinkedList;

public class Test {

	@org.junit.Test
	public void test() {
		DoublyLinkedList<Integer> lista=new DoublyLinkedList<Integer>();
		lista.addFirst(1);
		lista.removeFirst();
		assertEquals("[]",lista.toString());
	}

}
