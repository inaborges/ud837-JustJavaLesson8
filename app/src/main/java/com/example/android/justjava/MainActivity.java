/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */
package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */


    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById (R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById (R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        int price = calculatePrice();
        String priceMessage = createOrderSumary (price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }

    /**
     * Create summary of the order
     *
     * @param price of the order
     *
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate  is whether or not the user wants chocolate topping
     * @return text summary
     */

    private String createOrderSumary (int price, boolean addWhippedCream, boolean addChocolate){
        String priceMessage = "Name: Kaptain Kunal";
        priceMessage = priceMessage + "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate?" + addChocolate;
        priceMessage = priceMessage + "\nQuantity:" + quantity;
        priceMessage = priceMessage + "\nTotal: $" + (price);
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    /**
     * This method is called when the plus button is clicked.
     */

    int quantity = 2;

    public void increment (View view) {
        quantity = quantity + 1;
        displayQuantity (quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */

    public void decrement (View view) {
        quantity = quantity - 1;
        displayQuantity (quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
     */
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}
