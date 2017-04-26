package com.slu.se_project.contacts;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import com.slu.se_project.R;

/**
 * Created by Sean on 3/6/2017.
 */

public class mListAdapter extends ArrayAdapter<String> {

    Context context;
    int layoutResourceId;
    List data;

    public mListAdapter(Context context, int layoutResourceId, List data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ContactHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ContactHolder();
            //holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTag = (TextView)row.findViewById(R.id.contact_name);
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);

            row.setTag(holder);
        }
        else
        {
            holder = (ContactHolder)row.getTag();
        }

        String name= (String)data.get(position);
        holder.txtTag.setText(name);
        holder.imgIcon.setImageResource(R.drawable.ic_action_restaurant);
        //holder.imgIcon.setImageResource(contact.icon);

        return row;
    }

    static class ContactHolder
    {
        ImageView imgIcon;
        TextView txtTag;
    }

}
