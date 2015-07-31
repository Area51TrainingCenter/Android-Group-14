package com.johannfjs.mod3class1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.johannfjs.models.Usuario;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    EditText txtUsuario, txtClave;
    Button btnGrabar;
    TextView lblTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtClave = (EditText) findViewById(R.id.txtClave);
        btnGrabar = (Button) findViewById(R.id.btnGrabar);
        lblTexto = (TextView) findViewById(R.id.lblTexto);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAll();
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject parseObject = new ParseObject("Persona");
                parseObject.put("usuario", txtUsuario.getText().toString());
                parseObject.put("password", txtClave.getText().toString());
                parseObject.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(getApplicationContext(), "TODO OK", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "TODO MAL", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }

    private ArrayList<Usuario> getAll() {
        final ArrayList<Usuario> lista = new ArrayList<Usuario>();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Persona");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (list != null) {
                    String texto = "";
                    for (ParseObject obj : list) {
                        lista.add(new Usuario(obj.getString("usuario"),
                                obj.getString("password")));
                        texto += obj.getString("usuario") + "---" + obj.getString("password");
                        texto += "-----";
                    }
                    lblTexto.setText(texto);
                }
            }
        });
        return lista;
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
