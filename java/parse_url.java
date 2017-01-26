import java.net.URL;

public class parse_url {
  public static void main(String[] args) throws Exception {
    URL url = new URL("http://www.mp3.com/top-downloads/genre/r&b");
    System.out.println("protocol:" + url.getProtocol());
    System.out.println("prot:" + url.getPort());
    System.out.println("host:" + url.getHost());
    System.out.println("path:" + url.getPath());
    System.out.println("file:" + url.getFile());
    System.out.println("query:" + url.getQuery());
    System.out.println("ref:" + url.getRef());
  }
}
