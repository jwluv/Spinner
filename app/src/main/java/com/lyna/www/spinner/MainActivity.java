package com.lyna.www.spinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerFruit;
    TextView textViewItemSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFruit = findViewById(R.id.spinnerFruit);
        textViewItemSelected = findViewById(R.id.textViewItemSelected);


        List<String> list = new ArrayList<String>();
        list.add("");
        list.add("Apple");
        list.add("Mango");
        list.add("Banana");

        ArrayAdapter<String> dataAdaptor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);

        dataAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFruit.setAdapter(dataAdaptor);
        spinnerFruit.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected = ((TextView)view).getText().toString();
        String itemAtPos = parent.getItemAtPosition(position).toString();

        if(selected!="") {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }
//        textViewItemSelected.setText("Fruit: "+ selected + ", Fruit: " + itemAtPos);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
