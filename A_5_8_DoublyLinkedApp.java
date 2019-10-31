
class Link<T> {
	Link next;
	Link previos;
	T item;

	public Link(T item) {
		this.item = item;
	}

}

class TList<T> {
	Link first;
	Link last;

	public void insertFirst(T item) {
		Link newLink = new Link(item);
		if (isEmpty())
			last = newLink;
		else {
			newLink.next = first;
			first.previos = newLink;
		}
		first = newLink;
	}

	private boolean isEmpty() {
		return first == null;
	}

	public void displayFirst() {
		Link cur = first;
		while (cur != null) {
			System.out.print(cur.item);
			cur = cur.next;
		}
		System.out.println();
	}

	public void displayLast() {
		Link cur = last;
		while (cur != null) {
			System.out.print(cur.item);
			cur = cur.previos;
		}
		System.out.println();

	}

	public void insertLast(T item) {
		Link newLink = new Link(item);
		if (isEmpty())
			first = newLink;
		else {
			last.next = newLink;
			newLink.previos = last;
		}
		last = newLink;

	}

	public T removeFirst() {
		T temp = (T) first.item;
		first = first.next;
		first.previos = null;
		return temp;
	}

	public T removeLast() {
		T temp = (T) last.item;
		last = last.previos;
		last.next = null;
		return temp;
	}

	public T peekFirst() {
		return (T) first.item;
	}

	public T peekLast() {
		return (T) last.item;
	}

	public void deleteKey(T key) {
	Link cur=first;
	while(!key.equals(cur.item)) {
		if(cur==null)
			return;
		cur=cur.next;		
	}
		if(cur.equals(first)) {
			removeFirst();
			return;
		}
		if(cur.equals(last)) {
			removeLast();
			return;
		}
		cur.previos.next=cur.next;
		cur.next.previos=cur.previos;
	}

}

public class A_5_8_DoublyLinkedApp {

	public static void main(String[] args) {
		TList<Integer> list = new TList<>();
		for (int i = 0; i < 5; i++)
			list.insertFirst(i);
		list.displayFirst();
		list.displayLast();

		for (int i = 5; i > 1; i--)
			list.insertLast(i);
		list.displayFirst();
		System.out.println(list.removeFirst());
		System.out.println(list.removeLast());
		System.out.println(list.peekFirst());
		System.out.println(list.peekLast());
		list.displayFirst();
		list.deleteKey(1);
		list.displayFirst();
		list.deleteKey(3);
		list.deleteKey(3);
		list.displayFirst();
		
	}

}
