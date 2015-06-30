package com.johannfjs.mod2class1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.johannfjs.adapters.ListaAdapter;
import com.johannfjs.models.Persona;
import com.johannfjs.sqlite.Querys;

import java.util.ArrayList;
import java.util.List;


public class ListadoActivity extends ActionBarActivity {
    ListView lvLista;
    ListaAdapter adapter;
    Querys querys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        lvLista = (ListView) findViewById(R.id.lvLista);
        querys = new Querys(ListadoActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final ArrayList<Persona> lista = querys.listarPersonas();
        adapter = new ListaAdapter(getApplicationContext(), lista);
        lvLista.setAdapter(adapter);
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                querys.eliminarPersona(lista.get(position).getId());
                lista.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listado, menu);
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
