/*
 * File: ArrayStack.java
 *
 * Author: John Moon <johncarlmoon@gmail.com>
 * 
 * Purpose: Implements a stack class for double ints using arrays.
 *
 */

import java.util.EmptyStackException;

public class ArrayStack implements DStack {
	private int top;
	int size = 10;
	double[] stack = new double[size];

	public void push(double data) {
		if (top == size - 1) { // Array is full. Double the size.
			size = size * 2;
			stack = doubleSize(stack, size);
		}
		top = top + 1;
		stack[top] = data;
	}
	
	public double pop() {
		if (!isEmpty()) {
			double tmp = stack[top];
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
		return stack[top];
	}

	private double[] doubleSize(double[] oldArr, int newSize) {
		double[] newArr = new double[newSize];
		int i;
		for (i = 0; i < newSize / 2; i++) {
			newArr[i] = oldArr[i];
		}
		return newArr;
	}
}
