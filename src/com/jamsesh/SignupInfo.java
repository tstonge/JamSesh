package com.jamsesh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

public class SignupInfo extends Activity {
	Button next;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        
        next = (Button)findViewById(R.id.next);
        next.setOnClickListener(nextClick);
    }

    OnClickListener nextClick = new OnClickListener() {
		@Override
		public void onClick(View v) {	
			Intent i = new Intent(SignupInfo.this, Instruments.class);
			startActivity(i);
		}
    };
}