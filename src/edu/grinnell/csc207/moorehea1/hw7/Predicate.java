package edu.grinnell.csc207.moorehea1.hw7;
public interface Predicate<T> {
    /**
     * Determine if a value meets the predicate.
     */
    boolean test(T val);
} // Predicate<T>