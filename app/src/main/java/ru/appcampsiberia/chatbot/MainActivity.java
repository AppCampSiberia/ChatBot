package ru.appcampsiberia.chatbot;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    String punctuations = "`~!@#$%^&*()_+{}|:\"<>?-=[];'./,";
    ArrayList< ArrayList<String> > basicAns = new ArrayList<>();
    LinearLayout mainLayout;
    EditText messageField;
    Button submit;
    int cntMes = 0;
    int marTextLR = 13;
    int marTextTB = 6;
    ScrollView scrollView;
    ArrayList <String> basicQue = new ArrayList<>();
    ArrayList <String> randomAns = new ArrayList<>();
    ArrayList <String> unknownQue = new ArrayList<>();
    Button buttonAbout;
    Button buttonSet;

    boolean waitingAnswer = false;
    String curQue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        messageField = (EditText) findViewById(R.id.messageField);


        initBasicAns();
        initRandomAns();

        buttonAbout = (Button) findViewById(R.id.buttonAbout);
        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(), About.class), 0);
            }
        });

        buttonSet = (Button) findViewById(R.id.buttonSet);
        buttonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(), Settings.class), 0);
            }
        });


        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
            scrollView.post(new Runnable() {
                @Override
                public void run() {
                    scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                }
            });
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
                mes.setTextSize(18);
                cntMes++;
                mes.setText(messageField.getText());
                mes.setBackgroundColor(Color.parseColor("#a8eddf"));
                mes.setId(cntMes);

                if (waitingAnswer){
                    int ind = getIndex(curQue);

                    if (ind == -1) {
                        basicAns.add(new ArrayList<String>());
                        basicQue.add(delPunc(curQue));
                        basicAns.get(basicAns.size() - 1).add(messageField.getText().toString());
                    } else {
                        basicAns.get(ind - 1).add(messageField.getText().toString());
                    }
                    waitingAnswer = false;
                }

                LinearLayout.LayoutParams paramMes = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                paramMes.setMargins(173, 2, 2, 2);
                mes.setPadding(marTextLR, marTextTB, marTextLR, marTextTB);
                mes.setLayoutParams(paramMes);
                paramMes.gravity = Gravity.RIGHT;
                mainLayout.addView(mes);


                TextView ans = new TextView(MainActivity.this);
                ans.setTextSize(18);
                String answer = getAnswer(messageField.getText());
                answer += '.';
                Random r = new Random();
                if (r.nextInt(3) == 0 && unknownQue.size() > 0) {
                    answer += '\n';
                    int index = r.nextInt(unknownQue.size());
                    curQue = unknownQue.get(index);
                    unknownQue.remove(index);
                    answer += curQue;
                    answer += '?';
                    waitingAnswer = true;

                } else{
                    waitingAnswer = false;
                }

                ans.setText(answer);

                ans.setBackgroundColor(Color.parseColor("#d1c4ef"));
                messageField.setText("");
                ans.setId(cntMes);

                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                param.setMargins(2, 2, 173, 2);


                ans.setLayoutParams(param);
                ans.setPadding(marTextLR,marTextTB,marTextLR,marTextTB);

                mainLayout.addView(ans);
                scrollView.scrollTo(mainLayout.getMeasuredWidth(), mainLayout.getMeasuredHeight());
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                });

                cntMes++;
            }
        });


        findViewById(R.id.scrollView).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                hideKeyboard(view);
                return false;
            }
        });

    }

    protected int getIndex (String text) {
        for (int i = 0; i < basicQue.size(); i++) {
            if (basicQue.get(i).equals(text)) {
                return i;
            }

        }
        return -1;
    }

    protected String getAnswer(Editable t) {
        String text = t.toString();
        text = text.toLowerCase();
        text = delPunc(text);
        Random r = new Random();

        for (int i = 0; i < basicQue.size(); i++) {
            if (isEqual(splitStr(text), splitStr(basicQue.get(i))))
                return basicAns.get(i).get(r.nextInt(basicAns.get(i).size()));
        }

        if (!unknownQue.contains(text))
            unknownQue.add(text);

        return randomAns.get(r.nextInt(randomAns.size()));
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
            int ind = getIndex(question);

            if (ind == -1)
                basicAns.add(new ArrayList<String>());
            if (answer.length() > 0) {
                basicQue.add(delPunc(question));
                basicAns.get(basicAns.size() - 1).add(answer);
            }
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void initRandomAns() {
        InputStream is = getResources().openRawResource(R.raw.random_answers);
        Scanner reader = new Scanner(is);
        while (reader.hasNextLine()) {
            String text = reader.nextLine();
            randomAns.add(text);
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

            if (!found)
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
            if (!b.contains(a.get(i))) {
                return false;
            } else {
                int ind = -1;
                for (int j = 0; j < b.size(); j++) {
                    if (a.get(i).equals(b.get(j))) {
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



