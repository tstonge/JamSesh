package com.jamsesh;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class JamInfo extends Activity{
	TextView title;
	Integer parent;
	LinearLayout ll;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jaminfo);
        ll = (LinearLayout)findViewById(R.id.ll);
        title = (TextView)findViewById(R.id.jamtitle);
        title.setText(getIntent().getStringExtra("com.jamsesh.title"));
        parent = getIntent().getIntExtra("com.jamsesh.parent", 1);
        if (parent == 0) {
        	Button attend = new Button(this);
        	attend.setText("Already Attending");
        	attend.setClickable(false);
        	ll.addView(attend);
        } else {
        	Button attend = new Button(this);
        	attend.setText("Attend this Jam Sesh");
        	attend.setClickable(true);
        	ll.addView(attend);
        }
	}
}
