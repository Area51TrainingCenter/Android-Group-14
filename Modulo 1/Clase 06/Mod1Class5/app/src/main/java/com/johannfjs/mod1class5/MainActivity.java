package com.johannfjs.mod1class5;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.johannfjs.adapters.ItemAdapter;
import com.johannfjs.models.Item;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    GridView gridView;
    ItemAdapter adapter;
    ArrayList<Item> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gvGrilla);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (lista == null)
            lista = new ArrayList<Item>();

        for (int i = 10; i < 99; i++)
            lista.add(new Item(lista.size(),
                    "Descripcion " + i,
                    "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_0" + i + ".jpg"));
        adapter = new ItemAdapter(getApplicationContext(), lista);
        gridView.setAdapter(adapter);
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
}
