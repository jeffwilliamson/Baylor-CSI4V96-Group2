package com.example.lerpz1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Map extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_map, menu);
		return true;
	}
	
	public void launchInfo(View v) {
		// Launch the Information view. Also, attach additional info
		Intent intent = new Intent(this, InformationLinks.class);
		String context = "this is additional info";
		intent.putExtra("EXTRAINFO", context);
    	
    	startActivity(intent);
	}

}
