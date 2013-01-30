package com.example.lerpz1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void launchHelp(View v) {
		// launch the help activity
		Intent intent = new Intent(this, Help.class);
    	
    	startActivity(intent);
	}
	
	public void launchInformation(View v) {
		// launch information links activity
		Intent intent = new Intent(this, InformationLinks.class);
    	
    	startActivity(intent);
	}
	
	public void launchMap(View v) {
		// launch map activity
		Intent intent = new Intent(this, Map.class);
    	
    	startActivity(intent);
	}
	
	public void launchNotes(View v) {
		// launch notes activity
		Intent intent = new Intent(this, Notes.class);
    	
    	startActivity(intent);
	}
	
	public void launchSettings(View v) {
		// launch settings activity
		Intent intent = new Intent(this, SettingsPage.class);
    	
    	startActivity(intent);
	}
	
	public void launchTextReader(View v) {
		// launch textreader activity
		Intent intent = new Intent(this, TextReader.class);
    	
    	startActivity(intent);
	}
}
