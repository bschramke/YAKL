/**
 * 
 */
package de.coolbytes.android.yakl.kml;

import android.util.Log;

import de.coolbytes.android.yakl.Math;

/**
 * @author Bj�rn Schramke
 * @date 2012-08-16 test
 * 
 * @version 2012-08-16 bschramke: Klasse erstellt
 *
 */
public class KmlCoordinate {
	
	private static final String TAG = KmlCoordinate.class.getSimpleName();
	private float mLongitude = 0.0f;
	private float mLatitude = 0.0f;
	private float mAltitude = 0.0f;
	
	/**
	 * 
	 */
	public KmlCoordinate() {
		this(0.0f,0.0f,0.0f);
	}

	/**
	 * @param longLatAlt
	 * @throws Exception 
	 */
	public KmlCoordinate(String longLatAlt) throws Exception {
		this(0.0f,0.0f,0.0f);
		set(longLatAlt);
	}

	/**
	 * @param longitude
	 * @param latitude
	 * @param altitude
	 */
	public KmlCoordinate(float longitude, float latitude, float altitude) {
		super();
		set(longitude, latitude, altitude);
	}
	
	
	/**
	 * @param longLatAlt
	 * @todo this should throw an Exception if longLatAlt == null || longLatAlt.length() == 0
	 * @todo this should throw an Exception if if token[].length < 2 or > 3
	 */
	public void set(String longLatAlt){
		
		//TODO this should throw an Exception
		if(longLatAlt == null || longLatAlt.length() == 0){
			set(0.0f,0.0f,0.0f);
			return;
		}
		
		Log.d(TAG, "longLatAlt: "+longLatAlt);
		String[] tokens = longLatAlt.split(",");
		
		//TODO this should throw an exception if token[].length < 2 or > 3
		switch(tokens.length ){
			case 3:
				set(Float.valueOf(tokens[0]),Float.valueOf(tokens[1]),Float.valueOf(tokens[2]));
				break;
			case 2:
				set(Float.valueOf(tokens[0]),Float.valueOf(tokens[1]),0.0f);
				break;
			case 1:
				set(Float.valueOf(tokens[0]),0.0f,0.0f);
				break;
			default:
				set(0.0f,0.0f,0.0f);
				break;
		}
		
	}
	
	public void set(float longitude, float latitude){
		set(longitude, latitude, 0.0f);
	}
	
	public void set(float longitude, float latitude, float altitude){
		mLongitude = longitude;
		mLatitude = latitude;
		mAltitude = altitude;
	}
	
	/**
	 * @return the mLongitude
	 */
	public float getmLongitude() {
		return mLongitude;
	}

	/**
	 * @param longitude ≥ −180 and <= 180
	 */
	public void setLongitude(float longitude) {
		
		this.mLongitude = Math.clamp(longitude, -180.0f, 180.0f);
	}

	/**
	 * @return the mLatitude
	 */
	public float getLatitude() {
		return mLatitude;
	}

	/**
	 * @param latitude ≥ −90 and ≤ 90
	 */
	public void setLatitude(float latitude) {
		this.mLatitude = Math.clamp(latitude, -90.0f, 90.0f);
	}

	/**
	 * @return the mAltitude
	 */
	public float getAltitude() {
		return mAltitude;
	}

	/**
	 * @param altitude in meters above sea level
	 */
	public void setAltitude(float altitude) {
		this.mAltitude = altitude;
	}

}
