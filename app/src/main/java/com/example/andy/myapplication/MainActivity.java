package com.example.andy.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView list = findViewById(R.id.list);
        ArrayList<SubjectData> arrayList = new ArrayList<SubjectData>();
        arrayList.add(new SubjectData("PM", "4:00", ""));
        arrayList.add(new SubjectData("PM", "5:00", ""));
        arrayList.add(new SubjectData("AM", "6:00", ""));
        arrayList.add(new SubjectData("AM", "6:30", ""));
        arrayList.add(new SubjectData("AM", "7:00", ""));
        arrayList.add(new SubjectData("PM", "12:00", ""));
        CustomAdapter customAdapter = new CustomAdapter(this, arrayList);
        list.setAdapter(customAdapter);
    }
}
