package com.example.student.assignment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;

import java.util.ArrayList;


public class Stdudy extends ActionBarActivity {

    String[] webs;
    String[] links;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stdudy);

        webs = getResources().getStringArray(R.array.study);
        links = getResources().getStringArray(R.array.link_study);

        ListView listViewHandle = (ListView) findViewById( R.id .listView2)  ;


        ArrayAdapter<String> listAdaptor = new ArrayAdapter<String>(this,R.layout.second_row,R.id.textView6,webs);

        listViewHandle.setAdapter(listAdaptor);




        listViewHandle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(links[position]));
                startActivity(browserIntent);


                //startActivity(new Intent(this,fifth_activity.class ));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stdudy, menu);
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
            myIntent.putExtra("key","study");
            startActivity(myIntent);
        }

       /* if (id == R.id.action_about) {
            final Intent myIntent = new Intent(this, AboutActivity.class);
            myIntent.putExtra("key","study");
            startActivity(myIntent);
        }*/

        return super.onOptionsItemSelected(item);
    }
}
