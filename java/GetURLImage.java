import java.util.*;
import java.io.*;
import java.net.URL;
import java.net.URI;
import java.util.Enumeration;
import java.net.HttpURLConnection;
import java.net.URLConnection;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

public class GetURLImage {
   static boolean sameDomain(String domain, String url){
     boolean flag=false;
     try{
     URL purl = new URL(url);
     url = purl.getHost().toString();

     if(url.equals(domain)){
       flag = true;
     }
     else if(url.endsWith("."+domain)){
       flag = true;
     }
     }catch(Exception e){}
     return flag;
   }
   static String getAbsoluteURL(String base, String url){
     url = url.toLowerCase();
//     System.out.print(url + " ----> ");
     try{
     if(url.startsWith("/")){
       URL baseURL = new URL(base);
       url = baseURL.getProtocol() + "://" + baseURL.getHost() + url;
     }
     else{
     URL providedURL = new URL(url);
     }
     }catch(Exception e){
try{
       URL baseURL = new URL(base);
       String path = (baseURL.getPath().equals(""))? "/" : baseURL.getPath();
       url = baseURL.getProtocol() + "://" + baseURL.getHost() +  path.substring(0, path.lastIndexOf("/")+1) + url; 
}catch(Exception ee){}
     }
     return url;
   }
   static ArrayList temp_arr;
   public static void main(String[] args) throws Exception  {
      Reader r = null;
      temp_arr = new ArrayList();
      ArrayList visitedURL = new ArrayList();
      ArrayList arr = new ArrayList();
      String domain = args[1];
      //static String arr;

      try   {
//         System.setProperty("http.proxyHost", "3.212.136.15");
//         System.setProperty("http.proxyPort", "8080");
         URL u;
         String url;
         if(args[0]!=null){url = new String(args[0]);}
         else{ 
           url = new String("http://www.ivillage.com/");
         }
         arr.add(url);
         while(!arr.isEmpty()){
         url = arr.remove(0).toString(); 
         System.out.println(url);
         if(visitedURL.contains(url)){
           continue;
         }
         try{
         url = FindRedirectURL.getRedirectURL(url);
         u = new URL(url);
         URLConnection c = u.openConnection(); // Get URLConnection from URL
         c.connect();
         if(c.getContentType().startsWith("image/")){
           InputStream is = c.getInputStream();
           
           System.out.println("Image: " + c.getURL());
           is.close();
//           System.out.println("Hurrey It is a mp3 file");
         }
         else if(sameDomain(domain, url)){
         InputStream in = u.openStream();
         r = new InputStreamReader(in);

         ParserDelegator hp = new ParserDelegator();
         hp.parse(r, new HTMLEditorKit.ParserCallback() {
            public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
               // System.out.println(t);
               if(t == HTML.Tag.A)  {
                  Enumeration attrNames = a.getAttributeNames();
                  StringBuilder b = new StringBuilder();
                  while(attrNames.hasMoreElements())    {
                      Object key = attrNames.nextElement();
                      if("href".equals(key.toString())) {
                          //System.out.println(getAbsoluteURL("sd", a.getAttribute(key).toString()));
                          GetURLImage.temp_arr.add(a.getAttribute(key).toString());
                      }
                  }
               }
               if(t == HTML.Tag.IMG)  {
                  Enumeration attrNames = a.getAttributeNames();
                  StringBuilder b = new StringBuilder();
                  while(attrNames.hasMoreElements())    {
                      Object key = attrNames.nextElement();
                      if("src".equals(key.toString()) || "SRC".equals(key.toString())) {
                          //System.out.println(getAbsoluteURL("sd", a.getAttribute(key).toString()));
                          GetURLImage.temp_arr.add(a.getAttribute(key).toString());
                      }
                  }
               }
            }
         }, true);
         
         
         Iterator<String> itr = temp_arr.iterator();
         while(itr.hasNext()) {
           String element = itr.next();
           arr.add(getAbsoluteURL(url, element));
         }
         temp_arr.clear();

//         System.out.println(arr);
         }
         }catch(Exception e){}
         visitedURL.add(url);

         }
      }finally {
         if(r != null)  {
            r.close();
         }
      }
   }
}

