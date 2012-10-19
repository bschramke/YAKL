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
import java.util.Iterator;
import java.util.List;

/** An abstract object and cannot be used directly. 
 *  A KmlContainer object holds one or more features and allows the creation of nested hierarchies.
 *  
 * @author Björn Schramke
 *
 * @version 19.10.2012 Class created
 */
public abstract class KmlContainer extends KmlFeature {

	List<KmlFeature> mFeatures = new ArrayList<KmlFeature>();
	
	/**
	 * 
	 */
	public KmlContainer() {
		super();
	}

	/**
	 * @return A collection of features, such as name, description, and so on.
	 */
	public List<KmlFeature> getFeatures() {
		return mFeatures;
	}

	/**
	 * @return A collection of features matching the given class
	 */
	public List<? extends KmlFeature> getFeatures(Class<? extends KmlFeature> cls) {
		Iterator<KmlFeature> iter = mFeatures.iterator();
		List<KmlFeature> list = new ArrayList<KmlFeature>();
		
		while(iter.hasNext()){
			KmlFeature tmp = iter.next();
			if (cls.isInstance(tmp)){
				list.add(tmp);
			}
		}
		
		return list;
	}
	
	/**
	 * @return A collection of placemarks
	 */
	public List<KmlPlacemark> getPlacemarks() {
		return (List<KmlPlacemark>) getFeatures(KmlPlacemark.class);
	}
	

	/**
	 * @param features the features to set
	 */
	public void addFeature(KmlFeature feature) {
		this.mFeatures.add(feature);
	}

}
