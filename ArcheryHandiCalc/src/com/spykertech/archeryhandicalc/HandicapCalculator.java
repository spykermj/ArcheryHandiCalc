package com.spykertech.archeryhandicalc;

public class HandicapCalculator {

	public static double yardsToMeters(double yards) {
		return yards * 0.9144;
	}

	public static double getRMS(int handicap, int range, boolean rangeIsYards) {
		double dRange = range;
		double dHandicap = handicap;
		if(rangeIsYards){
			dRange = yardsToMeters(range);
		}
		//  100 * range * 1.036^(handicap + 12.9) * 5 * (10^-4) * (1 + 1.429 * 10^-6 * 1.07^(handicap + 4.3) * range^2)
		return 100 * dRange * Math.pow(1.036, (dHandicap + 12.9)) * 5 * (Math.pow(10.0, -4.0)) * (1 + 1.429 * Math.pow(10.0, -6.0) * Math.pow(1.07, (dHandicap + 4.3)) * Math.pow(dRange, 2));
	}
}
