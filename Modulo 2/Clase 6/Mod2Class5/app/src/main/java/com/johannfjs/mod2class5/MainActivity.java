package com.johannfjs.mod2class5;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.johannfjs.adapters.ListaAdapter;
import com.johannfjs.application.Configuracion;
import com.johannfjs.models.Heroes;
import com.johannfjs.models.Juego;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    ListaAdapter adapter;
    ListView lvHeroes;
    TextView lblTextoUno, lblTextoDos, lblTextoTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvHeroes = (ListView) findViewById(R.id.lvHeroes);
        lblTextoUno = (TextView) findViewById(R.id.lblTextoUno);
        lblTextoDos = (TextView) findViewById(R.id.lblTextoDos);
        lblTextoTres = (TextView) findViewById(R.id.lblTextoTres);
    }

    @Override
    protected void onResume() {
        super.onResume();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                "https://us.api.battle.net/d3/profile/FECORI%231637/?locale=es_MX&apikey=wmzs37hgs52vfc8kwg56jwumy3sa97kc",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.length() > 0) {
                                Juego item = new Juego();
                                ArrayList<Heroes> lista = null;
                                //Detecta que exista battleTag
                                if (response.has("battleTag")) {
                                    //Seteando al objeto
                                    //Battle Tag -> FECORI
                                    item.setBattleTag("Battle Tag -> " + response.getString("battleTag"));
                                }
                                if (response.has("heroes")) {
                                    JSONArray jsonArray = response.getJSONArray("heroes");
                                    if (jsonArray.length() > 0) {
                                        lista = new ArrayList<Heroes>();
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                                            Heroes heroes = new Heroes();
                                            heroes.setParagonLevel(jsonObject.getInt("paragonLevel"));
                                            heroes.setSeasonal(jsonObject.getBoolean("seasonal"));
                                            heroes.setName(jsonObject.getString("name"));
                                            lista.add(heroes);
                                        }
                                        item.setListaHeroes(lista);
                                    }
                                }

                                lblTextoUno.setText(item.getBattleTag());
                                adapter = new ListaAdapter(getApplicationContext(), lista);
                                lvHeroes.setAdapter(adapter);
                            } else {
                                Toast.makeText(getApplicationContext(), "No hay datos", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        Configuracion.getInstance().addToRequestQueue(jsonObjectRequest);
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
