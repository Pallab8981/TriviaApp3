package com.example.triviaapp;

import android.app.Application;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ApplicationClass extends Application {
// creating list of objects which can be stored before the app starts
    public static ArrayList<Player> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people=new ArrayList<Player>();
        loadData();
    }

    private void loadData()
    {
        people.clear();

// dtoring data from the file in the begining
        File file=getApplicationContext().getFileStreamPath("players.txt");
        String readline;

        if(file.exists())
        {
            try{
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(openFileInput("players.txt")));
                while((readline=bufferedReader.readLine())!=null)
                {
                    StringTokenizer tokenizer= new StringTokenizer(readline,";");
                    Player p= new Player(tokenizer.nextToken(),tokenizer.nextToken(),tokenizer.nextToken(),tokenizer.nextToken());
                    people.add((Player) p);

                }
                bufferedReader.close();


            }
            catch (IOException e)
            {
                Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

            }

        }


    }
}
