package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar myToolbar;
    private Bundle savedInstanceState;
    ListView list;
    listAdapter adapter;
    ArrayList<Data> arrData;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        adapter = new listAdapter(this, arrData);

        final ArrayList<String> items = new ArrayList<String>();
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, items);

        final ListView listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);


        //리스트뷰에 어댑터 연결
        list = (ListView)findViewById(R.id.listview1);
        list.setAdapter(adapter);

        Button addButton = (Button)findViewById(R.id.add) ;
        addButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count;
                count = adapter.getCount();

                arrData = new ArrayList<Data>();
                arrData.add(new Data(R.drawable.pills, "비타민", "매일", "식후", "1번","PM01:00"));
                arrData.add(new Data(R.drawable.pills, "피임약", "매일", "식후", "1번","AM09:00"));



                // listview 갱신
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void setData(){
        arrData = new ArrayList<Data>();
        arrData.add(new Data(R.drawable.pills, "비타민", "매일", "식후", "1번","PM01:00"));
        arrData.add(new Data(R.drawable.pills, "피임약", "매일", "식후", "1번","AM09:00"));

    }






    //추가된 소스, ToolBar에 menu.xml을 인플레이트함
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    //추가된 소스, ToolBar에 추가된 항목의 select 이벤트를 처리하는 함수
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        // If we got here, the user's action was not recognized.
        // Invoke the superclass to handle it.
        Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);

        }
    }



