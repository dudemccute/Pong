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
			String[] currentballDetails = null;
			String[] currentPos = null;
			
			while(true) {
				
				for(int i = 0; i<4; i++) {
					logs[i] = in.readLine();
					System.out.println(logs[i]);
					
					// Ball = 2
					if(i == 2) {
						currentballDetails = logs[2].split(" ");
						currentPos = logs[0].split(" ");
					}	
				}
				MovePaddle(sc, out, currentballDetails, currentPos);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void MovePaddle(Scanner sc, PrintWriter out, String[] currentballDetails, String[] currentPos) {
		
	System.out.println("Ball x-Position = " + currentballDetails[1]);
	System.out.println("Ball y-Position = " + currentballDetails[2]);
	System.out.println("Ball x-Speed = " + currentballDetails[3]);
	System.out.println("Ball y-Speed = " + currentballDetails[4]);
	double currentxPos = Double.parseDouble(currentballDetails[1]);
	double currentyPos = Double.parseDouble(currentballDetails[2]);
	double currentxSpeed = Double.parseDouble(currentballDetails[3]);
	double currentySpeed = Double.parseDouble(currentballDetails[4]);
	
	double paddlepos = Double.parseDouble(currentPos[1]);
	double size = 800-150;
	double mid = 400-150;
	// 
	System.out.println("moven pls");
	int moveTo = 0;
	
	if(currentxSpeed > 0) {
		if(paddlepos < mid) {
			moveTo = 18;
		}
		else {
			moveTo = -18;
		}
	}
	else {
		if(currentyPos > paddlepos+75) {
			moveTo = 36;
		}
		else {
			moveTo = -36;
		}
	}
	
	out.println("move " + moveTo);
	}
}