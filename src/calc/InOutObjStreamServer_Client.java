package calc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class InOutObjStreamServer_Client implements InputOutput {
	 ObjectInputStream input;
	 ObjectOutputStream output;
	 

	public InOutObjStreamServer_Client(ObjectInputStream input, ObjectOutputStream output) {
		this.input = input;
		this.output = output;
	}

	@Override
	public String inputString(String prompt) {
		try {
			outputLine(prompt);
			return (String) input.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void output(Object object) {
		try {
		output.writeObject(object);
		output.flush();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

}
