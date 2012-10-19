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

/** A KmlDocument has containers that holds features and styles.
 * This container is required if you use shared styles. 
 * It is recommended that you use shared styles, which require the following.
 * 
 * <ul>
 *   <li>Define all Styles in a Document. Assign a unique ID to each Style.</li>
 *   <li>Within a given feature or StyleMap, reference the Style's ID using a styleUrl element.</li>
 * </ul>
 *  
 * @author Björn Schramke
 *
 * @version 19.10.2012 Class created
 */
public class KmlDocument extends KmlContainer {

	/**
	 * 
	 */
	public KmlDocument() {
		super();
	}

}
