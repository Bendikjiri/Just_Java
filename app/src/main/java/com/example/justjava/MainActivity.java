/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.justjava;


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whipedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        Boolean hasWhippedCream = whipedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        Boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);
        displayMessage(createOrderSummary(price, hasWhippedCream, hasChocolate));
    }

    /**
     * This method calculate the price.
     * @return price
     */

    private int calculatePrice() {
        return quantity * 6;
           }

    /**
     * This method create order summary
     */
    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate) {
        String priceMessage = "Name: Jirka Syrka";
        priceMessage += "\nAdd whiped cream?" + hasWhippedCream;
        priceMessage += "\nAdd chocolate?" + hasChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }


    /**
     * This method displays the given quantity value on the screen.
     * @param
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
     }
}


