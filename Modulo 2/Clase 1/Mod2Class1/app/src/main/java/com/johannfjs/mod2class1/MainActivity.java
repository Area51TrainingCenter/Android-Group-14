package com.johannfjs.mod2class1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.johannfjs.sqlite.Querys;


public class MainActivity extends ActionBarActivity {
    private EditText txtNombre, txtApellido, txtEdad;
    private Spinner spSexo;
    private Button btnGrabar, btnListar;
    private Querys querys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellido = (EditText) findViewById(R.id.txtApellido);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        spSexo = (Spinner) findViewById(R.id.spSexo);
        btnGrabar = (Button) findViewById(R.id.btnGrabar);
        btnListar = (Button) findViewById(R.id.btnListar);
        querys = new Querys(MainActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListadoActivity.class));
            }
        });
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNombre.getText().toString().length() > 0 &&
                        txtApellido.getText().toString().length() > 0 &&
                        txtEdad.getText().toString().length() > 0) {
                    querys.insertarPersona(txtNombre.getText().toString(),
                            txtApellido.getText().toString(),
                            Integer.parseInt(txtEdad.getText().toString()),
                            spSexo.getSelectedItem().toString());
                    Toast.makeText(getApplicationContext(),
                            "Todo OK",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Ingrese todos los datos",
                            Toast.LENGTH_SHORT).show();
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
