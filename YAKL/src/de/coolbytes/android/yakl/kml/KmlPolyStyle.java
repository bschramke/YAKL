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
public class KmlPolyStyle extends KmlColorStyle {

	private static int mCounter = 0;
	private boolean mOutline = true;
	private boolean mFill = true;
	
	/**
	 * 
	 */
	public KmlPolyStyle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public KmlPolyStyle(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see de.init.android.maps.kml.KmlColorStyle#setValue(java.lang.String, int, java.lang.String)
	 */
	@Override
	protected void setValue(String localName, int localNameHash, String value) {
		switch(localNameHash){
			case KmlFeedHandler.TAG_FILL_HASH:
				setFill(Boolean.parseBoolean(value));
				break;
			case KmlFeedHandler.TAG_OUTLINE_HASH:
				setOutline(Boolean.parseBoolean(value));
				break;
			default:
				super.setValue(localName, localNameHash, value);
				break;
		}
	}

	public void setFill(boolean value){
		mFill = value;
	}
	
	public boolean getFill(){
		return mFill;
	}
	
	public void setOutline(boolean value){
		mOutline = value;
	}
	
	public boolean getOutline(){
		return mOutline;
	}

}
