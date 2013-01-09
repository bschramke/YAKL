package de.coolbytes.android.yakl;

import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;


/**
 * @author Björn Schramke
 *
 */
public class XmlFeedHandler extends DefaultHandler {
	private static final String TAG = XmlFeedHandler.class.getSimpleName();
	
	private StringBuffer mCharBuffer = null;
	/**
	 * 
	 */
	public XmlFeedHandler() {
		super();
		
		mCharBuffer = new StringBuffer();
	}

	/**
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {
		Log.d(TAG,"startDocument");
		// TODO Auto-generated method stub
		super.startDocument();
	}

	/**
	 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
	 */
	@Override
	public void endDocument() throws SAXException {
		Log.d(TAG,"endDocument");
		super.endDocument();
	}

	/**
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		Log.d(TAG,"startElement: "+uri+","+localName+","+qName);
		
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
	}

	/**
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		Log.d(TAG,"endElement: "+uri+","+localName+","+qName);
		Log.d(TAG,"value: "+getCharValue());
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}

	/**
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
//		Log.d(TAG,"characters: "+start+","+length+","+String.valueOf(ch,start,length));
		
		if(length == 1 && ch[start] == '\n'){
			mCharBuffer.append(ch[start]);
		}
		else{
//		mCharBuffer.append(ch, start, length);
		mCharBuffer.append(String.valueOf(ch, start, length).trim());
		}
	}

	/**
	 * @see org.xml.sax.helpers.DefaultHandler#resolveEntity(java.lang.String, java.lang.String)
	 */
	@Override
	public InputSource resolveEntity(String publicId, String systemId)
			throws IOException, SAXException {
		Log.d(TAG,"resolveEntity: "+publicId+","+systemId);
		// TODO Auto-generated method stub
		return super.resolveEntity(publicId, systemId);
	}

	/**
	 * @see org.xml.sax.helpers.DefaultHandler#warning(org.xml.sax.SAXParseException)
	 */
	@Override
	public void warning(SAXParseException e) throws SAXException {
		Log.d(TAG,"warning");
		e.printStackTrace();
		// TODO Auto-generated method stub
		super.warning(e);
	}

	/**
	 * @see org.xml.sax.helpers.DefaultHandler#error(org.xml.sax.SAXParseException)
	 */
	@Override
	public void error(SAXParseException e) throws SAXException {
		Log.d(TAG,"error");
		e.printStackTrace();
		// TODO Auto-generated method stub
		super.error(e);
	}

	/**
	 * @see org.xml.sax.helpers.DefaultHandler#fatalError(org.xml.sax.SAXParseException)
	 */
	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		Log.d(TAG,"fatalError");
		e.printStackTrace();
		// TODO Auto-generated method stub
		super.fatalError(e);
	}
	
	protected String getCharValue(){
		return mCharBuffer.toString().trim();
	}

	protected void clearCharBuffer(){
		mCharBuffer = null;
		mCharBuffer = new StringBuffer();
	}

}
