/*
 * Angus Henry
 * 02/04/2019
 * This program will collect information about customers for Discount Fly, fly with the confidence of convenience store meat
 */

package customerlist;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
/**
 *
 * @author anhen3335
 */
public class CustomerList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException { 
        String place, name, postal, city, province, address, customer;
       Boolean end = false;
       ArrayList <String> lines = new ArrayList();
        BufferedReader readFile = new BufferedReader(
        new FileReader("CustomerInfo.txt"));
        
    // Dispalys everything already in the file    
    while ((place = readFile.readLine()) != null) {
    System.out.println(place);
    Collections.addAll (lines, place); 
    System.out.println ("Array" + lines);
    }
    readFile.close();
    PrintWriter fileOut = new PrintWriter(new FileWriter("CustomerInfo.txt", true));
    int i = 0;
    while (end != true){
        name = JOptionPane.showInputDialog("What is the name of customer#" + (i + 1) + "?");
        address = JOptionPane.showInputDialog ("What is the address of customer#" + (i + 1) + "?");
        city = JOptionPane.showInputDialog ("What is the city of customer#" + (i + 1) + "?");
        province = JOptionPane.showInputDialog ("What is the province of customer#" + (i + 1) + "?");
        postal = JOptionPane.showInputDialog ("What is the postal code of customer#" + (i + 1) + "?");
        customer = "Name: " + name +"\n" 
                + "Address:" + address + "\n"
                + "City" + city +"\n"
                + "Province" + province + "\n"
                + "Postal Code" + postal + "\n";
        i++;
        // here be the problem i need so solve, it does not change end
        String theEnd;
        theEnd = JOptionPane.showInputDialog("Is that all the customer? \n"
        + "yes or no");
       
        if (theEnd == "yes"){
            end = true;
            System.out.println ("here we are");
        }
        System.out.println (customer);       
    }
    }
    
}
