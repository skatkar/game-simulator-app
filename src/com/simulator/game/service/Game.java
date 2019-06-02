/**
 * 
 */
package com.simulator.game.service;

import java.util.List;

import com.simulator.game.model.Player;

/**
 * @author SWAPNIL
 *
 */
public interface Game {

	public List<Player> setUpPlayers(String[] playerNames);
	public String playGame(List<Player> players);
}
