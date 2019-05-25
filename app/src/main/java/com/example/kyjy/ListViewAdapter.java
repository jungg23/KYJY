package com.example.kyjy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter  extends BaseAdapter {
        private ArrayList<ListViewItem> listViewItems = new ArrayList<ListViewItem>() ;

        public ListViewAdapter() {
        }

        // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
        @Override
        public int getCount() {
            return listViewItems.size() ;
        }

        // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos = position;
            final Context context = parent.getContext();

            // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.list_view_item, parent, false);
            }

            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            ImageView ImageView = (ImageView) convertView.findViewById(R.id.image);
            TextView name = (TextView) convertView.findViewById(R.id.name);
            TextView cycle = (TextView) convertView.findViewById(R.id.cycle);
            TextView when = (TextView) convertView.findViewById(R.id.when);
            TextView times = (TextView) convertView.findViewById(R.id.times);
            TextView time = (TextView) convertView.findViewById(R.id.time);


            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            ListViewItem listViewItem = listViewItems.get(position);

            // 아이템 내 각 위젯에 데이터 반영
            ImageView.setImageDrawable(listViewItem.getImage());
            name.setText(listViewItem.getName());
            cycle.setText(listViewItem.getCycle());
            when.setText(listViewItem.getWhen());
            times.setText(listViewItem.getTimes());
            time.setText(listViewItem.getTime());

            return convertView;
        }


        // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
        @Override
        public long getItemId(int position) {
            return position ;
        }

        // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
        @Override
        public Object getItem(int position) {
            return listViewItems.get(position) ;
        }

        // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
        public void addItem(Drawable image, String name, String cycle, String when, String times, String time) {
            ListViewItem item = new ListViewItem();

            item.setImage(image);
            item.setName(name);
            item.setCycle(cycle);
            item.setWhen(when);
            item.setTimes(times);
            item.setTime(time);

            listViewItems.add(item);
        }
}
