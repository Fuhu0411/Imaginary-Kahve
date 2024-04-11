import java.io.*;
import java.util.Scanner;
public class ReceiptsGenerator{
    public static void main(String[] args){
        takeOrder();
    }
    
    public static void takeOrder(){       
        int num = (int)(Math.random() * (35-20+1))+20;
        for(int i =0 ;i <num; i++){
            Order order = new Order();
            order.printOrder();
        }
    }
}