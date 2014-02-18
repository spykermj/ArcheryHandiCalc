package com.spykertech.archeryhandicalc;

public enum TargetFace {
	FITA122 	(122.0),
	FITA80		(80.0),
	FITA60		(60.0),
	FITA40		(40.0),
	WORCESTER	(40.64),
	VEGAS		(40.0);
	
	private double diameter;
	
	TargetFace(double diameter){
		this.diameter = diameter;
	}
	
	public double getDiameter(){
		return this.diameter;
	}
}
