package com.example.student.assignment;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class HelpActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        TextView tv = (TextView) findViewById(R.id.help);
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("key");
        switch (value) {
            case "main":  tv.setText("The main page contains three buttons that take you to three different pages.\n" +
                    "- Static page shows the the number of international student in Canada in 2013 and 2014\n." +
                    "- Study in Canada, guide you to the different websites that provide useful information for everybody who are interested to pursue education in Canada.\n" +
                    "- Top University, provides information about the best universities in different province in Canada.");
                        break;
            case "mainPage": tv.setText("- You should select a province and year from the list, then click result.\n" +
                    "In the box bellow you can find the number of international students who came to Canada in different quarter in the selected year and province.");
                break;

            case "study": tv.setText("- This page guides you to different websites that explain the process of how to come to Canada as an international student. Also, how to stay in Canada after graduation and etc..."

                    );
                break;

            case "topUniversity": tv.setText("- This page gives you the information about best universities in different provinces." +
                    "You should click on each province and then select your interest university from a list.\n" +
                    "- You need a long click on each item in list to be able to see the universities on each province.");

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_help, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
