package com.example.shoocal_task_2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText mEntername;
    private TextInputEditText mEnterphone;
    private Spinner mSpinner;
    private CheckBox mCheckbox;
    private Button mAdd;
    private Button mRemove;
    private Button mSave;

    String[] mSpinnerItem={"---Select Blood Group---","A-Positive","B-Positive","O-Positive","AB-Positive","A-Negative","B-Negative","O-Negative","AB-Negative"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        Toolbar toolbar =  findViewById(R.id.Formtoolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.arrow_back);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ArrayAdapter BloodGroupArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,mSpinnerItem);
        BloodGroupArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(BloodGroupArrayAdapter);


        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEntername.getText().toString();
                String number =mEnterphone.getText().toString();
                String bloodgroup = mSpinner.getSelectedItem().toString();


                if(TextUtils.isEmpty(name)){
                    mEntername.setError("Please Enter name");
                    mEntername.requestFocus();
                }
                else if(TextUtils.isEmpty(number)){
                    mEnterphone.setError("Please Enter Phone Number");
                    mEnterphone.requestFocus();
                }

                else if(mSpinner.getSelectedItem().toString().equals("---Select Blood Group---")){
                    Toast.makeText(MainActivity.this, "Please Select Bloood Group", Toast.LENGTH_SHORT).show();

                }

                else {
                    Intent intent = new Intent(MainActivity.this , ShowData.class);
                    intent.putExtra("name" , name);
                    intent.putExtra("number" , number);
                    intent.putExtra("bloodgroup" , bloodgroup);
                    startActivity(intent);
                    finish();
                }

            }
        });

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCheckbox.setChecked(true);


            }
        });

        mRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSave.setVisibility(View.GONE) ;
            }
        });


    }

    private void initView() {
        mEntername = findViewById(R.id.entername);
        mEnterphone = findViewById(R.id.enterphone);
        mSpinner = findViewById(R.id.spinner);
        mCheckbox = findViewById(R.id.checkbox);
        mAdd = findViewById(R.id.add);
        mRemove = findViewById(R.id.remove);
        mSave = findViewById(R.id.save);
    }
}