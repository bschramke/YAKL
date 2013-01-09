package de.coolbytes.android.yakl.kml;

import java.util.ArrayList;
import java.util.List;

/** A Polygon is defined by an outer boundary and 0 or more inner boundaries. The boundaries, in turn, are defined by LinearRings.
 * 
 * @detail 
 * @author Björn Schramke
 * @date 22.08.2012
 *
 * @version 22.08.2012 Klasse erstellt
 */
public class KmlPolygon extends KmlGeometry {

	private static int mCounter = 0;
	private KmlLinearRing mOuterBoundaryIs = null;
	private List<KmlLinearRing> mInnerBoundaryIs = new ArrayList<KmlLinearRing>();

	/**
	 * 
	 */
	public KmlPolygon() {
		super();
	}

	/**
	 * 
	 */
	public KmlPolygon(String id) {
		super(id);
	}

	/* (non-Javadoc)
	 * @see de.init.android.xml.kml.KmlObject#setValue(java.lang.String, int, java.lang.String)
	 */
	@Override
	protected void setValue(String localName, int localNameHash, String value) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the OuterBoundaryIs
	 */
	public KmlLinearRing getOuterBoundaryIs() {
		return mOuterBoundaryIs;
	}

	/**
	 * @param linearRing the OuterBoundaryIs to set
	 */
	public void setOuterBoundaryIs(KmlLinearRing linearRing) {
		this.mOuterBoundaryIs = linearRing;
	}

	/**
	 * @return the InnerBoundaryIs
	 */
	public List<KmlLinearRing> getInnerBoundaryIs() {
		return mInnerBoundaryIs;
	}

	/** You can specify multiple innerBoundary properties, which create multiple cut-outs inside the Polygon.
	 * @param linearRings the InnerBoundaryIs to set
	 */
	public void setInnerBoundaryIs(List<KmlLinearRing> linearRings) {
		mInnerBoundaryIs.addAll(linearRings);
	}
	
	/** You can specify multiple innerBoundary properties, which create multiple cut-outs inside the Polygon.
	 * @param mInnerBoundaryIs the InnerBoundaryIs to set
	 */
	public void addInnerBoundaryIs(KmlLinearRing linearRing) {
		this.mInnerBoundaryIs.add(linearRing);
	}
	
	

}
