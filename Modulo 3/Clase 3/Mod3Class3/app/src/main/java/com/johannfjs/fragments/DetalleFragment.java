package com.johannfjs.fragments;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.johannfjs.mod3class3.MainActivity;
import com.johannfjs.mod3class3.R;

/**
 * Created by johannfjs on 04/08/15.
 */
public class DetalleFragment extends Fragment {
    ImageView ivImagen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_detalle, container, false);
        ivImagen = (ImageView) root.findViewById(R.id.ivImagen);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        ivImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).toggle();
            }
        });
    }
}
