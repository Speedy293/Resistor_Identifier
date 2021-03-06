package com.blogspot.resistornamer.resistoridentifier;

import android.content.Intent;
import android.graphics.*;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
//Clone Worked

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    //Opens a camera when the button is clicked
    public void startCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }
    //Stores Image?
    @Override
    protected void  onActivityResult(int requestCode, int resultCode, Intent data){
        ImageView myImageView= (ImageView)findViewById(R.id.imageView);
        if(requestCode== 1 && resultCode== RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            myImageView.setImageBitmap(photo);
        }
    }

    //Intent for manual entry
    public void manualEntry(View view){
        Intent intent = new Intent(this, ManualEntry.class);
        startActivity(intent);
    }
}
