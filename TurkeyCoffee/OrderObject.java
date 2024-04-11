import java.io.*;

public class OrderObject{
    private static int orderNumber= 1;
    private String customer = "Anonymous" + this.orderNumber;
    
    public void printOrder(){
        
        
        try{
            String filename= "Order "+this.orderNumber;
           PrintWriter out = new PrintWriter(filename);
            out.println(this.orderNumber + "_" + this.customer); //Prints the orderNumber and customer into a text file
            out.close();
        }
        catch (IOException e){
            System.out.println("Exception");
        }
        finally{

        }
    }
    
    /*
       Try: looks for exceptions
       Catch: catches exceptions if found
       Finally section: the codes which you want to always run
       */
      
      /*
         Understand Try-catch
         Understand write and read to a file
         Complete the Kahve program
         Understand how to check if a file exists
         */
}