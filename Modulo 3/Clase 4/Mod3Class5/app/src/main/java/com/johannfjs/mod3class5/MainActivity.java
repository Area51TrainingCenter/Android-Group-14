package com.johannfjs.mod3class5;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.johannfjs.application.Configuracion;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    TextView lblTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblTexto = (TextView) findViewById(R.id.lblTexto);

        saveData();
    }

    private void saveData() {
        try {
            JSONObject jsonObject = new JSONObject("{\n" +
                    "    \"nombre\": \"Johann\",\n" +
                    "    \"ruc\": \"94579905492\",\n" +
                    "    \"razon_social\": \"Vurbo S.A.C.\",\n" +
                    "    \"direccion\": {\n" +
                    "      \"pais_id\": \"9589\",\n" +
                    "      \"departamento_id\": \"15\",\n" +
                    "      \"provincia_id\": \"1501\",\n" +
                    "      \"distrito_id\": \"150107\",\n" +
                    "      \"calle\": \"889 Lee Avenue\"\n" +
                    "    },\n" +
                    "    \"categoria\": \"559c5dde9b024e47e931533b\",\n" +
                    "    \"membresia\": \"559c5de19b024e47e9315344\",\n" +
                    "    \"vencimiento_membresia\": null,\n" +
                    "    \"contacto\": {\n" +
                    "      \"apellidos\": \"Wallace\",\n" +
                    "      \"nombres\": \"Flores\",\n" +
                    "      \"telefono\": \"(804) 587-3137\",\n" +
                    "      \"email\": \"flores.wallace@gmail.com\",\n" +
                    "      \"cargo\": null\n" +
                    "    },\n" +
                    "    \"url\": \"https://vurbo.com\",\n" +
                    "    \"comentarios\": \"Ea mollit ullamco laboris dolor aliqua aliquip labore voluptate duis mollit deserunt aliqua qui.\",\n" +
                    "    \"fecha_activacion\": \"Tue Dec 25 2007 06:22:37 GMT+0000 (UTC)\",\n" +
                    "    \"estado\": 2\n" +
                    "  }");
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.POST,
                    "https://cuponeo.herokuapp.com/negocio/save",
                    jsonObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Toast.makeText(getApplicationContext(),
                                    response.toString(),
                                    Toast.LENGTH_SHORT).show();
                            lblTexto.setText(response.toString());
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }
            ) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/json");
                    return params;
                }
            };
            Configuracion.getInstance().addToRequestQueue(jsonObjectRequest);
        } catch (Exception e) {

        }
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
