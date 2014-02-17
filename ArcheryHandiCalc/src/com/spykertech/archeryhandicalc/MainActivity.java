package com.spykertech.archeryhandicalc;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {
	private Spinner roundSpinner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buildRoundList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void buildRoundList() {
		roundSpinner = (Spinner) findViewById(R.id.spinner1);
		List<Round> list = new ArrayList<Round>();
		list.add(new Round("Portsmouth"));
		list.add(new Round("FITA 18"));
		ArrayAdapter<Round> dataAdapter = new ArrayAdapter<Round>(this, android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		roundSpinner.setAdapter(dataAdapter);
	}
}
