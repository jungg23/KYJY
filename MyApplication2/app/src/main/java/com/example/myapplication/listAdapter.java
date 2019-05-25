package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class listAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Data> arrData;
    private LayoutInflater inflater;

    public listAdapter (Context c, ArrayList<Data> arr) {
        this.context = c;
        this.arrData = arr;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrData.size();

    }

    @Override
    public Object getItem(int position) {
        return arrData.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_custom, parent, false);
        }

        ImageView image = (ImageView)convertView.findViewById(R.id.image);
        image.setImageResource(arrData.get(position).getImage());

        TextView name = (TextView)convertView.findViewById(R.id.name);
        name.setText(arrData.get(position).getName());

        TextView cycle = (TextView)convertView.findViewById(R.id.cycle);
        cycle.setText(arrData.get(position).getCycle());

        TextView when = (TextView)convertView.findViewById(R.id.when);
        when.setText(arrData.get(position).getWhen());

        TextView times = (TextView)convertView.findViewById(R.id.times);
        times.setText(arrData.get(position).getTimes());

        TextView time = (TextView)convertView.findViewById(R.id.time);
        time.setText(arrData.get(position).getTime());

        Button modifyBtn = (Button)convertView.findViewById(R.id.modifybtn);
        modifyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(context, "복용완료", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
