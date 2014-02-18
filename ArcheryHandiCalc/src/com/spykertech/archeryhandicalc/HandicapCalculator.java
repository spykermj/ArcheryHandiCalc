package com.spykertech.archeryhandicalc;

public class HandicapCalculator {

	public static double yardsToMeters(double yards) {
		return yards * 0.9144;
	}

	public static double getRMS(double handicap, double range, boolean rangeIsMeters) {
		if(!rangeIsMeters){
			range = yardsToMeters(range);
		}
		return 100 * range * Math.pow(1.036, (handicap + 12.9)) * 5 * (Math.pow(10.0, -4.0)) * (1 + 1.429 * Math.pow(10.0, -6.0) * Math.pow(1.07, (handicap + 4.3)) * Math.pow(range, 2));
	}

	public static double getFITATenZoneAverageScore(double handicap, double range, double faceDiameter, boolean rangeIsMeters) {
		double sum = 0;
		double rms = getRMS(handicap, range, rangeIsMeters);
		for(int i=1; i<=10; i++) {
			sum += Math.exp(-Math.pow((i * faceDiameter / 20 + 0.357), 2) / Math.pow(rms, 2));
		}
		return 10 - sum;
	}

	public static double getImperialAverageScore(double handicap, double range, double faceDiameter, boolean rangeIsMeters) {
		double sum = 0;
		double rms = getRMS(handicap, range, rangeIsMeters);
		for(int i=1; i<=4; i++){
			sum += Math.exp(-Math.pow(i * faceDiameter / 10 + 0.357, 2) / Math.pow(rms, 2));
		}
		return 9 - 2 * sum - Math.exp(-Math.pow(faceDiameter / 2 + 0.357, 2) / Math.pow(rms, 2));
	}

	public static double getFITAFiveZoneAverageScore(double handicap, double range, double faceDiameter, boolean rangeIsMeters) {
		double sum = 0;
		double rms = getRMS(handicap, range, rangeIsMeters);
		for(int i=1; i<=4; i++){
			sum += Math.exp(-Math.pow(i * faceDiameter / 20 + 0.357, 2) / Math.pow(rms, 2));
		}
		return 10 - sum - 6 * Math.exp(-Math.pow(5 * faceDiameter / 20 + 0.357, 2));
	}

	public static double getWorcesterAverageScore(double handicap, double range, double faceDiameter, boolean rangeIsMeters) {
		double sum = 0;
		double rms = getRMS(handicap, range, rangeIsMeters);
		for(int i=1; i<=5; i++){
			sum += Math.exp(-Math.pow(i * faceDiameter / 10 + 0.357, 2) / Math.pow(rms, 2));
		}
		return 5 - sum;
	}

	public static double getFITAInnerTenAverageScore(double handicap, double range, double faceDiameter, boolean rangeIsMeters) {
		double sum = 0;
		double rms = getRMS(handicap, range, rangeIsMeters);
		for(int i=2; i<=10; i++) {
			sum += Math.exp(-Math.pow(i * faceDiameter / 20 + 0.357, 2) / Math.pow(rms, 2));
		}
		return 10 - Math.exp(-Math.pow(faceDiameter / 40 + 0.357, 2) / Math.pow(rms, 2)) - sum;
	}

	public static double getFiveZoneInnerTenAverageScore(double handicap, double range, double faceDiameter, boolean rangeIsMeters) {
		double sum = 0;
		double rms = getRMS(handicap, range, rangeIsMeters);
		for(int i=2; i<=4; i++) {
			sum += Math.exp(-Math.pow(i * faceDiameter / 20 + 0.357, 2) / Math.pow(rms, 2));
		}
		return 10 - Math.exp(-Math.pow(faceDiameter / 40 + 0.357, 2) / Math.pow(rms, 2)) - sum - 6 * Math.exp(-Math.pow(5 * faceDiameter / 20 + 0.357, 2) / Math.pow(rms, 2));
	}
}
