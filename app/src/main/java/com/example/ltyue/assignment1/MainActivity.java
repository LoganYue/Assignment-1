package com.example.ltyue.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "subs.sav";
    private ListView oldSubList;

    private ArrayList<Subscription> subList;
    private ArrayAdapter<Subscription> adapter;

//    private EditText name;
//    private EditText date;
//    private EditText cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oldSubList = (ListView) findViewById(R.id.Subs);

    }

    public void createSub(View view) {
        Intent intent = new Intent(this, New_Subscription.class);
        startActivity(intent);
    }

}
