package com.coors.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etAddItem;
    private Button btnAddItem;
    private ListView listView;
    private ArrayList<String> itemList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setUp();
    }

    private void setUp() {
        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itemList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void findViews() {
        etAddItem = findViewById(R.id.et_item_name);
        btnAddItem = findViewById(R.id.btn_add_item);
        listView = findViewById(R.id.listView);
        btnAddItem.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_item:
                if (!etAddItem.getText().toString().trim().matches("")) {
                    itemList.add(etAddItem.getText().toString());
                    adapter.notifyDataSetChanged();
                }
                break;
        }
    }
}
