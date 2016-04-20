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
public class Test {
    public static void main(String[] args)
    {
        String message = new String();
        File file = new File("res/allFeeds.xml");

        try
        {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(file);

            NodeList nodes = doc.getElementsByTagName("feed");
            for (int i = 0; i < nodes.getLength(); i++)
            {
                Element feed = (Element) nodes.item(i);

                NodeList titles = feed.getElementsByTagName("title");
                Element title = (Element) titles.item(0);
                message += "<br />Title: " + getCharacterDataFromElement(title) + "<br />";

                NodeList links = feed.getElementsByTagName("link");
                Element link = (Element) links.item(0);
                message += "<br />Link: " + getCharacterDataFromElement(link) + "<br />\n";
            }

            //System.out.println(message);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println(message);
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
