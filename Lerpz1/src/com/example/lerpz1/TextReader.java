package com.example.lerpz1;

import android.os.Bundle;
import android.os.AsyncTask;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class TextReader extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_reader);
		
		arrayList = new ArrayList<String>();
		
		final EditText editText = (EditText) findViewById(R.id.editText35);
		Button send = (Button)findViewById(R.id.send_button);
		
		mList = (ListView)findViewById(R.id.list);
		mAdapter = new CustomAdapter(this, arrayList);
		mList.setAdapter(mAdapter);
		
		// Time to connect
		new connectTask().execute("");
		
		send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String message = editText.getText().toString();

				arrayList.add("Client: "+message);
				if(mTcpClient != null){
					mTcpClient.sendMessage(message);
				}
				mAdapter.notifyDataSetChanged();
				editText.setText("");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_text_reader, menu);
		return true;
	}

	
	private ListView mList;
	private ArrayList<String> arrayList;
	private CustomAdapter mAdapter;
	private TCPClient mTcpClient;
	
	public class connectTask extends AsyncTask<String,String,TCPClient>{
		@Override
		protected TCPClient doInBackground(String... message){
			mTcpClient = new TCPClient(new TCPClient.OnMessageReceived(){
				@Override
				public void messageReceived(String message){
					publishProgress(message);
				}
			});
			mTcpClient.run();
			return null;
		}
		
		@Override
		protected void onProgressUpdate(String... values){
			super.onProgressUpdate(values);
			
			arrayList.add(values[0]);
			mAdapter.notifyDataSetChanged();
		}
	}
}
