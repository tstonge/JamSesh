package com.jamsesh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

public class MainMenu extends Activity{
	Button findjam;
	Button startjam;
	Button myjams;
	String id; 
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        findjam = (Button)findViewById(R.id.findjam);
        startjam = (Button)findViewById(R.id.startjam);
        myjams = (Button)findViewById(R.id.myjams);
        findjam.setOnClickListener(findJamClick);
        startjam.setOnClickListener(startJamClick);
        myjams.setOnClickListener(myJamsClick);       
        id = getIntent().getStringExtra("com.jamsesh.id"); 
	}
	
	OnClickListener findJamClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent i = new Intent(MainMenu.this, FindJam.class);
			startActivity(i);
			
		}
		
	};
	OnClickListener startJamClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent i = new Intent(MainMenu.this, StartJam.class);
			startActivity(i);
			
		}
		
	};
	OnClickListener myJamsClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent i = new Intent(MainMenu.this, MyJams.class);
			startActivity(i);			
		}
		
	};
}
