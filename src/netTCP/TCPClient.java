package netTCP;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClient implements Closeable {
	protected ObjectInputStream input;
	protected ObjectOutputStream output;
	protected Socket socket;
	
	public TCPClient(String hostName, int port) throws Exception {
		socket = new Socket(hostName, port);
		output = new ObjectOutputStream(socket.getOutputStream());
		input = new ObjectInputStream(socket.getInputStream());

	}

	@Override
	public void close() throws IOException {
		socket.close();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T sendRequest(String requestType) {
		try {
			output.writeObject(requestType);
			String response = (String) input.readObject();
			return  (T) response;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

}
