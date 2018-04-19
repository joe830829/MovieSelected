package com.example.anew.movieselected;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PlusActivity extends AppCompatActivity {

    Button btn_enter;
    EditText input_text;
    TextView output_text;
    String out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);

        btn_enter = (Button)findViewById(R.id.btn_enter);
        input_text = (EditText)findViewById(R.id.input_text);
        output_text = (TextView)findViewById(R.id.output_text);

        btn_enter.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
               out += input_text.getText().toString();
               output_text.setText(out);
            }
        });

    }
}
