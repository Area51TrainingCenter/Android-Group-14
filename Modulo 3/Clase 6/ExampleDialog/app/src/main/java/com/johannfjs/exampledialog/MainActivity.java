package com.johannfjs.exampledialog;

import android.app.Dialog;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;


public class MainActivity extends ActionBarActivity {
    private String idCupon;
    private CharSequence tiempoRestante;
    private static final String FORMAT = "%02d:%02d:%02d";
    Button btn;
    TextView lblFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        lblFecha = (TextView) findViewById(R.id.lblFecha);

        //1333065600000

        String dateString = getDate(new Long("1439519214744"), "dd/MM/yyyy HH:mm:ss");
        Log.d("TAG", dateString);
        lblFecha.setText(dateString);

        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = formatter.parse(dateString);
            Date fechaActual = new Date();
            long diference = date.getTime() - fechaActual.getTime();
            SetTiempoRestante(diference);
        } catch (Exception e) {

        }
    }

    private String getDate(long milliSeconds, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        String timezoneID = TimeZone.getDefault().getID();
        formatter.setTimeZone(TimeZone.getTimeZone(timezoneID));
        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.mensaje);
                dialog.setCancelable(false);
                dialog.getWindow().setLayout(800, LinearLayout.LayoutParams.WRAP_CONTENT);

                TextView lblTitulo;
                Button btnIzquierda, btnDerecha;

                lblTitulo = (TextView) dialog.findViewById(R.id.lblTitulo);
                btnIzquierda = (Button) dialog.findViewById(R.id.btnIzquierda);
                btnDerecha = (Button) dialog.findViewById(R.id.btnDerecha);

                lblTitulo.setText("Este es el titulo");
                btnIzquierda.setText("Cancelar");
                btnDerecha.setText("Aceptar");

                btnDerecha.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Boton Aceptar", Toast.LENGTH_SHORT).show();
                    }
                });

                btnIzquierda.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    private void SetTiempoRestante(long fechaExpiracion) {

        new CountDownTimer(fechaExpiracion, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {

                lblFecha.setText("" + String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                lblFecha.setText("done!");
            }
        }.start();

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
