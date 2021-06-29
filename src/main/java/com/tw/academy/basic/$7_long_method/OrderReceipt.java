package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    public static final String ORDERS_HEADER = "======Printing Orders======\n";
    public static final String SALES_TAX = "Sales Tax";
    public static final String TOTAL_AMOUNT = "Total Amount";
    public static final double SALES_TAX_RATE_PERCENT = .10;
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    //todo: rename -- Tom
    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        printOrderHeader(output);
        printOrderDetails(output);

        return output.toString();
    }

    private void printOrderDetails(StringBuilder output) {
        // prints lineItems
        double totalSalesTax = 0d;
        double totalAmountOfLineItem = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            printSingleItem(output, lineItem);

            // calculate sales tax @ rate of 10%
            totalSalesTax += calculateSalesTax(lineItem);

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmountOfLineItem += calculateTotalAmount(lineItem);
        }

        // prints the state tax
        output.append(SALES_TAX).append('\t').append(totalSalesTax);

        // print total amount
        output.append(TOTAL_AMOUNT).append('\t').append(totalAmountOfLineItem);
    }

    private double calculateTotalAmount(LineItem lineItem) {
        return lineItem.totalAmount() + calculateSalesTax(lineItem);
    }

    private double calculateSalesTax(LineItem lineItem) {
        return lineItem.totalAmount() * SALES_TAX_RATE_PERCENT;
    }

    private void printOrderHeader(StringBuilder output) {
        // print headers
        output.append(ORDERS_HEADER);

        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    private void printSingleItem(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.totalAmount());
        output.append('\n');
    }
}