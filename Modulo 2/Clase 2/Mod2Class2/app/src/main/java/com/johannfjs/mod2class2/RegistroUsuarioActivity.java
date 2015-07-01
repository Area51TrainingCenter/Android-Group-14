package com.johannfjs.mod2class2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.johannfjs.models.Persona;
import com.johannfjs.sqlite.Querys;


public class RegistroUsuarioActivity extends ActionBarActivity {
    EditText txtNombre, txtApellido, txtUsuario, txtContrasena, txtRepetirContrasena;
    Button btnRegistrar;
    Querys querys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellido = (EditText) findViewById(R.id.txtApellido);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtContrasena = (EditText) findViewById(R.id.txtContrasena);
        txtRepetirContrasena = (EditText) findViewById(R.id.txtRepContrasena);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        querys = new Querys(RegistroUsuarioActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNombre.getText().toString().length() > 0 &&
                        txtApellido.getText().toString().length() > 0 &&
                        txtUsuario.getText().toString().length() > 0 &&
                        txtContrasena.getText().toString().length() > 0 &&
                        txtRepetirContrasena.getText().toString().length() > 0) {
                    if (txtContrasena.getText().toString()
                            .equals(txtRepetirContrasena.getText().toString())) {
                        Persona persona = new Persona(
                                txtNombre.getText().toString(),
                                txtApellido.getText().toString(),
                                txtUsuario.getText().toString(),
                                txtContrasena.getText().toString());
                        querys.registrarPersona(persona);
                        startActivity(new Intent(RegistroUsuarioActivity.this, MainActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Contraseñas no coinciden",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Ingrese todos los campos",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro_usuario, menu);
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
