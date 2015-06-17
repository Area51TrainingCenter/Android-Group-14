package com.johannfjs.mod1class7;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private Spinner spColores, spColores2;
    private LinearLayout llContainer;
    private TextView lblTexto;
    private Button btnProcesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spColores = (Spinner) findViewById(R.id.spColores);
        spColores2 = (Spinner) findViewById(R.id.spColores2);
        llContainer = (LinearLayout) findViewById(R.id.llContainer);
        lblTexto = (TextView) findViewById(R.id.lblTexto);
        btnProcesar = (Button) findViewById(R.id.btnProcesar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String colores[] = {"Rojo", "Azul", "Verde"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, colores);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spColores2.setAdapter(adapter);

        spColores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        llContainer.setBackgroundColor(getResources().getColor(R.color.rojo));
                        break;
                    case 1:
                        llContainer.setBackgroundColor(getResources().getColor(R.color.azul));
                        break;
                    case 2:
                        llContainer.setBackgroundColor(getResources().getColor(R.color.verde));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblTexto.setText(spColores2.getSelectedItem().toString());
                if (spColores2.getSelectedItem().toString().equals("Rojo"))
                    lblTexto.setBackgroundColor(getResources().getColor(R.color.rojo));
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
