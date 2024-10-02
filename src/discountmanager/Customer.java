package discountmanager;

public class Customer {
    // Private variables used by Customer class (Variable naming following hungarian notation).
    private String strFullname;
    private double dTotalPurchases;
    private int iClass;
    private int iYear;
    
    // Constructor used for creating an instance of the customer class.
    public Customer(String pstrFullname, double pdTotalPurchases, int piClass, int piYear){
        this.strFullname        = pstrFullname;
        this.dTotalPurchases    = pdTotalPurchases;
        this.iClass             = piClass;
        this.iYear              = piYear;
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
    
    public int getYear(){
        return iYear;
    }
    public void setYear(int piYear){
        this.iYear = piYear;
    }
    
    // Used to convert the data of the object instance into CSV (Comma Seperated Values).
    // Will be used to store the class instance within a txt file.
    public String toCSV() {
        return strFullname + "," + dTotalPurchases + "," + iClass + "," + iYear;
    }

    // Used to convert CSV back to a cutomer instance. This method is static so that it can be referenced from the class itself rather than an instance instself.
    // Will be used to create a class instance from data within a txt file.
    public static Customer fromCSV(String csv) {
        String[] params = csv.split(",");
        
        //**Check if param index exists?**

        return new Customer(params[0], Double.parseDouble(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]));
    }
}
