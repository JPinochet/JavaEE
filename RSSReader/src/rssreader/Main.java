/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rssreader;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URL;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final char CR = 13;
        final char LF = 10;

        String str = " ";
        String a[] = new String[1000];
        int i = 0;

        try
        {
            URL myURL = new URL ("http://feeds.reuters.com/reuters/topNews");
            BufferedReader b = new BufferedReader(new InputStreamReader(myURL.openStream()));
            String tempLine;

            while((tempLine = b.readLine()) != null)
            {
                str = str + tempLine + CR + LF;
                a[i++] = tempLine;
            }

            //Pattern titles = Pattern.compile("<title>[a-zA-Z0-9 \",:.]*</title>");
            Pattern openTag = Pattern.compile("<title>");
            Pattern closingTag = Pattern.compile("</title>");
            Pattern openPubTag = Pattern.compile("<pubDate>");
            Pattern closingPubTag = Pattern.compile("</pubDate>");

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
                        System.out.println(a[i].substring(findStartTitles.end(), findClosingTitles.start()));
                    }
                }

                Matcher findStartPubDate = openPubTag.matcher(a[i]);
                Matcher findClosingPubDate = closingPubTag.matcher(a[i]);

                if(findStartPubDate.find())
                {
                    if(findClosingPubDate.find())
                    {
                        System.out.println(a[i].substring(findStartPubDate.end(), findClosingPubDate.start()));
                        System.out.println();
                    }
                }
            }

            b.close();
            System.out.println(str);
        }
        catch(java.net.MalformedURLException e)
        {
            System.out.println(e.getStackTrace());
        }
        catch (IOException e)
        {
            System.out.println(e.getStackTrace());
        }
    }

}
