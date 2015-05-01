package test;
import java.util.ArrayList;
import java.util.List;

import doublylinkedlist.DNode;
import doublylinkedlist.DoublyLinkedList;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest  extends TestCase{
  
	public void CreateList(){
		DNode node0=new DNode(2);
		DoublyLinkedList list=new DoublyLinkedList(node0);
		List<DNode> list_test=new ArrayList<DNode>();
		list_test.add(node0);
		assertEquals(list.returnList(),list_test);
	
	}


	
}
