import java.io.*;

class StackX {
	private char[] stackArr;
	int top;

	public StackX(int length) {
		stackArr = new char[length];
		top = -1;
	}

	public void push(char key) throws Exception {
		if (isFull())
			throw new Exception("stack is full");
		stackArr[++top] = key;
	}

	private boolean isFull() {
		return top == stackArr.length - 1;
	}

	private int size() {
		return top + 1;
	}

	public char pop() throws Exception {
		if (isEmpty())
			throw new Exception("stack is empty");
		return stackArr[top--];
	}

	public char peek() throws Exception {
		if (isEmpty())
			throw new Exception("stack is empty");
		return stackArr[top];

	}

	boolean isEmpty() {
		return top == -1;
	}

}

class InToPost {
	StackX stack;
	String output;
	String input;

	public InToPost(String input) {
		stack = new StackX(input.length());
		this.input = input;
	}

	public String doTrans() throws Exception {
		output = "";

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch (ch) {
			case ' ':
				continue;
			case '+':
			case '-':
				gotOperator(ch, 1);
				break;
			case '*':
			case '/':
				gotOperator(ch, 2);
				break;
			case ')':
				gotParen();
				break;
			case '(':
				stack.push(ch);
				break;
			default:
				output += ch;
				break;
			}
		}
		while (!stack.isEmpty()) {
			char ch = stack.pop();
			output += ch;
		}
		return output;
	}

	private void gotParen() throws Exception {
		while (!stack.isEmpty()) {
			char ch = stack.pop();
			if (ch == '(')
				return;
			output += ch;

		}

	}

	private void gotOperator(char newOperator, int newMean) throws Exception {
		if (!stack.isEmpty()) {
			char oldOperator = stack.pop();
			int OldMean = FindMean(oldOperator);
			if (OldMean == 5) {
				stack.push(oldOperator);
				stack.push(newOperator);
				return;
			}
			if (newMean > OldMean) {
				stack.push(oldOperator);
			} else
				output += oldOperator;
		}
		stack.push(newOperator);
	}

	private int FindMean(char oldMean) {
		if (oldMean == '+' | oldMean == '-')
			return 1;
		if (oldMean == '(')
			return 5;
		return 2;
	}

}

class ParsePost {
	StackX stack;
	double ans;
	String inputPost;

	public ParsePost(String inputPost) {
		this.inputPost = inputPost;
		stack = new StackX(inputPost.length());
	}

	public char ParsePostFix() throws Exception {
		for (int i = 0; i < inputPost.length(); i++) {
			char ch = inputPost.charAt(i);
			if (!isOperator(ch)) {
				stack.push((char) (ch-'0'));
				continue;
			}
			char b=stack.pop();
			char a=stack.pop();
			switch (ch) {
			case '+':
				a+=b;
				break;
			case '*':
				a*=b;
				break;
			case '/':
				a/=b;
				break;
			case '-':
				a-=b;
				break;
			}
			stack.push(a);
		}
		
		return stack.pop();
	}

	private boolean isOperator(char ch) {
		if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
			return true;
		return false;
	}

}

public class A_4_8_PostfixApp {

	public static void main(String[] args) throws Exception {
		String input, output;
		while (true) {
			System.out.print("Enter infix: ");
			System.out.flush();
			input = getString(); // ������ ������ � ����������
			if (input.equals("")) // �����, ���� ������ ������� [Enter]
				break;
			// �������� �������-���������������
			InToPost theTrans = new InToPost(input);
			output = theTrans.doTrans(); // ��������������
			System.out.println("Postfix is " + output + '\n');
			ParsePost q = new ParsePost(output);
			char ans = q.ParsePostFix();
			System.out.println("ans= " + (int)ans);
		}

	}

	private static String getString() throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader M = new BufferedReader(ir);
		String s = M.readLine().trim();
		return s;
	}

}
