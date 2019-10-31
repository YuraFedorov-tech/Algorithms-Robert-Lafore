class Link<T> {
	Link next;
	T item;

	public Link(T ins) {
	item=ins;
	}

	public void display() {
		System.out.print(item + " ");
	}

	public boolean less(Link pret) {
		T a2=(T) this.item;
		T a3=(T) pret.item;
		int q =((Comparable<T>) a2).compareTo(a3);
		return q<0;
	}
}

class SortedList<T> {
	Link first;
	Link last;

	public void insert(T ins) {
		Link pret = new Link(ins);
		Link previos = null;
		Link cur = first;
		while (cur != null && isMore(cur, pret)) {
			previos = cur;
			cur = cur.next;
		}
		if (previos == null) {
			first = pret;
		} else
			previos.next = pret; // старое значение prev --> newLink
		pret.next = cur;
	}

	private boolean isMore(Link cur, Link pret) {	
		return cur.less(pret); 
	}

	public void display() {
		Link cur = first;
		while (cur != null) {
			cur.display();
			cur = cur.next;
		}
		System.out.println();
	}

	public T pop() {
		T temp = (T) first.item;
		first = first.next;
		return temp;
	}

	public T peek() {
		return (T) first.item;
	}
}

public class A_5_6_SortedListApp {

	public static void main(String[] args) {
		SortedList<Integer> list = new SortedList<>();
		for (int i = 0; i < 100; i++) {
			int ins = (int) (Math.random() * 80);
			list.insert(ins);
		}
		list.display();
		System.out.println(list.peek());
		System.out.println(list.peek());
		for (int i = 0; i < 95; i++) {
			System.out.print(list.pop()+" ");
		}
		System.out.println();
		list.display();
		
		
		SortedList<String> listStr = new SortedList<>();
		for (int i = 0; i < 100; i++) {
			int ins = (int) (Math.random() * 28);
			listStr.insert(""+(char)('a'+ins));
		}
		listStr.display();
		System.out.println(listStr.peek());
		System.out.println(listStr.peek());
		for (int i = 0; i < 95; i++) {
			System.out.print(listStr.pop()+" ");
		}
		System.out.println();
		listStr.display();
	}

}
