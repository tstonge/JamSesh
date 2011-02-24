package com.jamsesh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.view.WindowManager;

public class MyJams extends Activity{
    public void onCreate(Bundle savedInstanceState) {
    	EditText hosting1;
    	EditText hosting2;
    	EditText attending1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myjams);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        OnClickListener eventClicked = new OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			Intent i = new Intent(MyJams.this, JamInfo.class);
    			startActivity(i);    			
    		}
        	
        };
    }
}
