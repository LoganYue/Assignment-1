package com.example.ltyue.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    private static final String FILENAME = "subs.sav";
    private ListView oldSubList;
//    private String[] subs;

    private ArrayList<Subscription> subList;
    private ArrayAdapter<Subscription> adapter;

    private ArrayList<String> subStrings = new ArrayList<String>();

//    private int totalCost = 0;
//
//    private TextView tCost;

//    private EditText name;
//    private EditText date;
//    private EditText cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        totalCost = 0;
        oldSubList = (ListView) findViewById(R.id.Subs);
//        tCost = (TextView) findViewById(R.id.TotalCost);

        Bundle subData = getIntent().getExtras();
        if (subData != null){
            String name = subData.getString("subName");
            String date = subData.getString("subDate");
            int cost = subData.getInt("subCost");

            //test case
//            TextView test = findViewById(R.id.textView2);
//            test.setText(name + cost + date);

//            Subscription newSub = new Subscription(name, date, cost);
//            subList.add(newSub);
//            ArrayList<String> subStrings = new ArrayList<String>();
//            totalCost += cost;
//            tCost.setText(totalCost);

            subStrings.add(name + '\n' + cost + '\n' + date);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, subStrings);

            oldSubList.setAdapter(adapter);
        }

//        subs = new String[subList.size()];
//        for (int i = 0; i < subList.size(); i++) {
//            Subscription sub = subList.get(i);
//            subs[i] = "a";
//            subs[i] = sub.getSub_name() + "/n" + sub.getCost() + "/n" + sub.getDate();
//        }
//
////        String[] testArray = new String[]{"yes", "no", "maybe so?"};


    }

    public void createSub(View view) {
        Intent intent = new Intent(this, New_Subscription.class);
        startActivity(intent);
    }

//    @Override
//    protected void onStart() {
//        // TODO Auto-generated method stub
//        super.onStart();
//        this.subStrings = new ArrayList<String>();
//
//    }

}
