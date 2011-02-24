package com.jamsesh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableRow;

public class Instruments extends Activity {
	Button addInst;
	Button finish;
	int instCount = 0;
	TableRow[] instSkillArray;
	TableRow instSkillRow2;
	TableRow instSkillRow3;
	TableRow instSkillRow4;
	TableRow instSkillRow5;
	EditText inst1;
	EditText inst2;
	EditText inst3;
	EditText inst4;
	Spinner skill1;
	Spinner skill2;
	Spinner skill3;
	Spinner skill4;
	Spinner skill5;
	String username;
	String password;
	String email;
	String location;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instruments);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);  
        username = getIntent().getStringExtra("com.jamsesh.username");
        password = getIntent().getStringExtra("com.jamsesh.password");
        email = getIntent().getStringExtra("com.jamsesh.email");
        location = getIntent().getStringExtra("com.jamsesh.location");
        addInst = (Button)findViewById(R.id.addInst);
        finish = (Button)findViewById(R.id.finish);
        addInst.setOnClickListener(addInstClick);
        finish.setOnClickListener(finishClick);
        instSkillArray = new TableRow[4];
        instSkillRow2 = (TableRow)findViewById(R.id.instSkillRow2);
        instSkillRow3 = (TableRow)findViewById(R.id.instSkillRow3);
        instSkillRow4 = (TableRow)findViewById(R.id.instSkillRow4);
        instSkillRow5 = (TableRow)findViewById(R.id.instSkillRow5);
        instSkillArray[0] = instSkillRow2;
        instSkillArray[1] = instSkillRow3;
        instSkillArray[2] = instSkillRow4;
        instSkillArray[3] = instSkillRow5;
        
        skill1 = (Spinner) findViewById(R.id.skill1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.skills, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        skill1.setAdapter(adapter1);
        
        skill2 = (Spinner) findViewById(R.id.skill2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this, R.array.skills, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        skill2.setAdapter(adapter2);
        
        skill3 = (Spinner) findViewById(R.id.skill3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
                this, R.array.skills, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        skill3.setAdapter(adapter3);
        
        skill4 = (Spinner) findViewById(R.id.skill4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(
                this, R.array.skills, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        skill4.setAdapter(adapter4);
        
        skill5 = (Spinner) findViewById(R.id.skill5);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(
                this, R.array.skills, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        skill5.setAdapter(adapter5);
        
        skill1.setOnItemSelectedListener(new MyOnItemSelectedListener());
        skill2.setOnItemSelectedListener(new MyOnItemSelectedListener());
        skill3.setOnItemSelectedListener(new MyOnItemSelectedListener());
        skill4.setOnItemSelectedListener(new MyOnItemSelectedListener());
        skill5.setOnItemSelectedListener(new MyOnItemSelectedListener());
    }
    
    OnClickListener addInstClick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (instCount == instSkillArray.length) { 
				//Do nothing
			} else {
				instSkillArray[instCount].setVisibility(View.VISIBLE);
				instCount++;
			}
		}
    };
    
    OnClickListener finishClick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			addUserToWebsite();
			Intent i = new Intent(Instruments.this, MainMenu.class);
			startActivity(i);	
		}

		private void addUserToWebsite() {
			HttpClient client = new DefaultHttpClient();
			String username = "testuser";
			String password = "testpass";
			String lng = "25";
			String lat = "25";
			String Instrument = "piano";
			String rating = "3";
			HttpPost post = new HttpPost("http://growing-flower-372.heroku.com/users/new.json");

	    try {
	        List<NameValuePair> pairs = new ArrayList<NameValuePair>(6);
			pairs.add(new BasicNameValuePair("username", username));
			pairs.add(new BasicNameValuePair("password", password));
			pairs.add(new BasicNameValuePair("lng", lng));
			pairs.add(new BasicNameValuePair("lat", lat));
			pairs.add(new BasicNameValuePair("instrument", Instrument));
			pairs.add(new BasicNameValuePair("rating", rating));
			
	        post.setEntity(new UrlEncodedFormEntity(pairs));
	        HttpResponse httpResponse = client.execute(post);
	        Toast.makeText(Instruments.this, httpResponse.toString(), Toast.LENGTH_LONG).show();

	    } catch( Throwable t ) {
	        goBlooey(t);
	    	//Toast.makeText(Instruments.this, "Post failed " + t.toString(), Toast.LENGTH_LONG);
	    }
			
		}
	};
    
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
    public class MyOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent,
            View view, int pos, long id) {
          /*Toast.makeText(parent.getContext(),
              parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
           */
        }

        public void onNothingSelected(AdapterView parent) {
          // Do nothing.
        }
    }
    private void goBlooey(Throwable t) {
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder
    	.setTitle("Exception!")
    	.setMessage(t.toString())
    	.setPositiveButton("OK", null)
    	.show();
    }
}