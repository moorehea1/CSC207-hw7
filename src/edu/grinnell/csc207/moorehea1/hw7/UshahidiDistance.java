package edu.grinnell.csc207.moorehea1.hw7;

import java.io.PrintWriter;

import edu.grinnell.glimmer.ushahidi.*;

public class UshahidiDistance {

	/**
	 * Reads a set of UshahidiIncidents into a list and prints all incidents
	 * that are within some distance of the average latitude/longitude.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		PrintWriter pen = new PrintWriter(System.out, true);

		DoublyLinkedList<UshahidiIncident> sampleList = new DoublyLinkedList<UshahidiIncident>();
		// UshahidiClient client = UshahidiUtils.SAMPLE_CLIENT;
		UshahidiClient client = new UshahidiWebClient("http://burgermap.org");
		double aLat = 0;
		double aLon = 0;
		double lat = 0;
		double lon = 0;
		int count = 0;

		while (client.hasMoreIncidents()) {
			UshahidiIncident incident = client.nextIncident();
			sampleList.append(incident);
			lat = lat + incident.getLocation().getLatitude();
			lon = lon + incident.getLocation().getLongitude();
			count++;
		} // while

		aLat = lat / count;
		aLon = lon / count;

		pen.println("Average Latitude: " + aLat);
		pen.println("Average Longitude: " + aLon);

		sampleList.select(new CheckLatLon(30, aLat, aLon));
		Experiment.printList(pen, sampleList);
	} // main
} // UshahidiDistance
