package de.coolbytes.android.yakl.kml;

import android.graphics.Color;

/**
 * @detail 
 * @author Björn Schramke
 * @date 22.08.2012
 *
 * @version 22.08.2012 Klasse erstellt
 */
public class KmlBaloonStyle extends KmlSubStyle {
	
	private static int mCounter = 0;
	private int mBgColor = Color.WHITE;
	private int mTextColor = Color.BLACK;
	private String mText = null;
	private int mDisplayMode = DEFAULT;
	
	/**
	 * 
	 */
	public KmlBaloonStyle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public KmlBaloonStyle(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see de.init.android.xml.kml.KmlObject#setValue(java.lang.String, int, java.lang.String)
	 */
	@Override
	protected void setValue(String localName, int localNameHash, String value) {
		switch(localNameHash){
			case KmlFeedHandler.TAG_BGCOLOR_HASH:
				setBackgroundColor(value);
				break;
			case KmlFeedHandler.TAG_TEXTCOLOR_HASH:
				setTextColor(value);
				break;
		}
	}
	
	public void setDisplayMode(int value){
		
		switch(value){
			case HIDE:
				mDisplayMode = HIDE;
				break;
			default:
				mDisplayMode = DEFAULT;
				break;
		}
	}
	
	public int getDisplayMode(){
		return mDisplayMode;
	}
	
	public void setText(String text){
		mText = text;
	}
	
	public String getText(){
		return mText;
	}
	
	public void setBackgroundColor(int color){
		mBgColor = color;
	}
	
	public void setBackgroundColor(String color) throws IllegalArgumentException{
		mBgColor = KmlBaloonStyle.stringToColor(color);
	}

	public void setBackgroundColor(int red, int green, int blue){
		mBgColor = Color.rgb(red, green, blue);
	}
	
	public int getBackgroundColor(){
		return mBgColor;
	}

	public void setTextColor(int color){
		mTextColor = color;
	}
	
	public void setTextColor(String color) throws IllegalArgumentException{
		mTextColor = KmlBaloonStyle.stringToColor(color);
	}

	public void setTextColor(int red, int green, int blue){
		mTextColor = Color.rgb(red, green, blue);
	}
	
	public int getTextColor(){
		return mTextColor;
	}
	
}
