package bases;

import java.util.ArrayList;

public class YearSet {
	// Attributes
	private final String acadYear;
	private final ArrayList<Offering> offerings;
	
	// Constructor
	public YearSet(String acadYear, ArrayList<Offering> offerings) {
		this.acadYear = acadYear;
		this.offerings = offerings;
	}
	
	// Getters
	public String getAY() { return acadYear; }
	public ArrayList<Offering> getOfferings() { return offerings; }
}
