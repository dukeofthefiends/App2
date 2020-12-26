package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MenuList extends AppCompatActivity {

    CircleImageView addbutton, addbutton2;
    TextView textView;
    int i = 0;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        addbutton = findViewById(R.id.addbutton);
        addbutton2 = findViewById(R.id.subbutton);
        textView = findViewById(R.id.textViewAmount1);
        textView.setText("0");

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = i+1;
                number = String.valueOf(i);
                textView.setText(number);
            }
        });

        addbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i>0)
                 {
                     i = i -1;
                     number = String.valueOf(i);
                     textView.setText(number);
                 }

            }
        });
    }
}