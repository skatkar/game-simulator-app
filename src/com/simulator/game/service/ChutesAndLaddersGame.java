/**
 * 
 */
package com.simulator.game.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.simulator.game.model.ChutesAndLaddersBoard;
import com.simulator.game.model.Player;
import com.simulator.game.model.Spinner;
import com.simulator.game.util.GameUtils;
import com.simulator.game.util.ChutesAndLaddersValues;

/**
 * Logic to support the functionalities for Chutes and Ladders game
 * @author SWAPNIL
 *
 */
public class ChutesAndLaddersGame implements Game{

	private static ChutesAndLaddersGame instance;
	private static Spinner spinner = new Spinner();
	private static ChutesAndLaddersBoard board = new ChutesAndLaddersBoard();
	
	private ChutesAndLaddersGame() {
	};

	// Creates the singleton instance
	public static ChutesAndLaddersGame getInstance() {
		if (instance == null){
			//System.out.println("Creating instance");
			instance = new ChutesAndLaddersGame();
		}
		return instance;
	}

	
	/**
	 * Game play logic
	 * @param players
	 * @return winner name
	 */
	public String playGame(List<Player> players) {
		boolean isWinnerFound = false;
		int turnCount = 0;
		String winner = null;

		while (!isWinnerFound) {
			for (Player player : players) {
				turnCount++;
				int newPosition = player.getCurrentPosition() + spinner.getSpin();

				// New position is going beyond HOME position, so retry
				if (newPosition > ChutesAndLaddersValues.HOME_POSITION.getValue()) {
					continue;
				} else {
					System.out.print(turnCount + ": " + player.getPlayerName() + ": " + player.getCurrentPosition()
							+ " --> " + newPosition);
					newPosition = lookupNewPositionOnBoard(newPosition);
					player.setCurrentPosition(newPosition);
					System.out.println();
				}

				// Check whether the player is a winner or not
				if(isPlayerWinner(player)){
					winner = player.getPlayerName();
					isWinnerFound = true;
					break;
				}

			}
		}
		
		return winner;
	}

	/**
	 * Checks whether the player is a winner or not
	 * @param player
	 * @return is winner or not
	 */
	private boolean isPlayerWinner(Player player) {
		return player.getCurrentPosition() == ChutesAndLaddersValues.HOME_POSITION.getValue();
	}

	/**
	 * Returns a new position the board. It checks whether is there any
	 * ladder/chute at a current position
	 * 
	 * @param newPosition
	 * @return new position based on ladder/chute/neither of them
	 */
	private int lookupNewPositionOnBoard(int newPosition) {

		// Lookup is there any ladder at the new position
		// If it is there, rise to the end of ladder
		// Else be there
		int ladderPosition = board.lookUpLadders(newPosition);
		if (ladderPosition != newPosition) {
			System.out.print(" --LADDER--> " + ladderPosition);
			newPosition = ladderPosition;
		}

		// Lookup is there any chute at the new position
		// If it is there, slide to the new position
		// Else be there
		int chutePosition = board.lookUpChutes(newPosition);
		if (chutePosition != newPosition) {
			System.out.print(" --CHUTE--> " + chutePosition);
			newPosition = chutePosition;
		}
		return newPosition;
	}

	/**
	 * Sets up all players. Whoever gets the high value of spin will be the first one to start the game
	 * @param playerNames
	 * @return list of players in the sorted order
	 */
	public List<Player> setUpPlayers(String[] playerNames) {

		List<Player> players = new ArrayList<>();
		Set<Integer> spinValues = new HashSet<>();

		for (int i = 0; i < playerNames.length; i++) {
			Player player = new Player(i + 1, playerNames[i]);

			int spinValue = GameUtils.spin();

			while (spinValues.contains(spinValue)) {
				// System.out.println("Duplicate value. "+ spinValue + " So
				// doing it again");
				spinValue = GameUtils.spin();
			}
			spinValues.add(spinValue);

			player.setSpinValue(spinValue);
			players.add(player);
		}
		Collections.sort(players);
		return players;
	}
}
