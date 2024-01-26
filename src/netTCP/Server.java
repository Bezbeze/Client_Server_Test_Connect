package netTCP;


import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

	ServerSocket serverSocket;
	IProtocol protocol;
	int port;

	public Server(IProtocol protocol, int port) throws Exception {
		this.protocol = protocol;
		this.port = port;
		serverSocket = new ServerSocket(port);
	}

	@Override
	public void run() {
		System.out.println("listen on port " + port);
		try {
			while (true) {
				Socket socket = serverSocket.accept();
				ServerListener serverClientListener = new ServerListener(socket, protocol);
				serverClientListener.run();
			}
		} catch (Exception e) {
			System.out.println("class Server.run()   "+ e.getMessage());
		}
	}

}
