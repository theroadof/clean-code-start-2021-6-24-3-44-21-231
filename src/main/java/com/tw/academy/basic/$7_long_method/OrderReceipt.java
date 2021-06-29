package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author Thoughtworks
 * @version 1.0
 * @since 2018-1-1
 */
public class OrderReceipt {

    private static final String ORDERS_HEADER = "======Printing Orders======\n";
    private static final String SALES_TAX = "Sales Tax";
    private static final String TOTAL_AMOUNT = "Total Amount";
    private static final double SALES_TAX_RATE_PERCENT = .10;
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        printOrderHeader(output);
        printOrderDetails(output);
        return output.toString();
    }

    private void printOrderDetails(StringBuilder output) {
        double totalSalesTax = 0d;
        double totalAmountOfLineItem = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            printSingleItem(output, lineItem);
            totalSalesTax += calculateSalesTax(lineItem);
            totalAmountOfLineItem += calculateTotalAmount(lineItem);
        }
        output.append(SALES_TAX).append('\t').append(totalSalesTax);
        output.append(TOTAL_AMOUNT).append('\t').append(totalAmountOfLineItem);
    }

    private double calculateTotalAmount(LineItem lineItem) {
        return lineItem.totalAmount() + calculateSalesTax(lineItem);
    }

    private double calculateSalesTax(LineItem lineItem) {
        return lineItem.totalAmount() * SALES_TAX_RATE_PERCENT;
    }

    private void printOrderHeader(StringBuilder output) {
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