/**
 * 
 */
package com.simulator.game.model;

/**
 * Player model
 * @author SWAPNIL
 *
 */
public class Player implements Comparable<Player>{

	private int playerNumber;
	private String playerName;
	private int currentPosition;
	private int spinValue;
	
	public Player(int playerNumber, String playerName) {
		this.playerNumber = playerNumber;
		this.playerName = playerName;
		this.currentPosition = 0;
		this.spinValue = 0;
	}

	
	public void setSpinValue(int spinValue){
		this.spinValue = spinValue;
	}
	
	public void setCurrentPosition(int currentPosition){
		this.currentPosition = currentPosition;
	}
	
	/**
	 * @return the playerNumber
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @return the currentPosition
	 */
	public int getCurrentPosition() {
		return currentPosition;
	}

	/**
	 * @return the spinValue
	 */
	public int getSpinValue() {
		return spinValue;
	}

	@Override
	public int compareTo(Player player) {
		if(this.spinValue == player.spinValue)
			return 0;
		else if(this.spinValue > player.spinValue)
			return -1;
		return 1;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nPlayer [playerNumber=" + playerNumber + ", playerName=" + playerName + ", currentPosition="
				+ currentPosition + ", spinValue=" + spinValue + "]";
	}
	
	
	
}
