package ru.appcampsiberia.chatbot;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {

    Map<String, ArrayList<String>> basicAns = new HashMap<>();

    boolean isEmpty = true;
    LinearLayout mainLayout;
    EditText messageField;
    Button submit;
    int cntMes = 0;
    int cntAns = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageField = (EditText) findViewById(R.id.messageField);

        initBasicAns();





        mainLayout = (LinearLayout)findViewById(R.id.mainLayout);

        submit = (Button)findViewById(R.id.submitxxx);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView mes = new TextView(MainActivity.this);
                cntMes++;
                mes.setText(messageField.getText());

                mes.setId(cntMes);
                mes.setLayoutParams(new ViewGroup.LayoutParams(200, 200));

                mainLayout.addView(mes);

                TextView ans = new TextView(MainActivity.this);
                ans.setText(getAnswer(messageField.getText()));

                messageField.setText("");
                ans.setId(cntMes);
                ans.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
                mainLayout.addView(ans);

                cntMes++;
            }
        });


        findViewById(R.id.mainLayout).setOnTouchListener(new View.OnTouchListener() {
          @Override
          public boolean onTouch(View view, MotionEvent motionEvent) {
              hideKeyboard(view);
              return true;
            }
        });

    }

    protected String getAnswer(Editable t) {
        String text = t.toString();
        text.toLowerCase();
        Random r = new Random();
        if (basicAns.containsKey(text))
            return basicAns.get(text).get(r.nextInt(basicAns.get(text).size()));
        return "Привет";


    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    protected void initBasicAns() {
        InputStream is = getResources().openRawResource(R.raw.basic_answers);
        Scanner reader = new Scanner(is);
        while (reader.hasNextLine()) {
            String question = reader.nextLine();
            String answer = "";
            if (reader.hasNextLine())
                answer = reader.nextLine();
            if (!basicAns.containsKey(question))
                basicAns.put(question, new ArrayList<String>());
            if (answer != "")
                basicAns.get(question).add(answer);
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    {}

}
