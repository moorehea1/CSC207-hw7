package edu.grinnell.csc207.moorehea1.hw7;

import java.io.PrintWriter;

import edu.grinnell.glimmer.ushahidi.*;

public class UshahidiDistance {
	
    public static <T> void printList(PrintWriter pen, DoublyLinkedList<T> list) {
        for (T val : list) {
            pen.print(val);
            pen.print(" ");
        } // for
        pen.println();
        pen.flush();
    } // printList(PrintWriter, DoublyLinkedList<T>)
    
    /**
     * Determines if an incident is within some distance of the average latitude/longitude. 
     */
    public class checkLatitude implements Predicate<UshahidiIncident> {
		double cutoff;
    	
    	public checkLatitude(double cutoff) {
			this.cutoff = cutoff;
		}
    	
    	@Override
		public boolean test(UshahidiIncident incident) {
			return ((this.getLocation().getLatitude() - val) <= 10);
        } // test
    } // class
    
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		PrintWriter pen = new PrintWriter(System.out, true);
		
        DoublyLinkedList<UshahidiIncident> sampleList = new DoublyLinkedList<UshahidiIncident>();
		UshahidiClient client = new UshahidiWebClient("http://www.burgermap.org/");
		double aLat = 0;
		double aLon = 0;
    	double lat = 0;
    	double lon = 0;
    	int count = 0;
    	
        for (UshahidiIncident incident: client.getIncidents()) {
        	lat = lat + incident.getLocation().getLatitude();
        	lon = lon + incident.getLocation().getLongitude();
        	sampleList.append(incident);
        	count++;
        }
        aLat = lat/count;
        aLon = lon/count;
        
        pen.println("The Average Latitude is " + aLat + " and the average Longitude is " + aLon + ".");
        
        
        sampleList.select(IsWithinDistance(UshahidiIncident incident));
	} // main

}
