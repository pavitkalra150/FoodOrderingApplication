package com.example.foodorderingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String itemsval = getIntent().getStringExtra("Item");
        TextView text2 = findViewById(R.id.text2);

        int quantityval = getIntent().getIntExtra("quantity", 0);
        TextView text3 = findViewById(R.id.text3);


        double totalprice = getIntent().getDoubleExtra("price", 0.00);
        TextView text4 = findViewById(R.id.text4);

        if(itemsval != null){
            text2.setText(itemsval);
        }
        text3.setText(String.valueOf(quantityval));
        text4.setText(String.valueOf(totalprice));

    }
}