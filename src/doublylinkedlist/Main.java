package doublylinkedlist;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
		lista.addElem(5);
		lista.addElem(6);
		lista.addElem(7);
		System.out.println(lista.toString());
		lista.removeLast();
		System.out.println(lista.toString());

	}

}
