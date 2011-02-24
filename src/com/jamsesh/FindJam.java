package com.jamsesh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FindJam extends Activity{
	Button NearMe;
	Button Content;
	Button User;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findjam);
        NearMe = (Button)findViewById(R.id.findme);
        Content = (Button)findViewById(R.id.findcontent);
        User = (Button)findViewById(R.id.finduser);
        NearMe.setOnClickListener(searchResults);
        Content.setOnClickListener(searchResults);
        User.setOnClickListener(searchResults);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        
    }
    
    OnClickListener searchResults = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent i =  new Intent(FindJam.this, JamList.class);
			startActivity(i);			
		}
    	
    };
}

 
