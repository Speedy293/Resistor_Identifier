package com.blogspot.resistornamer.resistoridentifier;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.Hashtable;


public class ManualEntry extends ActionBarActivity {
    private Spinner spinnerOne=(Spinner) findViewById(R.id.bandOne);
    private Spinner spinnerTwo=(Spinner) findViewById(R.id.bandTwo);
    private Spinner spinnerThree=(Spinner) findViewById(R.id.bandThree);
    private Spinner spinnerFour=(Spinner) findViewById(R.id.bandFour);
    private Spinner spinnerFive=(Spinner) findViewById(R.id.bandFive);


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
                    spinnerFive.setEnabled(false);
                }
                break;
            case R.id.five:
                if(checked){
                    spinnerFive.setEnabled(true);
                    spinnerFour.setEnabled(true);
                }
        }
    }
    public int compute(View view){
        Hashtable colors = new Hashtable();
        colors.put("Black", 0);
        colors.put("Brown", 1);
        colors.put("Red", 2);
        colors.put("Orange", 3);
        colors.put("Yellow", 4);
        colors.put("Green", 5);
        colors.put("Blue", 6);
        colors.put("Violet", 7);
        colors.put("Grey", 8);
        colors.put("White", 9);
        int ohms = 0;
        String one = spinnerOne.getSelectedItem().toString();
        String two = spinnerTwo.getSelectedItem().toString();
        String three = spinnerThree.getSelectedItem().toString();
        String four = spinnerFour.getSelectedItem().toString();
        /*if() {
            String five = spinnerFive.getSelectedItem().toString();
        }*/

        return ohms;
    }
}
