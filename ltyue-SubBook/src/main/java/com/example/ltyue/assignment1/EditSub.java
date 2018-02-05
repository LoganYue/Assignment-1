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
    private String arrayIndex;
    private String name;
    private String date;
    private String cost;
    private String comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sub);

        Intent intent = getIntent();
        arrayIndex = intent.getStringExtra("arrayIndex");
        name = intent.getStringExtra("name");
        date = intent.getStringExtra("date");
        cost = intent.getStringExtra("cost");
        comment = intent.getStringExtra("comment");

        nameBox = (EditText) findViewById(R.id.nameBox);
        costBox = (EditText) findViewById(R.id.costBox);
        dateBox = (EditText) findViewById(R.id.dateBox);
        commentBox = (EditText) findViewById(R.id.commentBox);

        nameBox.setText(name);
        costBox.setText(cost);
        dateBox.setText(date);
        commentBox.setText(comment);


        final Button editSub = findViewById(R.id.saveChanges);

        editSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                String newName = nameBox.getText().toString();
                String newCost = costBox.getText().toString();
                String newDate = dateBox.getText().toString();
                String newComment = commentBox.getText().toString();

                Intent main = new Intent();
                main.putExtra("name", newName);
                main.putExtra("cost", newCost);
                main.putExtra("date", newDate);
                main.putExtra("comment", newComment);
                main.putExtra("arrayIndex", arrayIndex);
                main.putExtra("delete", "0");
                setResult(2,main);
                finish();


            }
        });

        final Button deleteSub = findViewById(R.id.delete);

        deleteSub.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent main = new Intent();
                main.putExtra("delete", "1");
                main.putExtra("arrayIndex", arrayIndex);
                setResult(2,main);
                finish();
            }
        });

    }

}
