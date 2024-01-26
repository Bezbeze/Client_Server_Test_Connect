package netTCP;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


//связь между сервером и клиентом
public interface IProtocol {

	String getResponse(Object request, ObjectInputStream input, ObjectOutputStream output);
}
