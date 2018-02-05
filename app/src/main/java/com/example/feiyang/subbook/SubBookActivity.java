package com.example.feiyang.subbook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.provider.Telephony.Mms.Part.FILENAME;


public class SubBookActivity extends AppCompatActivity {
    //private Button button;
    private EditText bodyText;
    private ListView oldSubList;
    private static final int RETURN_CODE = 1;
    private ArrayList<AddNewSub> subList;
    private ArrayAdapter<AddNewSub> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_book);

        TextView WELCOME= (TextView) findViewById(R.id.textView);
        //Button deleteButton = (Button) findViewById(R.id.button15);
        Button listButton = (Button) findViewById(R.id.button);
        Button addButton = (Button) findViewById(R.id.button2);
        //Button JANButton = (Button) findViewById(R.id.button3);

        //Button saveButton = (Button) findViewById(R.id.save);
        //oldSubList = (ListView) findViewById(R.id.oldSubList);

        listButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),ShowSub.class);
                //startActivityForResult(intent, RETURN_CODE);
                //adapter.notifyDataSetChanged();

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),AddNewSub.class);
                startActivityForResult(intent, RETURN_CODE);
                adapter.notifyDataSetChanged();

            }
        });


    }

    @Override
    protected void onStart() {

        // TODO Auto-generated method stub
        super.onStart();
        Log.i("LifeCycle --->", "onStart is called");


    }

    private void readfromfile() {

        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Taken https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            // 2018-01-23
            Type listType = new TypeToken<ArrayList<AddNewSub>>(){}.getType();
            subList = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            subList = new ArrayList<AddNewSub>();
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }


    private void saveInFile() {
        try {

            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(subList);
            fos.close();


            //gson.toJson(subList, out);
            //flush.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Lifecycle", "onDestroy is called");
    }
}

