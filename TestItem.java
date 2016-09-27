
/**
 * Creates and sorts a list of Items
 * 
 * @author Lucas Sanders
 * @version 04/10/2015
 */
public class TestItem
{
    public static void main(String[] args)
    {
        Item[] hardware = new Item[6];
        
        hardware[0] = new Item("1011", "Air Filters", 200, 10.5);
        hardware[1] = new Item("1034", "Door Knobs", 60, 21.5);
        hardware[2] = new Item("1101", "Hammers", 90, 9.99);
        hardware[3] = new Item("1600", "Levels", 80, 19.99);
        hardware[4] = new Item("1500", "Ceiling Fans", 100, 59);
        hardware[5] = new Item("1201", "Wrench Sets", 55, 80);
        
        System.out.println("Original Array");
        System.out.println();
        printInventory(hardware);
        System.out.println();
        
        System.out.println("Sorted by ID:");
        System.out.println();
        sortID(hardware, 1);
        printInventory(hardware);
        System.out.println();
        
        System.out.println("Sorted by Name:");
        System.out.println();
        sortName(hardware, 2);
        printInventory(hardware);
        System.out.println();
        
        System.out.println("Sorted by inStore:");
        System.out.println();
        sortInStore(hardware, 1);
        printInventory(hardware);
        System.out.println();
        
        System.out.println("Sorted by Price:");
        System.out.println();
        sortPrice(hardware, 0, hardware.length - 1, 2);
        printInventory(hardware);
    }
    
    public static void printInventory(Item[] hardware)
    {
        System.out.println("itemID   itemName      inStore  price");
        System.out.println("-------------------------------------------------------");
        for(Item h : hardware)
            System.out.println(h);
    }
    
    public static void sortID(Item[] hardware, int choice)
    {
        int i, k, indexM;
        Item temporary;
        
        for(k = hardware.length - 1; k >= 0; k--)
        {
            indexM = 0;
            for(i = 0; i <= k; i++)
            {
                if(choice == 1 &&
                  hardware[indexM].getItemID().compareTo(hardware[i].getItemID()) < 0)
                {
                     indexM = i;
                }
                
                if(choice == 2 &&
                  hardware[indexM].getItemID().compareTo(hardware[i].getItemID()) > 0)
                {
                     indexM = i;
                }
            }
            
            temporary = hardware[k];
            hardware[k] = hardware[indexM];
            hardware[indexM] = temporary;
        }
        
    }
    
    public static void sortName(Item[] hardware, int choice)
    {
        Item[] out = new Item[hardware.length];
        
        for(int i = 0; i < out.length; i++)
        {
            Item nextItem = hardware[i];
            int insertPoint = 0;
            int k = i;
            
            while(insertPoint == 0 && k > 0)
            {
                if(choice == 1 && nextItem.getItemName().compareTo(out[k-1].getItemName()) < 0)
                {
                    out[k] = out[k-1];
                }
                else if(choice == 1)
                {
                    insertPoint = k;
                }
                else if(choice == 2 && nextItem.getItemName().compareTo(out[k-1].getItemName()) > 0)
                {
                    out[k] = out[k-1];
                }
                else
                {
                    insertPoint = k;
                }
                k--;
            }
            
            out[insertPoint] = nextItem;
        }
        
        for(int i = 0; i < hardware.length; i++)
        {
            hardware[i] = out[i];
        }
    }
    
    public static void sortInStore(Item[] hardware, int choice)
    {
        int i, k, indexM;
        Item temporary;
        
        for(k = hardware.length - 1; k >= 0; k--)
        {
            indexM = 0;
            for(i = 0; i <= k; i++)
            {
                if(choice == 1 && hardware[indexM].getInStore() - hardware[i].getInStore() < 0)
                {
                     indexM = i;
                }
                else if(choice == 2 && hardware[indexM].getInStore() - hardware[i].getInStore() > 0)
                {
                     indexM = i;
                }
            }
            
            temporary = hardware[k];
            hardware[k] = hardware[indexM];
            hardware[indexM] = temporary;
        }
        
    }
    
    public static void sortPrice(Item[] hardware, int low, int high, int choice)
    {
        if(low == high)
            return;
            
        int mid = (low + high) / 2;
        
        sortPrice(hardware, low, mid, choice);
        sortPrice(hardware, mid + 1, high, choice);
        
        mergePrice(hardware, low, mid, high, choice); 
    }
    
    public static void mergePrice(Item[] hardware, int low, int mid, int high, int choice)
    {
        Item[] temp = new Item[high - low + 1];
        int i = low;
        int j = mid + 1;
        int n = 0;
        
        while(i <= mid || j <= high)
        {
            if(i > mid)
            {
                temp[n] = hardware[j];
                j++;
            }
            else if(j > high)
            {
                temp[n] = hardware[i];
                i++;
            }
            else if(choice == 1 && hardware[i].getPrice() - hardware[j].getPrice() < 0)
            {
                temp[n] = hardware[i];
                i++;
            }
            else if(choice == 1)
            {
                temp[n] = hardware[j];
                j++;
            }
            else if(choice == 2 && hardware[i].getPrice() - hardware[j].getPrice() > 0)
            {
                temp[n] = hardware[i];
                i++;
            }
            else
            {
                temp[n] = hardware[j];
                j++;
            }
            n++;
        }
        
        for(int k = low ; k <= high ; k++) 
            hardware[k] = temp[k - low];
           
    }
}
