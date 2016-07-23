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
    Button buttonPres;
    int color = Color.parseColor("#d7d7d7");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        buttonZima = (Button) findViewById(R.id.buttonZima);
        buttonNeon = (Button) findViewById(R.id.buttonNeon);
        buttonStandart = (Button) findViewById(R.id.buttonStandart);
        buttonSpace = (Button) findViewById(R.id.buttonSpace);
        buttonColor = (Button) findViewById(R.id.buttonColor);
        buttonPres = (Button) findViewById(R.id.buttonPres);

        SharedPreferences p = getSharedPreferences("cur_theme", MODE_PRIVATE);
        String c = p.getString("cur_theme","standart" );

        if (c.equals("standart")) {
            buttonStandart.setBackgroundColor(Color.parseColor("#cfffaf"));
            buttonStandart.setTextColor(Color.parseColor("#000000"));

            buttonColor.setTextColor(Color.parseColor("#000000"));
            buttonColor.setBackgroundColor(color);
            buttonNeon.setBackgroundColor(color);
            buttonNeon.setTextColor(Color.parseColor("#000000"));
            buttonSpace.setBackgroundColor(color);
            buttonSpace.setTextColor(Color.parseColor("#000000"));
            buttonZima.setBackgroundColor(color);
            buttonZima.setTextColor(Color.parseColor("#000000"));
        } else if (c.equals("neon")) {
            buttonNeon.setTextColor(Color.parseColor("#0CFF00"));
            buttonNeon.setBackgroundColor(Color.parseColor("#000000"));

            buttonStandart.setTextColor(Color.parseColor("#000000"));
            buttonStandart.setBackgroundColor(color);
            buttonColor.setTextColor(Color.parseColor("#000000"));
            buttonColor.setBackgroundColor(color);
            buttonSpace.setBackgroundColor(color);
            buttonSpace.setTextColor(Color.parseColor("#000000"));
            buttonZima.setBackgroundColor(color);
            buttonZima.setTextColor(Color.parseColor("#000000"));
        } else if (c.equals("space")) {
            buttonStandart.setTextColor(Color.parseColor("#000000"));
            buttonStandart.setBackgroundColor(color);
            buttonColor.setTextColor(Color.parseColor("#000000"));
            buttonColor.setBackgroundColor(color);
            buttonNeon.setBackgroundColor(color);
            buttonNeon.setTextColor(Color.parseColor("#000000"));
            buttonZima.setBackgroundColor(color);
            buttonZima.setTextColor(Color.parseColor("#000000"));

            buttonSpace.setTextColor(Color.parseColor("#ecf2fe"));
            buttonSpace.setBackgroundColor(Color.parseColor("#040f49"));
        } else if (c.equals("zima")) {
            buttonZima.setTextColor(Color.parseColor("#ffffff"));
            buttonZima.setTextColor(Color.parseColor("#eaf9fe"));

            buttonStandart.setTextColor(Color.parseColor("#000000"));
            buttonStandart.setBackgroundColor(color);
            buttonColor.setTextColor(Color.parseColor("#000000"));
            buttonColor.setBackgroundColor(color);
            buttonNeon.setBackgroundColor(color);
            buttonNeon.setTextColor(Color.parseColor("#000000"));
            buttonSpace.setBackgroundColor(color);
            buttonSpace.setTextColor(Color.parseColor("#000000"));
        } else if (c.equals("color")) {
            buttonColor.setBackgroundColor(Color.parseColor("#FFBABA"));
            buttonColor.setBackgroundColor(Color.parseColor("#ff51ff"));

            buttonStandart.setTextColor(Color.parseColor("#000000"));
            buttonStandart.setBackgroundColor(color);
            buttonNeon.setBackgroundColor(color);
            buttonNeon.setTextColor(Color.parseColor("#000000"));
            buttonSpace.setBackgroundColor(color);
            buttonSpace.setTextColor(Color.parseColor("#000000"));
            buttonZima.setBackgroundColor(color);
            buttonZima.setTextColor(Color.parseColor("#000000"));
        }






        buttonNeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonNeon.setTextColor(Color.parseColor("#0CFF00"));
                buttonNeon.setBackgroundColor(Color.parseColor("#000000"));

                buttonStandart.setTextColor(Color.parseColor("#000000"));
                buttonStandart.setBackgroundColor(color);
                buttonColor.setTextColor(Color.parseColor("#000000"));
                buttonColor.setBackgroundColor(color);
                buttonSpace.setBackgroundColor(color);
                buttonSpace.setTextColor(Color.parseColor("#000000"));
                buttonZima.setBackgroundColor(color);
                buttonZima.setTextColor(Color.parseColor("#000000"));

                SharedPreferences.Editor editor = getSharedPreferences("cur_theme",MODE_PRIVATE).edit();
                editor.putString("cur_theme", "neon");
                editor.commit();

                editor = getSharedPreferences("color_background",MODE_PRIVATE).edit();
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

                buttonPres.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {



                    }
                 });


                buttonSpace.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        buttonStandart.setTextColor(Color.parseColor("#000000"));
                        buttonStandart.setBackgroundColor(color);
                        buttonColor.setTextColor(Color.parseColor("#000000"));
                        buttonColor.setBackgroundColor(color);
                        buttonNeon.setBackgroundColor(color);
                        buttonNeon.setTextColor(Color.parseColor("#000000"));
                        buttonZima.setBackgroundColor(color);
                        buttonZima.setTextColor(Color.parseColor("#000000"));

                        buttonSpace.setTextColor(Color.parseColor("#ecf2fe"));
                        buttonSpace.setBackgroundColor(Color.parseColor("#040f49"));
                        SharedPreferences.Editor editor = getSharedPreferences("color_background", MODE_PRIVATE).edit();
                        editor.putString("color_background", "#040f49");
                        editor.commit();

                        editor = getSharedPreferences("cur_theme", MODE_PRIVATE).edit();
                        editor.putString("cur_theme", "space");
                        editor.commit();

                        editor = getSharedPreferences("color_mesfield", MODE_PRIVATE).edit();
                        editor.putString("color_mesfield", "#ff0016");
                        editor.commit();

                        editor = getSharedPreferences("color_buttonSet", MODE_PRIVATE).edit();
                        editor.putString("color_buttonSet", "#040f49");
                        editor.commit();

                        editor = getSharedPreferences("color_buttonSet2", MODE_PRIVATE).edit();
                        editor.putString("color_buttonSet2", "#8e88b7");
                        editor.commit();

                        editor = getSharedPreferences("color_buttonAbout", MODE_PRIVATE).edit();
                        editor.putString("color_buttonAbout", "#040f49");
                        editor.commit();

                        editor = getSharedPreferences("color_buttonAbout2", MODE_PRIVATE).edit();
                        editor.putString("color_buttonAbout2", "#8e88b7");
                        editor.commit();

                        editor = getSharedPreferences("color_buttonsubmit2", MODE_PRIVATE).edit();
                        editor.putString("color_buttonsubmit2", "#8e88b7");
                        editor.commit();

                        editor = getSharedPreferences("color_buttonsubmit", MODE_PRIVATE).edit();
                        editor.putString("color_buttonsubmit", "#005191");
                        editor.commit();

                    }
                });
        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences.Editor editor = getSharedPreferences("cur_theme",MODE_PRIVATE).edit();
                editor.putString("cur_theme", "color");
                editor.commit();

                buttonColor.setBackgroundColor(Color.parseColor("#FFBABA"));

                buttonStandart.setTextColor(Color.parseColor("#000000"));
                buttonStandart.setBackgroundColor(color);
                buttonNeon.setBackgroundColor(color);
                buttonNeon.setTextColor(Color.parseColor("#000000"));
                buttonSpace.setBackgroundColor(color);
                buttonSpace.setTextColor(Color.parseColor("#000000"));
                buttonZima.setBackgroundColor(color);
                buttonZima.setTextColor(Color.parseColor("#000000"));


            }
        });
        buttonStandart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonStandart.setBackgroundColor(Color.parseColor("#cfffaf"));
                buttonStandart.setTextColor(Color.parseColor("#000000"));

                buttonColor.setTextColor(Color.parseColor("#000000"));
                buttonColor.setBackgroundColor(color);
                buttonNeon.setBackgroundColor(color);
                buttonNeon.setTextColor(Color.parseColor("#000000"));
                buttonSpace.setBackgroundColor(color);
                buttonSpace.setTextColor(Color.parseColor("#000000"));
                buttonZima.setBackgroundColor(color);
                buttonZima.setTextColor(Color.parseColor("#000000"));

                SharedPreferences.Editor editor = getSharedPreferences("color_background",MODE_PRIVATE).edit();
                editor.putString("color_background", "#cfffaf");
                editor.commit();

                editor = getSharedPreferences("cur_theme",MODE_PRIVATE).edit();
                editor.putString("cur_theme", "standart");
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

                SharedPreferences.Editor editor = getSharedPreferences("cur_theme",MODE_PRIVATE).edit();
                editor.putString("cur_theme", "zima");
                editor.commit();

                buttonZima.setTextColor(Color.parseColor("#ffffff"));

                buttonStandart.setTextColor(Color.parseColor("#000000"));
                buttonStandart.setBackgroundColor(color);
                buttonColor.setTextColor(Color.parseColor("#000000"));
                buttonColor.setBackgroundColor(color);
                buttonNeon.setBackgroundColor(color);
                buttonNeon.setTextColor(Color.parseColor("#000000"));
                buttonSpace.setBackgroundColor(color);
                buttonSpace.setTextColor(Color.parseColor("#000000"));
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