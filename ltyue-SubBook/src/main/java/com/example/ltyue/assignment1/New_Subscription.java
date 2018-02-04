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
//    private EditText comment;
//    private String subname;
//    private String subdate;
//    private int subcost;
    private ArrayList<Subscription> subList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_subscription);
        name = (EditText) findViewById(R.id.subname);
        date = (EditText) findViewById(R.id.subdate);
        cost = (EditText) findViewById(R.id.subcost);
//        Button saveButton = (Button) findViewById(R.id.createSub);

        final Button createSub = findViewById(R.id.createSub);
        createSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                String message = "testing";
                String subName = name.getText().toString();
                String subDate = date.getText().toString();
                int subCost = Integer.parseInt(cost.getText().toString());

                //testing stuff
                TextView test = findViewById(R.id.test);
                test.setText(message + subName + subDate + subCost);

                Intent main = new Intent();
                main.putExtra("subName", subName);
                main.putExtra("subDate", subDate);
                main.putExtra("subCost", subCost);
                setResult(RESULT_OK, main);
                finish();
                //Subscription newSub = new Subscription(subName, subDate, subCost);
                //saveSub(newSub);
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
