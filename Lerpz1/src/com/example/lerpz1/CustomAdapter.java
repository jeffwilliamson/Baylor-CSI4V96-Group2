package com.example.lerpz1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/*
 * http://myandroidsolutions.blogspot.com/2012/07/android-tcp-connection-tutorial.html
 */
public class CustomAdapter extends BaseAdapter{

	private ArrayList<String> mListItems;
	private LayoutInflater mLayoutInflater;
	
	public CustomAdapter(Context context,ArrayList<String> arrayList){
		mListItems = arrayList;
		
		mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}
	
	@Override
	public int getCount(){
		return mListItems.size();
	}
	
	@Override
	/* Get the data of an item from a specific position i, representing the position of
	 * an item in the list
	 */
	public Object getItem(int i){
		return null;
	}


	//Get the position id of the item from the list
	@Override
	public long getItemId(int i){
		return (long)0;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView = mLayoutInflater.inflate(R.layout.list_item,null);
		}
		
		String item = mListItems.get(position);
		if(item != null){
			TextView itemName = (TextView) convertView.findViewById(R.id.list_item_text_view);
			
			if(itemName != null){
				itemName.setText(item);
			}
		}
		return convertView;
	}
	
}
