/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmlreader2;
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
    public static void main(String[] args) {
        String message = new String();
   try
   {
     DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
     Document doc = builder.parse("http://feeds.reuters.com/reuters/topNews");

     NodeList nodes = doc.getElementsByTagName("item");
     for (int i = 0; i < nodes.getLength(); i++)
     {
       Element news = (Element) nodes.item(i);

       //customer name
       NodeList titles = news.getElementsByTagName("title");
       Element title = (Element) titles.item(0);
       message = "News: " + getCharacterDataFromElement(title);

       NodeList dates = news.getElementsByTagName("pubDate");
       Element date = (Element) dates.item(0);
       message += "\nDate: " + getCharacterDataFromElement(date) + "\n";

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
