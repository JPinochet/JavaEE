/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmlreadermultirss;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File("res/feeds.xml");
        ArrayList URLList = new ArrayList();
        ArrayList keywordList = new ArrayList();
        ArrayList newsTitleList = new ArrayList();

        try
        {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(file);

            NodeList feeds = doc.getElementsByTagName("feed");
            for (int i = 0; i < feeds.getLength(); i++)
            {
                Element feed = (Element)feeds.item(i);
                
                NodeList links = feed.getElementsByTagName("link");
                Element link = (Element) links.item(0);
                String theLink = getCharacterDataFromElement(link);
                URLList.add(theLink);
                System.out.println(theLink);
            }

            NodeList keywords = doc.getElementsByTagName("keywords");
            Element keyword = (Element)keywords.item(0);
            NodeList words = keyword.getElementsByTagName("word");
            for (int j = 0; j < words.getLength(); j++)
            {
                Element word = (Element)words.item(j);
                String theWord = getCharacterDataFromElement(word);
                keywordList.add(j, theWord);
                System.out.println(theWord);
            }

            String a[] = new String[1000];

            for (int i = 0; i < URLList.size(); i ++)
            {
                try
                {
                    URL myURL = new URL ((String) URLList.get(i));
                    BufferedReader b = new BufferedReader(new InputStreamReader(myURL.openStream()));
                    String tempLine;

                    while((tempLine = b.readLine()) != null)
                    {
                        a[i++] = tempLine;
                        //System.out.println(tempLine);
                    }
                        Pattern openTag = Pattern.compile("<title>");
                        Pattern closingTag = Pattern.compile("</title>");

                        for(i = 0; i < a.length; i++)
                        {
                            if(a[i] == null)
                            {
                                break;
                            }
                            Matcher findStartTitles = openTag.matcher(a[i]);
                            Matcher findClosingTitles = closingTag.matcher(a[i]);

                            if(findStartTitles.find())
                            {
                                if(findClosingTitles.find())
                                {
                                    //System.out.println(a[i].substring(findStartTitles.end(), findClosingTitles.start()));
                                    newsTitleList.add(a[i].substring(findStartTitles.end(), findClosingTitles.start()));
                                }
                            }
                        }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            System.out.println();
            for(int i = 0; i < newsTitleList.size(); i++)
            {
                //System.out.println(newsTitleList.get(i));
                for(int j = 0; j < keywordList.size(); j++)
                {
                    //System.out.println(keywordList.get(j));
                    Pattern wordFind = Pattern.compile((String) keywordList.get(j));
                    Matcher wordSearch = wordFind.matcher((CharSequence) newsTitleList.get(i));

                    if(wordSearch.find())
                    {
                        System.out.println(keywordList.get(j) + " " + newsTitleList.get(i));
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

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
