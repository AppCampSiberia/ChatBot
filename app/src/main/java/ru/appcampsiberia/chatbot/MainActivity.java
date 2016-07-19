package ru.appcampsiberia.chatbot;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {

    String punctuations = "`~!@#$%^&*()_+{}|:\"<>?-=[];'./,";
    //ArrayList< ArrayList<String> > basicAns = new ArrayList();
    Map<String, ArrayList<String> > basicAns = new HashMap<>();
    boolean isEmpty = true;
    LinearLayout mainLayout;
    EditText messageField;
    Button submit;
    int cntMes = 0;
    int cntAns = 0;
    int marTextLR = 13;
    int marTextTB = 6;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageField = (EditText) findViewById(R.id.messageField);

        initBasicAns();


        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(mainLayout.getMeasuredWidth(), mainLayout.getMeasuredHeight());
            }
        });
        submit = (Button) findViewById(R.id.submitxxx);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (messageField.getText().length() == 0) {
                    return;
                }

                TextView mes = new TextView(MainActivity.this);
                cntMes++;
                mes.setText(messageField.getText());
                mes.setBackgroundColor(Color.parseColor("#ffc122"));

                mes.setId(cntMes);
                LinearLayout.LayoutParams paramMes = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                paramMes.setMargins(173, 2, 2, 2);
                mes.setPadding(marTextLR, marTextTB, marTextLR, marTextTB);
                mes.setLayoutParams(paramMes);
                paramMes.gravity = Gravity.RIGHT;
                mainLayout.addView(mes);

                TextView ans = new TextView(MainActivity.this);
                ans.setText(getAnswer(messageField.getText()));

                ans.setBackgroundColor(Color.parseColor("#8cd9ff"));
                messageField.setText("");
                ans.setId(cntMes);

                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                param.setMargins(2, 2, 173, 2);


                ans.setLayoutParams(param);
                ans.setPadding(marTextLR,marTextTB,marTextLR,marTextTB);

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
        text = delPunc(text);
        Random r = new Random();
        if (basicAns.containsKey(text))
            return basicAns.get(text).get(r.nextInt(basicAns.get(text).size()));
        /*for (int i = 0; i < basicAns.size(); i++) {

        }*/
        return "Привет";
    }

    protected void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
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
            //int ind =

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

    protected String delPunc(String s ){
        String t = "";
        boolean isLastCharPunk = false;
        for (int i = 0; i < s.length(); i++) {
            boolean found = false;
            for (int j = 0; j < punctuations.length(); j++) {
                if (s.charAt(i) == punctuations.charAt(j)  ){
                    found = true;
                    break;
                }
            }

            if (isLastCharPunk)
                t += ' ';

            isLastCharPunk = found;

            if (found == false)
                t += s.charAt(i);
        }
        return t;
    }

    protected ArrayList<String> splitStr(String s) {
        ArrayList<String> result = new ArrayList<String>();
        String w = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (w.length() > 0)
                    result.add(w);
                w = "";
            } else {
                w += s.charAt(i);
            }
        }

        if (w.length() > 0)
            result.add(w);

        return result;
    }


    protected boolean isEqual(ArrayList<String> a, ArrayList<String> b) {
        if (a.size() > b.size()) {
            ArrayList<String> t = a;
            a = b;
            b = t;
        }

        for (int i = 0; i < a.size(); i++) {
            if (b.contains(a.indexOf(i)) == false) {
                return false;
            } else {
                int ind = -1;
                for (int j = 0; i < b.size(); j++) {
                    if (a.indexOf(i) == b.indexOf(j)) {
                        ind = j;
                        break;
                    }
                }
                b.remove(ind);
            }
        }
        return true;

    }


}



