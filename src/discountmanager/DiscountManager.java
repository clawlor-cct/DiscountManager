package discountmanager;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiscountManager {

    private static boolean isFullname(String s) {
        // Uses regex (regular expression) to check if string provided matches the format of a full name.
        return s.matches("[A-Za-z]+\\s[A-Za-z0-9]+");
    }
    
    private static boolean isDouble(String s) {
        // Uses regex (regular expression) to check if string provided matches the format of a decimal number.
        return s.matches("-?\\d*(\\.\\d+)?");
    }
    
    private static boolean isClass(String s) {
        // Uses isDouble method to check if the number is parsable.
        if (DiscountManager.isDouble(s)){
            // Convert string to an integer now that we know its a valid number.
            int i = Integer.parseInt(s);
            // Return if number is between 1 and 3.
            return i > 0 && i < 4;
        }
        return false;
    }
    
    private static boolean isValidYear(String s) {
        // Check if string has exactly 4 digits.
        if (s.matches("\\d{4}")) {
            int i = Integer.parseInt(s);
            // Check if year is between 1000 and 9999.
            return i >= 1000 && i <= 9999;
        }
        return false;
    }
    
    private static void printErrorDetails(int iErrorType, String strFullname, String strTotalPurchases, String strClass, String strLastPurchase) {
        System.out.println("-----------------------------------------");

        // Switch statement used for print the correct error along with details about the customer. Improves traceability when fixing.
        switch(iErrorType){
            case 1:
                System.out.println("| ERROR: Customer name (" + strFullname + ") not correct!");
                break;
            case 2:
                System.out.println("| ERROR: Customer Purchases (" + strTotalPurchases + ") not correct!");
                break;
            case 3:
                System.out.println("| ERROR: Customer class (" + strClass + ") not correct!");
                break;
            case 4:
                System.out.println("| ERROR: Customer year (" + strLastPurchase + ") not correct!");
                break;
        }
        System.out.println("-----------------------------------------");
        System.out.println("| Full Name:\t" + strFullname);
        System.out.println("| Purchases:\t" + strTotalPurchases);
        System.out.println("| Class:\t" + strClass);
        System.out.println("| Year:\t\t" + strLastPurchase);
        System.out.println("-----------------------------------------");
    }
    
    private static List<Customer> getCustomers() {
        // Create list with customer type to dynamically store instances of the customer class.
        List<Customer> listCustomers = new ArrayList<Customer>();
        
        // Catch to make sure we handle exceptions.
        try {
           // Create scanner so we can iterate file lines.
           Scanner scanner = new Scanner(new FileReader("customers.txt")); 
           
           // Keep creating customers until we reach end of file.
           while (scanner.hasNextLine()){

                String strFullname          = scanner.nextLine();
                String strTotalPurchases    = scanner.nextLine();
                String strClass             = scanner.nextLine();
                String strLastPurchase      = scanner.nextLine();

                // Check if name is correct as per the assignments guidelines.
                // a) the first name must be letters only;
                // b) The second name can be letters and/or numbers and must be separated from the first name by a single space;
                if (!DiscountManager.isFullname(strFullname)) {
                    DiscountManager.printErrorDetails(1, strFullname, strTotalPurchases, strClass, strLastPurchase);
                    continue;
                }
                
                // c) the value of purchase of classes must be double
                if (!DiscountManager.isDouble(strTotalPurchases)) {
                    DiscountManager.printErrorDetails(2, strFullname, strTotalPurchases, strClass, strLastPurchase);
                    continue;
                }
                
                // d) the Class must be a integer between 1 to 3.
                if (!DiscountManager.isClass(strClass)) {
                    DiscountManager.printErrorDetails(3, strFullname, strTotalPurchases, strClass, strLastPurchase);
                    continue;
                } 
         
                // e) Last purchase must be a valid year. (Supports any year that is 4 digits)
                if (!DiscountManager.isValidYear(strLastPurchase)) {
                    DiscountManager.printErrorDetails(4, strFullname, strTotalPurchases, strClass, strLastPurchase);
                    continue;
                }

                // Create an instance of customer class.
                // Customer(String pstrFullname, double pdTotalPurchases, int piClass, int piYear)
                Customer customer = new Customer(
                        strFullname,                            // String pstrFullname 
                        Double.parseDouble(strTotalPurchases),  // double pdTotalPurchases
                        Integer.parseInt(strClass),             // int piClass
                        Integer.parseInt(strLastPurchase)       // int piLastPurchase
                );
                
                // Push instance to list.
                listCustomers.add(customer);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving customers from file!");
        }
        
        // Return customer list.
        return listCustomers;
    }
    
    //https://github.com/clawlor-cct/DiscountManager
    public static void main(String[] args) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("customerdiscount.txt"))) { // Create buffered writer.
            List<Customer> listCustomers = DiscountManager.getCustomers(); // Create list with customer type.
            for (int i = 0; i < listCustomers.size(); i++){ // Iterate over list of customers.
                Customer customer = listCustomers.get(i); // Get customer at every index of the list.

                bufferedWriter.write(customer.getFullname()); // Write customers fullname.
                bufferedWriter.newLine(); // Write new line.
                
                bufferedWriter.write(Double.toString(customer.getDiscount())); // Write customers discount.
                bufferedWriter.newLine(); // Write new line.
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
