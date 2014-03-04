package com.spykertech.archeryhandicalc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements OnKeyListener {
	private Spinner roundSpinner;
	private EditText input;
	private TextView output;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		roundSpinner = (Spinner) findViewById(R.id.spinner1);
		input = (EditText) findViewById(R.id.editText1);
		output = (TextView) findViewById(R.id.textView5);
		input.setOnKeyListener(this);
		buildRoundList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void buildRoundList() {
		List<Round> list = new ArrayList<Round>();
		Round round = new Round("Portsmouth");
		Distance dist = new Distance(20, TargetFace.FITA60, ScoringStyle.TEN_ZONE, false, 60);
		round.addDistance(dist);
		list.add(round);
		round = new Round("FITA 18");
		dist = new Distance(18, TargetFace.FITA40, ScoringStyle.TEN_ZONE, true, 60);
		round.addDistance(dist);
		list.add(round);
		round = new Round("Portsmouth Compound");
		dist = new Distance(20, TargetFace.FITA60, ScoringStyle.TEN_ZONE_COMPOUND, false, 60);
		round.addDistance(dist);
		list.add(round);
		round = new Round("Frostbite");
		dist = new Distance(30, TargetFace.FITA80, ScoringStyle.TEN_ZONE, true, 36);
		round.addDistance(dist);
		list.add(round);
		round = new Round("Portsmouth 10-6");
		dist = new Distance(20, TargetFace.FITA60, ScoringStyle.FIVE_ZONE, false, 60);
		round.addDistance(dist);
		list.add(round);
		round = new Round("Portsmouth 10-6 Compound");
		dist = new Distance(20, TargetFace.FITA60, ScoringStyle.FIVE_ZONE_COMPOUND, false, 60);
		round.addDistance(dist);
		list.add(round);
		round = new Round("FITA (Gents)");
		dist = new Distance(90, TargetFace.FITA122, ScoringStyle.TEN_ZONE, true, 36);
		round.addDistance(dist);
		dist = new Distance(70, TargetFace.FITA122, ScoringStyle.TEN_ZONE, true, 36);
		round.addDistance(dist);
		dist = new Distance(50, TargetFace.FITA80, ScoringStyle.TEN_ZONE, true, 36);
		round.addDistance(dist);
		dist = new Distance(30, TargetFace.FITA80, ScoringStyle.TEN_ZONE, true, 36);
		round.addDistance(dist);
		list.add(round);
		round = new Round("York");
		dist = new Distance(100, TargetFace.FITA122, ScoringStyle.IMPERIAL, false, 72);
		round.addDistance(dist);
		dist = new Distance(80, TargetFace.FITA122, ScoringStyle.IMPERIAL, false, 48);
		round.addDistance(dist);
		dist = new Distance(60, TargetFace.FITA122, ScoringStyle.IMPERIAL, false, 24);
		round.addDistance(dist);
		list.add(round);
		round = new Round("FITA 70");
		dist = new Distance(70, TargetFace.FITA122, ScoringStyle.IMPERIAL, true, 72);
		round.addDistance(dist);
		list.add(round);
		Collections.sort(list);
		ArrayAdapter<Round> dataAdapter = new ArrayAdapter<Round>(this, android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		roundSpinner.setAdapter(dataAdapter);
	}

	@Override
	public boolean onKey(View view, int keyCode, KeyEvent event) {
		roundSpinner = (Spinner) findViewById(R.id.spinner1);
		Round round = (Round) roundSpinner.getSelectedItem();
		try {
			output.setText(String.format("%d", round.lookupHandicap(Integer.parseInt(input.getText().toString()))));
		} catch (Exception e) {
			
		}
		return false;
	}
}
