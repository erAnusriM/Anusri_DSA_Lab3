package com.gl.lab3;

import java.util.Stack;
import java.util.Scanner;

public class Prob1 {
	Stack<Character> stack = new Stack<Character>();
	int size;

	private boolean isBracketBalanced(String expr) {
		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);
			if (x == '(' || x == '[' || x == '{') {
				// Push the element in the stack
				stack.push(x);
				continue;
			}
			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}
		return (stack.isEmpty());
	}

	public static void main(String[] args) {
		Prob1 p1 = new Prob1();
		String expr = "( [ [ { } ] ] )";
		p1.size = expr.length();
		if (p1.isBracketBalanced(expr)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}
}
