package doublylinkedlist;

public class DNode {

	int data;
	DNode previousNode;
	DNode nextNode;

	public DNode(int data){		
		this.data = data;
		this.previousNode=null;
		this.nextNode=null;

    }
	public DNode(int data,DNode previousNode,DNode nextNode){		
		this.data = data;
		this.previousNode=previousNode;
		this.nextNode=nextNode;

    }

}