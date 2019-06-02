/**
 * 
 */
package com.candidate.chutesladders;

import java.util.List;

import com.simulator.game.exception.GameException;
import com.simulator.game.factory.GameFactory;
import com.simulator.game.model.Player;
import com.simulator.game.service.Game;
import com.simulator.game.util.ChutesAndLaddersValues;

/**
 * The starting point of the application
 * 
 * @author SWAPNIL
 *
 */
public class ChutesAndLadders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] playerNames;
				
		try {
			playerNames = getPlayerNames(args);
			
			Game game = GameFactory.getGame("chutesNLadders");
			List<Player> players = game.setUpPlayers(playerNames);
			System.out.println("The Winner is " + game.playGame(players) + "!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

		

	}

	/**
	 * Collect the player names from the command line otherwise return default names
	 * @param args
	 * @return Array of player names
	 * @throws GameException
	 */
	private static String[] getPlayerNames(String[] args) throws Exception {
		String[] playerNames = { "Player 1", "Player 2", "Player 3", "Player 4" };
		try {

			if (args.length > 0 && args.length < ChutesAndLaddersValues.MIN_NO_PLAYERS.getValue()) 
				throw new GameException("At least two players are required to start the game");
			else if(args.length != 0)
				playerNames = args;
		} catch (Exception ex) {
			throw ex;
		}
		return playerNames;
	}

}
