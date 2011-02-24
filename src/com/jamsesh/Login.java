package com.jamsesh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {
	Button login;
	Button newUser;
	EditText username;
	EditText password;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        username = (EditText)findViewById(R.id.unameedit);
        password = (EditText)findViewById(R.id.pwordedit);
        login = (Button)findViewById(R.id.loginbutton);
        newUser = (Button)findViewById(R.id.newuser);
        login.setOnClickListener(loginClick);
        newUser.setOnClickListener(newUserClick);
    }
    
    OnClickListener loginClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent i = new Intent(Login.this, MainMenu.class);
			i.putExtra("com.jamsesh.username", username.getText().toString());
			i.putExtra("com.jamsesh.password", password.getText().toString());
			startActivity(i);		
			}
    
    };
    
    OnClickListener newUserClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i = new Intent(Login.this, SignupInfo.class);
			startActivity(i);
			
		}
	};
    
}