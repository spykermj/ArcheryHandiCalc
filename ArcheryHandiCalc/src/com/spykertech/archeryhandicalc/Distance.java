package com.spykertech.archeryhandicalc;


public class Distance {
	private double range;
	private TargetFace face;
	private ScoringStyle style;
	private boolean isMetric;
	private int arrows;

	public Distance(double range, TargetFace face, ScoringStyle style, boolean isMetric, int arrows) {
		this.range = range;
		this.face = face;
		this.style = style;
		this.isMetric = isMetric;
		this.arrows = arrows;
	}

	public double getHandicapScore(int handicap) {
		double score;
		switch (style) {
		case TEN_ZONE:
			score = this.arrows * HandicapCalculator.getFITATenZoneAverageScore(handicap, this.range, this.face.getDiameter(), this.isMetric);
			break;
		case FIVE_ZONE:
			score = this.arrows * HandicapCalculator.getFITAFiveZoneAverageScore(handicap, this.range, this.face.getDiameter(), this.isMetric);
			break;
		case FIVE_ZONE_COMPOUND:
			score = this.arrows * HandicapCalculator.getFiveZoneInnerTenAverageScore(handicap, this.range, this.face.getDiameter(), this.isMetric);
			break;
		case IMPERIAL:
			score = this.arrows * HandicapCalculator.getImperialAverageScore(handicap, this.range, this.face.getDiameter(), this.isMetric);
			break;
		case TEN_ZONE_COMPOUND:
			score = this.arrows * HandicapCalculator.getFITAInnerTenAverageScore(handicap, this.range, this.face.getDiameter(), this.isMetric);
			break;
		case WORCESTER:
			score = this.arrows * HandicapCalculator.getWorcesterAverageScore(handicap, this.range, this.face.getDiameter(), this.isMetric);
			break;
		default:
			score = -1;
			break;
		}
		return score;
	}

}
