package netTCP;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//точка входа, посредник между сервером и клиентом
//запускает сервер, получает запрос от клиента, но не ведёт обработку запроса
//отправляет ответ
public class ServerListener implements Runnable {
		
	ObjectInputStream input;
	ObjectOutputStream output;
	Socket socket;					  // port socket
	IProtocol protocol;

	public ServerListener(Socket socket, IProtocol protocol) throws Exception {
		super();
		this.socket = socket;
		this.protocol = protocol;
		input = new ObjectInputStream(socket.getInputStream());
		output = new ObjectOutputStream(socket.getOutputStream());

	}

	@Override
	public void run() {
		try {
			while (true) {
				Object request = input.readObject();
				String response = protocol.getResponse(request, input, output);
				output.writeObject(response);
			}
		}catch (EOFException e) {			
			System.out.println("Client closed connection");
		} catch (Exception e) {	
			e.printStackTrace();
			System.out.println("Error ServerClientListener.run()" + e.getMessage());
		}
	}

}
