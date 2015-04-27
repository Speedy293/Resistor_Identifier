package com.blogspot.resistornamer.resistoridentifier;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;


public class ManualEntry extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_entry);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_manual_entry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //Handling Radio Button Clicks
    public void onRadioClick(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch(view.getId()){
            case R.id.four:
                if(checked){
                    Spinner five = (Spinner) findViewById(R.id.bandFive);
                    Spinner four = (Spinner)findViewById(R.id.bandFour);
                    //Spinner six = (Spinner)findViewById(R.id.bandSix);
                    five.setEnabled(false);
                    //four.setEnabled(false);
                    //six.setEnabled(true);

                }
                break;
            case R.id.five:
                if(checked){
                    Spinner five = (Spinner)findViewById(R.id.bandFive);
                    Spinner four = (Spinner)findViewById(R.id.bandFour);
                    //Spinner six = (Spinner)findViewById(R.id.bandSix);
                    five.setEnabled(true);
                    four.setEnabled(true);
                    //six.setEnabled(false);
                }
        }
    }
    public int compute(View view){
        int ohms = 0;
        return ohms;
    }
}
