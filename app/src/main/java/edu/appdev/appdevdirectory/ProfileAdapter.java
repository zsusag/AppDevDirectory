package edu.appdev.appdevdirectory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class ProfileAdapter extends ArrayAdapter {

    private List mData;
    public ProfileAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.mData = objects;
    }

    @Override
    public int getCount() {
        return this.mData.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item, null);
        }
        return convertView;
    }
}
