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
	    public void insertBefore(List<DNode> list,DNode node,DNode newNode){
	    	newNode.previousNode=node.previousNode;
	    	newNode.nextNode=node;
	    		if(newNode.previousNode==null){
	    			firstNode=newNode;
	    			node.previousNode=newNode;
	    		}else{
	    			node.previousNode.nextNode=newNode;
	    			node.previousNode=newNode;
	    		}
	    		list.add(newNode);
	    }
	    public void insertBeginning (List<DNode> list,DNode newNode){
    		if(firstNode==null){
    			firstNode=newNode;
    			lastNode=newNode;
    			newNode.nextNode=null;
    			newNode.previousNode=null;
    		}else{
    			insertBefore(list,firstNode,newNode);
    		}
    }
	    public void insertEnd(List<DNode> list,DNode newNode){
    		if(lastNode == null){
    			insertBeginning(list,newNode);
    		}else{
    			insertAfter(list,lastNode,newNode);
    		}
    }
}
