import java.util.EmptyStackException;

public class ArrayStack implements DStack {
	private int top;
	int size;
	double stack[];

	public void push(double data) {
		if (top == size - 1) {
			// Stack is full
		} else {
			top = top + 1;
			stack[top] = data;
		}
	}
	
	public double pop() {
		if (!isEmpty()) {
			double tmp = top;
			top = top - 1;
			return tmp;
		} else {
			throw new EmptyStackException();
		}
	}
	
	public boolean isEmpty() {
		return top == -1;
	}

	public double peek() {
		return top;
	}
}
