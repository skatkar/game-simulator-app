/**
 * 
 */
package com.simulator.game.model;

import com.simulator.game.util.GameUtils;

/**
 * Spinner model
 * @author SWAPNIL
 *
 */
public class Spinner {

	/**
	 * Method to get the spinner value
	 * @return spin value
	 */
	public int getSpin(){
		return GameUtils.spin();
	}
}
