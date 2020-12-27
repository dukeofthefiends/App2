package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MenuList extends AppCompatActivity {

    CircleImageView addbutton, subbutton,addbutton2,subbutton2,addbutton3,subbutton3;
    TextView textView,textView2,textView3;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int bill = 0;

    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        addbutton = findViewById(R.id.addbutton);
        subbutton = findViewById(R.id.subbutton);
        addbutton2 = findViewById(R.id.addbutton2);
        subbutton2 = findViewById(R.id.subbutton2);
        addbutton3 = findViewById(R.id.addbutton3);
        subbutton3 = findViewById(R.id.subbutton3);

        textView = findViewById(R.id.textViewAmount1);
        textView2 = findViewById(R.id.textViewAmount2);
        textView3 = findViewById(R.id.textViewAmount3);

        textView.setText("0");
        textView2.setText("0");
        textView3.setText("0");


        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i1 = i1+1;
                number = String.valueOf(i1);
                textView.setText(number);
            }
        });

        subbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i1>0)
                 {
                     i1 = i1 -1;
                     number = String.valueOf(i1);
                     textView.setText(number);
                 }

            }
        });

        addbutton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                i2 = i2+1;
                number = String.valueOf(i2);
                textView2.setText(number);
            }
        });

        subbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i2>0)
                {
                    i2--;
                    number = String.valueOf(i2);
                    textView2.setText(number);
                }
            }
        });

        addbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i3++;
                number = String.valueOf(i3);
                textView3.setText(number);
            }
        });

        subbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i3>0)
                {
                    i3--;
                    number = String.valueOf(i3);
                    textView3.setText(number);
                }
            }
        });
    }
}