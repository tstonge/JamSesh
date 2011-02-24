package com.jamsesh;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

public class FindJam extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findjam);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        
    }
}

 
