package com.johannfjs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.johannfjs.mod2class1.R;
import com.johannfjs.models.Persona;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by johannfjs on 25/06/15.
 */
public class ListaAdapter extends BaseAdapter {
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
        TextView lblNombre, lblApellido, lblEdad, lblSexo;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
            viewHolder.lblApellido = (TextView) convertView.findViewById(R.id.lblApellido);
            viewHolder.lblEdad = (TextView) convertView.findViewById(R.id.lblEdad);
            viewHolder.lblSexo = (TextView) convertView.findViewById(R.id.lblSexo);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        Persona persona = (Persona) getItem(position);
        viewHolder.lblNombre.setText(persona.getNombre());
        viewHolder.lblApellido.setText(persona.getApellido());
        viewHolder.lblEdad.setText(String.valueOf(persona.getEdad()));
        viewHolder.lblSexo.setText(persona.getSexo());
        return convertView;
    }
}
