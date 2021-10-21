package com.example.coffeeapp01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayOrderDetails extends AppCompatActivity {
    //crete variables
    String name, message, totalPrice;
    CoffeeDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_order_details);
        dbHandler = new CoffeeDBHandler(this, null, null, 1);
        //get the intent from the MainActivity
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        message = intent.getStringExtra("message");
        totalPrice = intent.getStringExtra("totalPrice");
        //crete an object of TextView and display the message
        TextView output = findViewById(R.id.displayOrder);
        //String strOutput = output.getText().toString();
        output.setText(message);

    }
    //method that will open Gmail and display the output
    public void sendEmail(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order for"+name);
        // if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
       // }
    }
    // a new method to save data in the SQLite Database
    public void addButtonClicked(View view){
        //start the new intent here
        Order order = new Order(name,Integer.parseInt(totalPrice));
        dbHandler.addOrder(order);
        Toast.makeText(getApplicationContext(),"Data Saved!",Toast.LENGTH_SHORT).show();
    }

    // a method that will generate a sales report on clicking the button
    public void salesReport(View view){
        //read the details from the database to produce the report
        String dbString = dbHandler.databaseToString();
        //start the new intent here
        Intent salesIntent = new Intent(this,DisplaySalesDetails.class);
        salesIntent.putExtra("db", dbString);
        startActivity(salesIntent);
    }
}