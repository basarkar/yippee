import java.net.*;
public class Test{
private static boolean isLive(String link) {
HttpURLConnection urlConnection = null;
try {
URL url = new URL(link);
urlConnection = (HttpURLConnection) url.openConnection();
urlConnection.setRequestMethod("HEAD");
urlConnection.setConnectTimeout(5000); /* timeout after 5s if can't connect */
urlConnection.setReadTimeout(5000); /* timeout after 5s if the page is too slow */
urlConnection.connect();
String redirectLink = urlConnection.getHeaderField("Location");
System.out.println(redirectLink);
if (redirectLink != null && !link.equals(redirectLink)) {
return isLive(redirectLink);
} else {
return urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK;
}
} catch (Exception e) {
System.out.println(urlConnection.getURL());
return false;
} finally {
if (urlConnection != null) {
urlConnection.disconnect();
}
}
}

public static void main(String[] args) {
//System.setProperty("http.proxyHost", "3.212.136.15");
//System.setProperty("http.proxyPort", "8080");
System.out.println(isLive(args[0]));
}
}
