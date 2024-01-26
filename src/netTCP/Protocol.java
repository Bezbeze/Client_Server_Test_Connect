package netTCP;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import calc.Calculator;
import calc.InOutObjStreamServer_Client;

public class Protocol implements IProtocol {

	@Override
	public String getResponse(Object request, ObjectInputStream input, ObjectOutputStream output) {
		
		if(request.equals("calc")) {
			InOutObjStreamServer_Client inOut = new InOutObjStreamServer_Client(input, output);
			Calculator calculator = new Calculator(inOut);
			calculator.perform();
			return "finish";			
		}else 
		return "Dont know command";
	}

	

}
