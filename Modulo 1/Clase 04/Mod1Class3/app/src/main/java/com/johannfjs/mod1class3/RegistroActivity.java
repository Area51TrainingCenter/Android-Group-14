package com.johannfjs.mod1class3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.johannfjs.models.Item;
import com.johannfjs.utils.Constant;

import java.util.ArrayList;

/**
 * Created by johannfjs on 04/06/15.
 */
public class RegistroActivity extends ActionBarActivity {
    EditText textoUno, textoDos, textoTres, tiempo;
    CheckBox mostrar;
    Button grabar, listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        textoUno = (EditText) findViewById(R.id.txtTextoUno);
        textoDos = (EditText) findViewById(R.id.txtTextoDos);
        textoTres = (EditText) findViewById(R.id.txtTextoTres);
        tiempo = (EditText) findViewById(R.id.txtTiempo);
        mostrar = (CheckBox) findViewById(R.id.cbMostrar);
        grabar = (Button) findViewById(R.id.btnGrabar);
        listar = (Button) findViewById(R.id.btnListado);
    }

    @Override
    protected void onResume() {
        super.onResume();
        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Constant.LISTA == null)
                    Constant.LISTA = new ArrayList<Item>();
                Constant.LISTA.add(new Item(
                        Constant.LISTA.size(),
                        textoUno.getText().toString(),
                        textoDos.getText().toString(),
                        textoTres.getText().toString(),
                        tiempo.getText().toString(),
                        mostrar.isChecked()
                ));
                textoUno.setText("");
                textoDos.setText("");
                textoTres.setText("");
                tiempo.setText("");
                mostrar.setChecked(false);
                textoUno.requestFocus();
            }
        });
        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistroActivity.this, MainActivity.class));
            }
        });
    }
}
