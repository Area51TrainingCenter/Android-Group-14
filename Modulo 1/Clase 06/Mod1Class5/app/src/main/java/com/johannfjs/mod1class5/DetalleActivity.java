package com.johannfjs.mod1class5;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.johannfjs.models.Item;
import com.johannfjs.utils.Constant;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by johannfjs on 11/06/15.
 */
public class DetalleActivity extends Activity {
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    ImageView imagen;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        imagen = (ImageView) findViewById(R.id.ivImagen);
        texto = (TextView) findViewById(R.id.lblTexto);

        if (getIntent() != null) {
            if (getIntent().getIntExtra("KEY", -1) > -1) {
                Item item = Constant.LISTA.get(getIntent().getIntExtra("KEY", -1));
                texto.setText(item.getDescripcion());
                imageLoader.displayImage(item.getRutaImagen(), imagen);
            }
        }
    }
}
