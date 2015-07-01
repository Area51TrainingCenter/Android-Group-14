package com.johannfjs.mod2class2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.johannfjs.sqlite.Querys;


public class MainActivity extends ActionBarActivity {
    EditText txtUsuario, txtContrasena;
    Button btnLogin;
    Querys querys;
    LinearLayout llRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        querys = new Querys(MainActivity.this);
        int sesion = querys.verificarSesion();
        switch (sesion) {
            case 1:
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                finish();
                break;
        }

        setContentView(R.layout.activity_main);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtContrasena = (EditText) findViewById(R.id.txtContrasena);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        llRegistrarse = (LinearLayout) findViewById(R.id.llRegistrarse);
    }

    @Override
    protected void onResume() {
        super.onResume();
        llRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistroUsuarioActivity.class));
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtUsuario.getText().toString().length() > 0 &&
                        txtContrasena.getText().toString().length() > 0) {
                    boolean existe = querys.validarPersona(
                            txtUsuario.getText().toString(),
                            txtContrasena.getText().toString()
                    );
                    if (existe) {
                        querys.actualizarSesion(1);
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        querys.actualizarSesion(0);
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
