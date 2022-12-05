package com.example.foodorderingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner items;
    String itemsValue;
    int itemPrice;
    TextView priceValue;
    RadioGroup group;
    TextView totalPrice;
    SeekBar quantityValue;
    TextView quantityTitle;
    double totalPriceVal;
    int quantity;
    Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = findViewById(R.id.itemdropdown);
        priceValue = findViewById(R.id.pricevalue);
        group = findViewById(R.id.group);
        totalPrice = findViewById(R.id.totalpricevalue);
        quantityValue = findViewById(R.id.quantityvalue);
        quantityTitle = findViewById(R.id.quantitytitle);
        order = findViewById(R.id.order);

        quantityValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                quantityTitle.setText("Quantity: " + String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        items.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                calculatePrice();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        order.setOnClickListener(v -> {
            calculateTotalPrice();

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("Item", itemsValue);
            intent.putExtra("quantity", quantity);
            intent.putExtra("price", totalPriceVal);
            startActivity(intent);
        });


    }




    void calculatePrice(){
        itemsValue = items.getSelectedItem().toString();

        switch(itemsValue){
            case "Item1":
                itemPrice = 1;
                priceValue.setText("1$");
                break;
            case "Item2":
                itemPrice = 2;
                priceValue.setText("2$");
                break;
            case "Item3":
                itemPrice = 3;
                priceValue.setText("3$");
                break;
            case "Item4":
                itemPrice = 4;
                priceValue.setText("4$");
                break;
            case "Item5":
                itemPrice = 5;
                priceValue.setText("5$");
                break;
            case "Item6":
                itemPrice = 6;
                priceValue.setText("6$");
                break;
            case "Item7":
                itemPrice = 7;
                priceValue.setText("7$");
                break;
            case "Item8":
                itemPrice = 8;
                priceValue.setText("8$");
                break;
            case "Item9":
                itemPrice = 9;
                priceValue.setText("9$");
                break;
            case "Item10":
                itemPrice = 10;
                priceValue.setText("10$");
                break;
            default:
                itemPrice = 1;
                break;
        }
    }

    void calculateTotalPrice(){

        itemsValue = items.getSelectedItem().toString();

        switch(itemsValue){
            case "Item1":
                itemPrice = 1;
                priceValue.setText("1$");
                break;
            case "Item2":
                itemPrice = 2;
                priceValue.setText("2$");
                break;
            case "Item3":
                itemPrice = 3;
                priceValue.setText("3$");
                break;
            case "Item4":
                itemPrice = 4;
                priceValue.setText("4$");
                break;
            case "Item5":
                itemPrice = 5;
                priceValue.setText("5$");
                break;
            case "Item6":
                itemPrice = 6;
                priceValue.setText("6$");
                break;
            case "Item7":
                itemPrice = 7;
                priceValue.setText("7$");
                break;
            case "Item8":
                itemPrice = 8;
                priceValue.setText("8$");
                break;
            case "Item9":
                itemPrice = 9;
                priceValue.setText("9$");
                break;
            case "Item10":
                itemPrice = 10;
                priceValue.setText("10$");
                break;
            default:
                itemPrice = 1;
                break;
        }
        quantity = quantityValue.getProgress();

        int dealId = group.getCheckedRadioButtonId();
        String deal;
        switch(dealId){
            case R.id.first:
                deal = "0.10";
                break;
            case R.id.second:
                deal = "0.20";
                break;
            case R.id.third:
                deal = "0.30";
                break;
            default:
                deal = "0";
        }

        double tipPercentage = Double.parseDouble(deal);
        double regularPrice = quantity * itemPrice;
        double tax = 0.13 * regularPrice;
        double tip = tipPercentage * regularPrice;
        totalPriceVal = regularPrice + tax + tip;

        totalPrice.setText( "" + totalPriceVal + "$");

    }


}