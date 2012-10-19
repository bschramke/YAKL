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

/** The KmlFeature object is an abstract object and is the base for all feature types (for example Placemarks, Overlays, and NetworkLinks).
 * 
 * @author Björn Schramke
 *
 * @version 19.10.2012 Class created
 */
public abstract class KmlFeature extends KmlObject {
	
	public static final int TAG_HASH_NAME = 0x337a8b;
	public static final int TAG_HASH_VISIBILITY = 0x73b66312;
	public static final int TAG_HASH_DESCRIPTION = 0x993583fc;

	private String mName = null;
	private boolean mVisibility = true;
	private boolean mOpen = true;
	private String mAdress = null;
	private String mPhoneNumber = null;
	private String mSnippet = null;
	private String mDescription = null;
	private KmlAbstractView mViewpoint = null;
	private KmlTimePrimitive mTime = null;
	
	/**
	 * 
	 */
	public KmlFeature() {
		super();
	}

	/**
	 * 
	 */
	public KmlFeature(String id) {
		super(id);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return mName;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.mName = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return mDescription;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.mDescription = description;
	}

	/**
	 * @return the description
	 */
	public boolean isVisibile() {
		return mVisibility;
	}

	/**
	 * @param 
	 */
	public void setVisibility(boolean value) {
		this.mVisibility = value;
	}

	/**
	 * @param 
	 */
	public void setVisibility(String value) {
		try{
			int tmp = Integer.valueOf(value);
			setVisibility(tmp > 0);										
		}catch(NumberFormatException e){
			setVisibility(Boolean.valueOf(value));					
		}
	}

	/**
	 * @return the description
	 */
	public boolean isOpen() {
		return mOpen;
	}

	/**
	 * @param 
	 */
	public void setOpen(boolean value) {
		this.mOpen = value;
	}

	/**
	 * @param 
	 */
	public void setOpen(String value) {
		try{
			int tmp = Integer.valueOf(value);
			setOpen(tmp > 0);										
		}catch(NumberFormatException e){
			setOpen(Boolean.valueOf(value));					
		}
	}

	@Override
	protected void setValue(String localName, int localNameHash, String value) {
		
		switch(localNameHash){
			case TAG_HASH_NAME:
				setName(value);
				break;
			case TAG_HASH_VISIBILITY:
				setDescription(value);
				break;
			case TAG_HASH_DESCRIPTION:
				setVisibility(value);
				break;
		}
		
	}

}
