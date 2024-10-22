package discountmanager;

public class Customer {
    // Private variables used by Customer class (Variable naming following hungarian notation).
    private String strFullname;
    private double dTotalPurchases;
    private int iClass;
    private int iLastPurchase;
    
    // Constructor used for creating an instance of the customer class.
    public Customer(String strFullname, double dTotalPurchases, int iClass, int iLastPurchase){
        this.strFullname        = strFullname;
        this.dTotalPurchases    = dTotalPurchases;
        this.iClass             = iClass;
        this.iLastPurchase      = iLastPurchase;
    }
    
    // Getters & Setters used to retrieve and set data in an instance of the class.
    public String getFullname(){
        return strFullname;
    }
    public void setFullname(String strFullname){
        this.strFullname = strFullname;
    }
    
    public double getTotalPurchases(){
        return dTotalPurchases;
    }
    public void setTotalPurchases(double dTotalPurchases){
        this.dTotalPurchases = dTotalPurchases;
    }
    
    public int getClassType(){
        return iClass;
    }
    public void setClassType(int iClass){
        this.iClass = iClass;
    }
    
    public int getLastPurchase(){
        return iLastPurchase;
    }
    public void setLastPurchase(int iLastPurchase){
        this.iLastPurchase = iLastPurchase;
    }
    
    // Main Discount Rate Calculator:
    // - Uses switch statement for logic
    // - Switch statement uses "arrow notation switch" https://nkamphoa.com/switch-statements-and-switch-expressions-in-java/ (I never knew it existed, and its a very cool implementation)
    // - Method is made a clean and concise as possible to improve maintainability and readability via ternary operator. https://www.w3schools.com/java/java_conditions_shorthand.asp
    private double calculateDiscountRate() {
        switch (iClass) {
            case 1 -> {
                if (iLastPurchase == 2024) // Check if last purchase is 2024.
                    return 0.7; // 30% discount.
                else if (iLastPurchase < 2024) // Check if last purchase is less than 2024 then check if its less than 2019 aswell calculate the discounts (using ternary operator).
                    return iLastPurchase < 2019 ? 0.9 : 0.8; // 10% or 20% discount.
            }
                
            case 2 -> {
                if (iLastPurchase == 2024) // Check if last purchase is 2024.
                    return 0.85; // 15% discount.
                else if (iLastPurchase < 2024) // Check if last purchase is less than 2024 then check if its less than 2019 aswell calculate the discounts (using ternary operator).
                    return iLastPurchase < 2019 ? 0.95 : 0.87; // 5% or 13% discount.
            }

            case 3 -> {
                if (iLastPurchase == 2024) // Check if last purchase is 2024.
                    return 0.97; // 3% discount.
            }
        }
        return 1.0; // 0% discount.
    }
    
    public double getDiscount() {
        return Math.round((dTotalPurchases * calculateDiscountRate()) * 100.0) / 100.0; // Round result and return.
    }
    
}
