import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Socket echoSocket = new Socket("localhost", 7000);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            String[] logs = new String[4];
            String[] ballDetails = null;

            while(true) {
                for(int i = 0; i<4; i++) {
                  logs[i] = in.readLine();
                   System.out.println(logs[i]);

                    //Ball = 2
                    if(i == 2) {
                     ballDetails = logs[2].split(" ");
                }
                }
                	MovePaddle(sc, out, ballDetails);
            
            	}
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void MovePaddle(Scanner sc, PrintWriter out, String[] ballDetails) {
    System.out.println("Ball x-Position = " + ballDetails[1]);
    System.out.println("Ball y-Position = " + ballDetails[2]);
    System.out.println("Ball x-Speed = " + ballDetails[3]);
    System.out.println("Ball y-Speed = " + ballDetails[4]);
    double xSpeed = Double.parseDouble(ballDetails[3]);
    double ySpeed = Double.parseDouble(ballDetails[4]);

    // System.out.println("moven pls: ");
    int moveTo = 0;

    if(xSpeed > 0) 
    {
        moveTo = 0;
    }
    else {
        if(ySpeed < 0) 
        {
          moveTo = 36;
        } else 
        {
          moveTo = -36;
        }
    }
    out.println("move " + moveTo);
    }
}