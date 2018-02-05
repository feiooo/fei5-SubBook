package com.example.feiyang.subbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Fei Yang on 2018-02-05.
 */

public class AddNewSub extends AppCompatActivity {
    //private Button button;
    private EditText bodyText;
    private ListView oldSubList;
    private static final int RETURN_CODE = 1;
    private ArrayList<AddNewSub> subList;
    private ArrayAdapter<AddNewSub> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_sub);

        //button = (Button) findViewById(R.id.button);
        EditText name = (EditText) findViewById(R.id.editText);
        EditText date = (EditText) findViewById(R.id.editText2);
        EditText charge = (EditText) findViewById(R.id.editText3);
        EditText comment = (EditText) findViewById(R.id.editText4);
        Button saveButton = (Button) findViewById(R.id.button17);
        //Button editButton = (Button) findViewById(R.id.button16);
        /*
        deleteButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Intent intent = new Intent(getBaseContext(),ShowSub.class);
                //startActivityForResult(intent, RETURN_CODE);
                //adapter.notifyDataSetChanged();

            }
        });
        */

        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Intent intent = new Intent(getBaseContext(), AddNewSub.class);
                //startActivityForResult(intent, RETURN_CODE);
                //adapter.notifyDataSetChanged();

            }
        });


    }
}
