/**
 * 
 */
package de.coolbytes.android.yakl;

import java.util.Iterator;
import java.util.List;

import android.util.Log;

/**
 * @author bschramke
 *
 */
public class GeoPoint {

	private static final String TAG = GeoPoint.class.getSimpleName();
	private int mAltitude = 0;
	private int mLat = 0;
	private int mLon = 0;
	
	public GeoPoint(double lat, double lon) {
		this(toIntE6(lat), toIntE6(lon),0);
	}

	public GeoPoint(double lat, double lon, int alt) {
		this(toIntE6(lat), toIntE6(lon),alt);
	}

	public GeoPoint(int lat, int lon) {
		this(lat, lon,0);
	}

	public GeoPoint(int lat, int lon, int alt) {
		mLat = lat;
		mLon = lon;
		mAltitude = alt;
	}
	
	public int getAltitude(){
		return mAltitude;
	}

	public int getLatitudeE6(){
		return mLat;
	}

	public int getLongitudeE6(){
		return mLon;
	}

	/** Converts the Values to the correct format for GeoPoints
	 * @param double value that has to be converted to int
	 * @return int value for GeoPoint Coordinates
	 */
	public static int toIntE6(double value) {
		return (int) (value * 1e6);
	}

	/** Converts the Values to the correct format for GeoPoints
	 * @param double value that has to be converted to int
	 * @return int value for GeoPoint Coordinates
	 */
	public static GeoPoint create(String[] values) throws NumberFormatException {
		Log.d(TAG, "count: "+values.length);
		
		int lat = 0;
		int lon = 0;
		int alt = 0;
		double tmp = 0;
		
		if(values.length >= 2){
				Log.d(TAG, "values[0]: "+values[0]);
				tmp = Double.parseDouble(values[0]);
				lon = toIntE6(tmp);
				
				Log.d(TAG, "values[1]: "+values[1]);
				tmp = Double.parseDouble(values[1]);
				lat = toIntE6(tmp);
		}
				
		if(values.length >= 3){
			Log.d(TAG, "values[2]: "+values[2]);
			alt = Integer.parseInt(values[2]);
		}
		
		return new GeoPoint(lat,lon,alt);
	}
	
}
