package com.johannfjs.sliding;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.johannfjs.fragments.ColorFragment;
import com.johannfjs.fragments.DetalleFragment;
import com.johannfjs.mod3class3.MainActivity;
import com.johannfjs.mod3class3.R;

public class SampleListFragment extends ListFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list, null);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SampleAdapter adapter = new SampleAdapter(getActivity());
        adapter.add(new SampleItem("Detalle", android.R.drawable.ic_menu_search));
        adapter.add(new SampleItem("Color Verde", android.R.drawable.ic_menu_search));
        adapter.add(new SampleItem("Color Azul", android.R.drawable.ic_menu_search));
        adapter.add(new SampleItem("Color Blanco", android.R.drawable.ic_menu_search));
        adapter.add(new SampleItem("Color Negro", android.R.drawable.ic_menu_search));
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView lv, View v, int position, long id) {
        Fragment newContent = null;
        switch (position) {
            case 0:
                newContent = new DetalleFragment();
                break;
            case 1:
                newContent = new ColorFragment(R.color.green);
                break;
            case 2:
                newContent = new ColorFragment(R.color.blue);
                break;
            case 3:
                newContent = new ColorFragment(android.R.color.white);
                break;
            case 4:
                newContent = new ColorFragment(android.R.color.black);
                break;
        }
        if (newContent != null)
            switchFragment(newContent);
    }

    // the meat of switching the above fragment
    private void switchFragment(Fragment fragment) {
        if (getActivity() == null)
            return;

        if (getActivity() instanceof MainActivity) {
            MainActivity fca = (MainActivity) getActivity();
            fca.switchContent(fragment);
        }
    }

    private class SampleItem {
        public String tag;
        public int iconRes;

        public SampleItem(String tag, int iconRes) {
            this.tag = tag;
            this.iconRes = iconRes;
        }
    }

    public class SampleAdapter extends ArrayAdapter<SampleItem> {

        public SampleAdapter(Context context) {
            super(context, 0);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
            }
            ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
            icon.setImageResource(getItem(position).iconRes);
            TextView title = (TextView) convertView.findViewById(R.id.row_title);
            title.setText(getItem(position).tag);

            return convertView;
        }

    }
}
