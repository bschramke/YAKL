/**
 * Copyright 2012 Björn Schramke - http://www.coolbytes.de/
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.coolbytes.android.yakl.kml;

/** The KmlPlacemark is a feature with associated Geometry.
 * 
 * @author Björn Schramke
 *
 * @version 19.10.2012 Class created
 */
public class KmlPlacemark extends KmlFeature {

	private KmlGeometry mGeometry = null;
	
	/**
	 * 
	 */
	public KmlPlacemark() {
		super();
	}

	/**
	 * 
	 */
	public KmlPlacemark(String id) {
		super(id);
	}

	/**
	 * @return the geometry
	 */
	public KmlGeometry getGeometry() {
		return mGeometry;
	}

	/**
	 * @param geometry the geometry to set
	 */
	public void setGeometry(KmlGeometry geometry) {
		this.mGeometry = geometry;
	}

}
