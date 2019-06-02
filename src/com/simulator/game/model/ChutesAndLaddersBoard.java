/**
 * 
 */
package com.simulator.game.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SWAPNIL
 *
 */
public class ChutesAndLaddersBoard {
	
	public static final Map<Integer,Integer> ladders = new HashMap<>();
	public static final Map<Integer,Integer> chutes = new HashMap<>();
	
	static {
		
		ladders.put(1, 38);
		ladders.put(4, 14);
		ladders.put(9, 31);
		ladders.put(21, 42);
		ladders.put(28, 84);
		ladders.put(36, 44);
		ladders.put(51, 67);
		ladders.put(71, 91);
		ladders.put(80, 100);
		
		
		chutes.put(16, 6);
		chutes.put(49, 11);
		chutes.put(62, 19);
		chutes.put(87, 24);
		chutes.put(47, 26);
		chutes.put(56, 53);
		chutes.put(64, 60);
		chutes.put(93, 73);
		chutes.put(95, 75);
		chutes.put(98, 78);
	}
	
	public int lookUpLadders(int currentPosition){
		return ladders.getOrDefault(currentPosition, currentPosition);
	}
	
	public int lookUpChutes(int currentPosition){
		return chutes.getOrDefault(currentPosition, currentPosition);
	}

}
