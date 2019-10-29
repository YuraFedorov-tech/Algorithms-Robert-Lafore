class Link<T> {
	Link next;
	T item1;
	T item2;

	public Link(T i, T j) {
		item1 = i;
		item2 = j;
	}

	public Link() {
	}

	public void display() {
		System.out.print(item1 + " " + item2 + " <> ");

	}

}

class LinkList<T> {
	Link first;

	public LinkList() {
		first = new Link();
	}

	public void insertFirst(T i, T j) {
		Link cur = new Link(i, j);
		cur.next = first;
		first = cur;
	}

	public Link removeFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}

	public void display() {
		Link cur = first;
		while (cur.next != null) {
			cur.display();
			cur = cur.next;
		}
		System.out.println();
	}

	public boolean isEmpty() {
		return first.next == null;
	}

	public Link deleteKey(T key) {
		Link prev;
		Link cur;
		prev = cur = first;
		while (!cur.item1.equals(key) ) {
			if (cur.next == null)
				return null;
			prev = cur;
			cur = cur.next;
		}
		Link an = cur;
		if (cur.equals(first)) {
			first = first.next;
		} else
			prev.next = cur.next;
		return an;
	}

	public Link findKey(T key) {
		Link cur = first;
		while (cur.next != null) {
			if (key.equals(cur.item1))
				return cur;
			cur = cur.next;
		}
		return null;
	}
}

public class A_5_2_LinkList2App {

	public static void main(String[] args) {
		LinkList<Integer> myList = new LinkList<>();
		for (int i = 0; i < 10; i++)
			myList.insertFirst(i, i);
		Link a = myList.removeFirst();
		a.display();
		System.out.println();
		myList.display();
		while (!myList.isEmpty()) {
			a = myList.removeFirst();
			a.display();
		}
		System.out.println();
		for (int i = 10; i < 20; i++)
			myList.insertFirst(i, i + 2);
		myList.display();
		a = myList.deleteKey(15);
		myList.display();
		if (a == null)
			System.out.println("key absent");
		else
			System.out.println("for key= " + 15 + "mean=" + a.item2);
		a = myList.findKey(19);
		if (a == null)
			System.out.println("key absent");
		else
			System.out.println("for key= " + 19 + "mean=" + a.item2);

		LinkList<String> myListSTR = new LinkList<>();
		for (int i = 0; i < 10; i++)
			myListSTR.insertFirst(Integer.toString(i), Integer.toString(i));
		a = myListSTR.removeFirst();
		a.display();
		System.out.println();
		myListSTR.display();
		while (!myListSTR.isEmpty()) {
			a = myListSTR.removeFirst();
			a.display();
		}
		System.out.println();
		for (int i = 10; i < 20; i++)
			myListSTR.insertFirst(Integer.toString(i), Integer.toString(i+11));
		myListSTR.display();
		a = myListSTR.deleteKey("15");
		myListSTR.display();
		if (a == null)
			System.out.println("key absent");
		else
			System.out.println("for key= " + 15 + "mean=" + a.item2);
		a = myListSTR.findKey("19");
		if (a == null)
			System.out.println("key absent");
		else
			System.out.println("for key= " + 19 + "mean=" + a.item2);
	}

}
