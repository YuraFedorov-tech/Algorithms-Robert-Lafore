
class Link<T> {
	Link next;
	T item;

	public Link(T j) {
		item = j;
		}
	public Link() {
	}

	public void display() {
		System.out.print(item);
	}
}
class LinkList<T> {
	Link first;
	public LinkList() {
		first=new Link();
	}
	public void insertFirst(T j) {
		Link nextNext = new Link(j);
		nextNext.next = first;
		first = nextNext;
	}
	public boolean isEmpty() {
		return first.next == null;
	}

	public Link removeFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}

	public void display() {
		Link cur=first;
		while(cur.next!=null) {
			System.out.print(cur.item+" ");
			cur=cur.next;
		}
		System.out.println();
	}

}

public class A_5_1_LinkListApp {

	public static void main(String[] args) {
		LinkList<Integer> myList = new LinkList<>();
		for (int i = 1; i < 10; i++)
			myList.insertFirst(i);
		myList.display();
		while (!myList.isEmpty()) {
			Link a = myList.removeFirst();
			a.display();
		}
		System.out.println();
		
		LinkList<String> myListStr = new LinkList<>();
		for (int i = 1; i < 10; i++)
			myListStr.insertFirst(Integer.toString(i)+Integer.toString(i));
		myListStr.display();
		while (!myListStr.isEmpty()) {
			Link a = myListStr.removeFirst();
			a.display();
		}
		System.out.println();
	}

}
