package com.example.bob.knowyourheritage;

import android.app.ListActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by _vaibbhavv_ on 8/29/2017.
 */

class StadiumAdapter extends BaseAdapter {
    public final DrawerActivity draweractivity;
    public final List<Stadium> stadiums;

    public StadiumAdapter(DrawerActivity draweractivity, List<Stadium> stadiums) {
        this.draweractivity=draweractivity;
        this.stadiums=stadiums;

    }

    @Override
    public int getCount() {
        return stadiums.size();
    }

    @Override
    public Object getItem(int position) {
        return stadiums.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(draweractivity).inflate(R.layout.single_row,parent,false);
        TextView title = (TextView) convertView.findViewById(R.id.editText);
        TextView descp = (TextView) convertView.findViewById(R.id.editText2);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView) ;

        Stadium stadium = stadiums.get(position);
        String imgname = stadium.getTitle();
        title.setText(stadium.getTitle());
        descp.setText(stadium.getDescription());
        if(imgname.equals("Eden Garden"))
        {
            image.setImageResource(R.drawable.edengardn);
        }
        if(imgname.equals("The Lords"))
        {
            image.setImageResource(R.drawable.mcg);
        }
        if(imgname.equals("MCG"))
        {
            image.setImageResource(R.drawable.edengardn);
        }
        if(imgname.equals("The Wanderers"))
        {
            image.setImageResource(R.drawable.thewanderers);
        }
        if(imgname.equals("The Oval"))
        {
            image.setImageResource(R.drawable.theoval);
        }
        if(imgname.equals("New Lands"))
        {
            image.setImageResource(R.drawable.newlands);
        }
        if(imgname.equals("The WACA"))
        {
            image.setImageResource(R.drawable.thewaca);
        }
        if(imgname.equals("Kensington Oval"))
        {
            image.setImageResource(R.drawable.kensington);
        }
        if(imgname.equals("Old Trafford"))
        {
            image.setImageResource(R.drawable.oldtrafford);
        }
        if(imgname.equals("SCG"))
        {
            image.setImageResource(R.drawable.scc);
        }
        return convertView;

    }
}
