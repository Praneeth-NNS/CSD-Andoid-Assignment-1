package com.csd.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.csd.myapplication.adapters.MyItemRecyclerViewAdapter;
import com.csd.myapplication.models.MyItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    List<MyItem> myItems = new ArrayList<>();
    MyItem dummyItem = new MyItem("Title", "SubTitle");
    MyDBHandler db = new MyDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Cursor cursor = db.getMyItem();
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                myItems.add(new MyItem(cursor.getString(1), cursor.getString(2)));
            }
        }


        //if (savedInstanceState != null) {
        //for (int i = 0; i < savedInstanceState.getInt("size"); i++)
        //myItems.add(new MyItem(savedInstanceState.get("title" + i).toString(), savedInstanceState.get("subTitle" + i).toString()));
        //}
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //myItems.add(dummyItem);
        //if (myItems.size() > 1){
        //myItems.remove(dummyItem);
        //}


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //.setAction("Action", null).show();
                Intent i = new Intent(MainActivity.this, AddMyItem.class);
                startActivityForResult(i, 0);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.rvlist);
        MyItemRecyclerViewAdapter adapter = new MyItemRecyclerViewAdapter(this, myItems);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            assert data != null;
            Bundle gotExtras = data.getExtras();
            assert gotExtras != null;
            myItems.add(new MyItem(gotExtras.getString("title"), gotExtras.getString("subTitle")));
            db.addMyItem(new MyItem(gotExtras.getString("title"), gotExtras.getString("subTitle")));

        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//// Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//// Handle action bar item clicks here. The action bar will
//// automatically handle clicks on the Home/Up button, so long
//// as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
////noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//
//
//    }


//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        if (myItems.size() != 0) {
//            for (int i = 0; i < myItems.size(); i++) {
//                outState.putString("title" + i, myItems.get(i).getTitle());
//                outState.putString("subTitle" + i, myItems.get(i).getTitle());
//            }
//            outState.putInt("size", myItems.size());
//        }
//        super.onSaveInstanceState(outState);
//    }
}
