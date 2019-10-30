import java.io.IOException;

class Link<T> {
	Link next;
	T item;

	public Link(T item) {
		this.item = item;
	}

	public void display() {
		System.out.print(item + " ");
	}

}

class LinkList<T> {
	Link first;
	Link last;

	public void insertLast(T item) {
		Link cur = new Link(item);
		if (first == null) {
			first = cur;
		} else
			last.next = cur;
		last = cur;

	}

	public void diaplay() throws IOException {
		if(isEmpty())
			throw new  IOException("Empty");
		Link cur = first;
		while (cur != null) {
			cur.display();
			cur = cur.next;
		}
		System.out.println();
	}

	public T removeFirst() throws IOException {
		if(isEmpty())
			throw new  IOException("Empty");
		T it = (T) first.item;
		first = first.next;
		return it;
	}

	private boolean isEmpty() {
		 return first==null;
	}

	public T peekFirst() throws IOException {
		if(isEmpty())
			throw new  IOException("Empty");
		T it = (T) first.item;
		return it;
	}

}

class LinkQueue<T> {
	LinkList<T> linqQueue = new LinkList();

	public void push(T item) {
		linqQueue.insertLast(item);

	}

	public void displayQueue() throws IOException {
		linqQueue.diaplay();
	}

	public T pop() throws IOException {
		return linqQueue.removeFirst();
	}

	public T peek() throws IOException {
		return linqQueue.peekFirst();
	}

}

public class A_5_5_LinkQueueApp {

	public static void main(String[] args) throws IOException {
		LinkQueue<Integer> theQueue = new LinkQueue<>(); 
		theQueue.push(20); 
		theQueue.push(40);
		theQueue.displayQueue(); 
		theQueue.push(60); 
		theQueue.push(80);
		theQueue.push(90);
		theQueue.displayQueue();
		System.out.println(theQueue.pop());
		System.out.println(theQueue.peek());
		System.out.println(theQueue.peek());
		theQueue.displayQueue();

		
		
		LinkQueue<Double> stack = new LinkQueue<>(); 
		stack.push(20.1);
		stack.push(40.1);
		stack.displayQueue(); 
		stack.push(60.1); 
		stack.push(80.1);
		stack.push(90.1);
		stack.displayQueue(); 
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		stack.displayQueue();
		
		
		LinkQueue<String> strStack = new LinkQueue<>(); 
		strStack.push("a"); 
		strStack.push("B");
		strStack.displayQueue(); 
		strStack.push("dg"); 
		strStack.push("g");
		strStack.push("qqqqqqq");
		strStack.displayQueue(); 
		System.out.println(strStack.pop());
		System.out.println(strStack.peek());
		System.out.println(strStack.peek());
		strStack.displayQueue();
	}

}
