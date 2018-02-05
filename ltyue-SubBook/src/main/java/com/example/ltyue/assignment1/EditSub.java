package com.example.ltyue.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditSub extends AppCompatActivity {

    private EditText nameBox;
    private EditText dateBox;
    private EditText costBox;
    private EditText commentBox;
    private Subscription sub;
    private String gsonSub;
    private int arrayIndex;
    private Intent intent;
    private String name;
    private String date;
    private int cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sub);

        Intent intent = getIntent();
//        arrayIndex = Integer.parseInt(intent.getStringExtra("arrayIndex"));
        name = intent.getStringExtra("name");
        date = intent.getStringExtra("date");
        cost = Integer.parseInt(intent.getStringExtra("cost"));
//        gsonSub = intent.getStringExtra("subString");

//        Gson gson = new Gson();
//        sub = gson.fromJson(gsonSub, Subscription.class);


        nameBox = (EditText) findViewById(R.id.nameBox);
        costBox = (EditText) findViewById(R.id.costBox);
        dateBox = (EditText) findViewById(R.id.dateBox);

        nameBox.setText(name);
        costBox.setText(cost);
        dateBox.setText(date);


        final Button editSub = findViewById(R.id.saveChanges);

        editSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                String newName = nameBox.getText().toString();
                int newCost = Integer.parseInt(costBox.getText().toString());
                String newDate = dateBox.getText().toString();


            }
        });

    }

}
