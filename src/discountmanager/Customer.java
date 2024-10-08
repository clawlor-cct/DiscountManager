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
}
