package com.example.listcity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    ListView cityList;
    Toolbar toolbar;
    Button add_button, del_button, confirm_button;
    EditText city;
    LinearLayout box;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        cityList = findViewById(R.id.city_list);
        add_button = findViewById(R.id.add_button_id);
        del_button = findViewById(R.id.del_button_id);
        confirm_button = findViewById(R.id.confirm_button_id);
        city = findViewById(R.id.city);
        box = findViewById(R.id.add_box);

        dataList = new ArrayList<>();
        cityAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.context, dataList);
        cityList.setAdapter(cityAdapter);

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                item = adapterView.getItemAtPosition(i).toString();

                del_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dataList.remove(item);
                        cityAdapter.notifyDataSetChanged();

                    }
                });
            }

        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                box.setVisibility(View.VISIBLE);
                city.requestFocus();

                confirm_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String input = city.getText().toString().trim();
                        if(!input.isEmpty()) {
                            dataList.add(input);
                            cityAdapter.notifyDataSetChanged();
                            city.setText("");
                            box.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
    }
}