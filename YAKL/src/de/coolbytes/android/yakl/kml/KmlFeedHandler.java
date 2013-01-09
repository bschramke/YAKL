/**
 * 
 */
package de.coolbytes.android.yakl.kml;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import de.coolbytes.android.yakl.XmlFeedHandler;

import android.util.Log;

/**
 * @author bschramke
 * 
 */
public class KmlFeedHandler extends XmlFeedHandler {
	private static final String TAG = KmlFeedHandler.class.getSimpleName();

	public static final int TAG_KML_HASH = 0x19f4a;
	public static final int TAG_PLACEMARK_HASH = 0x6ade0454;
	public static final int TAG_NAME_HASH = 0x337a8b;
	public static final int TAG_DESCRIPTION_HASH = 0x993583fc;
	public static final int TAG_COORDINATES_HASH = 0x6f9339fb;
	public static final int TAG_POINT_HASH = 0x65e5590;
	public static final int TAG_DOCUMENT_HASH = 0x335cd11b;
	public static final int TAG_VISIBILITY_HASH = 0x73b66312;
	public static final int TAG_STYLE_HASH = 0x68b1db1;
	public static final int TAG_POLYSTYLE_HASH = 0xeb98565;
	public static final int TAG_COLOR_HASH = 0x5a72f63;
	public static final int TAG_COLORMODE_HASH = 0x761dff86;
	public static final int TAG_BALLOONSTYLE_HASH = 0xb539eee2;
	public static final int TAG_BGCOLOR_HASH = 0xf58d063e;
	public static final int TAG_TEXTCOLOR_HASH = 0xc25e1e56;
	public static final int TAG_POLYGON_HASH = 0xe84e553a;
	public static final int TAG_OUTERBOUNDARYIS_HASH = 0x4d9e958f;
	public static final int TAG_INNERBOUNDARYIS_HASH = 0x6e576daa;
	public static final int TAG_LINEARRING_HASH = 0xca5ded5;
	public static final int TAG_ALTITUDEMODE_HASH = 0x2bcc6345;
	public static final int TAG_SNIPPET_HASH = 0x851df11d;
	public static final int TAG_ICONSTYLE_HASH = 0xae39c4d8;
	public static final int TAG_LISTSTYLE_HASH = 0x9ec8d73d;
	public static final int TAG_LABELSTYLE_HASH = 0xb8241fd3;
	public static final int TAG_LINESTYLE_HASH = 0x960c463d;
	public static final int TAG_TEXT_HASH = 0x36452d;
	public static final int TAG_FILL_HASH = 0x2ff583;
	public static final int TAG_OUTLINE_HASH = 0xbe100842;
	public static final int TAG_MULTIGEOMETRY_HASH = 0xd1d694ab;

	private Stack<KmlObject> mObjects;
	private List<KmlObject> mData;
	private Stack<KmlLinearRing> mBoundaryCach;
	private boolean mInBoundary = false;

	/**
	 * 
	 */
	public KmlFeedHandler() {

		mObjects = new Stack<KmlObject>();
		mData = new ArrayList<KmlObject>();
		mBoundaryCach = new Stack<KmlLinearRing>();
	}

	public List<KmlObject> getData(){
		return mData;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see de.init.android.xml.XmlFeedHandler#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {
		mObjects.clear();
		super.startDocument();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.init.android.xml.XmlFeedHandler#endDocument()
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	/**
	 * @see de.init.android.xml.XmlFeedHandler#startElement(java.lang.String,
	 *      java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String namespace, String localName, String qName,
			Attributes attributes) throws SAXException {

		clearCharBuffer();
		final int localNameHash = localName.toLowerCase().hashCode();
		
		if (localNameHash == TAG_KML_HASH) {
			mObjects.clear();
			mData.clear();
			Log.d(TAG, "start kml tag ");
		}
		else if (localNameHash == TAG_OUTERBOUNDARYIS_HASH
				|| localNameHash == TAG_INNERBOUNDARYIS_HASH) {
			mInBoundary = true;
			mBoundaryCach.clear();
		}
		else if(isFeatureElement(localNameHash)){
			startFeatureElement(namespace, localName, localNameHash, qName, attributes);
		}
		else if(isGeometryElement(localNameHash)){
			startGeometryElement(namespace, localName, localNameHash, qName, attributes);
		}
		else if(isStyleElement(localNameHash)){
			startStyleElement(namespace, localName, localNameHash, qName, attributes);
		}
		else{
		}

	}

	/**
	 * @see de.init.android.xml.XmlFeedHandler#endElement(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String namespace, String localName, String qName)
			throws SAXException {

		final int localNameHash = localName.toLowerCase().hashCode();

		if (localNameHash == TAG_KML_HASH) {
			Log.d(TAG, "end kml tag ");
		}
		else if (localNameHash == TAG_OUTERBOUNDARYIS_HASH) {
			
			//<outerBoundaryIs> is only valid in <Polygon>
			KmlPolygon obj = (KmlPolygon) mObjects.peek();
			obj.setOuterBoundaryIs(mBoundaryCach.pop());
			
			mInBoundary = false;
		}
		else if (localNameHash == TAG_INNERBOUNDARYIS_HASH) {
			
			//<innerBoundaryIs> is only valid in <Polygon>
			KmlPolygon obj = (KmlPolygon) mObjects.peek();
			obj.setInnerBoundaryIs(mBoundaryCach.subList(0, mBoundaryCach.size()));
			mBoundaryCach.clear();
			
			mInBoundary = false;
		}
		else if(isFeatureElement(localNameHash)){
			endFeatureElement(namespace, localName, localNameHash, qName);
		}
		else if(isGeometryElement(localNameHash)){
			endGeometryElement(namespace, localName, localNameHash, qName);
		}
		else if(isStyleElement(localNameHash)){
			endStyleElement(namespace, localName, localNameHash, qName);
		}
		else{ 
			if (!mObjects.isEmpty()){
				KmlObject obj = mObjects.peek();
				obj.setValue(localName, localNameHash, getCharValue());
			}
		}
		
	}
	
	protected boolean isFeatureElement(int localNameHash){
		
		return (localNameHash == TAG_PLACEMARK_HASH 
				|| localNameHash == TAG_DOCUMENT_HASH);
	}

	protected boolean isGeometryElement(int localNameHash){
		
		return (localNameHash == TAG_POINT_HASH 
				|| localNameHash == TAG_LINEARRING_HASH
				|| localNameHash == TAG_POLYGON_HASH
				|| localNameHash == TAG_MULTIGEOMETRY_HASH);
	}

	protected boolean isStyleElement(int localNameHash){
		
		return (localNameHash == TAG_STYLE_HASH 
				|| localNameHash == TAG_POLYSTYLE_HASH
				|| localNameHash == TAG_BALLOONSTYLE_HASH);
	}

	public void startFeatureElement(String namespace, String localName, int localNameHash, String qName,
			Attributes attributes) throws SAXException {

		switch(localNameHash){
			case TAG_DOCUMENT_HASH:
				mObjects.push(new KmlDocument());
				break;
			case TAG_PLACEMARK_HASH:
				mObjects.push(new KmlPlacemark());
				break;
		}

	}

	protected void endFeatureElement(String namespace, String localName, int localNameHash,
			String qName) throws SAXException {
		
			KmlFeature obj = (KmlFeature) mObjects.pop();
			
			if(mObjects.empty()){
				mData.add(obj);
				return;
			}
			
			KmlContainer container = (KmlContainer) mObjects.peek();
			container.addFeature(obj);

	}

	public void startGeometryElement(String namespace, String localName, int localNameHash, String qName,
			Attributes attributes) throws SAXException {

		switch(localNameHash){
			case TAG_POINT_HASH:
				mObjects.push(new KmlPoint());
				break;
			case TAG_LINEARRING_HASH:
				mObjects.push(new KmlLinearRing());
				break;
			case TAG_POLYGON_HASH:
				mObjects.push(new KmlPolygon());
				break;
			case TAG_MULTIGEOMETRY_HASH:
				mObjects.push(new KmlMultiGeometry());
				break;
		}

	}

	protected void endGeometryElement(String namespace, String localName, int localNameHash,
			String qName) throws SAXException {
		
			KmlGeometry geometry = (KmlGeometry) mObjects.pop();
			
			if(mInBoundary){
				if(geometry instanceof KmlLinearRing){
					mBoundaryCach.push((KmlLinearRing) geometry);
				}
			}
			else{
				KmlObject obj = mObjects.peek();
				if(obj instanceof KmlPlacemark){
					((KmlPlacemark)obj).setGeometry(geometry);
				}else if(obj instanceof KmlMultiGeometry){
					((KmlMultiGeometry)obj).addGeometry(geometry);
				}
			}

	}

	public void startStyleElement(String namespace, String localName, int localNameHash, String qName,
			Attributes attributes) throws SAXException {
		
		String id = attributes.getValue("id");
		
		switch(localNameHash){
			case TAG_STYLE_HASH:
				mObjects.push(new KmlStyle(id));
				break;
			case TAG_POLYSTYLE_HASH:
				mObjects.push(new KmlPolyStyle(id));
				break;
			case TAG_BALLOONSTYLE_HASH:
				mObjects.push(new KmlBaloonStyle(id));
				break;
			case TAG_ICONSTYLE_HASH:
				mObjects.push(new KmlIconStyle(id));
				break;
			case TAG_LABELSTYLE_HASH:
				mObjects.push(new KmlLabelStyle(id));
				break;
			case TAG_LISTSTYLE_HASH:
				mObjects.push(new KmlListStyle(id));
				break;
			case TAG_LINESTYLE_HASH:
				mObjects.push(new KmlLineStyle(id));
				break;
		}

	}

	protected void endStyleElement(String namespace, String localName, int localNameHash,
			String qName) throws SAXException {
		
		if (mObjects.isEmpty()) return;

		KmlObject obj = mObjects.pop();
		
		if(mObjects.isEmpty()){
			mData.add(obj);
			return;
		}
		
		KmlObject parent = mObjects.peek();
		
		if(parent instanceof KmlStyle && obj instanceof KmlSubStyle){
			((KmlStyle)parent).setSubStyle((KmlSubStyle) obj);
		}
		
	}

}
