package calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BinaryOperator;

public class Calculator {
	InputOutput inOut;
	static HashMap<String, BinaryOperator<Integer>> operations;
	static {
		operations = new HashMap<String, BinaryOperator<Integer>>();
		operations.put("+",	(x, y) -> x + y);
		operations.put("-",	(x, y) -> x - y);
		operations.put("*",	(x, y) -> x * y);
		operations.put("/",	(x, y) -> x / y);
	}

	public Calculator(InputOutput inOut) {
		this.inOut = inOut;
	}
	public String displayedName() {		
		return "Integer numbers calculator";
	}


	public void perform() {
		Integer op1 = inOut.inputInteger("Enter first number");
		if(op1==null)
			return;
		Integer op2 = inOut.inputInteger("Enter second number");
		if(op2==null)
			return;
		String oper = inOut.inputString("Enter operator from ", new ArrayList<String>(operations.keySet()));
		if(oper == null) return;
		inOut.outputLine(operations.get(oper).apply(op1, op2));	
	}

}
