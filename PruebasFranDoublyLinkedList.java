package doublylinkedlist;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PruebasFranDoublyLinkedList {
	
	private DoublyLinkedList<Integer> lista;

	@Before
	public void testPreparatorio() {
		this.lista = new DoublyLinkedList<Integer>();
	}
	
	@After
	public void testFinalizatorio(){
		this.lista = null;
	}
	
	@Test
	public void testConstructor(){
		assertEquals("[]" , lista.toString());
	}
	
	@Test
	public void testConstructor2(){
		assertTrue(this.lista.isEmpty());
	}
	
	@Test
	public void testTamConstructor(){
		assertEquals(0 , lista.size());
	}
	
	@Test
	public void testNoVacioUnElem(){
		this.lista.addElem(1);
		assertFalse(this.lista.isEmpty());
	}
	
	@Test
	public void testTamUnElem(){
		this.lista.addElem(1);
		assertEquals(1, this.lista.size());
	}
	
	@Test
	public void testAgnadirElem(){
		this.lista.addElem(5);
		assertEquals("[5]" , this.lista.toString());
	}
	
	@Test
	public void testDosElem(){
		this.lista.addElem(5);
		this.lista.addElem(3);
		assertEquals("[5, 3]" , this.lista.toString());
	}
	
	@Test
	public void testTamDosElem(){
		this.lista.addElem(5);
		this.lista.addElem(3);
		assertEquals(2 , this.lista.size());
	}
	
	@Test
	public void testNoVerifyIterHasNext(){
		Iterator<Integer> iteradorLista;
		iteradorLista = this.lista.iterator();
		assertFalse(iteradorLista.hasNext());	
	}
	
	@Test
	public void testVerifyIterHasNext(){
		lista.addElem(5);
		Iterator<Integer> iteradorLista;
		iteradorLista = this.lista.iterator();
		assertTrue(iteradorLista.hasNext());	
	}
	
	@Test
	public void testVerifyIterNext(){
		lista.addElem(5);
		Iterator<Integer> iteradorLista;
		iteradorLista = this.lista.iterator();
		assertEquals("5" , iteradorLista.next().toString());	
	}
	
	@Test
	public void testVerifyIterFailNext(){
		try{
		lista.addElem(5);
		lista.addElem(6);
		Iterator<Integer> iteradorLista;
		iteradorLista = this.lista.iterator();
		while(iteradorLista.hasNext()){
			iteradorLista.next();
		}
		assertEquals("6" , iteradorLista.next().toString());
		}catch (NoSuchElementException e){
			assertTrue(e instanceof NoSuchElementException);
		}	
	}
	
	@Test
	public void testVerifyIter2Next(){
		lista.addElem(5);
		lista.addElem(6);
		Iterator<Integer> iteradorLista;
		iteradorLista = this.lista.iterator();
		iteradorLista.next();
		assertEquals("6" , iteradorLista.next().toString());
	}
	
	@Test
	public void testNoVerifyIterHasNextForward(){
		Iterator<Integer> iteradorLista;
		iteradorLista = this.lista.forward();
		assertFalse(iteradorLista.hasNext());	
	}
	
	@Test
	public void testVerifyIterHasNextForward(){
		lista.addElem(5);
		Iterator<Integer> iteradorLista;
		iteradorLista = this.lista.forward();
		assertTrue(iteradorLista.hasNext());	
	}
	
	@Test
	public void testVerifyIterNextForward(){
		lista.addElem(5);
		Iterator<Integer> iteradorLista;
		iteradorLista = this.lista.forward();
		assertEquals("5" , iteradorLista.next().toString());	
	}
	
	@Test
	public void testVerifyIterFailNextForward(){
		try{
		lista.addElem(5);
		lista.addElem(6);
		Iterator<Integer> iteradorLista;
		iteradorLista = this.lista.forward();
		while(iteradorLista.hasNext()){
			iteradorLista.next();
		}
		assertEquals("6" , iteradorLista.next().toString());
		}catch (NoSuchElementException e){
			assertTrue(e instanceof NoSuchElementException);
		}	
	}
	
	@Test
	public void testVerifyIter2NextForward(){
		lista.addElem(5);
		lista.addElem(6);
		Iterator<Integer> iteradorLista;
		iteradorLista = this.lista.forward();
		iteradorLista.next();
		assertEquals("6" , iteradorLista.next().toString());
	}
	
	@Test
	public void testNoVerifyIterHasNextBackward(){
		Iterator<Integer> iteradorLista;
		iteradorLista = this.lista.backward();
		assertFalse(iteradorLista.hasNext());	
	}
	
	@Test
	public void testVerifyIterHasNextBackward(){
		lista.addElem(5);
		Iterator<Integer> iteradorLista;
		iteradorLista = this.lista.backward();
		assertTrue(iteradorLista.hasNext());	
	}
	
	@Test
	public void testVerifyIterNextBackward(){
		lista.addElem(5);
		Iterator<Integer> iteradorLista;
		iteradorLista = this.lista.backward();
		assertEquals("5" , iteradorLista.next().toString());	
	}
	
	@Test
	public void testVerifyIterFailNextBackward(){
		try{
		lista.addElem(5);
		lista.addElem(6);
		Iterator<Integer> iteradorLista;
		iteradorLista = this.lista.backward();
		while(iteradorLista.hasNext()){
			iteradorLista.next();
		}
		assertEquals("5" , iteradorLista.next().toString());
		}catch (NoSuchElementException e){
			assertTrue(e instanceof NoSuchElementException);
		}	
	}
	
	@Test
	public void testVerifyIter2NextBackward(){
		lista.addElem(5);
		lista.addElem(6);
		Iterator<Integer> iteradorLista;
		iteradorLista = this.lista.backward();
		iteradorLista.next();
		assertEquals("5" , iteradorLista.next().toString());
	}
	
	@Test
	public void testAddFirst(){
		lista.addFirst(2);
		assertEquals("[2]", this.lista.toString());
	}
	
	@Test
	public void testAddFirstTam(){
		lista.addFirst(2);
		assertEquals(1, this.lista.size());
	}
	
	@Test
	public void testAddFirst2Elem(){
		lista.addFirst(2);
		lista.addFirst(3);
		assertEquals("[3, 2]", this.lista.toString());
	}
	
	@Test
	public void testRemoveFirstFail(){
		try{
		this.lista.removeFirst();
		} catch (NoSuchElementException e){
			assertTrue(e instanceof NoSuchElementException);
		}
	}
	
	@Test
	public void testRemoveFirst(){
		lista.addFirst(3);
		assertFalse(this.lista.isEmpty());
		this.lista.removeFirst();
		assertTrue(this.lista.isEmpty());	
	}
	
	@Test
	public void testRemoveFirst2(){
		lista.addFirst(3);
		lista.addFirst(7);
		lista.addFirst(5);
		assertFalse(this.lista.isEmpty());
		this.lista.removeFirst();
		assertEquals("[7, 3]", this.lista.toString());	
	}
	
	@Test
	public void testRemoveLastFail(){
		try{
		this.lista.removeLast();
		} catch (NoSuchElementException e){
			assertTrue(e instanceof NoSuchElementException);
		}
	}
	
	@Test
	public void testRemoveLast(){
		lista.addElem(3);
		assertFalse(this.lista.isEmpty());
		this.lista.removeLast();
		assertTrue(this.lista.isEmpty());	
	}
	
	@Test
	public void testRemoveLast2(){
		lista.addElem(3);
		lista.addElem(7);
		lista.addElem(5);
		assertFalse(this.lista.isEmpty());
		this.lista.removeLast();
		assertEquals("[3, 7]", this.lista.toString());	
	}
	
	@Test
	public void testGetFail1(){
		try{
			lista.addElem(5);
			lista.get(-1);
			assertFalse(true);
		} catch (IndexOutOfBoundsException e){
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
	}
	
	@Test
	public void testGetFail2(){
		try{
			lista.addElem(5);
			lista.addElem(6);
			lista.get(2);
			assertFalse(true);
		} catch (IndexOutOfBoundsException e){
			assertTrue(e instanceof IndexOutOfBoundsException);
		}	
	}
	
	@Test
	public void testGet(){
		lista.addElem(5);
		lista.addElem(6);
		assertEquals("5", lista.get(0).toString());
	}
	
	@Test
	public void testGet2(){
		lista.addElem(5);
		lista.addElem(6);
		assertEquals("6", lista.get(1).toString());
	}
	
	@Test
	public void testSetFail1(){
		try{
		lista.addFirst(5);
		lista.addFirst(6);
		lista.set(-1, 7);
		assertFalse(true);
		} catch(IndexOutOfBoundsException e){
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
	}
	
	@Test
	public void testSetFail2(){
		try{
			lista.addFirst(5);
			lista.addFirst(6);
			lista.set(2, 7);
			assertFalse(true);
			} catch(IndexOutOfBoundsException e){
				assertTrue(e instanceof IndexOutOfBoundsException);
			}
	}
	
	@Test
	public void testSet(){
		lista.addElem(5);
		lista.addElem(6);
		lista.set(0, 8);
		assertEquals("[8, 6]", lista.toString());
	}
	
	@Test
	public void testSet2(){
		lista.addElem(5);
		lista.addElem(6);
		lista.set(1, 9);
		assertEquals("[5, 9]", lista.toString());
	}
	
	@Test
	public void testRemoveNodeAtIndexFail1(){
		try{
		lista.addElem(2);
		lista.addElem(3);
		lista.removeNodeAtIndex(-1);
		assertFalse(true);
		}catch(IndexOutOfBoundsException e){
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
	}
	
	@Test
	public void testRemoveNodeAtIndexFail2(){
		try{
		lista.addElem(2);
		lista.addElem(3);
		lista.removeNodeAtIndex(2);
		assertFalse(true);
		}catch(IndexOutOfBoundsException e){
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
	}
	
	@Test
	public void testRemoveNodeAtIndex1(){
		lista.addElem(2);
		lista.addElem(3);
		lista.addElem(4);
		lista.removeNodeAtIndex(1);
		assertEquals("[2, 4]", this.lista.toString());
	}
	
	@Test
	public void testRemoveNodeAtIndex2(){
		lista.addFirst(2);
		lista.addElem(3);
		lista.addFirst(4);
		lista.removeNodeAtIndex(1);
		assertEquals("[4, 3]", this.lista.toString());
	}
	
	@Test
	public void testRemoveNodeAtIndex3(){
		lista.addFirst(2);
		lista.addElem(3);
		lista.addFirst(4);
		lista.removeNodeAtIndex(0);
		assertEquals("[2, 3]", this.lista.toString());
	}
}
