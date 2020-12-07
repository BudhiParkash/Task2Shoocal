package com.example.shoocal_task_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class ShowData extends AppCompatActivity {

    private TextView mName;
    private TextView mNumber;
    private TextView mBloodgroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        initView();

        Toolbar toolbar =  findViewById(R.id.showdatatoolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.arrow_back);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String number = intent.getStringExtra("number");
        String bloodgroup = intent.getStringExtra("bloodgroup");

        mName.setText(name);
        mNumber.setText(number);
        mBloodgroup.setText(bloodgroup);


    }

    private void initView() {
        mName = findViewById(R.id.name);
        mNumber = findViewById(R.id.number);
        mBloodgroup = findViewById(R.id.bloodgroup);
    }
}