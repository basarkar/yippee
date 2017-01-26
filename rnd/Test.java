import java.util.*;
import java.io.*;
import java.net.URL;
import java.net.URI;
class Test{
  public static void main(String arg[]){
    try {
                String u = "http://sound26.mp3pk.com/indian/emaet/ek-main-aur-ekk-tu01(www.songs.pk).mp3";
                URL url = new URL("http://facebook.com");
                InputStream is = url.openStream();
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
