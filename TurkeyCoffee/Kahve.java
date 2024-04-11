import java.util.Scanner;
import java.lang.Math;

public class Kahve{
    public enum DrinkSize{CUCUK, NORMAL, BUYUK};
    
    //Instance variables
    private DrinkSize size;
    private int sugarCubes; 
    private boolean takeAway;

    
    private static final int SUGARGRAM = 2;
    private static final int CUCUK_GLASS = 90;
    private static final int NORMAL_GLASS = 130;
    private static final int BUYUK_GLASS = 180;
    private static final int CUCUK_PAPER = 75;
    private static final int NORMAL_PAPER = 100;
    private static final int BUYUK_PAPER = 145;
    

    //default constructor
    Kahve(){
        randomSize(Randomize());
        randomCup(Randomize());
        randomSugar(Randomize());
        
    }
    
    private static int Randomize(){
        int ran = (int)(Math.random() * (100 - 0 +1));
        
        while(ran == 50){
            ran = (int)(Math.random() * (100 - 0 +1));
        }
        
        return ran;
    }
    
    private void randomSize(int num){
        if(num >=0 && num <5){
            this.size = DrinkSize.CUCUK;
        }
        else if(num>=5&&num<80){
            this.size = DrinkSize.NORMAL;
        }
        else if(num >=80 && num<101){
            this.size = DrinkSize.BUYUK;
        }
    }
    
    private void randomCup(int num){
        if(num>=0 &&num<20){
            this.takeAway = true;
        }
        else if(num >=20 && num<101){
            this.takeAway = false;
        }
    }
    
    private void randomSugar(int num){
        if(num >= 0 && num<5){
            this.sugarCubes= 0;
        }
        else if(num >=5 && num <25){
            this.sugarCubes = 1;
        }
        else if(num >=25 && num<90){
            this.sugarCubes = 2;
        }
        else if(num >=90 && num <101){
            int temp = RandomMaxSugar();
            this.sugarCubes = temp;
        }
    }
    
    private static int RandomMaxSugar(){
        int ran = (int)(Math.random() * (10-3 +1))+3;
        
        return ran;
    }
    
    
    Kahve(String ds, int sugar, boolean takeAway){
        setDrinkSize(ds);
        if(sugar > 10 || sugar < 0){
            System.out.println("Bad sugar amount. Automatically set to 0");
            this.sugarCubes = 0;
        }
        else{
            this.sugarCubes = sugar;
        }
        
        
        
        this.takeAway = takeAway;
    }
    
    Kahve(boolean take){
        this.takeAway = take;
        //Input size and sugar
        System.out.print("Enter number of sugar: \n");
        Scanner in = new Scanner(System.in);
        this.sugarCubes = in.nextInt();
        in.nextLine();
        while(this.sugarCubes > 10 ||this.sugarCubes <0){
            System.out.print("Enter number of sugar: \n");
            this.sugarCubes = in.nextInt();
            in.nextLine();
        }
        

        in.close();
        
        askingSize();  
    }
    
    public void askingSize(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size: ");
        String temp = in.nextLine();
              
        while(!(temp.toUpperCase().equals("CUCUK") || temp.toUpperCase().equals("NORMAL") || temp.toUpperCase().equals("BUYUK"))){
            System.out.print("Enter Size: ");
            temp = in.nextLine();
        }
        
        switch(temp.toUpperCase()){
            case "CUCUK": 
                this.size = DrinkSize.CUCUK;
                break;
                
            case "NORMAL":
                this.size = DrinkSize.NORMAL;
                break;
                
            case "BUYUK":
                this.size = DrinkSize.BUYUK;
                break;
            
            default:
                this.size = DrinkSize.NORMAL;
                break;                
        }
        
        System.out.println();
        in.close();
    }
    




    public String toString(){
        String s = ""+this.size+",";
        s+= this.sugarCubes+ ",";
        s+= this.takeAway + "\n";
        
        return s;
    }
    
    
    
    public int getWeightGrams(){
        int size = this.sugarCubes*SUGARGRAM;

        if(this.size.equals(DrinkSize.CUCUK) && this.takeAway == false){
            size += CUCUK_GLASS;
        }
        else if(this.size.equals(DrinkSize.CUCUK) && this.takeAway == true){
            size+= CUCUK_PAPER;
        }
        else if(this.size.equals(DrinkSize.NORMAL) && this.takeAway == false){
            size+= NORMAL_GLASS;
        }
        else if(this.size.equals(DrinkSize.NORMAL) && this.takeAway == true){
            size+= NORMAL_PAPER;
        }
        else if(this.size.equals(DrinkSize.BUYUK) && this.takeAway == false){
            size+= BUYUK_GLASS;
        }
        else if(this.size.equals(DrinkSize.BUYUK) && this.takeAway == true){
            size+= BUYUK_PAPER;
        }
        
        return size;
        
    }
    
    
    //Getters 
    public DrinkSize getDrinkSize(){
        return this.size;
    }
    
    public int getSugarCubes(){
        return this.sugarCubes;
    }
    
    public boolean takeAwayOrStay(){
        return this.takeAway;
    }
    
    //Setters
    public void setDrinkSize(String ds){
        if(ds == "NORMAL"){
            this.size = DrinkSize.NORMAL;
        }
        else if(ds == "CUCUK"){
            this.size = DrinkSize.CUCUK;
        }
        else if(ds == "BUYUK"){
            this.size = DrinkSize.BUYUK;
        }
    }
    
    public void setSugarCubes(int sugar){
        this.sugarCubes = sugar;
    }
    
    public void setTakeOrStay(boolean t){
        this.takeAway = t;
    }
    
}