import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileNotFoundException;


public class Order{
    private enum Delivery{KIOSK, HAND, DRONE};
    private static final int CAPACITY = 350;
    private static String[] nameList = new String[]{"KWAN", "HUU", "HARDMAN TZIVIA", "YEVFROSINIYA", "IQBAL", "HUGH", "DAENERYS", "ZEPHYROS", "VEDAST", "BEATA", "MAAS", "ILDAR"};
    private static int orderStartNumber = 220102001;
    private static int anonymousNumber =1;
    
    private int orderNumber;
    private String customer;
    private ArrayList<Kahve> drinkList = new ArrayList<Kahve> ();
    private int Total_Coffees_Weight;
    
    private Delivery option;
    
    Order(){
        this.orderNumber = orderStartNumber;
        orderStartNumber++;
        
        RandomName(Randomize());
        
        if(this.customer.length() >9){
            if(this.customer.substring(0,9).equals("Anonymous")){
                int temp = (int)(Math.random()*(3-1+1))+1;
                for(int i = 0; i<temp; i++){
                    this.drinkList.add(new Kahve("NORMAL", 2, false));
                }
                this.option = Delivery.KIOSK;    
            }
            else{
                int temp = (int)(Math.random()*(4-1+1))+1;
                for(int i = 0; i<temp; i++){
                    this.drinkList.add(new Kahve());
                }
                RandomDelivery(Randomize());    
            }
        }
        else{
            int temp = (int)(Math.random()*(4-1+1))+1;
            for(int i = 0; i<temp; i++){
                this.drinkList.add(new Kahve());
            }
            
            RandomDelivery(Randomize());
            
        }
    }
    
    Order(String name, boolean take, int amount){
        this.orderNumber = orderStartNumber;
        orderStartNumber++;
        
        this.customer = name;
        
        for(int i =0; i<amount; i++){
            System.out.printf("\nDrink %d\n", i+1);
            this.drinkList.add(i, new Kahve(take));
        }
        
        System.out.printf("Thank you for choosing PULLI_KOHI!\n\n");
    }

    private static int Randomize(){
        int ran = (int)(Math.random() * (100 - 0 +1));
        
        while(ran == 50){
            ran = (int)(Math.random() * (100 - 0 +1));
        }
        
        return ran;
    }
    
    private void RandomDelivery(int num){
        if(num>=0 && num<40){
            this.option = Delivery.KIOSK;
        }
        else if(num>=40 && num<101){
            if(sendByDrone()){
                this.option = Delivery.DRONE;
            }
            else{
                this.option = Delivery.HAND;
            }
        }
    }
    private void RandomName(int num){
        if(num>=0 && num<40){
            this.customer = "Anonymous " + anonymousNumber;
            anonymousNumber++;
        }
        else if(num >=40 && num<101){
            int temp= RandomNameFromList();
            this.customer = nameList[temp];
        }
    }
    
    private int RandomNameFromList(){
        int temp = (int)(Math.random() * (11 - 0 +1));
        
        return temp;
    }
    
    
    public String toString(){
        String s = "" + orderNumber + " "+customer+"\n";
        for(Kahve j : this.drinkList){
            s += j.toString();
        }
        
        return s;
    }
    
    private boolean sendByDrone(){
        this.Total_Coffees_Weight =0;
        for(Kahve j : this.drinkList){
            this.Total_Coffees_Weight += j.getWeightGrams();
        }
        
        if(this.Total_Coffees_Weight > CAPACITY){
            return false;
        }
        
        return true;
    }
    
    
    public static int getOrderStartNumber(){
        return orderStartNumber;
    }

    public static String getOrderStartNumberString(){
        String s = "" + orderStartNumber;

        return s.substring(0,6); 
    }
    public void printOrder(){
        String s = "C:\\Users\\lengu\\OneDrive\\Desktop\\TurkeyCoffee\\TurkeyCoffee\\Receipts 220102\\" + "Order " + this.orderNumber +".txt";
        String temp =""+ this.option;
        PrintWriter out = null;
        try{
            out = new PrintWriter(s);
            out.printf("%d\n", this.orderNumber);
            out.printf("%s\n", this.customer);
            out.println();
            out.printf("%s\n", temp);
            for(Kahve j : this.drinkList){
                out.printf("%s", j.toString());
            }
            
            System.out.printf("%d - %s\n", this.orderNumber, this.customer);
            System.out.printf("%s\n", temp);
            for(Kahve j : this.drinkList){
                System.out.printf("%s", j.toString());
            }
            System.out.println();

            out.close();
        }
        catch(FileNotFoundException e){
            System.out.print("Please configure correctly the file paths");
        }

        
    }
    
    
    
    
    
    //Setters
    
    //Getters
    public String getOrderNumberString(){
        String s =""+ this.orderNumber;
        return  s;
    }
    
    
    
    
    
    
    
}