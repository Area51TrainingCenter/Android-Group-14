package com.johannfjs.mod1class3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.johannfjs.adapters.ListaAdapter;
import com.johannfjs.models.Item;
import com.johannfjs.utils.Constant;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    ListView lvLista;
    ListaAdapter adapter;
    //ArrayList<Item> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvLista = (ListView) findViewById(R.id.lvLista);
/*
        if (lista == null) {
            lista = new ArrayList<Item>();
            lista.add(
                    new Item(
                            lista.size(),
                            "Texto Uno",
                            "Texto Dos",
                            "Texto Tres",
                            "5 min",
                            true));
            lista.add(
                    new Item(
                            lista.size(),
                            "Texto Uno",
                            "Texto Dos",
                            "Texto Tres",
                            "15 min",
                            false));
        }*/
        //adapter = new ListaAdapter(MainActivity.this, lista);
        adapter = new ListaAdapter(getApplicationContext(), Constant.LISTA);
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getResources().getString(R.string.seleccione))
                        .setCancelable(false)
                        .setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);

                                intent.putExtra("KEY", position);
                                /*
                                Bundle bundle = new Bundle();
                                bundle.putInt("KEY", position);
                                intent.putExtras(bundle);
                                */
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Constant.LISTA.remove(position);
                                adapter.notifyDataSetChanged();
                            }
                        }).create().show();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
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
