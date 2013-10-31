package edu.grinnell.csc207.moorehea1.hw7;

import java.io.PrintWriter;

import edu.grinnell.glimmer.ushahidi.*;

public class UshahidiSummary {

	/**
	 * Simultaneously reads a set of UshahidiIncidents into a list and prints
	 * useful summary information about the incidents.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		PrintWriter pen = new PrintWriter(System.out, true);

		DoublyLinkedList<UshahidiIncident> sampleList = new DoublyLinkedList<UshahidiIncident>();
		UshahidiClient client = new UshahidiWebClient("http://burgermap.org");
		//UshahidiClient client = UshahidiUtils.SAMPLE_CLIENT;
		
		while (client.hasMoreIncidents()) {
			UshahidiIncident incident = client.nextIncident();
			sampleList.append(incident);
			pen.println("Incident #: " + incident.getId() + " "
					+ incident.getTitle());
			pen.println("  Location: " + incident.getLocation());
			pen.println("  Status: (" + incident.getMode() + ", "
					+ incident.getActive() + ", " + incident.getVerified()
					+ ")");
		} // while
	} // main
} // UshahidiSummary
