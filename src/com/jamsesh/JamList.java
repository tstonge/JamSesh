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

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class JamList extends ListActivity { 
	private ArrayList<JamClass> jcArray;
	private String[] jamArray;
	int code;
	@Override 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		code = getIntent().getIntExtra("com.jamsesh.code", -1);
		getListView().setBackgroundResource(R.drawable.bg);
		if (code == 0)
			locationSearchJams();
		if (code == 1) {
			contentSearchJams(getIntent().getStringExtra("com.jamsesh.contentterm"));
		}
		if (code == 2) {
			userSearchJams(getIntent().getStringExtra("com.jamsesh.searchname"));
		}
		jamArray = new String[jcArray.size()];
		for (JamClass jc : jcArray) {
			jamArray[jc.id] = jc.title;
		}
		setListAdapter(new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1,
				new ArrayList())); 
		
		new AddStringTask().execute();
	}
	
	private void locationSearchJams() {
		ArrayList<JamClass> newArr = new ArrayList<JamClass>();
		newArr = downloadJams();
}
	private void contentSearchJams(String searchterm) {
		ArrayList<JamClass> newArr = new ArrayList<JamClass>();
		newArr = downloadJams();
		for (JamClass jc : newArr) {
			
		}
}

	private void userSearchJams(String username) {
		ArrayList<JamClass> newArr = new ArrayList<JamClass>();
		newArr = downloadJams();
		newArr = downloadJams();
		for (JamClass jc : newArr) {
			if (!jc.host.contentEquals(username)) {
				newArr.remove(jc);
			}
		}
}
	private ArrayList<JamClass> downloadJams() {
        HttpClient httpClient = new DefaultHttpClient();
		HttpGet getMethod = new HttpGet("http://growing-flower-372.heroku.com/jams.json");
    	HttpResponse response;
		HttpEntity entity;
		jcArray = new ArrayList<JamClass>();
		
		try{
		response = httpClient.execute(getMethod);
		entity = response.getEntity();
		String contentString = convertStreamToString(entity.getContent());
		JSONArray jarray = new JSONArray(contentString);
		for (int i = 0; i < jarray.length(); i++) {
			JamClass jc = new JamClass();
			jc.id = i;
			JSONObject jobject = jarray.getJSONObject(i);
			String sstring = jobject.getString("jam");
			JSONObject jsobject = new JSONObject(sstring);
			jc.loc = jsobject.getString("loc").toString();
			jc.title = jsobject.getString("name").toString();
			jc.genre = jsobject.getString("genre").toString();
			//jc.host = getHostNameFromId(jsobject.getString("host").toString());
			//jc.time = jsobject.getString("time").toString();
			//jc.deciption = jsobject.getString("decription").toString();
			jcArray.add(jc); 
		}
		} catch (Throwable t) {
		Log.e("Networking", "Exception in getStatus()", t);
		return jcArray;
	}		
		return jcArray;
}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent message = new Intent(JamList.this, JamInfo.class);
		JamClass jc = new JamClass();
		for (JamClass JC : jcArray) {
			if (JC.id == position) {
				jc = JC;
			}
		}
		message.putExtra("com.jamsesh.title", jamArray[position]);
		message.putExtra("com.jamsesh.genre", jc.genre);
		message.putExtra("com.jamsesh.loc", jc.loc);
		message.putExtra("com.jamsesh.parent", 1);
        startActivity(message);
	}

	class AddStringTask extends AsyncTask<Void, String, Void> { 
		@Override 
		protected Void doInBackground(Void... unused) {
			for (String s:jamArray) {
				publishProgress(s);				
			}
			return(null);
		}
		
		@Override 
		protected void onProgressUpdate(String... item) {
			((ArrayAdapter)getListAdapter()).add(item[0]);
		}
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
    
    public String getHostNameFromId(String Id) {
    	HttpClient httpClient = new DefaultHttpClient();
		HttpGet getMethod = new HttpGet("http://growing-flower-372.heroku.com/users/" + Id + ".json");
    	HttpResponse response;
		HttpEntity entity;
		try {
		response = httpClient.execute(getMethod);
		entity = response.getEntity();
		String contentString = convertStreamToString(entity.getContent());
		JSONObject jobject = new JSONObject(contentString);
		String username = jobject.getString("username");
		return username;
		} catch (Throwable t) {
			t.printStackTrace();
			String badid = "badId";
			return badid;
		}
    }
}	