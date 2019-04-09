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
    int i = 0;
    customer = "";
    // Here we will assemble the customers out of the information provided
    while (end != true){
        // ask user for name and check if the user knows the address of the customer
        name = JOptionPane.showInputDialog("What is the name of customer#" + (i + 1) + "?");
        address = JOptionPane.showInputDialog ("What is the address of customer#" + (i + 1) + "?\n" 
        + "If you do not know, enter NA");
        // If the address is not none, fills in rest of customer inof with "?"
        if (address.equalsIgnoreCase("NA")){
            // make cusomter without address
        customerMaker customerP1 = new customerMaker (name);  
        customer += customerP1;
        customer += "\n";
        customer+= "----------------------------------";
        customer+= "\n";
        }
        else {
            // if address is know, ask user and then build with the info
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
        // Ask the user if there is maore customers to be added
        while (check == false){
        theEnd = JOptionPane.showInputDialog("Is that all the customers? \n"
        + "1 (Yes that is all the customers) or 0 (No, there are more customers)");
       // Try to use the value entered by user
        try{
           // if yes. end while loop and stop adding customers
       if ("1".equals(theEnd)){
            end = true;
            check = true;
        } 
       // if yes allow user to add more customers
       else if ("0".equals(theEnd)){
           end = false;
           check = true;
       }
       }
        // if the value enterd by the user is not 1 or 0 ask again
       catch(NumberFormatException nfe){
       System.out.println ("Did not provide a valid answer");
       check = false;
       }    
       }
    }
    int q = 0;
    // ask the user if it wants more randomly generated customers
     while (question.equals("1")){
      question = JOptionPane.showInputDialog ("Is that enough customer or shall we artificaly increase the amount (you know, to make you look better illegaly.)?\n"
     + "1(Yes, make more customers) 0(No, I have enough customers)");
      // if yes, ramdomly generate a customer and ask again and if no, end
      if (question.equals("1")){
            customerMaker customerP3 = new customerMaker ();
      customer += customerP3;
      customer += "\n";
      customer+= "----------------------------------";
      customer+= "\n";
      q++;
      System.out.println(q);    
      }
     }
     readFile.close();
     System.out.println ("-----------------------------");
     System.out.println (customer);
     // append the customer into CustomerInfo.txt to be saved for future use
    PrintWriter fileIn = new PrintWriter(new FileWriter("CustomerInfo.txt", true)); 
    fileIn.println (customer);
    fileIn.close();
    }   
}