import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackX {
	private char[] stackArr;
	private int top;
	private int size;

	public StackX(int n) {
		stackArr = new char[n];
		top = -1;
		size = n;
	}

	public void push(char key) {
		stackArr[++top] = key;
	}

	public char pop() {
		return stackArr[top--];
	}

	public char peek() {
		return stackArr[top];
	}

	public boolean isFull() {
		return top == size - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}
}

class BracketChecker {
	private String input;

	public BracketChecker(String input) {
		this.input = input;
	}

	public void check() {
		StackX stack = new StackX(input.length());
		int mistake = 0;
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch (ch) {
			case '{':
			case '[':
			case '(':
				stack.push(ch);
				break;
			case '}':
			case ']':
			case ')':
				if (norm(ch, stack))
					break;
				else
					mistake = i + 1;
				break ;
			default:
				continue;
			}
			if (mistake != 0)
				break;
		}
		if (mistake == 0 && stack.isEmpty())
			System.out.println("all right");
		else
			System.out.println("mistake"+mistake);
	}

	private boolean norm(char ch, StackX stack) {
		char chOpen = stack.pop();
		if (chOpen + 1 == ch | chOpen + 2 == ch) // ASII to see
			return true;
		return false;
	}

}

public class A_4_3_BracketsApp {

	public static void main(String[] args) throws IOException {
		String input;
		while (true) {
			System.out.print("Enter string containing delimiters: ");
			System.out.flush();
			input = getString(); // Чтение строки с клавиатуры
			if (input.equals("")) // Завершение, если [Enter]
				break;
			// Создание объекта BracketChecker
			BracketChecker theChecker = new BracketChecker(input);
			theChecker.check(); // Проверка парных скобок

		}

	}

	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine().trim();
	}
}