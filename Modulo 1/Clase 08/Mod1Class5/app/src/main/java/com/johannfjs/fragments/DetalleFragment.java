package com.johannfjs.fragments;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.johannfjs.mod1class5.R;

/**
 * Created by johannfjs on 18/06/15.
 */
public class DetalleFragment extends Fragment {
    ImageView imagen;
    TextView texto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_detalle, container, false);
        imagen = (ImageView) root.findViewById(R.id.ivImagen);
        texto = (TextView) root.findViewById(R.id.lblTexto);
        return root;
    }
}
