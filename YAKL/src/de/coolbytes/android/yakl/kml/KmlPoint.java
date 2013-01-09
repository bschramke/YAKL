/**
 * 
 */
package de.coolbytes.android.yakl.kml;

/** A geographic location defined by longitude, latitude, and (optional) altitude.
 * 
 * @detail  When a Point is contained by a Placemark, the point itself determines the position of the Placemark's name and icon. 
 * 
 * @author Björn Schramke
 * @date 28.08.2012
 *
 * @version 28.08.2012 Klasse erstellt
 */
public class KmlPoint extends KmlGeometry {

	private static final int CLAMP_TO_GROUND = 1;
	private static final int RELATIVE_TO_GROUND = 2;
	private static final int ABSOLUTE = 3;

	private static int mCounter = 0;
	
	private boolean mExtrude = false;
	private int mAltitudeMode = CLAMP_TO_GROUND;
	private KmlCoordinate mCoordinate = null;
	
	/**
	 * 
	 */
	public KmlPoint() {
		this(null);
	}

	/**
	 * 
	 */
	public KmlPoint(String id) {
		super(id);
		mCoordinate = new KmlCoordinate();
	}

	/**
	 * @param longLatAlt
	 * @see de.init.android.maps.kml.KmlCoordinate#set(java.lang.String)
	 */
	public void setCoordinate(String longLatAlt) {
		mCoordinate.set(longLatAlt);
	}

	@Override
	protected void setValue(String localName, int localNameHash, String value) {
		
		switch(localNameHash){
			case KmlFeedHandler.TAG_COORDINATES_HASH:
				setCoordinate(value);
				break;
		}
		
	}
	
	

}
