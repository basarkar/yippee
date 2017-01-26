import java.net.URLEncoder;

public class Encode
{
   public static void main(String[] args) throws Exception
   {
      System.out.println("Should see %20 here: " + URLEncoder.encode(" ", "RFC1738"));

   }
}
