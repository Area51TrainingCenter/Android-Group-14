package com.johannfjs.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

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
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
