/**
 * 
 */
package de.coolbytes.android.yakl.kml;

/** Defines the icon, label, line, list, polygon, and balloon styles.
 * 
 * @author Björn Schramke
 * @date 22.08.2012
 *
 * @version 22.08.2012 Klasse erstellt
 */
public class KmlStyle extends KmlStyleSelector {

	private static int mCounter = 0;
	
	private KmlBaloonStyle mBaloonStyle = null;
	private KmlPolyStyle mPolyStyle = null;
	private KmlListStyle mListStyle = null;
	private KmlLineStyle mLineStyle = null;
	private KmlIconStyle mIconStyle = null;
	private KmlLabelStyle mLabelStyle = null;
	
	/**
	 * 
	 */
	public KmlStyle() {
		super();
	}

	/**
	 * @param id
	 */
	public KmlStyle(String id) {
		super(id);
	}

	/* (non-Javadoc)
	 * @see de.init.android.xml.kml.KmlObject#setValue(java.lang.String, int, java.lang.String)
	 */
	@Override
	protected void setValue(String localName, int localNameHash, String value) {
		// TODO Auto-generated method stub

	}
	
	public void setSubStyle(KmlSubStyle subStyle){
		
		if(subStyle instanceof KmlBaloonStyle){
			mBaloonStyle = (KmlBaloonStyle) subStyle;
		}
		else if(subStyle instanceof KmlListStyle){
			mListStyle = (KmlListStyle) subStyle;
		}
		else if(subStyle instanceof KmlPolyStyle){
			mPolyStyle = (KmlPolyStyle) subStyle;
		}
		else if(subStyle instanceof KmlIconStyle){
			mIconStyle = (KmlIconStyle) subStyle;
		}
		else if(subStyle instanceof KmlLineStyle){
			mLineStyle = (KmlLineStyle) subStyle;
		}
		else if(subStyle instanceof KmlLabelStyle){
			mLabelStyle = (KmlLabelStyle) subStyle;
		}
	}

}
