package com.example.lerpz1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class Notes extends Navigable {
	
	 protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(0);
        String restoredText = prefs.getString("journal", null);
        if (restoredText != null) {
            editBox.setText(restoredText, TextView.BufferType.EDITABLE);
            int selectionStart = prefs.getInt("selection-start", -1);
            int selectionEnd = prefs.getInt("selection-end", -1);
            if (selectionStart != -1 && selectionEnd != -1) {
                editBox.setSelection(selectionStart, selectionEnd);
            }
        }
    }
 
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getPreferences(0).edit();
        editor.putString("journal", editBox.getText().toString());
        editor.putInt("selection-start", editBox.getSelectionStart());
        editor.putInt("selection-end", editBox.getSelectionEnd());
        editor.commit();
    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notes);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		setContentView(R.layout.activity_notes);
        editBox =(EditText)findViewById(R.id.editText1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_notes, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private EditText editBox;

}
