package com.jamsesh;

import com.jamsesh.MyLocation.LocationResult;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class SignupInfo extends Activity {
	Button next;
	EditText username;
	EditText password;
	EditText email;
	EditText location;	
	MyLocation myLocation;
    double lat;
    double longit;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        username = (EditText)findViewById(R.id.editUname);
        password = (EditText)findViewById(R.id.editPword);
        email = (EditText)findViewById(R.id.editEmail);
        location = (EditText)findViewById(R.id.editLoc);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        
        next = (Button)findViewById(R.id.next);
        next.setOnClickListener(nextClick);
        myLocation = new MyLocation();
        myLocation.getLocation(this, locationResult);        
    }
    private void locationClick() {
        myLocation.getLocation(this, locationResult);
    }
    OnClickListener nextClick = new OnClickListener() {
		@Override
		public void onClick(View v) {	
			Intent i = new Intent(SignupInfo.this, Instruments.class);
			i.putExtra("com.jamsesh.username", username.getText().toString());
			i.putExtra("com.jamsesh.password", password.getText().toString());
			i.putExtra("com.jamsesh.email", email.getText().toString());
			i.putExtra("com.jamsesh.location", location.getText().toString());
			startActivity(i);
		}
    };

    public LocationResult locationResult = new LocationResult(){
        @Override
        public void gotLocation(final Location locationcoord){
        	if (locationcoord != null) {
            lat = locationcoord.getLatitude();
            longit = locationcoord.getLongitude();
            location.setText("Location Found."); 
            location.setClickable(isRestricted());
        	}
            }
        };

	
}