package com.example.anew.movieselected;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListviewActivity extends AppCompatActivity {

    String [] data = {"code002","code015","code016","code063","code167","code648"};
    ListView lis_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lis_code = (ListView)findViewById(R.id.lis_code);

        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1 , data);
        lis_code.setAdapter(adapter);
        lis_code.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplication(), data[position] ,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
