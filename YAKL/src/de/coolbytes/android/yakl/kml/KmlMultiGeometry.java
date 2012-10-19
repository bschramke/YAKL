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

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

/** A container for zero or more geometry primitives associated with the same feature.
 * 
 * @author Björn Schramke
 *
 * @version 19.10.2012 Class created
 */
public class KmlMultiGeometry extends KmlGeometry {

	private static final String TAG = KmlMultiGeometry.class.getSimpleName();
	private static int mCounter = 0;
	private List<KmlGeometry> mChilds = null;
	/**
	 * 
	 */
	public KmlMultiGeometry() {
		this(null);
	}

	/**
	 * @param id
	 */
	public KmlMultiGeometry(String id) {
		super(id);
		this.mChilds = new ArrayList<KmlGeometry>();
	}

	/* (non-Javadoc)
	 * @see de.init.android.maps.kml.KmlObject#setValue(java.lang.String, int, java.lang.String)
	 */
	@Override
	protected void setValue(String localName, int localNameHash, String value) {
		//nothing to do
	}
	
	public void addGeometry(KmlGeometry obj){
		mChilds.add(obj);
	}
	
	public List<KmlGeometry> getGeometry(){
		return mChilds;
	}
	
	public KmlGeometry getGeometry(int index) throws IndexOutOfBoundsException{
		return mChilds.get(index);
	}
	
	public int count(){
		return mChilds.size();
	}

}
