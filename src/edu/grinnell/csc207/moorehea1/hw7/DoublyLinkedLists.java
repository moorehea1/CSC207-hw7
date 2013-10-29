package edu.grinnell.csc207.moorehea1.hw7;

import java.awt.Cursor;
import java.util.Iterator;

import javax.sql.rowset.Predicate;

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
    } // DoublyLinkedListpublic class ListOf {



    // ITERABLE METHODS
    @Override
    public Iterator<T> iterator() {
        return null;    // STUB
    } // iterator()

    // LISTOF METHODS
    public void insert(T val, Cursor c) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // insert(T, Cursor)

    public void append(T val) throws Exception {
	  // Special case: Empty list
        if (this.isEmpty()) {
            this.front = new Node<T>(val, null);
            this.back = this.front;
            this.dummy.next = this.front;
        }
        // Normal case: Nonempty list
        else {
            this.back.next = new Node<T>(val, null);
            this.back = this.back.next;
        }
    } // append(T)
    } // append(T)

    public void prepend(T val) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // prepend(T)

    public void delete(Cursor c) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // delete(Cursor)

    public Cursor front() throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // front()

    public void advance(Cursor c) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // advance(Cursor)

    public void retreat(Cursor c) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // retreat(Cursor)

    public T get(Cursor c) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // get

    public T getPrev(Cursor c) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // getPrev(Cursor)

    public boolean hasNext(Cursor c) {
        return false;   // STUB
    } // hasNext

    public boolean hasPrev(Cursor c) {
        return false;   // STUB
    } // hasPrev

    public void swap(Cursor c1, Cursor c2) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // swap(Cursor, Cursor)

    public boolean search(Cursor c, Predicate<T> pred) throws Exception {
        throw new UnsupportedOperationException("STUB");
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
class DoublyLinkedListCursor<T> implements Cursor {
    Node<T> pos;

    /**
     * Create a new cursor that points to a node.
     */
    public DoublyLinkedListCursor(Node<T> pos) {
        this.pos = pos;
    } // DoublyLinkedListCursor
} // DoublyLinkedListCursor<T>
