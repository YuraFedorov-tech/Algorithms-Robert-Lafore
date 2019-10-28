import java.io.*;

class StackX {
	private char stackArr[];
	private int top;

	public StackX(String input) {
		top = -1;
		stackArr = new char[input.length()];
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

	public boolean isEmpty() {
		return top == -1;
	}

	public int size() {
		return top + 1;
	}

	public void display() {
		for (int i = 0; i < size(); i++)
			System.out.print(stackArr[i]);
		System.out.println();

	}

}

class InToPost {
	StackX theSteck;
	String input;
	String output = "";

	public InToPost(String input) {
		this.input = input;
		theSteck = new StackX(input);
	}

	public String doTrans() {
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == ' ')
				continue;
			show(ch);
			switch (ch) {
			case '(':
				theSteck.push(ch);
				break;
			case '+':
			case '-':
				gotOper(ch, 1);
				break;
			case '*':
			case '/':
				gotOper(ch, 2);
				break;

			case ')':
				gotParen();
				break;
			default:
				output += ch;
			}
		}
		while (!theSteck.isEmpty())
			output += theSteck.pop();
		return output;
	}

	private void gotParen() {
		while (!theSteck.isEmpty()) {
			char ch = theSteck.pop();
			if (ch == '(')
				break;
			output += ch;
		}
	}


private void gotOper(char newOperator, int newMean)  {
	while (!theSteck.isEmpty()) {
		char oldOperator = theSteck.pop();
		int OldMean = getPTop(oldOperator);
		if (OldMean == 5) {
			theSteck.push(oldOperator);
			theSteck.push(newOperator);
			return;
		}
		if (newMean > OldMean) {
			theSteck.push(oldOperator);
			break;
		} else
			output += oldOperator;
	}
	theSteck.push(newOperator);
}
///////////////////////////////
	private int getPTop(char chTop) {
		if (chTop == '+' || chTop == '-')
			return 1;
		if(chTop == '(' )
			return 5;
		return 2;
	}

	private void show(char ch) {
		if (theSteck.isEmpty())
			return;
		System.out.println("show stack, znak - " + ch);
		theSteck.display();
		System.out.println();
	}
}

public class A_4_7_InfixApp {
	public static void main(String[] args) throws IOException {
		String input, output;
		while (true) {
			System.out.print("Enter infix: ");
			System.out.flush();
			input = getString(); // Чтение строки с клавиатуры
			if (input.equals("")) // Выход, если нажата клавиша [Enter]
				break;
			// Создание объекта-преобразователя
			InToPost theTrans = new InToPost(input);
			output = theTrans.doTrans(); // Преобразование
			System.out.println("Postfix is " + output + '\n');
		}
	}

	private static String getString() throws IOException {
		InputStreamReader inp = new InputStreamReader(System.in);
		BufferedReader M = new BufferedReader(inp);
		return M.readLine().trim();
	}
}