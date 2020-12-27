package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;

public class MenuList extends AppCompatActivity {

    CircleImageView addbutton, subbutton,addbutton2,subbutton2,addbutton3,subbutton3;
    TextView textView,textView2,textView3, moneyCocktail, total_bill;
    Button button_pay;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int bill = 0;
    int a ,b;
    int bill_cocktail = 30000;
    int bill_orange = 20000;
    String bill_ct;
    String bill_org;
    String number;
    String post_bill;
    DatabaseHelper myDb;

    private SQLiteDatabase sql;

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
        button_pay = findViewById(R.id.button_pay);

        textView = findViewById(R.id.textViewAmount1);
        textView2 = findViewById(R.id.textViewAmount2);
        textView3 = findViewById(R.id.textViewAmount3);
        moneyCocktail = findViewById(R.id.moneyCocktail);
        total_bill = findViewById(R.id.textView_totalBill);

        textView.setText("0");
        textView2.setText("0");
        textView3.setText("0");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("bill");
        myDb = new DatabaseHelper(this);
        AddData();

        addbutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                i1 = i1+1;
                a = i1* bill_cocktail;
                number = String.valueOf(i1);
                bill_ct = String.valueOf(a);
                textView.setText(number);
                Sum(i1,i2);
                total_bill.setText(bill_ct + "VNĐ");

            }
        });

        subbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i1>0)
                 {
                     i1 = i1 -1;
                     a = i1* bill_cocktail;
                     bill_ct = String.valueOf(a);
                     total_bill.setText(bill_ct);
                     number = String.valueOf(i1);
                     textView.setText(number);
                     Sum(i1,i2);
                 }

            }
        });

        addbutton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                i2 = i2+1;
                b = i2*bill_orange;
                number = String.valueOf(i2);
                bill_org = String.valueOf(b);
                textView2.setText(number);
                total_bill.setText(bill_org);
                Sum(i1,i2);
            }
        });

        subbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i2>0)
                {
                    i2--;
                    b = i2*bill_orange;
                    bill_org = String.valueOf(b);
                    number = String.valueOf(i2);
                    total_bill.setText(bill_org);
                    textView2.setText(number);
                    Sum(i1,i2);

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

    public void AddData() {
        button_pay.setOnClickListener(v -> {
            String time = String.valueOf(System.currentTimeMillis());
            String sum = total_bill.getText().toString();
            String amount = textView.getText().toString();
            boolean isInserted = myDb.insertData(null, time, sum, amount);
            if (isInserted){
                Toast.makeText(MenuList.this, "Data insert" , Toast.LENGTH_LONG).show();
                textView.setText("");
                total_bill.setText("");
            }
        });
    }

    public  void Sum(int i1, int i2 ){
        int n;
        String sum;
        i1 = i1 ++;
        a = i1*bill_cocktail;
        b = i2*bill_orange;
        n = a+b;
        sum = String.valueOf(n);
       // total_bill.setText(sum + "VNĐ");

    }
}