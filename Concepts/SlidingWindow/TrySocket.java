package Concepts.SlidingWindow;

import java.net.Socket;
import java.lang.*;

public class TrySocket {
    public static void main(String[] args){
        try{

            Socket client = new Socket("cs5700fa20.ccs.neu.edu", 27995);OutputStream outstream = socket .getOutputStream(); 
            PrintWriter out = new PrintWriter(outstream);
            out.print(toSend );
            client.close();
        }
        catch(Exception e){
            System.out.println("NO NO");
        }

    }
}
