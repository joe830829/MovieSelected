package com.example.anew.movieselected;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class inoutActivity extends AppCompatActivity {
    TextView output;
    Button btn_output,btn_function1,btn_function2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inout);

        output = (TextView)findViewById(R.id.output);
        btn_output = (Button)findViewById(R.id.btn_output);
        btn_function1 = (Button)findViewById(R.id.btn_function1);



        btn_function2 = (Button)findViewById(R.id.btn_function2);


        btn_output.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText("子曰：Just do it");
            }
        });
        btn_function1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        btn_function2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplication(),ListviewActivity.class);
                startActivity(it);
            }
        });

    }
}
