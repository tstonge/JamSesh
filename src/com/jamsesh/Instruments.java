package com.jamsesh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.Toast;

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
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instruments);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);  
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
			Intent i = new Intent(Instruments.this, MainMenu.class);
			startActivity(i);	
		}
	};
    
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
}