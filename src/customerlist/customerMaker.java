/*
 * This will make the customer
 */

package customerlist;

import java.util.ArrayList;

/**
 *
 * @author anhen3335
 */
public class customerMaker {
    
  private String Cname, Ccity, Caddress, Cprovince, Cpostcode;
  public customerMaker (){
    ArrayList <String> nameran = new ArrayList();
        nameran.add("Randy Howard");
        nameran.add("Susie Clark");
        nameran.add("Alexander Demitri");
        nameran.add("Josehpine Miller");
        nameran.add("Clark Muth");
        nameran.add("Sasha McDonald");
        nameran.add("Gary, Just Gary");
    ArrayList <String> cityran = new ArrayList();
        cityran.add("Toronto");
        cityran.add("Ottawa");
        cityran.add("Quebec City");
        cityran.add("Montreal");
        cityran.add("Vancouver");
        cityran.add("Regina");
        cityran.add("St. Spooky");
    ArrayList <String> addran = new ArrayList();
        addran.add("576 Elmer St");
        addran.add("5 Main st");
        addran.add("54 Franklin drive");
        addran.add("95 Cromwell st, Unit 67");
        addran.add("1 First st");
        addran.add("78 Red drive");
        addran.add("3.14th dimensional boulevard");
    ArrayList <String> provinceran = new ArrayList(); 
        provinceran.add("Ontario");
        provinceran.add("Quebec");
        provinceran.add("British Columbia");
        provinceran.add("Alberta");
        provinceran.add("Yukon");
        provinceran.add("Prince Edward Island");
        provinceran.add("Maine (shhhh, don't tell the Americans)");
     ArrayList <String> postran = new ArrayList(); 
        postran.add("N6R9J2");
        postran.add("Q9G8M3");
        postran.add("S8G5K8");
        postran.add("B4M2G0");
        postran.add("N9E7F8");
        postran.add("V5W9H9");
        postran.add("A1B2C3");
    int randomNum;
        randomNum = (int)(Math.random() * nameran.size());
       Cname = nameran.get (randomNum);
       randomNum = (int)(Math.random() * nameran.size());
       Caddress = addran.get (randomNum);
        randomNum = (int)(Math.random() * nameran.size());
        Ccity = cityran.get (randomNum);
        randomNum = (int)(Math.random() * nameran.size());
       Cprovince = provinceran.get (randomNum);
       randomNum = (int)(Math.random() * nameran.size());
       Cpostcode = postran.get (randomNum);
  }
    public customerMaker (String name){
        Cname = name;
        Ccity = "?";
        Caddress = "?";
        Cprovince = "?";
        Cpostcode = "?";
    }
       public customerMaker (String name, String add, String city, String pro, String post){
        Cname = name;
        Ccity = city;
        Caddress = add;
        Cprovince = pro;
        Cpostcode = post;
        
    }
    
    public String toString() {
    String output = "Name: " + Cname + "\n";
    output += "Address: " + Caddress + "\n";
    output += "City: " + Ccity + "\n";
    output += "Province: " + Cprovince + "\n";
    output += "Postal Code: " + Cpostcode;
    //output string is complete, return it
    return output;
    }
    
}
