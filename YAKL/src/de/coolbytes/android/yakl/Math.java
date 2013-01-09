/**
 * 
 */
package de.coolbytes.android.yakl;

/**
 * @author Björn Schramke
 *
 */
public class Math {

	/**
	 * 
	 */
	private Math() {
		// TODO Auto-generated constructor stub
	}
	
	public static float clamp(float value,float min, float max){
		return java.lang.Math.max(min,java.lang.Math.min(max,value));
	}

}
