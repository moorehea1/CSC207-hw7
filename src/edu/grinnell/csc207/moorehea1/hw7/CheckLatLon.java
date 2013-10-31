package edu.grinnell.csc207.moorehea1.hw7;

import edu.grinnell.glimmer.ushahidi.UshahidiIncident;

/**
 * Determines if an incident is within some distance of the average
 * latitude/longitude.
 */
public class CheckLatLon implements Predicate<UshahidiIncident> {
	/**
	 * The cutoff distance.
	 */
	double cutoff;

	/**
	 * The average longitudes and latitudes.
	 */
	double aLat;
	double aLon;

	/**
	 * Build a new predicate that tests if the incident longitudes and latitudes
	 * are within the cutoffs.
	 * 
	 * @param cutoffLat
	 * @param cutoffLon
	 * @param aLat
	 * @param aLon
	 */
	public CheckLatLon(double cutoff, double aLat, double aLon) {
		this.cutoff = cutoff;
		this.aLat = aLat;
		this.aLon = aLon;
	}

	/**
	 * Determine if incident is within the cutoff.
	 * 
	 * @pre Latitudes do not wrap around.
	 */
	@Override
	public boolean test(UshahidiIncident incident) {
		return (((incident.getLocation().getLatitude() <= aLat + cutoff) && (incident
				.getLocation().getLatitude() >= aLat - cutoff)) && ((incident
				.getLocation().getLongitude() <= aLon + cutoff) && (incident
				.getLocation().getLongitude() >= aLon - cutoff)));
	} // test(incident)
} // class CheckLatitude