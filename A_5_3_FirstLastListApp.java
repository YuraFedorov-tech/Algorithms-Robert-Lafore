class Link<T> {
	Link next;
	T item;

	public Link(T j) {
		item = j;
	}
	public void display() {
		System.out.print(item + " ");
	}
}

class FirstLastList<T> {
	Link first;
	Link last;

	public FirstLastList() {
		first = null;
		last = null;
	}

	public void insertFirst(T key) {
		Link newLink = new Link(key);
		if (isEmpty()) {
			last = newLink;
		}
		newLink.next = first;
		first = newLink;
	}

	public void insertLast(T key) {
		Link newLink = new Link(key); 
		if( isEmpty() ) 
		first = newLink;
		else
		last.next = newLink;
		last = newLink; 
	}
	private boolean isEmpty() {
		return first == null;
	}

	public void display() {
		Link cur = first;
		while (cur!= null) {	
			cur.display();
			cur = cur.next;		
		}
		System.out.println();
	}

	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}

	public Link deleteLast() {
		Link cur = first;
		while (cur.next != last)
			cur = cur.next;
		last = cur;
		last.next = null;
		return cur;
	}
}

public class A_5_3_FirstLastListApp {

	public static void main(String[] args) {
		FirstLastList<Integer> list = new FirstLastList<>();
		for (int i = 10; i < 15; i++)
			list.insertLast(i);
		list.display();
		for (int i = 0; i < 5; i++)
			list.insertFirst(i);
		list.display();
		list.deleteFirst();
		list.display();
		list.deleteLast();
		list.display();
		
		
		FirstLastList<String> listStr = new FirstLastList<>();
		for (int i = 10; i < 15; i++)
			listStr.insertLast(""+i+'0');
		listStr.display();
		for (int i = 0; i < 5; i++)
			listStr.insertFirst(""+i+'0');
		listStr.display();
		listStr.deleteFirst();
		listStr.display();
		listStr.deleteLast();
		listStr.display();
	}

}
