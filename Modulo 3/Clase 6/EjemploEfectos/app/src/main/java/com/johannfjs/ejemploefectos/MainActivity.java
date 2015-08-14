package com.johannfjs.ejemploefectos;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;


public class MainActivity extends Activity {
    Button btnIzquierda, btnDerecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIzquierda = (Button) findViewById(R.id.btnIzquierda);
        btnDerecha = (Button) findViewById(R.id.btnDerecha);
/*
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

        }
*/
    }

    @Override
    protected void onResume() {
        super.onResume();

        SensorManager sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(new SensorEventListener() {
            int orientation = -1;
            ;

            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[1] < 6.5 && event.values[1] > -6.5) {
                    if (orientation != 1) {
                        //Landscape
                        Log.d("Sensor", "Landscape");

                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                        layoutParams.gravity = Gravity.TOP | Gravity.LEFT;
                        layoutParams.setMargins(0, 90, 0, 0);
                        btnIzquierda.setLayoutParams(layoutParams);
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                        layoutParams2.gravity = Gravity.TOP | Gravity.RIGHT;
                        layoutParams2.setMargins(0, 90, 0, 0);
                        btnDerecha.setLayoutParams(layoutParams2);
/*
                        btnIzquierda.setRotation(90);
                        btnDerecha.setRotation(90);
                        */
                        RotateAnimation rotate = (RotateAnimation) AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate_out);
                        btnIzquierda.setAnimation(rotate);
                        btnDerecha.setAnimation(rotate);
                        btnIzquierda.setRotation(90);
                        btnDerecha.setRotation(90);
                    }
                    orientation = 1;
                } else {
                    if (orientation != 0) {
                        //Portrait
                        Log.d("Sensor", "Portrait");

                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                        layoutParams.gravity = Gravity.TOP | Gravity.LEFT;
                        layoutParams.setMargins(0, 0, 0, 0);
                        btnIzquierda.setLayoutParams(layoutParams);
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                        layoutParams2.gravity = Gravity.TOP | Gravity.RIGHT;
                        layoutParams2.setMargins(0, 0, 0, 0);
                        btnDerecha.setLayoutParams(layoutParams2);
/*
                        btnIzquierda.setRotation(0);
                        btnDerecha.setRotation(0);
                        */
                        RotateAnimation anrotate = (RotateAnimation) AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate_in);
                        btnIzquierda.setAnimation(anrotate);
                        btnDerecha.setAnimation(anrotate);
                        btnIzquierda.setRotation(0);
                        btnDerecha.setRotation(0);

                    }
                    orientation = 0;
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                // TODO Auto-generated method stub

            }
        }, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);
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
