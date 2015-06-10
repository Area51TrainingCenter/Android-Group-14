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
    int position = -1;

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

        if (getIntent() != null) {
            if (getIntent().getIntExtra("KEY", -1) > -1) {
                position = getIntent().getIntExtra("KEY", 0);
                Item item = Constant.LISTA.get(position);
                textoUno.setText(item.getTextoUno());
                textoDos.setText(item.getTextoDos());
                textoTres.setText(item.getTextoTres());
                tiempo.setText(item.getTiempo());
                mostrar.setChecked(item.isCancel());
                grabar.setText(getResources().getString(R.string.modificar));
            } else {
                grabar.setText(getResources().getString(R.string.grabar));
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Constant.LISTA == null)
            Constant.LISTA = new ArrayList<Item>();
        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == -1) {
                    Constant.LISTA.add(new Item(
                            Constant.LISTA.size(),
                            textoUno.getText().toString(),
                            textoDos.getText().toString(),
                            textoTres.getText().toString(),
                            tiempo.getText().toString(),
                            "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_00" + (Constant.LISTA.size() + 1) + ".jpg",
                            mostrar.isChecked()
                    ));
                    //"drawable://" + R.drawable.image
                    textoUno.setText("");
                    textoDos.setText("");
                    textoTres.setText("");
                    tiempo.setText("");
                    mostrar.setChecked(false);
                    textoUno.requestFocus();
                } else {
                    Constant.LISTA.get(position).setTextoUno(textoUno.getText().toString());
                    Constant.LISTA.get(position).setTextoDos(textoDos.getText().toString());
                    Constant.LISTA.get(position).setTextoTres(textoTres.getText().toString());
                    Constant.LISTA.get(position).setTiempo(tiempo.getText().toString());
                    Constant.LISTA.get(position).setCancel(mostrar.isChecked());
                    position = -1;
                    //Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                    //startActivity(intent);
                    finish();
                }
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
