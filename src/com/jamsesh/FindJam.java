package com.jamsesh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FindJam extends Activity{
	Button NearMe;
	Button Content;
	Button User;
	EditText usersearch;
	EditText contentsearch;
	String id; 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findjam);
        NearMe = (Button)findViewById(R.id.findme);
        Content = (Button)findViewById(R.id.findcontent);
        User = (Button)findViewById(R.id.finduser);
        usersearch = (EditText)findViewById(R.id.useredittext);
        contentsearch = (EditText)findViewById(R.id.commentedittext);
        NearMe.setOnClickListener(locationResults);
        Content.setOnClickListener(contentResults);
        User.setOnClickListener(userResults);
        id = getIntent().getStringExtra("com.jamsesh.id");
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        
    }
    
    OnClickListener locationResults = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent i =  new Intent(FindJam.this, JamList.class);
			i.putExtra("com.jamsesh.code", 0);
			i.putExtra("com.jamsesh.id", id);
			startActivity(i);			
		}
    	
    };
    OnClickListener contentResults = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent i =  new Intent(FindJam.this, JamList.class);
			i.putExtra("com.jamsesh.code", 1);
			i.putExtra("com.jamsesh.contentterm", contentsearch.getText().toString());
			startActivity(i);			
		}
    	
    };
    OnClickListener userResults = new OnClickListener() {

		public void onClick(View v) {
			Intent i =  new Intent(FindJam.this, JamList.class);
			i.putExtra("com.jamsesh.code", 2);
			i.putExtra("com.jamsesh.searchname", usersearch.getText().toString());
			startActivity(i);			
		}
    	
    };
}

 
