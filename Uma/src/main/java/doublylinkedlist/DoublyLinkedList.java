package doublylinkedlist;
import java.util.*;
public class DoublyLinkedList {
	// points to first node of list
		DNode firstNode=null;
		// points to last node of list
	    DNode lastNode=null;
	    List<DNode> list=new ArrayList<DNode>();
	    

	    public DoublyLinkedList(DNode node){
	    	insertBeginning(node);
	    }

	    
	    public void insertAfter(DNode node,DNode newNode ){
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
	    public void insertBefore(DNode node,DNode newNode){
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
	    public void insertBeginning (DNode newNode){
    		if(firstNode==null){
    			firstNode=newNode;
    			lastNode=newNode;
    			newNode.nextNode=null;
    			newNode.previousNode=null;
    		}else{
    			insertBefore(firstNode,newNode);
    		}
    }
	    public void insertEnd(DNode newNode){
    		if(lastNode == null){
    			insertBeginning(newNode);
    		}else{
    			insertAfter(lastNode,newNode);
    		}
    }
	    public void remove(DNode node){
    		if (node.previousNode==null){
    			firstNode=node.nextNode;
    		}else if(node.nextNode==null){
    			lastNode=node.previousNode;
    		}else{
    			node.previousNode.nextNode=node.nextNode;
    			node.nextNode.previousNode=node.previousNode;
    		}
    		list.remove(node);
    }
	    public List<DNode> returnList(){
	    	return list;
	    }
	    public DNode firstNode(){
	    	return firstNode;
	    }
	    public DNode lastNode(){
	    	return lastNode;
	    }
}
