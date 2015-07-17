package com.johannfjs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.johannfjs.mod2class5.R;
import com.johannfjs.models.Heroes;

import java.util.ArrayList;

/**
 * Created by johannfjs on 16/07/15.
 */
public class ListaAdapter extends BaseAdapter {
    Context context;
    ArrayList<Heroes> lista;

    public ListaAdapter(Context context, ArrayList<Heroes> lista) {
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
        return 0;
    }

    static class ViewHolder {
        TextView lblTextoUno, lblTextoDos, lblTextoTres;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.lblTextoUno = (TextView) convertView.findViewById(R.id.lblTextoUno);
            viewHolder.lblTextoDos = (TextView) convertView.findViewById(R.id.lblTextoDos);
            viewHolder.lblTextoTres = (TextView) convertView.findViewById(R.id.lblTextoTres);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        Heroes item = (Heroes) getItem(position);
        viewHolder.lblTextoUno.setText(item.getName());
        viewHolder.lblTextoDos.setText(String.valueOf(item.getParagonLevel()));
        return convertView;
    }
}
