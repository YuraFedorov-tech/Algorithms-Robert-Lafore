class Link<T> {
	T item;
	Link next;

	public Link(T ins) {
		item = ins;
	}

	public void display() {
		System.out.print(item + " ");

	}

	public boolean less(Link cur) {
		int q = ((Comparable<T>) this.item).compareTo((T) cur.item);
		return q > 0;
	}

}

class SortedList<T> {
	Link<Integer>[] linkArr;
	Link first;

	public SortedList(Link<Integer>[] linkArr) {
		this.linkArr = linkArr;
	}

	public void sort() {
		for (int i = 0; i < linkArr.length; i++)
			insert(linkArr[i]);

	}

	private void insert(Link<Integer> pret) {
		Link prev = null;
		Link cur = first;
		while (cur != null && pret.less(cur)) {
			prev = cur;
			cur = cur.next;
		}
		if (prev == null)
			first = pret;
		else
			prev.next = pret;
		pret.next = cur;

	}

	public void sartArr() {
		Link cur=first;
		for(int i=0;i<linkArr.length;i++) {
			linkArr[i]=cur;			
			cur=cur.next;
		}
	
		
	}

}

public class A_5_7_ListInsertionSortApp {

	public static void main(String[] args) {

		int size = 100;
		Link<Integer>[] linkArr = new Link[size];
		for (int i = 0; i < size; i++) {
			// int ins = (int) (Math.random() * size);
			// Link k = new Link(ins);
			linkArr[i] = new Link((int) (Math.random() * size));
		}
		for (int i = 0; i < size; i++)
			linkArr[i].display();
		System.out.println();
		SortedList<Integer> theSortedList = new SortedList(linkArr);
		theSortedList.sort();
		theSortedList.sartArr();
		for (int i = 0; i < size; i++)
			linkArr[i].display();
		System.out.println();
		
		Link<String>[] linkArrStr = new Link[size];
		for (int i = 0; i < size; i++) {
			 Link k = new Link(""+(char) ('a'+(int) (Math.random() * 26)));
			linkArrStr[i] = k;
		}
		for (int i = 0; i < size; i++)
			linkArrStr[i].display();
		System.out.println();
		SortedList<String> theSortedListStr = new SortedList(linkArrStr);
		theSortedListStr.sort();
		theSortedListStr.sartArr();
		for (int i = 0; i < size; i++)
			linkArrStr[i].display();
		System.out.println();
	}

}
