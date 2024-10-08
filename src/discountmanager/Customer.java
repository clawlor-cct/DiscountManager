package discountmanager;

public class Customer {
    // Private variables used by Customer class (Variable naming following hungarian notation).
    private String strFullname;
    private double dTotalPurchases;
    private int iClass;
    private int iLastPurchase;
    
    // Constructor used for creating an instance of the customer class.
    public Customer(String pstrFullname, double pdTotalPurchases, int piClass, int piLastPurchase){
        this.strFullname        = pstrFullname;
        this.dTotalPurchases    = pdTotalPurchases;
        this.iClass             = piClass;
        this.iLastPurchase      = piLastPurchase;
    }
    
    // Getters & Setters used to retrieve and set data in an instance of the class.
    public String getFullname(){
        return strFullname;
    }
    public void setFullname(String pstrFullname){
        this.strFullname = pstrFullname;
    }
    
    public double getTotalPurchases(){
        return dTotalPurchases;
    }
    public void setTotalPurchases(double pdTotalPurchases){
        this.dTotalPurchases = pdTotalPurchases;
    }
    
    public int getClassType(){
        return iClass;
    }
    public void setClassType(int piClass){
        this.iClass = piClass;
    }
    
    public int getLastPurchase(){
        return iLastPurchase;
    }
    public void setLastPurchase(int piLastPurchase){
        this.iLastPurchase = piLastPurchase;
    }
    
    
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
        return dTotalPurchases * calculateDiscountRate();
    }
    
}
