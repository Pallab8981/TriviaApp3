package com.example.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class Summary extends AppCompatActivity {

    String flag,name,player;
    //creating a list of objects of players
    ArrayList<Player> p;
    // to display te output
    TextView tvcric,tvflag,hello; Button finish, history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        //getting result from intent
        flag=getIntent().getStringExtra("flag"); name=getIntent().getStringExtra("value");player=getIntent().getStringExtra("player");
        // to get time and date
        final Date currentTime= Calendar.getInstance().getTime();

        tvcric=findViewById(R.id.tvcric);tvflag=findViewById(R.id.tvflag);hello=findViewById(R.id.hello);
        finish=findViewById(R.id.finish);history=findViewById(R.id.history);
        // displaying the output
        tvcric.setText("Answer:  "+player);tvflag.setText("Answer:  "+flag);hello.setText("Hello  "+name);
        //checking application class is empty or not
        if(ApplicationClass.people.isEmpty())
        {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
            try
            { // if empty then store first data to file
                FileOutputStream file=openFileOutput("players.txt",MODE_PRIVATE);
                OutputStreamWriter outFile= new OutputStreamWriter(file);

                outFile.write(currentTime+";"+name+";"+player+";"+flag+ "\n");


                Toast.makeText(Summary.this,"Successfully Saved",Toast.LENGTH_SHORT).show();
                outFile.flush();
                outFile.close();


            }
            catch (IOException e)
            {
                Toast.makeText(Summary.this,e.getMessage(),Toast.LENGTH_SHORT).show();

            }
        }
        else{// else we are adding data to the previous list
            Player p= new Player(currentTime.toString(),name,player,flag);
            ApplicationClass.people.add(p);
            try
            {// then store it on the file
                FileOutputStream file=openFileOutput("players.txt",MODE_PRIVATE);
                OutputStreamWriter outFile= new OutputStreamWriter(file);
                for(int i=0;i<ApplicationClass.people.size();i++)
                {
                    outFile.write(ApplicationClass.people.get(i).getDate()+";"+ApplicationClass.people.get(i).getName()+";"+ApplicationClass.people.get(i).getCric()+";"+ApplicationClass.people.get(i).getFlag()+ "\n");
                }

                Toast.makeText(Summary.this,"Successfully Saved",Toast.LENGTH_SHORT).show();
                outFile.flush();
                outFile.close();


            }
            catch (IOException e)
            {
                Toast.makeText(Summary.this,e.getMessage(),Toast.LENGTH_SHORT).show();

            }
        }



        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Summary.this,MainActivity.class));
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f=new Intent(Summary.this,History.class);
                f.putExtra("date",currentTime);
                f.putExtra("name",name);
                f.putExtra("player",player);
                f.putExtra("flag",flag);
                startActivity(f);

            }
        });


    }
}
