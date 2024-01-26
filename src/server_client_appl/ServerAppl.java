package server_client_appl;
import netTCP.Protocol;
import netTCP.Server;

public class ServerAppl {

	public static void main(String[] args) throws Exception {
		Server server = new Server(new Protocol(), 2001);
		server.run();

	}

}
