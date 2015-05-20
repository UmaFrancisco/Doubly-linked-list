package doublylinkedlist;
import java.util.Iterator;
import java.util.NoSuchElementException;


 
public class DoublyLinkedList<T> implements Iterable<T> {
	 private static class DNode<E> {
	        private E data;
	        private DNode<E> previousNode, nextNode;

	        public DNode(E elem, DNode<E> prev,DNode<E> next) {
	            data = elem;
	            previousNode = prev;
	            nextNode = next;
	        }
	    }

    private DNode<T> firstNode, lastNode;

    public DoublyLinkedList() {
        this.firstNode = null;
            // points to first node of list
        this.lastNode = null;
            // points to last node of list
    }

    private void insertAfter(DNode<T> node,DNode<T> newNode) {
        newNode.previousNode = node;
        newNode.nextNode = node.nextNode;
        if (node.nextNode == null) {
            this.lastNode = newNode;
             node.nextNode = newNode;
        } else {
            node.nextNode.previousNode = newNode;
            node.nextNode = newNode;
        }
       
    }

    private void insertBefore(DNode<T> node, DNode<T> newNode) {
        newNode.previousNode = node.previousNode;
        newNode.nextNode = node;
        if (node.previousNode == null) {
            firstNode = newNode;
            node.previousNode = newNode;
        } else {
            node.previousNode.nextNode = newNode;
            node.previousNode = newNode;
        }
        
    }

    private void insertBeginning(DNode<T> newNode) {
            if (firstNode == null) {
            firstNode = newNode;
            lastNode = newNode;
            newNode.previousNode = null;
            newNode.nextNode = null;
        } else {
            insertBefore(firstNode, newNode);
        }
    }

    private void insertEnd(DNode<T> newNode) {
        if (firstNode == null) {
            insertBeginning(newNode);
        } else {
            insertAfter(lastNode, newNode);
        }
    }

    private void remove(DNode<T> node) {
        if (node.previousNode == null) {
            firstNode = node.nextNode;
        } else {
            node.previousNode.nextNode = node.nextNode;
        }
        if (node.nextNode == null) {
            this.lastNode = node.previousNode;
        } else {
            node.nextNode.previousNode = node.previousNode;
        }
    }


    private class Forward implements Iterator<T> {

        private DNode<T> actual_Node;

        public Forward() {
            this.actual_Node = firstNode;
        }

        public boolean hasNext() {
            return this.actual_Node != null;
        }

        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            T next_elem = actual_Node.data;
            actual_Node=actual_Node.nextNode;
            return next_elem;
        }

		@Override
		public void remove() {
			
		}

    }

    private class Backward implements Iterator<T> {

        private DNode<T> actual_Node;

        public Backward() {
            this.actual_Node = lastNode;
        }

        public boolean hasNext() {
            return this.actual_Node != null;
        }

        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            T bef_elem = this.actual_Node.data;
            this.actual_Node = this.actual_Node.previousNode;
            return bef_elem;
        }

		@Override
		public void remove() {
			
		}

    }

    public Iterator<T> forward() {
        return new Forward();
    }

    public Iterator<T> backward() {
        return new Backward();
    }
    
    public Iterator<T> iterator() {
        return new Forward();
    }
    
    public void addElem(T elem) {
        insertEnd(new DNode<T>(elem, null, null));
    }

    public void addFirst(T elem) {
        insertBeginning(new DNode<T>(elem, null, null));
    }

    public void removeFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        remove(firstNode);
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        remove(lastNode);
    }
    
    public boolean isEmpty() {
        return firstNode == null;
    }

    public int size() {
        int size = 0;
        Iterator<T> iter = forward();
        while (iter.hasNext()) {
            iter.next();
            size++;
        }
        return size;
    }

    private DNode<T> getNode(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        int position = 0;
        DNode<T> node = this.firstNode;
        while (position != index) {
            node = node.nextNode;
            position++;
        }
        return node;
    }
    
    public T get(int index) {
        return this.getNode(index).data;
    }
    
    public void set(int position, T element) {
       getNode(position).data = element;
    }

    public void removeNodeAtIndex(int position) {
        if (position < 0 || position >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        this.remove(this.getNode(position));
    }



    public String string(Iterator<T> iterator) {
        StringBuilder listStringBuilder = new StringBuilder("[");
        while (iterator.hasNext()) {
            listStringBuilder.append(iterator.next());
            if (iterator.hasNext()) {
                listStringBuilder.append(", ");
            }
        }
        listStringBuilder.append("]");
        return listStringBuilder.toString();
    }

    @Override
    public String toString() {
        return this.string(forward());
    }

}