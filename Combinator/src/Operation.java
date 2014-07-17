public class Operation {
	private int operand_one;
	private int operand_two;

	public Operation(int a, int b) {
		this.operand_one = a;
		this.operand_two = b;
	}

	public int getOperand_one() {
		return operand_one;
	}

	public void setOperand_one(int operand_one) {
		this.operand_one = operand_one;
	}

	public int getOperand_two() {
		return operand_two;
	}

	public void setOperand_two(int operand_two) {
		this.operand_two = operand_two;
	}

	public int add() {
		return operand_one + operand_two;
	}

	public int subtract() {
		return operand_one - operand_two;
	}

	public int multiply() {
		return operand_one * operand_two;
	}

	public int divide() {
		if (operand_two > operand_one || (operand_one % operand_two) != 0
				|| operand_two == 0) {
			throw new ArithmeticException();
		}else{
			return operand_one / operand_two;
		}
		
	}
}
