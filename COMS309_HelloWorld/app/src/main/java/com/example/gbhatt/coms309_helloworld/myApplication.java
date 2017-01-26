//package com.example.gbhatt.coms309_helloworld;

/**
 * Created by gbhatt on 10/1/16.
 */
package com.example.gbhatt.coms309_helloworld;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class myApplication extends ArrayAdapter<String> {
    private String[] ids;
    private String[] fnames;
    private String[] lnames;
    private Activity context;

    public myApplication(Activity context, String[] ids, String[] fnames, String[] lnames) {
        super(context, R.layout.list_view_layout, ids);
        this.context = context;
        this.ids = ids;
        this.fnames = fnames;
        this.lnames = lnames;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_layout, null, true);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.textViewId);
        TextView textViewFName = (TextView) listViewItem.findViewById(R.id.textViewFName);
        TextView textViewLName = (TextView) listViewItem.findViewById(R.id.textViewLName);

        textViewId.setText(ids[position]);
        textViewFName.setText(fnames[position]);
        textViewLName.setText(lnames[position]);

        return listViewItem;
    }
}