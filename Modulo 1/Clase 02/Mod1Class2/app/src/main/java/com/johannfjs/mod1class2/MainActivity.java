package com.johannfjs.mod1class2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView texto, lblTexto2;
    private EditText ingrese_texto;
    private Button probar, btnPresionar, btnCambiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (TextView) findViewById(R.id.lblTexto);
        lblTexto2 = (TextView) findViewById(R.id.lblTexto2);
        ingrese_texto = (EditText) findViewById(R.id.txtTexto);
        probar = (Button) findViewById(R.id.btnProbando);
        btnPresionar = (Button) findViewById(R.id.btnPresionar);
        btnCambiar = (Button) findViewById(R.id.btnCambiar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        probar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText(getResources().getString(R.string.texto));
            }
        });
        btnPresionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblTexto2.setText(ingrese_texto.getText().toString());
            }
        });
        ingrese_texto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                lblTexto2.setText(ingrese_texto.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
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
