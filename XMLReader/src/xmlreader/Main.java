/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmlreader;
import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    // using DOM
    public static void main(String[] args) {
        String message = new String();

   File file = new File("res/customers.xml");

   try
   {
     DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
     Document doc = builder.parse(file);

     NodeList nodes = doc.getElementsByTagName("customer");
     for (int i = 0; i < nodes.getLength(); i++)
     {
       Element customer = (Element) nodes.item(i);

       //customer name
       NodeList names = customer.getElementsByTagName("name");
       Element name = (Element) names.item(0);
       message = "Name: " + getCharacterDataFromElement(name);

       //customer address (street, city,postal code)
       try
       {
           NodeList addresses = customer.getElementsByTagName("address");
           Element address = (Element) addresses.item(0);

           //street
           NodeList streets = address.getElementsByTagName("street");
           Element street = (Element) streets.item(0);
           message = message + "\tADDRESS: " + getCharacterDataFromElement(street);

           //city
           NodeList cities = address.getElementsByTagName("city");
           Element city = (Element) cities.item(0);
           message = message + ", " + getCharacterDataFromElement(city);

           //postal code
           NodeList pCodes = address.getElementsByTagName("postalCode");
           Element postalCode = (Element) pCodes.item(0);
           message = message + ", " + getCharacterDataFromElement(postalCode);

       }
       catch (Exception e)
       { }

       //customer phone number(s) (number,type)
       try
       {
            //Number
           NodeList numbers = customer.getElementsByTagName("phoneNumber");
           for (int j=0; j<numbers.getLength(); j++)
           {
               Element phone = (Element) numbers.item(j);

               //number
               NodeList thisNumber = phone.getElementsByTagName("number");
               Element number = (Element) thisNumber.item(0);
               String tempNumber = getCharacterDataFromElement(number);
               message = message + "\tPHONE: " + tempNumber;

               //type
               try
               {
               NodeList thisType = phone.getElementsByTagName("type");
               Element type = (Element) thisType.item(0);
               String tempType = getCharacterDataFromElement(type);

               message = message + ", " + tempType + "; ";
               }
               catch (Exception e)
               {}
           }
       }
       catch (Exception e)
       {}

       System.out.println(message);
     }
   }
   catch (Exception e)
   {
      e.printStackTrace();
   }

 }


    //Get character data from specified element, return as a String
    private static String getCharacterDataFromElement(Element e)
    {
            Node child = e.getFirstChild();
            String result="";

            if (child instanceof CharacterData)
            {
                    CharacterData cd = (CharacterData) child;
                    result=cd.getData();
            }

            return result;
    }

}
