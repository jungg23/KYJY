package com.example.kyjy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

//hello
   ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.list_view);
        ListViewAdapter adapter = new ListViewAdapter();

        listView.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background),
                "비타민", "매일","식후", "1번", "PM01:00") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background),
                "피임약", "매일","식후", "1번", "AM10:00") ;



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // 커스텀 다이얼로그에서 입력한 메시지를 출력할 TextView 를 준비한다.
        final TextView main_label = (TextView) findViewById(R.id.main_label);

        // 커스텀 다이얼로그를 호출할 버튼을 정의한다.
        FloatingActionButton fab_security = (FloatingActionButton)findViewById(R.id.fab_security);

        fab_security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                CustomDialog customDialog = new CustomDialog(MainActivity.this);

                // 커스텀 다이얼로그를 호출한다.
                // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                customDialog.callFunction(main_label);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        //or switch문을 이용하면 될듯 하다.

        if (id == R.id.action_authority) {
            Toast.makeText(this, "권한 설정", Toast.LENGTH_SHORT).show();
            Intent Intent = new Intent(this, Password.class); //클래스명 바꾸기
            startActivity(Intent);
            return true;
        }

        else if (id == R.id.action_password) {
            Toast.makeText(this, "비밀번호 설정", Toast.LENGTH_SHORT).show();
            Intent Intent = new Intent(this, Password.class);
            startActivity(Intent);
            return true;
        }

        else if (id == R.id.action_logout) {
            Toast.makeText(this, "로그아웃", Toast.LENGTH_SHORT).show();
            Intent Intent = new Intent(this, Password.class); //클래스명 바꾸기
            startActivity(Intent);
            return true;
        }

        else if (id == R.id.ex) {
            Toast.makeText(this, "혜령언니 테스트", Toast.LENGTH_SHORT).show();
            Intent Intent = new Intent(this, Password.class); //클래스명 바꾸기
            startActivity(Intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


}
