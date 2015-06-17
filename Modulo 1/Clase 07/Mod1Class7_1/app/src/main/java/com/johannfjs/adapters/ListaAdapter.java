package com.johannfjs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.johannfjs.mod1class7_1.R;
import com.johannfjs.models.Persona;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by johannfjs on 16/06/15.
 */
public class ListaAdapter extends BaseAdapter {
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    Context context;
    ArrayList<Persona> lista;

    public ListaAdapter(Context context, ArrayList<Persona> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    static class ViewHolder {
        TextView nombre, sexo, edad;
        ImageView imagen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.nombre = (TextView) convertView.findViewById(R.id.lblNombre);
            viewHolder.sexo = (TextView) convertView.findViewById(R.id.lblSexo);
            viewHolder.edad = (TextView) convertView.findViewById(R.id.lblEdad);
            viewHolder.imagen = (ImageView) convertView.findViewById(R.id.ivImagen);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.nombre.setText(lista.get(position).getNombre());
        viewHolder.sexo.setText(lista.get(position).getSexo());
        viewHolder.edad.setText(String.valueOf(lista.get(position).getEdad()));
        imageLoader.displayImage(lista.get(position).getRutaImagen(), viewHolder.imagen);
        return convertView;
    }
}
