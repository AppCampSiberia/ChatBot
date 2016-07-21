package ru.appcampsiberia.chatbot;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    Button buttonZima;
    Button buttonNeon;
    Button buttonColor;
    Button buttonSpace;
    Button buttonStandart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void onClick(View view) {

        buttonZima = (Button) findViewById(R.id.buttonZima);
        buttonNeon = (Button) findViewById(R.id.buttonNeon);
        buttonStandart = (Button) findViewById(R.id.buttonStandart);
        buttonSpace = (Button) findViewById(R.id.buttonSpace);
        buttonColor = (Button) findViewById(R.id.buttonColor);

        buttonNeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonNeon.setTextColor(Color.parseColor("#0CFF00"));
                buttonNeon.setBackgroundColor(Color.parseColor("#000000"));
            }
        });
        buttonSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSpace.setBackgroundColor(Color.parseColor("#000000"));
                buttonSpace.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonColor.setBackgroundColor(Color.parseColor("#FFBABA"));
            }
        });
        buttonStandart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStandart.setBackgroundColor(Color.parseColor("#cfffaf"));
            }

        });

        buttonZima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonZima.setTextColor(Color.parseColor("#ffffff"));
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}