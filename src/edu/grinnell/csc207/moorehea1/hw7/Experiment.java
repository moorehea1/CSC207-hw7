package edu.grinnell.csc207.moorehea1.hw7;

import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * A simple set of experiments to make sure that our amazing LinkedList
 * class works fine.
 */
public class Experiment {

     /**
      * Print a list of objects.
      */
     public static <T> void printList(PrintWriter pen, LinkedList<T> list) {
         for (T val : list) {
             pen.print(val);
             pen.print(" ");
         } // for
         pen.println();
         pen.flush();
     } // printList(PrintWriter, LinkedList<Object>)

     public static void main(String[] args) throws Exception {
         // Set up output
         PrintWriter pen = new PrintWriter(System.out, true);

         // Create some lists
         LinkedList<String> strings = new LinkedList<String>();
         LinkedList<Integer> numbers = new LinkedList<Integer>();

         // Prepend a few elements
         numbers.prepend(42);
         numbers.prepend(77);
         numbers.prepend(11);
         printList(pen, numbers);

         // Append a few elements
         numbers.append(1);
         numbers.append(2);
         numbers.append(3);

         // And we're done
         pen.close();
     } // main(String[])
} // class Experiment