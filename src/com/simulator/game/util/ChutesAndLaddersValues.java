/**
 * 
 */
package com.simulator.game.util;

/**
 * Enum for various values that can be used in this application
 * @author SWAPNIL
 *
 */
public enum ChutesAndLaddersValues {

	MAX_NO_OF_PLAYERS(4),
	MIN_NO_PLAYERS(2),
	HOME_POSITION(100),
	SPIN_MAX(6),
	SPIN_MIN(1);
	
	private int value;
	
	ChutesAndLaddersValues(int value){
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
		
}
