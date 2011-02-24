package com.jamsesh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	Button login;
	Button newUser;
	EditText username;
	EditText password;
	String id;
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
			//int ret = getID();
			//if (ret == -2 || ret == -3) {
				//Toast.makeText(Login.this, "Incorrect Login Information", Toast.LENGTH_LONG).show();
			//} 
			if (true){//ret ==1){
				Intent i = new Intent(Login.this, MainMenu.class);
				Toast.makeText(Login.this, "Succesfully Logged On!", Toast.LENGTH_LONG).show();
				id = "1";
				i.putExtra("com.jamsesh.id", id);
				startActivity(i);		
			}
		}
    
    };
    
    OnClickListener newUserClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i = new Intent(Login.this, SignupInfo.class);
			startActivity(i);
			
		}
	};
	public int getID() {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet getMethod = new HttpGet("http://growing-flower-372.heroku.com/users/get_by_name/" +
				username.getText().toString() + ".json");
    	HttpResponse response;
		HttpEntity entity;
		
		try{
		if (password.getText().toString().length() == 0) {
			Toast.makeText(this, "You must enter your password", Toast.LENGTH_LONG).show();
			return -1;
		}
		response = httpClient.execute(getMethod);
		entity = response.getEntity();
		String contentString = convertStreamToString(entity.getContent()).replace("\n", "");
		Integer intId = Integer.parseInt(contentString);
		id = intId.toString();
		if (intId != 4) {
			return 1;
			}
		}
		catch (Throwable t) {
			System.out.println(t.toString());
			return -2;
		}
		return -3;
	}
	
    public static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    
}