/**
 * 
 */
package com.simulator.game.factory;

import com.simulator.game.service.ChutesAndLaddersGame;
import com.simulator.game.service.Game;

/**
 * Factory class
 * @author SWAPNIL
 *
 */
public class GameFactory {

	/**
	 * Factory method
	 * @param gameType
	 * @return correct game instance
	 * @throws Exception
	 */
	public static Game getGame(String gameType) throws Exception {

		switch (gameType) {
		case "chutesNLadders":
			return ChutesAndLaddersGame.getInstance();
		default:
			throw new Exception("Invalid selection");

		}
	}
}
