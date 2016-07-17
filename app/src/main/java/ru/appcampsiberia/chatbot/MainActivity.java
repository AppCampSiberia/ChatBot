package ru.appcampsiberia.chatbot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText messageField;
    Editable message;
    TextView chat;
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

        chat = (TextView) findViewById(R.id.chat);

        messageField = (EditText) findViewById(R.id.messageField);

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



    }

    protected String getAnswer(Editable t) {
        String text = t.toString();
        return "Привет";

    }
}
