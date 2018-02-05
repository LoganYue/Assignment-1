package com.example.ltyue.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class New_Subscription extends AppCompatActivity {

    private ArrayList<Subscription> subList;

    EditText name;
    EditText date;
    EditText cost;
    EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_subscription);
        name = (EditText) findViewById(R.id.subname);
        date = (EditText) findViewById(R.id.subdate);
        cost = (EditText) findViewById(R.id.subcost);
        comment = (EditText) findViewById(R.id.commentBox);

        final Button createSub = findViewById(R.id.createSub);
        createSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                String message = "testing";
                String subName = name.getText().toString();
                String subDate = date.getText().toString();
                double subCost = Double.parseDouble(cost.getText().toString());
                String subComment = comment.getText().toString();


                Intent main = new Intent();
                main.putExtra("subName", subName);
                main.putExtra("subDate", subDate);
                main.putExtra("subCost", subCost);
                main.putExtra("subComment", subComment);

                setResult(RESULT_OK, main);
                finish();

            }
        });

    }

}
