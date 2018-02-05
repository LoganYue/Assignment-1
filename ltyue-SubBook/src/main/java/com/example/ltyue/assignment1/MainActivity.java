/*
 * Copyright (c) Logan Yue February 2018
 *
 * collaborated with Liam McDonald
 * recieved assistance from Kevin DeHaan
 */

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

import java.sql.Date;
import java.util.ArrayList;

/**
 * Main activity displays a list of subscriptions and a new subscription button as well as a
 * total cost tracker
 *
 * @author Logan Yue
 * @see Subscription
 * @see EditSub
 * @see New_Subscription
 */
public class MainActivity extends AppCompatActivity {

    private ListView oldSubList;

    private ArrayList<Subscription> subList = new ArrayList<Subscription>();
    private ArrayAdapter<Subscription> adapter;

    private static final String FILENAME = "newfile.sav";

    public static final int EDIT_SUB = 2;

    /**
     * generates the main page
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oldSubList = (ListView) findViewById(R.id.Subs);

        updateScreen();

        //copied and adjusted from https://teamtreehouse.com/community/how-can-i-open-a-new-activity-when-an-item-is-clicked-on-in-the-listview
        /**
         * interaction for moving to EditSub
         *
         * @see EditSub
         * @see Subscription
         */
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

                        startActivityForResult(intent, EDIT_SUB);
                    }
                }
        );



    }

    /**
     * interaction for moving to New_Subscription
     * @param view
     */
    public void createSub(View view) {
        Intent intent = new Intent(this, New_Subscription.class);
        startActivityForResult(intent, 1);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * on returning from New_Subscription
         *
         * @see New_Subscription
         * @see Subscription
         */
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
//                TextView test = findViewById(R.id.TotalCost);
//                test.setText("after Return");

                Bundle subData = data.getExtras();
                if (subData != null) {
                    String name = subData.getString("subName");
                    Date date = Date.valueOf(subData.getString("subDate"));
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

        /**
         * on returning from EditSub
         *
         * @see EditSub
         * @see Subscription
         */
        if (requestCode == EDIT_SUB) {

            int arrayIndex = Integer.parseInt(data.getStringExtra("arrayIndex"));
            int delete = Integer.parseInt(data.getStringExtra("delete"));

            if (delete == 1){
                subList.remove(arrayIndex);
            } else {

                String name = data.getStringExtra("name");
                Date date = Date.valueOf(data.getStringExtra("date"));
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

    /**
     * updates the listview and total cost
     */
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
