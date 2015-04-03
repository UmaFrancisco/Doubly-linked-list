package doublylinkedlist;
import java.util.*;
public class DoublyLinkedList {
	// points to first node of list
		DNode firstNode;
		// points to last node of list
	    DNode lastNode;

	    
	    public void insertAfter(List<DNode> list,DNode node,DNode newNode ){
	    	newNode.previousNode=node;
	    	newNode.nextNode=node.nextNode;
	    		if(newNode.nextNode==null){
	    			lastNode=newNode;
	    			node.nextNode=newNode;
	    		}else{
	    			node.nextNode.previousNode=newNode;
	    			node.nextNode=newNode;
	    		}
	    		list.add(newNode);
	    }
}
