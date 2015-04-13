package com.example.student.assignment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MainPage extends ActionBarActivity {

    Spinner spinner1, spinner2;
    SqlLiteDbHelper dbHelper;
    Student contacts;
    public String dbname = "Student.db";
    //EditText mytext;
    TextView text;
    //List name1;
    //ListView lv;
    Context my;
    Button result;
    boolean ok = false;
    String[] province;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        try {
            copy2sdcard();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this, MyReceiver.class);
        // intent.putExtra("content", content.getText().toString());
        sendBroadcast(intent);
        MainActivity.mp =  MediaPlayer.create(this, R.raw.yani);

        my = this;
        province = getResources().getStringArray(R.array.country_arrays);


        dbHelper = new SqlLiteDbHelper(this);
                        //mytext.setText("");
                        dbHelper.openDataBase();
                        contacts = new Student();

                       MainActivity.mp.start();
                        spinner1 = (Spinner) findViewById(R.id.spinner1);
                        spinner2 = (Spinner) findViewById(R.id.spinner2);
                        result = (Button) findViewById(R.id.btnresult);

                        text = (TextView) findViewById(R.id.textView);


                        result.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                MainActivity.mp.start();
                                String s = "";
                                dbHelper.openDataBase();
                                final String s1 = String.valueOf(spinner1.getSelectedItem());
                                final String s2 = String.valueOf(spinner2.getSelectedItem());
                                for(int i=0 ; i <13 ; i++)
                                {
                                    if(s1.equals(province[i]))
                                    {
                                        contacts = dbHelper.Get_ContactDetails(i+1);
                                        if(s2.equals("2013"))
                                        {
                                            s = "Quarter 1: " + contacts.getQ1_13() + "\nQuarter 2: " + contacts.getQ2_13() + "\nQuarter 3: " + contacts.getQ3_13() + "\nQuarter 4: " + contacts.getQ4_13();
                                        }

                                        else
                                        {
                                            s = "Quarter 1: " + contacts.getQ1_14() + "\nQuarter 2: " + contacts.getQ2_14() + "\nQuarter 3: " + contacts.getQ3_14();
                                        }
                                        break;
                                    }
                                }

                                text.setText("The number of international students in different quarter:\n" +s);


                            }

                        });





                   // } else {
                        //mytext.setText("");
                        //Toast.makeText(getApplicationContext(), "No database exists", Toast.LENGTH_SHORT).show();


                   // }



    }


    private void copy2sdcard() throws IOException {
        final int songID = R.raw.yani;   //R.raw.mamamia;

        String path = Environment.getExternalStorageDirectory() + "/mySongs";   //it makes mysongsfolder
        File dir = new File(path);
        if (dir.mkdirs() || dir.isDirectory()) {
            path = path + "/yani.mp3";    //mamamia.ogg
        }
        InputStream in = getResources().openRawResource(songID);
        FileOutputStream out = new FileOutputStream(path);
        byte[] buff = new byte[1024];
        int read = 0;
        try {
            while ((read = in.read(buff)) > 0) {
                out.write(buff, 0, read);
            }
        } finally {
            in.close();
            out.close();
        }
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
            myIntent.putExtra("key","mainPage");
            startActivity(myIntent);
        }

        /*if (id == R.id.action_about) {
            final Intent myIntent = new Intent(this, AboutActivity.class);
            myIntent.putExtra("key","mainPage");
            startActivity(myIntent);
        }*/

        return super.onOptionsItemSelected(item);
    }

}
