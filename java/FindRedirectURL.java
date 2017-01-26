import java.net.*;
class FindRedirectURL{
public static String getRedirectURL(String url){
try{
HttpURLConnection con = (HttpURLConnection)(new URL( url ).openConnection());
con.setInstanceFollowRedirects( false );
con.connect();
int responseCode = con.getResponseCode();
//System.out.println( responseCode );
if(responseCode == 302){
  String location = con.getHeaderField( "Location" );
  return( location.replace(" ", "%20") );
}
else {
  return(url);
}
}catch(Exception e){
  return(url);
}

}
}
