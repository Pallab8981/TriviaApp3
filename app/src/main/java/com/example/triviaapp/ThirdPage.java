package com.example.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdPage extends AppCompatActivity {
    //to connect with buttons
    Button bt1,bt2,bt3,bt4;
    // count for no.of counts pressing the options
    int count=0;
    String i;
    String name,player;
    //for selecting effect
    boolean b1,b2,b3,b4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);
        b1=true;b2=true;b3=true;b4=true;
        //getting result from intent
        name=getIntent().getStringExtra("value");
        player=getIntent().getStringExtra("player");

        i=" ";
        bt1=findViewById(R.id.bt1); bt2=findViewById(R.id.bt2); bt3=findViewById(R.id.bt3); bt4=findViewById(R.id.bt4);

        //Selecting option

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b1)
                {//selection
                    bt1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    count=count+1;
                    i=i+"white, ";

                }
                else{//no selection
                    bt1.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                    count=count-1;
                    i=" ";
                }
                b1=!b1;


            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b2)
                {//selection
                    bt2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    count=count+1;
                    i=i+"Yellow, ";

                }
                else{//no selection
                    bt2.setBackgroundColor(getResources().getColor(R.color.colorYellow));
                    count=count-1;i=" ";
                }
                b2=!b2;

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b3)
                {//selection
                    bt3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    count=count+1;
                    i=i+"Orange, ";

                }
                else{//no selection
                    bt3.setBackgroundColor(getResources().getColor(R.color.colorOrange));
                    count=count-1;
                    i=" ";
                }
                b3=!b3;

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b4)
                {//selection
                    bt4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    count=count+1;i=i+"Green, ";

                }
                else{//no selection
                    bt4.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                    count=count-1;i=" ";
                }
                b4=!b4;

            }
        });

    }

    public void click(View v)
    {
        if(count<3)// if anyone select less than 3 option
        {
            Toast.makeText(ThirdPage.this, "You will have to select three option", Toast.LENGTH_SHORT).show();
        }
        else if(i.isEmpty()) {
            Toast.makeText(ThirdPage.this, "no option is selected", Toast.LENGTH_SHORT).show();
        }
        else{//passing right selection to next intent
            Intent f= new Intent(ThirdPage.this,Summary.class);
            f.putExtra("value",name);
            f.putExtra("player",player);
            f.putExtra("flag",i);
            startActivity(f);

        }
    }
}

