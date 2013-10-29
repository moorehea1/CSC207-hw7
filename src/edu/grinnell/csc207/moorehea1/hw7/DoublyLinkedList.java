package edu.grinnell.csc207.moorehea1.hw7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Doubly linked lists.
 */
public class DoublyLinkedList<T> implements ListOf<T> {

    // FIELDS
	 /**
	     * The front of the list.  Set to null for the empty list.
	     */
	    Node<T> front;

	    /**
	     * The back of the list.  Set to null for the empty list.
	     */
	    Node<T> back;
	    
	    /**
	     * The dummy node!  Yay!
	     */
	    Node<T> dummy;

	    /**
	     * The number of mutations.
	     */
	    long mutations;

    // CONSTRUCTORS
    /**
     * Create a new linked list.
     */
    public DoublyLinkedList() {
		this.dummy = new Node(null);
	        this.front = dummy;
	        this.back = dummy;
	        this.mutations = 0;
    } // DoublyLinkedList

    // Internal methods
    boolean isEmpty() {
        return (this.front == this.dummy);
    } // isEmpty

    // ITERABLE METHODS
    @Override
    public Iterator<T> iterator() {
        return new DLLIterator<T>(this);
    } // iterator()

    // LISTOF METHODS
    public void insert(T val, Cursor c) throws Exception {
    	DoublyLinkedListCursor<T> dllc = (DoublyLinkedListCursor<T>) c;
    	dllc.pos.prev.next = new Node<T>(val);
    	dllc.pos.prev.next.prev = dllc.pos.prev;  
    	dllc.pos.prev = dllc.pos.prev.next;
    	dllc.pos.prev.next = dllc.pos;        
    } // insert(T, Cursor)

    public void append(T val) throws Exception {
	  // Special case: Empty list
        if (this.isEmpty()) {
            this.front = new Node<T>(val);
            this.back = this.front;
            this.dummy.next = this.front;
        }
        // Normal case: Nonempty list
        else {
            this.back.next = new Node<T>(val);
            this.back = this.back.next;
            this.back.prev = this.dummy.prev;
            this.dummy.prev = this.back;
        }
    } // append(T)

    public void prepend(T val) throws Exception {
    	// Special case: Empty list
        if (this.isEmpty()) {
            this.front = new Node<T>(val);
            this.back = this.front;
        }
        // Normal case: Nonempty list
        else {
            this.dummy.next = new Node<T>(val);
            this.dummy.next.next = this.front;
            this.front.prev = this.dummy.next;
            this.front = this.dummy.next;
            this.front.prev = this.dummy;
        }
        this.dummy.next = this.front;
    } // prepend(T)

    public void delete(Cursor c) throws Exception {
    	DoublyLinkedListCursor<T> dllc = (DoublyLinkedListCursor<T>) c;
        dllc.pos.prev.next = dllc.pos.next;
        dllc.pos.next.prev = dllc.pos.prev;
        this.advance(dllc);
    } // delete(Cursor)

    public Cursor front() {
    	return new DoublyLinkedListCursor<T>(this.front);
    } // front()

    public void advance(Cursor c) throws Exception {
    	DoublyLinkedListCursor<T> dllc = (DoublyLinkedListCursor<T>) c;
    	dllc.pos = dllc.pos.next;
    } // advance(Cursor)

    public void retreat(Cursor c) throws Exception {
    	DoublyLinkedListCursor<T> dllc = (DoublyLinkedListCursor<T>) c;
    	dllc.pos = dllc.pos.prev;
    } // retreat(Cursor)

    public T get(Cursor c) throws Exception {
    	DoublyLinkedListCursor<T> dllc = (DoublyLinkedListCursor<T>) c;
    	return dllc.pos.val;
    } // get

    public T getPrev(Cursor c) throws Exception {
    	DoublyLinkedListCursor<T> dllc = (DoublyLinkedListCursor<T>) c;
    	return dllc.pos.prev.val;
    } // getPrev(Cursor)

    public boolean hasNext(Cursor c) {
    	DoublyLinkedListCursor<T> dllc = (DoublyLinkedListCursor<T>) c;
        return !(dllc.pos.next == this.dummy);
    } // hasNext

    public boolean hasPrev(Cursor c) {
    	DoublyLinkedListCursor<T> dllc = (DoublyLinkedListCursor<T>) c;
        return !(dllc.pos.prev == this.dummy);
    } // hasPrev

    public void swap(Cursor c1, Cursor c2) throws Exception {
    	DoublyLinkedListCursor<T> dllc1 = (DoublyLinkedListCursor<T>) c1;
    	DoublyLinkedListCursor<T> dllc2 = (DoublyLinkedListCursor<T>) c2;
    	T temp;
    	temp = dllc1.pos.val;
    	dllc1.pos.val = dllc2.pos.val;
    	dllc2.pos.val = temp;
    } // swap(Cursor, Cursor)

    public boolean search(Cursor c, Predicate<T> pred) throws Exception {
    	DLLIterator<T> dlli = (DLLIterator<T>) c;
    	while (dlli.hasNext()){
    		pred(this.val)
    	}
    	return false;
    } // search(Cursor, Predicate<T>)
     
    public ListOf<T> select(Predicate<T> pred) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // select(Predicate<T>)
     
    public ListOf<T> subList(Cursor start, Cursor end) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // subList(Cursor, Cursor)

    public boolean precedes(Cursor c1, Cursor c2) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // precedes(Cursor, Cursor)
} // class DoublyLinkedList

/**
 * Nodes in the list.
 */
class Node<T> {
    T val;
    Node<T> next;
    Node<T> prev;

    /**
     * Create a new node.
     */
    public Node(T val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    } // Node(T)
} // Node<T>

/**
 * Cursors in the list.
 */
class DoublyLinkedListCursor<T> implements Cursor<T> {
    Node<T> pos;

    /**
     * Create a new cursor that points to a node.
     */
    public DoublyLinkedListCursor(Node<T> pos) {
        this.pos = pos;
    } // DoublyLinkedListCursor
} // DoublyLinkedListCursor<T>

class DLLIterator<T> implements Iterator<T> {
    Node<T> pos;
    DoublyLinkedList<T> list;

    /**
     * Create a new iterator at the front of the list.
     */
    public DLLIterator(DoublyLinkedList<T> list) {
        this.pos = list.front;
        this.list = list;
    } // DLLIterator(Node<T>)

    public T next() throws NoSuchElementException {
        if (this.pos == null) {
            throw new NoSuchElementException("at end of list");
        }
        T val = this.pos.val;
        this.pos = this.pos.next;
        return val;
    } // next()

    public boolean hasNext() {
        return this.pos != null;
    } // hasNext()

    public void remove() throws UnsupportedOperationException {
         throw new UnsupportedOperationException("No way, no how");
    } // remove()
} // DLLIterator<T>