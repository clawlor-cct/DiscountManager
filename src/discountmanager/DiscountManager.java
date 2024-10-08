package discountmanager;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiscountManager {

    private static List<Customer> getCustomers(){
        // Create list with customer type to dynamically store instances of the customer class.
        List<Customer> listCustomers = new ArrayList<Customer>();
        
        // Catch to make sure we handle exceptions.
        try{
           // Create scanner so we can iterate file lines.
           Scanner scanner = new Scanner(new FileReader("customers.txt")); 
           
           // Keep creating customers until we reach end of file.
           while(scanner.hasNextLine()){

                // Create an instance of customer class.
                // Customer(String pstrFullname, double pdTotalPurchases, int piClass, int piYear)
                Customer customer = new Customer(
                        scanner.nextLine(),                     // String pstrFullname 
                        Double.parseDouble(scanner.nextLine()), // double pdTotalPurchases
                        Integer.parseInt(scanner.nextLine()),   // int piClass
                        Integer.parseInt(scanner.nextLine())    // int piYear
                );
                
                // Push instance to list.
                listCustomers.add(customer);
            }
        }catch(Exception e){
            System.out.println("Error retrieving customers from file!");
        }
        
        // Return customer list.
        return listCustomers;
    }
    

    public static void main(String[] args) {
        List<Customer> listCustomers = DiscountManager.getCustomers();
        for(int i = 0; i < listCustomers.size(); i++){
            System.out.println(listCustomers.get(i).getFullname());
        }
    }

}
