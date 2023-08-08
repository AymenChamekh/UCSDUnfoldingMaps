package EarthquakeMap;


import java.util.HashMap;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class EarthquakeCityMap extends PApplet{
	
	private UnfoldingMap map;
	
	
	public void setup() {
		size(950, 600, OPENGL);
		map = new UnfoldingMap(this, 200, 50, 700, 500,new Google.GoogleMapProvider());
	    Map<String , Float> lifeExpByCountry;
	    
		
	}
	public void draw() {
		background(220);
		map.draw();
		//addKey();
	}
	private Map<String , Float> loadLifeExpFromCvs(String fileName){
		Map<String , Float> expLife = new HashMap<String, Float>();
		String[] rows = loadStrings(fileName);
		for (String row : rows) {
			// Reads country name and population density value from CSV row
			// NOTE: Splitting on just a comma is not a great idea here, because
			// the csv file might have commas in their entries, as this one does.  
			// We do a smarter thing in ParseFeed, but for simplicity, 
			// we just use a comma here, and ignore the fact that the first field is split.
			String[] columns = row.split(",");
			if (columns.length == 6 && !columns[5].equals("..")) {
				expLife.put(columns[4], Float.parseFloat(columns[5]));
			}
		}

		return expLife;
	}

}
