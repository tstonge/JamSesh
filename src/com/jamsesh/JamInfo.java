package com.jamsesh;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class JamInfo extends Activity{
	TextView title;
	Integer parent;
	LinearLayout ll;
	Button attend;
	String genre;
	String loc;
	TextView genreText;
	TextView LocText;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jaminfo);
        ll = (LinearLayout)findViewById(R.id.ll);
        genreText = (TextView)findViewById(R.id.infosong);
        LocText = (TextView)findViewById(R.id.infolocation);
        title = (TextView)findViewById(R.id.jamtitle);
        title.setText(getIntent().getStringExtra("com.jamsesh.title"));
        parent = getIntent().getIntExtra("com.jamsesh.parent", 1);
        if (parent == 0) {
        	attend = new Button(this);
        	attend.setText("Already Attending");
        	attend.setClickable(false);
        	attend.setVisibility(4);
        	ll.addView(attend);
        } else {
        	attend = new Button(this);
        	attend.setText("Attend this Jam Sesh");
        	loc = getIntent().getStringExtra("com.jamsesh.loc");
        	LocText.setText(loc.toString());
        	genre = getIntent().getStringExtra("com.jamsesh.genre");
        	genreText.setText(genre.toString());        	
        	attend.setClickable(true);
        	ll.addView(attend);
        }
        attend.setOnClickListener(attendClick);
	}
	
	OnClickListener attendClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(JamInfo.this, "Jam added to you MyJams Page!", Toast.LENGTH_LONG).show();			
		}
		
	};
}
