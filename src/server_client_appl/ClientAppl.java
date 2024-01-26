package server_client_appl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import netTCP.TCPClient;

public class ClientAppl {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String enter = "calc";
		String enswer;
		try (TCPClient client = new TCPClient("localhost", 2001)) {
			while (true) {
				enswer = client.sendRequest(enter);
				System.out.println(enswer + " (Exit for escape)");
				enter = bf.readLine();
				if (enter.equalsIgnoreCase("Exit") || enswer.equals("finish"))
					return;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}