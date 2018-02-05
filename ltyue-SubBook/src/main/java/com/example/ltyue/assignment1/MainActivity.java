package com.example.ltyue.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView oldSubList;

    private ArrayList<Subscription> subList = new ArrayList<Subscription>();
    private ArrayAdapter<Subscription> adapter;

//    private ArrayList<String> subStrings = new ArrayList<String>();

    private String gsonSub;

    public static final int EDIT_SUB = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oldSubList = (ListView) findViewById(R.id.Subs);

        //copied and adjusted from https://teamtreehouse.com/community/how-can-i-open-a-new-activity-when-an-item-is-clicked-on-in-the-listview

        oldSubList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Object sub = oldSubList.getItemAtPosition(position);
                        Intent intent = new Intent(view.getContext(), EditSub.class);

                        TextView test = findViewById(R.id.TotalCost);

                        intent.putExtra("name", ((Subscription) sub).getName());
                        intent.putExtra("cost", String.valueOf(((Subscription) sub).getCost()));
                        intent.putExtra("date", ((Subscription) sub).getDate());
                        intent.putExtra("comment", ((Subscription) sub).getComment());
                        intent.putExtra("arrayIndex", String.valueOf(position));
//                        Gson gson = new Gson();
//                        gsonSub = gson.toJson(editSub);
//                        intent.putExtra("subString", gsonSub);
//                        intent.putExtra("arrayIndex", position);

                        startActivityForResult(intent, EDIT_SUB);
                    }
                }
        );



    }

    public void createSub(View view) {
        Intent intent = new Intent(this, New_Subscription.class);
        startActivityForResult(intent, 1);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
//                TextView test = findViewById(R.id.TotalCost);
//                test.setText("after Return");

                Bundle subData = data.getExtras();
                if (subData != null) {
                    String name = subData.getString("subName");
                    String date = subData.getString("subDate");
                    double cost = subData.getDouble("subCost");
                    String comment = subData.getString("subComment");

                    if (comment != ""){

                        Subscription sub = new Subscription(name, date, cost, comment);
                        this.subList.add(sub);

                    } else {

                        Subscription sub = new Subscription(name, date, cost);
                        this.subList.add(sub);
                    }

                    updateScreen();
                }

            }
        }

        if (requestCode == EDIT_SUB) {

            int arrayIndex = Integer.parseInt(data.getStringExtra("arrayIndex"));
            int delete = Integer.parseInt(data.getStringExtra("delete"));

            if (delete == 1){
                subList.remove(arrayIndex);
            } else {

                String name = data.getStringExtra("name");
                String date = data.getStringExtra("date");
                double cost = Double.parseDouble(data.getStringExtra("cost"));
                String comment = data.getStringExtra("comment");
                Object sub = oldSubList.getItemAtPosition(arrayIndex);
                Subscription editSub = (Subscription) sub;

                editSub.setName(name);
                editSub.setDate(date);
                editSub.setCost(cost);
                editSub.setComment(comment);

                subList.set(arrayIndex, editSub);
            }

            updateScreen();
        }

    }

    private void updateScreen() {

        double totalCost = 0.00;
        TextView costBox = findViewById(R.id.TotalCost);

        for (int i = 0; i < subList.size(); i++){
            Subscription sub = subList.get(i);
            totalCost += sub.getCost();

        }

        costBox.setText(String.valueOf("$" + totalCost));

        adapter = new ArrayAdapter<Subscription>(this,
                android.R.layout.simple_list_item_1, subList);
        oldSubList.setAdapter(adapter);



    }

}
