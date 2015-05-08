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
    private boolean fourV;
    private boolean fiveV;

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
        /*Spinner spinnerOne=(Spinner) findViewById(R.id.bandOne);
        Spinner spinnerTwo=(Spinner) findViewById(R.id.bandTwo);
        Spinner spinnerThree=(Spinner) findViewById(R.id.bandThree);*/
        Spinner spinnerFour=(Spinner) findViewById(R.id.bandFour);
        Spinner spinnerFive=(Spinner) findViewById(R.id.bandFive);
        boolean checked = ((RadioButton)view).isChecked();
        switch(view.getId()){
            case R.id.four:
                if(checked){
                    spinnerFive.setEnabled(false);
                    fourV = true;
                    fiveV = false;
                }
                break;
            case R.id.five:
                if(checked){
                    spinnerFive.setEnabled(true);
                    spinnerFour.setEnabled(true);
                    fiveV = true;
                    fourV = false;
                }
        }
    }
    public void compute(View view){
        calculate(view);
    }
    public void calculate(View view){
        Spinner spinnerOne=(Spinner) findViewById(R.id.bandOne);
        Spinner spinnerTwo=(Spinner) findViewById(R.id.bandTwo);
        Spinner spinnerThree=(Spinner) findViewById(R.id.bandThree);
        Spinner spinnerFour=(Spinner) findViewById(R.id.bandFour);
        Spinner spinnerFive=(Spinner) findViewById(R.id.bandFive);

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

        Hashtable mult = new Hashtable();
        mult.put("Black", 1);
        mult.put("Brown", 10);
        mult.put("Red", 100);
        mult.put("Orange", 1000);
        mult.put("Yellow", 10000);
        mult.put("Green", 100000);
        mult.put("Blue", 1000000);
        mult.put("Violet", 10000000);

        Hashtable per = new Hashtable();
        per.put("Gold", "+/-5%");
        per.put("Silver", "+/-10%");

        String ohms ="";

        String one = spinnerOne.getSelectedItem().toString();
        String two = spinnerTwo.getSelectedItem().toString();
        String three = spinnerThree.getSelectedItem().toString();
        String four = spinnerFour.getSelectedItem().toString();

        /*boolean checked = ((RadioButton)view).isChecked();
*/
        /*switch(view.getId()){
            case R.id.four:
                if(checked){
                    int val = ((int)colors.get(one)*10+(int)colors.get(two)*10)*(int)mult.get(three);
                    ohms = ""+val+per.get(four);
                }
                break;
            case R.id.five:
                if(checked){
                    String five = spinnerFive.getSelectedItem().toString();
                    int val = ((int)colors.get(one)*10+(int)colors.get(two)*10+(int)colors.get(three))*(int)mult.get(four);
                    ohms = ""+val+per.get(five);
                }
        }*/
        if(fourV){
            int val = ((int)colors.get(one)*10+(int)colors.get(two)*10)*(int)mult.get(three);
            ohms = ""+val+per.get(four);
        }
        if(fiveV){
            String five = spinnerFive.getSelectedItem().toString();
            int val = ((int)colors.get(one)*10+(int)colors.get(two)*10+(int)colors.get(three))*(int)mult.get(four);
            ohms = ""+val+per.get(five);
        }
        System.out.println(ohms);
    }
}
