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

/** The base class for all the other KML related objects
 * The methods and behavior of KMLObject are inherited by all other objects. 
 * This is an abstract base class and cannot be used directly. 
 * It provides the id attribute, which allows unique identification of an object.
 * 
 * @author Björn Schramke
 *
 * @version 19.10.2012 Class created
 */
public abstract class KmlObject {
	
	public static final int DEFAULT = 0;
	public static final int HIDE = 1;
	public static final int NORMAL = 2;
	public static final int RANDOM = 3;
		
	private final String mId;
	private String mTargetId;
	
	/**
	 * the default constructor
	 */
	public KmlObject() {
		this(null);
	}
	
	/** 
	 * @param id
	 */
	public KmlObject(String id) {		
		mId = id;
	}
	
	public String getId(){
		return mId;
	}
	
	protected abstract void setValue(String localName,int localNameHash,String value);
}
