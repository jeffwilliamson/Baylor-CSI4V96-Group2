package com.example.lerpz1;

import android.content.Intent;
import android.view.View;

public abstract class Navigable extends NoRotateActivity{

	
	public void launchHelp(View v) {
		// launch the help activity
		Intent intent = new Intent(this, Help.class);
    	
    	startActivity(intent);
	}
	
	public void launchHome(View v){
		// Go back to home
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	public void launchSettings(View v) {
		// launch settings activity
		Intent intent = new Intent(this, SettingsPage.class);
    	
    	startActivity(intent);
	}
	
	
	
}
