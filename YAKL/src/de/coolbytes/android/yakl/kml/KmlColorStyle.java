package de.coolbytes.android.yakl.kml;

import android.graphics.Color;

/**
 * @detail 
 * @author Björn Schramke
 * @date 22.08.2012
 *
 * @version 22.08.2012 Klasse erstellt
 */
public abstract class KmlColorStyle extends KmlSubStyle {

	
	private int mColor = Color.BLACK;
	private int mColorMode = NORMAL;	//valid values are NORMAL and RANDOM
	
	/**
	 * 
	 */
	public KmlColorStyle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public KmlColorStyle(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see de.init.android.xml.kml.KmlObject#setValue(java.lang.String, int, java.lang.String)
	 */
	@Override
	protected void setValue(String localName, int localNameHash, String value) {
		switch(localNameHash){
			case KmlFeedHandler.TAG_COLOR_HASH:
				setColor(value);
				break;
			case KmlFeedHandler.TAG_COLORMODE_HASH:
				setColorMode(value);
				break;
		}
	}
	

	public void setColor(int color){
		mColor = color;
	}
	
	public void setColor(String color) throws IllegalArgumentException{
		mColor = KmlColorStyle.stringToColor(color);
	}

	public void setColor(int red, int green, int blue){
		mColor = Color.rgb(red, green, blue);
	}
	
	public int getColor(){
		return mColor;
	}
	
	public void setColorMode(String mode){
		
		if(mode.equalsIgnoreCase("random")){
			mColorMode = RANDOM;
		}
		else{
			mColorMode = NORMAL;
		}
	}
	
	public void setColorMode(int mode){
		switch(mode){
			case RANDOM:
				mColorMode = RANDOM;
				break;
			default:
				mColorMode = NORMAL;
				break;
		}
	}
	
	public int getColorMode(){
		return mColorMode;
	}

}
