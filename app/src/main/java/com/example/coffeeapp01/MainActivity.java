package com.example.coffeeapp01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//declare variables
    int noOfCoffee = 0;
    int priceOfCoffee = 5;
    String custName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //method that is called when order button is clicked
    public void submitOrder(View view) {
        //get the name of the customer
        EditText nameField = findViewById(R.id.name_field);
        custName = nameField.getText().toString();

        //figure out if the user wants whipped cream
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        //figure out if the user wants chocolate
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        //calculate the price
        int totalPrice = calculatePrice(hasWhippedCream,hasChocolate);

        //get the message ready
        String message = orderSummary(custName, hasWhippedCream, hasChocolate,noOfCoffee,totalPrice);

        //open another intent
        Intent intent = new Intent(this,DisplayOrderDetails.class);
        intent.putExtra("name", custName);
        intent.putExtra("message",message);
        intent.putExtra("totalPrice",Integer.toString(totalPrice));
        startActivity(intent);

    }

    private String orderSummary(String custName, boolean hasWhippedCream, boolean hasChocolate, int noOfCoffee, int totalPrice) {
        String finalMessage = "Name: "+custName+"\n"+
                              "Add Whipped cream? " +hasWhippedCream+"\n"+
                              "Add chocolate? " +hasChocolate+"\n"+
                              "Quantity: "+noOfCoffee+"\n"+
                              "Total: $"+totalPrice+"\n"+
                              "Thank You!!";
        return finalMessage;
    }

    //method to calculate the total price
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int basePrice = 5;
        //if the user wants whipped cream add $1 per cup
        if (hasWhippedCream == true) {
            basePrice = basePrice + 1;
        }
        //if the user wants chocolate add $2 per cup
        if (hasChocolate == true) {
            basePrice = basePrice + 2;
        }
        //calculate the total price
        int price = basePrice * noOfCoffee;
        return price;
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    //increase the number of Coffee when increment button is clicked
    public void increment(View view){
        noOfCoffee = noOfCoffee + 1;
        if (noOfCoffee>10) {
            noOfCoffee = 10;
        }
        //call the display() method to display the current quantity
        display(noOfCoffee);
    }

    //decrease the number of Coffee when decrement button is clicked
    public void decrement(View view){
        noOfCoffee = noOfCoffee - 1;
        if (noOfCoffee<1) {
            noOfCoffee = 1;
        }
        //call the display() method to display the current quantity
        display(noOfCoffee);
    }
}