
/**
 *  Class to create the Item object
 * 
 * @author Lucas Sanders
 * @version 04/10/2015
 */
public class Item
{
    private String itemID, itemName;
    private int inStore;
    private double price;
    
    /**
     * Constructor for objects of class Item
     */
    public Item(String itemID, String itemName, int inStore, double price)
    {
        this.itemID = itemID;
        this.itemName = itemName;
        this.inStore = inStore;
        this.price = price;
    }

    /**
     * Getter method for the itemID
     * 
     * @return String itemID    the object's item ID number
     */
    public String getItemID()
    {
        return this.itemID;
    }
    /**
     * Getter method for the itemName
     * 
     * @return String itemName   the object's item name
     */
    public String getItemName()
    {
        return this.itemName;
    }
    /**
     * Getter method for the inStore variable
     * 
     * @return int inStore    the number of items left in the store
     */
    public int getInStore()
    {
        return this.inStore;
    }
    /**
     * Getter method for the price
     * 
     * @return double price    the object's price
     */
    public double getPrice()
    {
        return this.price;
    }
    
    /**
     * Overriden toString() method
     * 
     * @return String    the string representation of this object
     */
    public String toString()
    {
        return String.format("%-8s %-12s  %-6d   $%5.2f",
                            this.itemID, this.itemName, this.inStore, this.price);
    }
}
