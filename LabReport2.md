# Lab Report 2 - Servers and SSH Keys

Here is the code for the StringServer

```
import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 1;
    String string = "";

  public String handleRequest(URI url){
    if(url.getPath().equals("/")){
        return string;
    }
    else{
    if(url.getPath().contains("/add-message")){
      String[] parameters = url.getQuery().split("=");
      if(parameters[0].equals("s")){
        String message = "";
        try{
           String encodedParameter = parameters[1];
           String decodedParameter = URLDecoder.decode(encodedParameter, "UTF-8");
           message = num + ". " + decodedParameter + "\n";
        }
        catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        string += message;
        num += 1;
        return string;
      }
    }
        return "404 not Found!";
    }
  }
}


class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }
        int port = Integer.parseInt(args[0]);
        Server.start(port, new Handler());
    }
}
```
![hello.png]
![howareyou.png]
