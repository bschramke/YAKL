/**
 * 
 */
package de.coolbytes.android.yakl.kml;

import java.io.IOException;

/**
 * @author bschramke
 *
 */
public class MalformedKMLException extends IOException {

	/**
	 * replace this with a short description of these field
	 */
	private static final long serialVersionUID = 1951575046717952429L;

	/**
	 * 
	 */
	public MalformedKMLException() {
		super();
	}

	/**
	 * @param detailMessage
	 */
	public MalformedKMLException(String detailMessage) {
		super(detailMessage);
	}

}
