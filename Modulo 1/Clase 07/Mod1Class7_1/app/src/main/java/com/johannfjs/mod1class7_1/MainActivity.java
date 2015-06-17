package com.johannfjs.mod1class7_1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.johannfjs.adapters.ListaAdapter;
import com.johannfjs.models.Persona;
import com.johannfjs.utils.Constant;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    EditText nombre, edad;
    Spinner sexo;
    Button grabar;
    ListView lvLista;
    ListaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText) findViewById(R.id.txtNombre);
        edad = (EditText) findViewById(R.id.txtEdad);
        sexo = (Spinner) findViewById(R.id.spSexo);
        grabar = (Button) findViewById(R.id.btnGrabar);
        lvLista = (ListView) findViewById(R.id.lvLista);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Constant.LISTA == null)
            Constant.LISTA = new ArrayList<Persona>();
        adapter = new ListaAdapter(getApplicationContext(), Constant.LISTA);
        lvLista.setAdapter(adapter);

        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nombre.getText().toString().equals("") &&
                        !edad.getText().toString().equals("")) {
                    Constant.LISTA.add(new Persona(Constant.LISTA.size(),
                            nombre.getText().toString(),
                            sexo.getSelectedItem().toString(),
                            Integer.parseInt(edad.getText().toString()),
                            "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_00" + (Constant.LISTA.size() + 1) + ".jpg"));
                    adapter.notifyDataSetChanged();
                    nombre.setText("");
                    sexo.setSelection(0);
                    edad.setText("");
                    nombre.requestFocus();
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese todos los datos", Toast.LENGTH_SHORT).show();
                }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
