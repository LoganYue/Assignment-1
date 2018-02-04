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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView oldSubList;

    private ArrayList<Subscription> subList;
    private ArrayAdapter<Subscription> adapter;

    private ArrayList<String> subStrings = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oldSubList = (ListView) findViewById(R.id.Subs);

        //copied and adjusted from https://teamtreehouse.com/community/how-can-i-open-a-new-activity-when-an-item-is-clicked-on-in-the-listview

        oldSubList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(view.getContext(), EditSub.class);
                        startActivity(intent);
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
                TextView test = findViewById(R.id.TotalCost);
//                test.setText("after Return");

                Bundle subData = data.getExtras();
                if (subData != null) {
                    String name = subData.getString("subName");
                    String date = subData.getString("subDate");
                    int cost = subData.getInt("subCost");

                    subStrings.add("Name:" + name + '\n' + "Cost:" + cost + '\n' + "Date:" + date);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                            android.R.layout.simple_list_item_1, subStrings);

                    oldSubList.setAdapter(adapter);
                }

            }
        }
    }
    

}
