package com.csd.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddMyItem extends AppCompatActivity {

    EditText title;
    EditText subTitle;
    Button addItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_my_item);
        title = findViewById(R.id.ettitle);
        subTitle = findViewById(R.id.etsubTitle);
        addItem = findViewById(R.id.badd);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddMyItem.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", title.getText().toString());
                bundle.putString("subTitle", subTitle.getText().toString());
                i.putExtras(bundle);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
