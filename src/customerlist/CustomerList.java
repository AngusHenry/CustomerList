/*
 * Angus Henry
 * 02/04/2019
 * This program will collect information about customers for Discount Fly, fly with the confidence of convenience store meat
 */

package customerlist;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author anhen3335
 */
public class CustomerList {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException { 
        String place, name, postal, city, province, address, customer; 
        String question = "1";
       Boolean end = false;
        BufferedReader readFile = new BufferedReader(
        new FileReader("CustomerInfo.txt"));
        
    // Dispalys everything already in the file    
    while ((place = readFile.readLine()) != null) {
    System.out.println(place);
    }
    
    readFile.close();
    PrintWriter fileOut = new PrintWriter(new FileWriter("CustomerInfo.txt", true));
    int i = 0;
    customer = "";
    
    while (end != true){
        name = JOptionPane.showInputDialog("What is the name of customer#" + (i + 1) + "?");
        address = JOptionPane.showInputDialog ("What is the address of customer#" + (i + 1) + "?\n" 
        + "If you do not know, enter NA");
        if (address.equalsIgnoreCase("NA")){
        customerMaker customerP1 = new customerMaker (name);  
        customer += customerP1;
        customer += "\n";
        customer+= "----------------------------------";
        customer+= "\n";
        }
        else {
        city = JOptionPane.showInputDialog ("What is the city of customer#" + (i + 1) + "?");
        province = JOptionPane.showInputDialog ("What is the province of customer#" + (i + 1) + "?");
        postal = JOptionPane.showInputDialog ("What is the postal code of customer#" + (i + 1) + "?"); 
        customerMaker customerP2 = new customerMaker (name, city, address, province, postal);
        customer += customerP2;
        customer += "\n";
        customer+= "----------------------------------";
        customer+= "\n";
        } 
        i++;
        String theEnd;
        Boolean check = false;
        
        while (check == false){
        theEnd = JOptionPane.showInputDialog("Is that all the customers? \n"
        + "1 (Yes that is all the customers) or 0 (No, there are more customers)");
       try{
       if ("1".equals(theEnd)){
            end = true;
            check = true;
        }   
       else if ("0".equals(theEnd)){
           end = false;
           check = true;
       }
       }
       catch(NumberFormatException nfe){
       System.out.println ("Did not provide a valid answer");
       check = false;
       }    
       }
    }
    int q = 0;
     while (question.equals("1")){
      question = JOptionPane.showInputDialog ("Is that enough customer or shallwe artificaly increase the amount?\n"
     + "1(Yes, make more customers) 0(No, I have enough customers)");   
      customerMaker customerP3 = new customerMaker ();
      customer += customerP3;
      customer += "\n";
      customer+= "----------------------------------";
      customer+= "\n";
      q++;
      System.out.println(q);
     }
     readFile.close();
     System.out.println ("-----------------------------");
     System.out.println (customer);
    PrintWriter fileIn = new PrintWriter(new FileWriter("CustomerInfo.txt", true)); 
    fileIn.println (customer);
    fileIn.close();
    }   
}