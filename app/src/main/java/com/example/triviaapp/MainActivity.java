package com.example.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
//to connect with buttons and edittext
   Button bt1; EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1=findViewById(R.id.bt1);et1=findViewById(R.id.et1);



        //for Entering the Name

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter your name", Toast.LENGTH_SHORT).show();
                }
                else {
                    //getting name of the user
                    String name=et1.getText().toString();
                    //going to 2nd page
                    Intent i = new Intent(MainActivity.this, SecondPage.class);
                    i.putExtra("name",name);
                    startActivity(i);
                }

            }
        });



    }
}
