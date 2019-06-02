/**
 * 
 */
package com.simulator.game.util;

import java.util.Random;

/**
 * Class for utility methods
 * @author SWAPNIL
 *
 */
public class GameUtils {

	public static int spin(){
		return generateRandomNum(ChutesAndLaddersValues.SPIN_MIN.getValue(), ChutesAndLaddersValues.SPIN_MAX.getValue());
	}

	private static int generateRandomNum(int min,int max) {
		int randomNumber;
		Random random = new Random();
		randomNumber = random.nextInt(max) + min;
		
		return randomNumber;
	}
}
