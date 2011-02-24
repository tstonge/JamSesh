package com.jamsesh;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class StartJam extends Activity{
	Button submit;
	EditText Title;
	EditText Location;
	EditText Song;
	EditText Time;
	EditText Comments;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startjam);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        submit = (Button)findViewById(R.id.submit);
        Title = (EditText)findViewById(R.id.titleedittext);
        Location = (EditText)findViewById(R.id.locationedittext);
        Song = (EditText)findViewById(R.id.songedittext);
        Time = (EditText)findViewById(R.id.timeedittext);
        Comments = (EditText)findViewById(R.id.commentedittext);
        
    }
    
    OnClickListener submitClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			//TODO: this part;
			
		}
    	
    };  

}
