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

	public int pop() {
		return stackArr[top--];
	}

	public char peek() {
		return stackArr[top];
	}

	public void push(char key) {
		stackArr[++top] = key;
	}

	public boolean isFull() {
		return top == size - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

}

class Reverser {
	private String input;
	private String output;

	public Reverser(String input) {
		this.input = input;
	}

	public void doRev() {
		StackX stack = new StackX(input.length());
		FindStack(stack);
		output="";
		while(!stack.isEmpty())
			output+=""+(char)stack.pop();
		
	}

	private void FindStack(StackX stack) {
		for (int i = 0; i < input.length(); i++)
			stack.push(input.charAt(i));
	}

	public String getOutput() {		
		return output;
	}

}

public class A_4_2_ReverseApp {

	public static void main(String[] args) throws IOException {
		String input, output;
		while (true) {
			System.out.print("Enter a string: ");
	//		System.out.flush();
			input = getString(); // Чтение строки с клавиатуры
			if (input.equals("")) // Завершение, если [Enter]
				break;
			// Создание объекта Reverser
			Reverser theReverser = new Reverser(input);
			 theReverser.doRev(); // Использование
			 output =theReverser.getOutput();
			System.out.println("Reversed: " + output);
		}
	}

	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;

	}
}
