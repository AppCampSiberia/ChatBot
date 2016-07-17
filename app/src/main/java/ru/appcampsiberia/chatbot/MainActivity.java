package ru.appcampsiberia.chatbot;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;


public class MainActivity extends AppCompatActivity {

    Map<String, ArrayList<String>> basicAns = new HashMap<>();

    boolean isEmpty = true;
    LinearLayout mainLayout;
    EditText messageField;
    Button submit;
    TextView mes1;
    TextView mes2;
    TextView mes3;
    TextView mes4;
    TextView mes5;
    TextView mes6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageField = (EditText) findViewById(R.id.messageField);

        initBasicAns();

        messageField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty)
                    messageField.setText("");
                isEmpty = false;

            }
        });
        mes1 = (TextView) findViewById(R.id.mes1);
        mes2 = (TextView) findViewById(R.id.mes2);
        mes3 = (TextView) findViewById(R.id.mes3);
        mes4 = (TextView) findViewById(R.id.mes4);
        mes5 = (TextView) findViewById(R.id.mes5);
        mes6 = (TextView) findViewById(R.id.mes6);

        submit = (Button)  findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mes6.setText(mes4.getText());
                mes4.setText(mes2.getText());
                mes5.setText(mes3.getText());
                mes3.setText(mes1.getText());
                mes2.setText(messageField.getText());
                mes1.setText(getAnswer(messageField.getText()));

                messageField.setText("");

            }
        });

        mainLayout = (LinearLayout)findViewById(R.id.mainLayout);

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

}
