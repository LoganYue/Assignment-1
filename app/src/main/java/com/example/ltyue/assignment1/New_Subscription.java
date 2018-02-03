package com.example.ltyue.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class New_Subscription extends AppCompatActivity {
    private EditText name;
    private EditText date;
    private EditText cost;
    private EditText comment;
    private String subname;
    private String subdate;
    private int subcost;
    private ArrayList<Subscription> subList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_subscription);
        this.name = (EditText) findViewById(R.id.subname);
        this.date = (EditText) findViewById(R.id.subdate);
        this.cost = (EditText) findViewById(R.id.subcost);
//        Button saveButton = (Button) findViewById(R.id.createSub);

        final Button button = findViewById(R.id.createSub);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                String message = "testing";
                TextView test = findViewById(R.id.test);
                test.setText(message);

            }
        });

    }

//    public void CreateSub(View view) {
//
//        this.subname = this.name.getText().toString();
//        this.subdate = this.date.getText().toString();
//        this.subcost = Integer.parseInt(cost.getText().toString());
//
//        Subscription newSub = new Subscription(subname, subdate, subcost);
//
//        subList.add(newSub);
////        Intent intent = new Intent(this, MainActivity.class);
////        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////        startActivity(intent);
//
//    }

}
