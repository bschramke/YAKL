/**
 * 
 */
package de.coolbytes.android.yakl.kml;

/**
 * @detail 
 * @author Björn Schramke
 * @date 22.08.2012
 *
 * @version 22.08.2012 Klasse erstellt
 */
public class KmlLabelStyle extends KmlColorStyle {

	private static int mCounter = 0;
	
	/**
	 * 
	 */
	public KmlLabelStyle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public KmlLabelStyle(String id) {
		super(id);
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
