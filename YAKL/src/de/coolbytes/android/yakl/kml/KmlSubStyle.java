/**
 * 
 */
package de.coolbytes.android.yakl.kml;

import android.graphics.Color;

/**
 * @detail 
 * @author Björn Schramke
 * @date 22.08.2012
 *
 * @version 22.08.2012 Klasse erstellt
 */
public abstract class KmlSubStyle extends KmlObject {

	/**
	 * 
	 */
	public KmlSubStyle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public KmlSubStyle(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public static int stringToColor(String color) throws IllegalArgumentException{
		
		String tmp = ( color.startsWith("#") )?color:"#"+color;
				
		return Color.parseColor(tmp);
	}

}
