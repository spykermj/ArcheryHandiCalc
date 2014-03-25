package com.spykertech.archeryhandicalc;

import java.util.ArrayList;
import java.util.List;

public class Round implements Comparable<Round> {
	
	private String name;
	private List<Distance> distances = new ArrayList<Distance>();
	private int[] handicapTable = null;
	
	public Round(String roundName) {
		name = roundName;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}

	public void addDistance(Distance dist) {
		distances.add(dist);
	}

	public List<Distance> getDistances() {
		return distances;
	}

	public int getHandicapScore(int handicap) {
		double scoreSum = 0;
		for(Distance distance:distances){
			scoreSum += distance.getHandicapScore(handicap);
		}
		return (int) Math.round(scoreSum);
	}

	public int[] getHandicapTable() {
		if(null == handicapTable) {
			handicapTable = new int[101];
			for(int i = 0; i < 101; i++) {
				handicapTable[i] = this.getHandicapScore(i);
			}
		}
		return handicapTable;
	}

	public int lookupHandicap(int score) {
		int[] table = this.getHandicapTable();
		int handicap = -1;
		for(int i=100; i>=0 && score >= table[i]; i--) {
			handicap = i;
			if(score == table[i]) {
				break;
			}
		}
		return handicap;
	}

	@Override
	public int compareTo(Round another) {
		return this.getName().compareTo(another.getName());
	}
}
