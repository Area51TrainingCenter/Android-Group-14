package com.johannfjs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.johannfjs.mod1class3.R;
import com.johannfjs.models.Item;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by johannfjs on 02/06/15.
 */
public class ListaAdapter extends BaseAdapter {
    Context context;
    ArrayList<Item> lista;

    public ListaAdapter(Context context, ArrayList<Item> lista) {
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
        TextView textoUno, textoDos, textoTres, tiempo;
        ImageView cancelar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_list, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textoUno = (TextView) convertView.findViewById(R.id.lblTextoUno);
            viewHolder.textoDos = (TextView) convertView.findViewById(R.id.lblTextoDos);
            viewHolder.textoTres = (TextView) convertView.findViewById(R.id.lblTextoTres);
            viewHolder.tiempo = (TextView) convertView.findViewById(R.id.lblTiempo);
            viewHolder.cancelar = (ImageView) convertView.findViewById(R.id.ivCancel);
            convertView.setTag(viewHolder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        Item item = (Item) getItem(position);
        holder.textoUno.setText(lista.get(position).getTextoUno());
        holder.textoDos.setText(item.getTextoDos());
        holder.textoTres.setText(item.getTextoTres());
        holder.tiempo.setText(item.getTiempo());
        if (item.isCancel())
            holder.cancelar.setVisibility(View.VISIBLE);
        else
            holder.cancelar.setVisibility(View.GONE);
        return convertView;
    }
}
