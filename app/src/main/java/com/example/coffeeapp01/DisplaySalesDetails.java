package com.example.coffeeapp01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplaySalesDetails extends AppCompatActivity {
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sales_details);

        //get the message and display the report
        Intent intent = getIntent();
        message = intent.getStringExtra("db");
        //capture the layout's Textview and set the string as its text
        TextView salesView = (TextView) findViewById(R.id.displayTextView);
        salesView.setText(message);
    }

    //method to take the control back to MainActivity
    public void reOrder(View view){
        Intent mainActivity = new Intent(this, MainActivity.class);
        mainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainActivity);
    }
}