package com.johannfjs.mod1class2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView texto;
    private EditText ingrese_texto;
    private Button probar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (TextView) findViewById(R.id.lblTexto);
        ingrese_texto = (EditText) findViewById(R.id.txtTexto);
        probar = (Button) findViewById(R.id.btnProbando);
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
