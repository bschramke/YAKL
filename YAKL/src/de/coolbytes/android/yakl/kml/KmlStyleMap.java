/**
 * 
 */
package de.coolbytes.android.yakl.kml;

/** Maps between two different icon styles. 
 * 
 * @detail Typically this interface is used to provide separate normal and highlighted styles 
 * 			for a placemark, so that the highlighted version appears when the user mouses over the icon. 
 * 
 * @author Björn Schramke
 * @date 22.08.2012
 *
 * @version 22.08.2012 Klasse erstellt
 */
public class KmlStyleMap extends KmlStyleSelector {

	private static int mCounter = 0;
	
	/**
	 * 
	 */
	public KmlStyleMap() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see de.init.android.xml.kml.KmlObject#setValue(java.lang.String, int, java.lang.String)
	 */
	@Override
	protected void setValue(String localName, int localNameHash, String value) {
		// TODO Auto-generated method stub

	}

}
