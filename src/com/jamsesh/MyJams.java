package com.jamsesh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.TextView;

public class MyJams extends Activity{
	TextView hosting1;
	TextView hosting2;
	TextView attending1;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myjams);
        hosting1 = (TextView)findViewById(R.id.hosting1);
        hosting2 = (TextView)findViewById(R.id.hosting2);
        attending1 = (TextView)findViewById(R.id.attending1);
        hosting1.setOnClickListener(hosting1Clicked);
        hosting2.setOnClickListener(hosting2Clicked);
        attending1.setOnClickListener(attending1Clicked);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
    
    OnClickListener hosting1Clicked = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent i = new Intent(MyJams.this, JamInfo.class);
			i.putExtra("com.jamsesh.title", hosting1.getText().toString());
			i.putExtra("com.jamsesh.parent", 0);
			startActivity(i);    			
		}
    	
    };
    OnClickListener hosting2Clicked = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent i = new Intent(MyJams.this, JamInfo.class);
			i.putExtra("com.jamsesh.title", hosting2.getText().toString());
			i.putExtra("com.jamsesh.parent", 0);
			startActivity(i);    			
		}
    	
    };    OnClickListener attending1Clicked = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent i = new Intent(MyJams.this, JamInfo.class);
			i.putExtra("com.jamsesh.title", attending1.getText().toString());
			i.putExtra("com.jamsesh.parent", 0);
			startActivity(i);    			
		}
    	
    };
}
