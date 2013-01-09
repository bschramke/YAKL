/**
 * 
 */
package de.coolbytes.android.yakl.kml;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import de.coolbytes.android.yakl.GeoPoint;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

/** Defines a closed line string, typically the outer boundary of a Polygon.
 * @detail Optionally, a LinearRing can also be used as the inner boundary of a Polygon to create holes in the Polygon. 
 * 			A Polygon can contain multiple LinearRing elements used as inner boundaries. 
 * 			You do not need to connect the first and last points.
 * 
 * @author Bj�rn Schramke
 * @date 22.08.2012
 *
 * @version 22.08.2012 Klasse erstellt
 */
public class KmlLinearRing extends KmlGeometry {

	private static final String TAG = KmlLinearRing.class.getSimpleName();
	private static int mCounter = 0;
	private List<GeoPoint> mPoints = null;
	/**
	 * 
	 */
	public KmlLinearRing() {
		this(null);
	}

	/**
	 * @param id
	 */
	public KmlLinearRing(String id) {
		super(id);
		
		mPoints = new ArrayList<GeoPoint>();
	}

	/* (non-Javadoc)
	 * @see de.init.android.xml.kml.KmlObject#setValue(java.lang.String, int, java.lang.String)
	 */
	@Override
	protected void setValue(String localName, int localNameHash, String value) {
		if (value == null)
			Log.e(TAG,"setValue VALUE NULL");
		Log.d(TAG,"setValue >>" + value+"<<");
//		
//		try {
//			File root = new File(Environment.getExternalStorageDirectory(), "VerkehrsappDEBUG");
//			 if (!root.exists()) 
//		        {
//		            root.mkdirs();
//		        }
//			 Log.e(TAG, "Path: " + root.getAbsolutePath());
//			 File gpxfile = new File(root, "Characters.txt");
//			 FileWriter writer = new FileWriter(gpxfile);
//			 writer.append(value);
//			 writer.flush();
//			 writer.close();
//			 
//			 
//		} catch (IOException e) {
//		    Log.i("Data Input Sample", "I/O Error");
//		}
//		
				
		
		if(localNameHash != KmlFeedHandler.TAG_COORDINATES_HASH) return;
		
		try{
			String[] coords = value.split("[\\s\\r\\n]+");
//			List<String> tmp = new ArrayList<String>();
//			StringBuilder sb = new StringBuilder();
//			
//			for(int i = 0; i < value.length(); i++){
//				char c = value.charAt(i);
//				switch(c){
//					case '\n':
//					case '\r':
//					case ' ':
//						if(sb.length() > 0){
//							tmp.add(sb.toString());
//							sb = new StringBuilder();
//						}
//						break;
//					default:
//						sb.append(c);
//						break;
//				}				
//			}
//			
//			Object[] coords = tmp.toArray();
			
			for(int i = 0; i < coords.length; i++){
				String[] coord = coords[i].split(",");
//				String[] coord = ((String)coords[i]).split(",");
				
				try{
					mPoints.add(GeoPoint.create(coord));
				} catch (Exception e){
					Log.e(TAG, "These coordinates couldn't get parsed! :-( ");
				}
			}			
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
	}
	
	public List<GeoPoint> getPoints(){
		return mPoints;
	}
	
	/** Creates a bounding Box of all geoPoints
	 * @return GeoPoint[] of 2 values of the BoundingBox [Minimum, Maximum]
	 */
	public GeoPoint[] getBoundingBox(){		
		int minLat  = Integer.MAX_VALUE;
		int minLong = Integer.MAX_VALUE;
		
		int maxLat  = Integer.MIN_VALUE;
		int maxLong = Integer.MIN_VALUE;
		
		ListIterator<GeoPoint> iter = mPoints.listIterator();
		GeoPoint tempPoint = null;
		while(iter.hasNext()){
			tempPoint = iter.next();
//			Log.e(TAG, "Checking Point " + tempPoint.getLatitudeE6() + " " + tempPoint.getLongitudeE6());
			// Set Minimum Values
			if (tempPoint.getLatitudeE6() < minLat){
				minLat = tempPoint.getLatitudeE6(); 
			}
			if (tempPoint.getLongitudeE6() < minLong){
				minLong = tempPoint.getLongitudeE6(); 
			}
			
			// Set Maximum Values
			if (tempPoint.getLatitudeE6() > maxLat){
				maxLat = tempPoint.getLatitudeE6(); 
			}
			if (tempPoint.getLongitudeE6() > maxLong){
				maxLong = tempPoint.getLongitudeE6(); 
			}
		}
		GeoPoint[] boundaries = new GeoPoint[] { new GeoPoint(minLat, minLong),		// Minimum
												 new GeoPoint(maxLat, maxLong)}; 	// Maximum
		
//		Log.e(TAG, "Minimum Point " + boundaries[0].getLatitudeE6() + " " + boundaries[0].getLongitudeE6());
//		Log.e(TAG, "Maximum Point " + boundaries[1].getLatitudeE6() + " " + boundaries[1].getLongitudeE6());
		
		return boundaries;																		
	}

}
