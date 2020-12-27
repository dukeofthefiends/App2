package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button ban1, ban2 , ban3,ban4,ban5,ban6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ban1 = findViewById(R.id.button1);


        ban1.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity2.this, MenuList.class));
        });
    }
}