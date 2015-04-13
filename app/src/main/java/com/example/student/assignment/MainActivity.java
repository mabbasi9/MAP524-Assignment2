package com.example.student.assignment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    static MediaPlayer mp=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button bMain = (Button) findViewById(R.id.b1);
        final Intent myIntent1 = new Intent(this, MainPage.class);

        bMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(myIntent1);
            }
        });

        Button bUniversity = (Button) findViewById(R.id.b3);
        final Intent myIntent2 = new Intent(this, Top_Universities.class);

        bUniversity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(myIntent2);
            }
        });

        Button bStudy = (Button) findViewById(R.id.b2);
        final Intent myIntent3 = new Intent(this, Stdudy.class);

        bStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(myIntent3);
            }
        });
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
        if (id == R.id.action_help) {
            final Intent myIntent = new Intent(this, HelpActivity.class);
            myIntent.putExtra("key","main");
            startActivity(myIntent);
        }

        if (id == R.id.action_about) {
            final Intent myIntent = new Intent(this, AboutActivity.class);
            myIntent.putExtra("key","main");
            startActivity(myIntent);
        }


        return super.onOptionsItemSelected(item);
    }

    public void onResume() {
        super.onResume();  // Always call the superclass method first

        if(mp != null)
            mp.stop();

    }




}
