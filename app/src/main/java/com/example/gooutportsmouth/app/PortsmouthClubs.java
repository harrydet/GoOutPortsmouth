package com.example.gooutportsmouth.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PortsmouthClubs extends ActionBarActivity implements AdapterView.OnItemClickListener {

    ArrayList<String> clubs;
    ListView list;
    LazyAdapter adapter;
    Animation animAlpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide the title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_portsmouth_clubs);


        clubs = new ArrayList<String>();


        clubs.add("Liquid");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");


        list = (ListView) findViewById(R.id.list);
        adapter = new LazyAdapter(this, clubs);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("MESSAGE", Integer.toString(position));
        view.findViewById(R.id.second_layer).setAlpha(1f);
        Log.e("Alpha", Float.toString(view.findViewById(R.id.second_layer).getAlpha()));
    }

}
