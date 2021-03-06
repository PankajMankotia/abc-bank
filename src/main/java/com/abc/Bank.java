package com.abc;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {
	private static final String ACCOUNT = "account";
	private static final String CUSTOMER_SUMMARY = "Customer Summary";
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public String customerSummary() {
        StringBuilder summary = new StringBuilder(CUSTOMER_SUMMARY);
        for (Customer c : customers)
            summary.append("\n - ").append(c.getName()).append(" (").append(format(c.getNumberOfAccounts(), ACCOUNT)).append(")"); 
        return return summary.toString();
    }

    //Make sure correct plural of word is created based on the number passed in:
    //If number passed in is 1 just return the word otherwise add an 's' at the end
    private String format(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }

    public BigDecimal totalInterestPaid() {
        BigDecimal total = BigDecimal.ZERO;
        for(Customer c: customers)
            total = total.add(c.totalInterestEarned());
        return total;
    }

    public String getFirstCustomer() {
        try {
            customers = null;
            return customers.get(0).getName();
        } catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
    }
}
