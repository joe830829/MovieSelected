package com.example.anew.movieselected;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class inoutActivity extends AppCompatActivity {
    TextView output;
    Button btn_output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inout);

        output = (TextView)findViewById(R.id.output);
        btn_output = (Button)findViewById(R.id.btn_output);

        btn_output.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }
}
