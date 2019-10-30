class Link<T> {
	T item;
	Link next;

	public Link(T item) {
		this.item = item;
	}

	public void display() {
		System.out.print(item + " ");
	}

}

class LinkList<T> {
	Link first;

	public void insertFirst(T item) {
		Link cur = new Link(item);
		cur.next = first;
		first = cur;
	}

	public T removeFirst() {
		Link temp = first;
		first = first.next;
		return (T) temp.item;
	}

	public T peek() {
		T it = (T) first.item;
		return it;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void display() {
		Link cur = first;
		while (cur != null) {
			cur.display();
			cur = cur.next;
		}
		System.out.println();
	}
}

class LinkStack<T> {
	LinkList<T> stack = new LinkList();
	public void push(T item) {
		stack.insertFirst(item);
	}

	public T pop() {
		T temp = stack.removeFirst();
		return temp;
	}

	public void displayStack() {
		stack.display();
	}

	public T peek() {
		return stack.peek();
	}

}

public class A_5_4_LinkStackApp {
	public static void main(String[] args) {
		LinkStack<Integer> theStack = new LinkStack<>(); // Создание стека
		theStack.push(20); // Вставка элементов
		theStack.push(40);
		theStack.displayStack(); // Вывод содержимого стека
		theStack.push(60); // Вставка элементов
		theStack.push(80);
		theStack.push(90);
		theStack.displayStack(); 
		System.out.println(theStack.pop());
		System.out.println(theStack.peek());
		System.out.println(theStack.peek());
		theStack.displayStack();
	}
}
