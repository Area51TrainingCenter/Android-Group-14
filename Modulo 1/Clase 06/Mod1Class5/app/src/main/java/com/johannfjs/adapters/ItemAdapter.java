package com.johannfjs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.johannfjs.mod1class5.R;
import com.johannfjs.models.Item;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johannfjs on 09/06/15.
 */
public class ItemAdapter extends ArrayAdapter<Item> {
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    Context context;
    ArrayList<Item> lista;

    public ItemAdapter(Context context, ArrayList<Item> objects) {
        super(context, R.layout.item_grid, objects);
        this.context = context;
        this.lista = objects;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView lblTexto;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_grid, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.ivImagen);
            viewHolder.lblTexto = (TextView) convertView.findViewById(R.id.lblTexto);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        imageLoader.displayImage(lista.get(position).getRutaImagen(), viewHolder.imageView);
        viewHolder.lblTexto.setText(lista.get(position).getDescripcion());
        return convertView;
    }
}
