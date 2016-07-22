package ru.appcampsiberia.chatbot;

import android.content.SharedPreferences;
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
                SharedPreferences.Editor editor = getSharedPreferences("color_background",MODE_PRIVATE).edit();
                editor.putString("color_background", "#000000");
                editor.commit();

                editor = getSharedPreferences("color_mesfield",MODE_PRIVATE).edit();
                editor.putString("color_mesfield", "#c614c1");
                editor.commit();

                editor = getSharedPreferences("color_buttonSet",MODE_PRIVATE).edit();
                editor.putString("color_buttonSet", "#000000");
                editor.commit();

                editor = getSharedPreferences("color_buttonAbout",MODE_PRIVATE).edit();
                editor.putString("color_buttonAbout", "#000000");
                editor.commit();

                editor = getSharedPreferences("color_buttonsubmit2",MODE_PRIVATE).edit();
                editor.putString("color_buttonsubmit2", "#aef436");
                editor.commit();

                editor = getSharedPreferences("color_buttonAbout2",MODE_PRIVATE).edit();
                editor.putString("color_buttonAbout2", "#aef436");
                editor.commit();

                editor = getSharedPreferences("color_buttonSet2",MODE_PRIVATE).edit();
                editor.putString("color_buttonSet2", "#aef436");
                editor.commit();

                editor = getSharedPreferences("color_buttonsubmit",MODE_PRIVATE).edit();
                editor.putString("color_buttonsubmit", "#000000");
                editor.commit();







            }
        });
        buttonSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSpace.setBackgroundColor(Color.parseColor("#000000"));
                buttonSpace.setTextColor(Color.parseColor("#ffffff"));

                buttonSpace.setTextColor(Color.parseColor("#ecf2fe"));
                buttonSpace.setBackgroundColor(Color.parseColor("#040f49"));
                SharedPreferences.Editor editor = getSharedPreferences("color_background",MODE_PRIVATE).edit();
                editor.putString("color_background", "#040f49");
                editor.commit();

                editor = getSharedPreferences("color_mesfield",MODE_PRIVATE).edit();
                editor.putString("color_mesfield", "#4d0058");
                editor.commit();

                editor = getSharedPreferences("color_buttonSet",MODE_PRIVATE).edit();
                editor.putString("color_buttonSet", "#040f49");
                editor.commit();

                editor = getSharedPreferences("color_buttonSet2",MODE_PRIVATE).edit();
                editor.putString("color_buttonSet2", "#8e88b7");
                editor.commit();

                editor = getSharedPreferences("color_buttonAbout",MODE_PRIVATE).edit();
                editor.putString("color_buttonAbout", "#040f49");
                editor.commit();

                editor = getSharedPreferences("color_buttonAbout2",MODE_PRIVATE).edit();
                editor.putString("color_buttonAbout2", "#8e88b7");
                editor.commit();

                editor = getSharedPreferences("color_buttonsubmit2",MODE_PRIVATE).edit();
                editor.putString("color_buttonsubmit2", "#8e88b7");
                editor.commit();

                editor = getSharedPreferences("color_buttonsubmit",MODE_PRIVATE).edit();
                editor.putString("color_buttonsubmit", "#005191");
                editor.commit();

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

                buttonStandart.setBackgroundColor(Color.parseColor("#cfffaf"));
                buttonStandart.setTextColor(Color.parseColor("#000000"));

                SharedPreferences.Editor editor = getSharedPreferences("color_background",MODE_PRIVATE).edit();
                editor.putString("color_background", "#cfffaf");
                editor.commit();

                editor = getSharedPreferences("color_mesfield",MODE_PRIVATE).edit();
                editor.putString("color_mesfield", "#f3ff7a");
                editor.commit();

                editor = getSharedPreferences("color_buttonSet",MODE_PRIVATE).edit();
                editor.putString("color_buttonSet", "#b7d2ff");
                editor.commit();

                editor = getSharedPreferences("color_buttonSet2",MODE_PRIVATE).edit();
                editor.putString("color_buttonSet2", "#000000");
                editor.commit();

                editor = getSharedPreferences("color_buttonAbout",MODE_PRIVATE).edit();
                editor.putString("color_buttonAbout", "#b7d2ff");
                editor.commit();

                editor = getSharedPreferences("color_buttonAbout2",MODE_PRIVATE).edit();
                editor.putString("color_buttonAbout2", "#000000");
                editor.commit();

                editor = getSharedPreferences("color_buttonsubmit2",MODE_PRIVATE).edit();
                editor.putString("color_buttonsubmit2", "#000000");
                editor.commit();

                editor = getSharedPreferences("color_buttonsubmit",MODE_PRIVATE).edit();
                editor.putString("color_buttonsubmit", "#b7d2ff");
                editor.commit();


            }

        });

        buttonZima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonZima.setTextColor(Color.parseColor("#ffffff"));
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }



}