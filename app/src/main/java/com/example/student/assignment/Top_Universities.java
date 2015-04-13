package com.example.student.assignment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class Top_Universities extends ActionBarActivity {



    String[] webs;
    String[] links;
    String[] provinces;
    String myProvinces;
    int[] images = {R.drawable.alberta,R.drawable.britishcolumbia, R.drawable.ontario, R.drawable.quebec, R.drawable.novascotia , R.drawable.saskatchewan, R.drawable.manitoba , R.drawable.newfoundland};

    //AutoCompleteTextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top__universities);



        //webs = getResources().getStringArray(R.array.website_alberta);
        //links = getResources().getStringArray(R.array.link_alberta);
        provinces = getResources().getStringArray(R.array.Provinces);

        final ListView listViewHandle = (ListView) findViewById(R.id.list);

        VivzAdapter adapter = new VivzAdapter(this,provinces,images);

        listViewHandle.setAdapter(adapter);
        listViewHandle.setSelector( R.drawable.listselector);

        registerForContextMenu(listViewHandle);






    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
        myProvinces = provinces[info.position];

        switch (myProvinces) {
            case "Alberta":
                webs = getResources().getStringArray(R.array.website_alberta);
                links = getResources().getStringArray(R.array.link_alberta);
                break;
            case "British Columbia":
                webs = getResources().getStringArray(R.array.website_british);
                links = getResources().getStringArray(R.array.link_british);
                break;
            case "Ontario":
                webs = getResources().getStringArray(R.array.website_ontario);
                links = getResources().getStringArray(R.array.link_ontario);
                break;
            case "Quebec":
                webs = getResources().getStringArray(R.array.website_quebec);
                links = getResources().getStringArray(R.array.link_quebec);
                break;

            case " Nova Scotia":
                webs = getResources().getStringArray(R.array.website_NovaScotia);
                links = getResources().getStringArray(R.array.link_NovaScotia);
                break;

            case "Saskatchewan":
                webs = getResources().getStringArray(R.array.website_Saskatchewan);
                links = getResources().getStringArray(R.array.link_Saskatchewan);
                break;

            case "Manitoba":
                webs = getResources().getStringArray(R.array.website_Manitoba);
                links = getResources().getStringArray(R.array.link_Manitoba);
                break;

            case "Newfoundland and Labrador":
                webs = getResources().getStringArray(R.array.website_Newfoundland);
                links = getResources().getStringArray(R.array.link_Newfoundland);
                break;
        }

        menu.setHeaderTitle("Select The University");
        for(int i=0; i< webs.length; i++) {
            menu.add(0, v.getId(), 0, webs[i]);
        }


    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {
        for(int i=0; i< webs.length; i++) {
            if (item.getTitle() == webs[i]) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(links[i]));
                startActivity(browserIntent);

            }
        }
        return true;
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top__universities, menu);
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
            myIntent.putExtra("key","topUniversity");
            startActivity(myIntent);
        }

        /*if (id == R.id.action_about) {
            final Intent myIntent = new Intent(this, AboutActivity.class);
            myIntent.putExtra("key","topUniversity");
            startActivity(myIntent);
        }*/

        return super.onOptionsItemSelected(item);
    }
}

class VivzAdapter extends  ArrayAdapter<String>
{
    int[] images;
    Context context;
    String[] pArray;
    VivzAdapter(Context c, String[] province, int imgs[])
    {
        super(c,R.layout.single_row, R.id.textView5, province);
        this.context=c;
        this.images = imgs;
        this.pArray = province;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_row,parent, false);
        ImageView myImage = (ImageView) row.findViewById(R.id.imageView2);
        TextView myProvince = (TextView) row.findViewById(R.id.textView5);
        myImage.setImageResource(images[position]);
        myProvince.setText(pArray[position]);

        return  row;
    }
}
