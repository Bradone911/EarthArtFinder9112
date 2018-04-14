package com.cidm4385.android.earthartfinder9112;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList = new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = new String []{"Amarillo_Ramp", "Broken_Circle", "Sprial_Jetty", "Sun_Tunnels", "Lighting_Field"};
        description = new String[]{"Amarillo Ramp detail...", "Broken Circle detail....", "Sprial Jetty detail....", "Sun Tunnels detail....", "Lighting Field detail...."};
        icon = new int[]{R.drawable.amarilloramp, R.drawable.brokencircle, R.drawable.spiraljetty, R.drawable.suntunnels, R.drawable.lightingfield};

        listView = findViewById(R.id.listView);

        for (int i = 0; i < title.length; i++)  {
            Model model = new Model(title[i], description[i], icon[i]);
//            bind all strings in an array
            arrayList.add(model);
        }

//        pass results to lisViewAdapter class
        adapter = new ListViewAdapter(this, arrayList);

//        bind the adapter to the listview
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);


    MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s))   {
                    adapter.filter("");
                    listView.clearTextFilter();
                }else {
                    adapter.filter(s);
                }
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
//            do your functionality here
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
/*design row of listview
* adding menu to add searchView in actionbar
* add model class
* add adapter class
* add some images in drawable folder
* run project and test the listview and searchview*/