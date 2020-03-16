package com.example.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondPage extends AppCompatActivity {
    //to connect with buttons
    Button bt1,bt2,bt3,bt4;
    // count for no.of counts pressing the options
    int count=0;
    // assigning id to each option
    int i=0;
    String name;
    //for selecting effect
    boolean b1,b2,b3,b4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        b1=true;b2=true;b3=true;b4=true;

        //getting result from intent
        name=getIntent().getStringExtra("name");

        bt1=findViewById(R.id.bt1); bt2=findViewById(R.id.bt2); bt3=findViewById(R.id.bt3); bt4=findViewById(R.id.bt4);

        //Selecting option

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b1)
                {
                    //selection
                    bt1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    count=count+1;
                    i=1;

                }
                else{
                    //non selection
                    bt1.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                    count=count-1;
                    i=0;
                }
                b1=!b1;


            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b2)
                {
                    //selection
                    bt2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    count=count+1;
                    i=2;

                }
                else{
                    //non selection
                    bt2.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                    count=count-1;i=0;
                }
                b2=!b2;

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b3)
                {
                    //selection
                    bt3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    count=count+1;
                    i=3;

                }
                else{
                    //non selection
                    bt3.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                    count=count-1;
                    i=0;
                }
                b3=!b3;

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b4)
                {
                    //selection
                    bt4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    count=count+1;i=4;

                }
                else{
                    //non selection
                    bt4.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                    count=count-1;i=0;
                }
                b4=!b4;

            }
        });

    }
    
    public void click(View v)
    {
        if(count>1)// if anyone select one option
     {
        Toast.makeText(SecondPage.this, "You will have to select one option", Toast.LENGTH_SHORT).show();
        }
        //passing right selection to next intent
        else if(i==1){
            Intent i= new Intent(SecondPage.this,ThirdPage.class);
            i.putExtra("value",name);
            i.putExtra("player","Sachin Tendulkar");
            startActivity(i);

        }else if(i==2){
            Intent i= new Intent(SecondPage.this,ThirdPage.class);
            i.putExtra("value",name);
            i.putExtra("player","Virat Kohli");
            startActivity(i);

        }else if(i==3){
            Intent i= new Intent(SecondPage.this,ThirdPage.class);
            i.putExtra("value",name);
            i.putExtra("player","Adam Gilchrist");
            startActivity(i);

        }else if(i==4){
            Intent i= new Intent(SecondPage.this,ThirdPage.class);
            i.putExtra("value",name);
            i.putExtra("player","Jaque Kallis");
            startActivity(i);

        }
        else{
            Toast.makeText(this, "no option is selected", Toast.LENGTH_SHORT).show();
        }
    }
}
