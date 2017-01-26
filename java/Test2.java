import java.net.*;
public class Test2{
public static void main(String[] args) throws Exception{
String url = args[0];
HttpURLConnection con = (HttpURLConnection)(new URL( url ).openConnection());
con.setInstanceFollowRedirects( false );
con.connect();
int responseCode = con.getResponseCode();
System.out.println( responseCode );
if(responseCode == 302){
  String location = con.getHeaderField( "Location" );
  System.out.println( location.replace(" ", "%20") );
}
else {
  System.out.println(url);
}

}
}
