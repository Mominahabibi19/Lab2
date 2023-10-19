import java.io.IOException;
import java.net.URI;

class StringServer implements URLHandler{
  String accumulatedMessages = "";
  
public String handleRequest(URI url){
    if (url.getPath().startsWith("/add-message")) {
           String queryString = url.getQuery();
      if ( queryString!= null){
        String[] parts = queryString.split("s=");
        if (parts.length >1){
          String message = parts[1];
          accumulatedMessages += message + "\n";
        }
      }
      return accumulatedMessages;
      
    }
  else{
    return "404 not Found!";
  }
}
}
