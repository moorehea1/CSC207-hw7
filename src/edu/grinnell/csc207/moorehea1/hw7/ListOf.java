package edu.grinnell.csc207.moorehea1.hw7;

import java.util.Iterator;

/**
 * Lists have cursors/iterators, which fall between elements (or before
 * the first element or after the last element).
 */
public interface ListOf<T> extends Iterable<T> {
    // Adding Elements
    
    /**
     * Insert an element at the location of the Cursor<T> (between two
     * elements).
     *
     * @pre
     *   lit must be associated with the list and in the list.
     *
     * @throws Exception
     *   If the precondition is not met.
     * @throws Exception
     *   If there is no memory to expand the list.
     *
     * @post
     *   The previous element to the iterator remains the same
     *   str is immediately after the iterator
     *   The element that previously followed the iterator follows str
     *   And writing postconditions is a PITN
     */
    public void insert(T val, Cursor<T> c) throws Exception;

    /**
     * Add an element to the end of the list.  (Creates a one-element
     * list if the list is empty.)
     *
     * @throws Exception
     *   If there is no memory to expand the list.
     */
    public void append(T val) throws Exception;

    /**
     * Add an element to the front of the list.  (Creates a one-element
     * list if the list is empty.)
     *
     * @throws Exception
     *   If there is no memory to expand the list.
     */
    public void prepend(T val) throws Exception;

    // Removing Elements
    /**
     * Delete the element immediately after the iterator.
     *
     * @post
     *    The remaining elements retain their order.
     * @post
     *    The iterator is at the position
     *    The successor of the element immediately before the iterator
     *      is the successor of the now-deleted element.
     */
    public void delete(Cursor<T> c) throws Exception;

    // Iterating Lists
    /**
     * Get a standard interator at the front of the list.
     */
    @Override
    public Iterator<T> iterator();

    /**
     * Get an iterator right before the front of the list.
     *
     * @throws Exception
     *   If the list is empty.
     */
    public Cursor<T> front() throws Exception;

    /**
     * Advance to the next position.
     *
     * @pre
     *   The list has a next element.
     * @throws Exception
     *   If there is no next element.
     */
    public void advance(Cursor<T> c) throws Exception;

    /**
     * Back up to the previous position.
     *
     * @pre
     *   The list has a next element.
     * @throws Exception
     *   If there is no next element.
     */
    public void retreat(Cursor<T> c) throws Exception;

    /**
     * Get the element under the cursor.
     *
     * @pre
     *   it is valid and associated with this list.
     * @throws Exception
     *   If the preconditions are not met.
     */
    public T get(Cursor<T> c) throws Exception;

    /**
     * Get the element immediately before the cursor.
     */
    public T getPrev(Cursor<T> c) throws Exception;

    /**
     * Determine if it's safe to advance to the next position.
     *
     * @pre
     *   pos is valid and associated with the list.
     */
    public boolean hasNext(Cursor<T> c) throws Exception;

    /**
     * Determine if it's safe to retreat to the previous position.
     *
     * @pre
     *   pos is valid and associated with the list.
     */
    public boolean hasPrev(Cursor<T> c) throws Exception;

    // Other operations

    /**
     * Swap the elements at the positions the corresopnd to it1 and it2.
     *
     * @pre
     *   Both it1 and it2 are valid and associated with this list.
     *   v1 = get(it1), v2 = get(it2)
     * @post
     *   it1 and it2 are unchanged.
     *   v1 = get(it2), v2 = get(it1)
     */
    public void swap(Cursor<T> c1, Cursor<T> c2)
            throws Exception;

    /**
     * Search for a value that meets a predicate, moving the iterator to that 
     * value.
     *
     * @return true, if the value was found
     * @return false, if the value was not found
     *
     * @post If the value is not found, the iterator has not moved.
     * @post IF the value is found, get(it) is value
     */
    public boolean search(Cursor<T> c, Predicate<T> pred) throws Exception;

    /** 
     * Grab a sublist.  (Detailed discussion not included.)
     *
     * @pre
     *    Valid iterators.
     *    start precedes end.
     * @throws Exception
     *    If the iterators are invalid.
     */
    public ListOf<T> subList(Cursor<T> start, Cursor<T> end)
            throws Exception;

    /** 
     * Select all of the elements that meet a predicate.
     */
    public ListOf<T> select(Predicate<T> pred) throws Exception;

    /**
     * Determine if one iterator precedes another iterator.
     */
    public boolean precedes(Cursor<T> c1, Cursor<T> c2)
           throws Exception;
} // interface ListOf<T>