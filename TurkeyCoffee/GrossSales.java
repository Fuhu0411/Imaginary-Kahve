import java.util.*;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;



public class GrossSales{
    public static void main(String[] args){
        summary();
    }
    
    public static void summary(){
        int order = Order.getOrderStartNumber(); //check this one
            

        ArrayList<String> NORMAL  = new ArrayList<String> ();
        ArrayList<String> CUCUK = new ArrayList<String>();
        ArrayList<String> BUYUK = new ArrayList<String>();
        ArrayList<String> PAPER = new ArrayList<String>();
        ArrayList<String> NORMAL_SUGAR = new ArrayList<String>();
        ArrayList<String> CUCUK_SUGAR = new ArrayList<String>();
        ArrayList<String> BUYUK_SUGAR = new ArrayList<String>();
        ArrayList<String> TOTAL = new ArrayList<String>();
        ArrayList<String> TOTAL_SUGAR = new ArrayList<String>();
        ArrayList<String> DRONE = new ArrayList<String>();
        ArrayList<String> HAND = new ArrayList<String>();
        ArrayList<String> KIOSK = new ArrayList<String> ();
        ArrayList<String> ANO = new ArrayList<String>();

        
        String temp1 = Order.getOrderStartNumberString();
        int num = Integer.parseInt(temp1+"001");
        String s = "C:\\Users\\lengu\\OneDrive\\Desktop\\TurkeyCoffee\\TurkeyCoffee\\Receipts 220102\\Order "+num+".txt";
        
        File check = new File(s);
        Scanner in = null;
        
        
        try{
            while(check.isFile()){
                in = new Scanner(check);
                while(in.hasNextLine()){
                        String readStrings = in.nextLine();
                        String[] p = readStrings.split(",");
                    

                        if(p[0].length() >9){
                            if(p[0].substring(0,9).equals("Anonymous")){
                                ANO.add(p[0]);
                            }
                        }
                        
                        if(p[0].equals("HAND")){
                            HAND.add(p[0]);
                        }
                        else if(p[0].equals("DRONE")){
                            DRONE.add(p[0]);
                        }
                        else if(p[0].equals("KIOSK")){
                            KIOSK.add(p[0]);
                        }
                        
                        
                        if(p[0].equals("NORMAL")){
                            TOTAL.add(p[0]);
                            NORMAL.add(p[0]);
                            NORMAL_SUGAR.add(p[0+1]);
                            TOTAL_SUGAR.add(p[0+1]);
                            if(p[0+2].equals("true")){
                                PAPER.add(p[0+2]);
                            }
                        }
                        else if(p[0].equals("CUCUK")){
                            TOTAL.add(p[0]);
                            CUCUK.add(p[0]);
                            CUCUK_SUGAR.add(p[0+1]);
                            TOTAL_SUGAR.add(p[0+1]);
                            if(p[0+2].equals("true")){
                                PAPER.add(p[0+2]);
                            }
                        }
                        else if(p[0].equals("BUYUK")){
                            TOTAL.add(p[0]);
                            BUYUK.add(p[0]);
                            BUYUK_SUGAR.add(p[0+1]);
                            TOTAL_SUGAR.add(p[0+1]);
                            if(p[0+2].equals("true")){
                                PAPER.add(p[0+2]);
                            }
                        }    
                }
                num++;
                s = "C:\\Users\\lengu\\OneDrive\\Desktop\\TurkeyCoffee\\TurkeyCoffee\\Receipts 220102\\Order "+num+".txt";
                check = new File(s);  
            }
            in.close();
        }
        catch(FileNotFoundException e){
            System.out.print("No more receipts to read");
        }

        
 
        
        sales(NORMAL, CUCUK, BUYUK, PAPER, NORMAL_SUGAR, CUCUK_SUGAR, BUYUK_SUGAR, TOTAL, TOTAL_SUGAR, HAND, DRONE, KIOSK, ANO);
    }
    
    
    public static void sales(ArrayList<String> NORMAL, ArrayList<String> CUCUK, ArrayList<String> BUYUK, ArrayList<String> PAPER, ArrayList<String> NORMAL_SUGAR, ArrayList<String> CUCUK_SUGAR, ArrayList<String> BUYUK_SUGAR, ArrayList<String> TOTAL, ArrayList<String> TOTAL_SUGAR, ArrayList<String> HAND, ArrayList<String> DRONE, ArrayList<String> KIOSK, ArrayList<String> ANO){
        int total_NORMAL=0;
        int total_CUCUK=0;
        int total_BUYUK=0;
        
        int total_Sold=0;
        double grossSales=0;
        int total_Paper=0;
        double total_Paper_Fees=0;
        int total_Sugar=0;
        
        double Average_Sugar_NORMAL=0;
        double Average_Sugar_CUCUK=0;
        double Average_Sugar_BUYUK=0;
        
        int countNorm = 0;
        int countCU = 0;
        int countBU = 0;
        
        int total_HAND = 0;
        int total_KIOSK = 0;
        int total_DRONE = 0;
        
        double percentHand = 0;
        double percentKiosk = 0;
        double percentDrone = 0;
        
        double Ano = 0;
        double name =0;
        
        for(String j : NORMAL){
            total_NORMAL+=1;
        }
        
        for(String j : CUCUK){
            total_CUCUK+=1;
        }
        
        for(String j :BUYUK){
            total_BUYUK+=1;
        }
        
        for(String j: TOTAL){
            total_Sold +=1;
        }
        
        grossSales = total_NORMAL*1.00 + total_CUCUK*0.75 + total_BUYUK*1.50;
        
        for(String j :PAPER){
            total_Paper +=1;
        }
        
        total_Paper_Fees = total_Paper * 0.25;
        
        for(String j : TOTAL_SUGAR){
            total_Sugar += Integer.parseInt(j);
        }
        
        for(String j : NORMAL_SUGAR){
            countNorm +=1;
            Average_Sugar_NORMAL += Integer.parseInt(j);
        }
        Average_Sugar_NORMAL /= countNorm;
        
        
        for(String j : CUCUK_SUGAR){
            countCU +=1;
            Average_Sugar_CUCUK += Integer.parseInt(j);
        }
        
        Average_Sugar_CUCUK /= countCU;
        
        for(String j : BUYUK_SUGAR){
            countBU +=1;
            Average_Sugar_BUYUK += Integer.parseInt(j);
        }
        
        Average_Sugar_BUYUK /= countBU;
        
        for(String j : HAND){
            total_HAND +=1;
        }
        
        for(String j :KIOSK){
            total_KIOSK +=1;
        }
        
        for(String j : DRONE){
            total_DRONE +=1;
        }
          
        percentHand = (total_HAND*100.0)/(total_HAND+total_KIOSK+total_DRONE);
        percentKiosk = (total_KIOSK*100.0)/(total_HAND+total_KIOSK+total_DRONE);
        percentDrone = (total_DRONE*100.0)/(total_HAND+total_KIOSK+total_DRONE);
        
        for(String j : ANO){
            Ano += 1;
        }
        
        Ano = (Ano/(total_KIOSK+total_DRONE+total_HAND)) * 100;
        
        name = 100 - Ano;
        
        /*
             Write to file
           */
          
        String s = "C:\\Users\\lengu\\OneDrive\\Desktop\\TurkeyCoffee\\TurkeyCoffee\\"+Order.getOrderStartNumberString() +" Sales Summary.txt";  
        PrintWriter out= null;
        try{
            out = new PrintWriter(s);
            out.printf("Total number of deliveries by Drone: %d\n", total_DRONE);
            out.printf("Total number of deliveries by Hand: %d\n", total_HAND);
            out.printf("Total number of deliveries at Kiosk: %d\n", total_KIOSK);
            out.printf("Total number of NORMAL: %d\n", total_NORMAL);
            out.printf("Total number of CUCUK: %d\n", total_CUCUK);
            out.printf("Total number of BUYUK: %d\n", total_BUYUK);
            out.printf("Total number of Coffee sold: %d\n", total_Sold);
            out.printf("Gross sales: %.02f\n", grossSales);
            out.printf("Number of takeaway: %d\n", total_Paper);
            out.printf("Amount of paper collected in fees: %.02f\n", total_Paper_Fees);
            out.printf("Total amount of sugar used: %d\n", total_Sugar);
            out.printf("Average number of sugars used (NORMAL): %.1f\n", Average_Sugar_NORMAL);
            out.printf("Average number of sugars used (CUCUK): %.1f\n", Average_Sugar_CUCUK);
            out.printf("Average number of sugars used (BUYUK): %.1f\n", Average_Sugar_BUYUK);
            out.printf("Anonymous percentage: %.02f%%\n", Ano);
            out.printf("Customer with name percentage: %.02f%%\n", name); 
            out.printf("Percentage at KIOSK: %.02f%%\n", percentKiosk);
            out.printf("Percentage by HAND: %.02f%%\n", percentHand);
            out.printf("Percentage by DRONE: %.02f%%", percentDrone);
            
            System.out.printf("Total number of deliveries by Drone: %d\n", total_DRONE);
            System.out.printf("Total number of deliveries by Hand: %d\n", total_HAND);
            System.out.printf("Total number of deliveries at Kiosk: %d\n", total_KIOSK);
            System.out.printf("Total number of NORMAL: %d\n", total_NORMAL);
            System.out.printf("Total number of CUCUK: %d\n", total_CUCUK);
            System.out.printf("Total number of BUYUK: %d\n", total_BUYUK);
            System.out.printf("Total number of Coffee sold: %d\n", total_Sold);
            System.out.printf("Gross sales: %.02f\n", grossSales);
            System.out.printf("Number of takeaway: %d\n", total_Paper);
            System.out.printf("Amount of paper collected in fees: %.02f\n", total_Paper_Fees);
            System.out.printf("Total amount of sugar used: %d\n", total_Sugar);
            System.out.printf("Average number of sugars used (NORMAL): %.1f\n", Average_Sugar_NORMAL);
            System.out.printf("Average number of sugars used (CUCUK): %.1f\n", Average_Sugar_CUCUK);
            System.out.printf("Average number of sugars used (BUYUK): %.1f\n", Average_Sugar_BUYUK);
            System.out.printf("Anonymous percentage: %.02f%%\n", Ano);
            System.out.printf("Customer with name percentage: %.02f%%\n", name);
            System.out.printf("Percentage at KIOSK: %.02f%%\n", percentKiosk);
            System.out.printf("Percentage by HAND: %.02f%%\n", percentHand);
            System.out.printf("Percentage by DRONE: %.02f%%", percentDrone);

            out.close();
        }
        catch(FileNotFoundException e){
            System.out.print("FileNOtFound");
            
        }
        
    }
    
}