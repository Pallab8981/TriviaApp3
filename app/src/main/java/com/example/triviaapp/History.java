package com.example.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {
    //creating listview and list adapter objects
ListView list; ListAdapter myAdapter;
Player p; String name,date,player, flag;
    List<Player> pl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        list =findViewById(R.id.list);
        pl= new ArrayList<Player>();
        date=getIntent().getStringExtra("flag");
        flag=getIntent().getStringExtra("flag"); name=getIntent().getStringExtra("name");player=getIntent().getStringExtra("player");

        if(ApplicationClass.people.isEmpty()){
            Player p= new Player(date,name,player,flag);
            pl.add(0,p);
            ApplicationClass.people= (ArrayList<Player>) pl;
            myAdapter= new ListAdapter(this,pl);
            //setting the adapter for the list
            list.setAdapter(myAdapter);

        }
        else {

            myAdapter = new ListAdapter(this, ApplicationClass.people);
            //setting the adapter for the list
            list.setAdapter(myAdapter);
        }

    }
}
