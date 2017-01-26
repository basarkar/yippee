import java.util.*;
import java.io.*;
import java.net.URL;
import java.net.URI;
import java.net.URLConnection;
class ID3V1{
  public static void main(String arg[]){
    try {
                String u = "http://sound26.mp3pk.com/indian/emaet/ek-main-aur-ekk-tu01(www.songs.pk).mp3";
                URL url = new URL(u);
                URLConnection conn;
                URLConnection conn1;
                conn = url.openConnection(); conn1 = url.openConnection();
//                System.out.println(conn.getContentLength());
                conn.setRequestProperty("range", "bytes="+(conn1.getContentLength()-128)+"-");
                conn.connect();
                InputStream is = conn.getInputStream();
                ByteArrayOutputStream os = new ByteArrayOutputStream();                 
                byte[] buf = new byte[4096];
                int n;                  
                while ((n = is.read(buf)) >= 0) 
                        os.write(buf, 0, n);
                os.close();
                is.close();                     
                byte[] data = os.toByteArray();
                System.out.println(os.toString());
        } catch (IOException e) {
                e.printStackTrace();
          }
  }
}
