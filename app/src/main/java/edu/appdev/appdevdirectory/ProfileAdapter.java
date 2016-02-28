package edu.appdev.appdevdirectory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfileAdapter extends ArrayAdapter {

    private ArrayList<HashMap<String, String>> mData;
    private TextView mNameText;
    private TextView mRoleText;
    private ImageView mProfileImage;


    public ProfileAdapter(Context context, int resource, ArrayList<HashMap<String, String>> objects){
        super(context, resource);
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

        // Set data dynamically
        mNameText = (TextView) convertView.findViewById(R.id.nameTextView);
        mRoleText = (TextView) convertView.findViewById(R.id.roleTextView);
        mProfileImage = (ImageView) convertView.findViewById(R.id.profileImageView);
        HashMap<String, String> item = mData.get(position);
        String url = item.get("image");
        mNameText.setText(item.get("name"));
        mRoleText.setText(item.get("role"));
        Picasso.with(getContext()).load(url).into(mProfileImage);

        return convertView;
    }
}
