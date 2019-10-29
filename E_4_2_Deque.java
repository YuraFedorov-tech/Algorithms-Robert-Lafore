import java.io.IOException;

class Deque<T> {
	private T[] dequeArr;
	private int front;
	private int rear;
	private int nItem;

	public Deque(int len) {
		dequeArr = (T[]) new Object[len];
		front = -1;
		nItem = 0;
		rear = 0;
	}

	public void insertLeft(T j) throws IOException {
		if (isFull())
			throw	 new IOException("queue is full");
		if (front == -1)
			front = size() - 1;
		dequeArr[front--] = j;
		nItem++;
	}

	public void insertRight(T j) throws IOException {
		if (isFull())
			throw	 new IOException("queue is full");
		if (rear == size())
			rear = 0;
		dequeArr[rear++] = j;
		nItem++;
	}

	private int size() {
		return dequeArr.length;
	}

	public void diplay() {
		int min = front;
		int max = rear;
		if (isTurn() | (!isTurn() && nItem == size()))
			max += size();
		print(min, max);

	}

	private void print(int min, int max) {
		for (int i = min + 1; i < max; i++) {
			int j = i;
			if (i >= size())
				j -= size();
			System.out.print(dequeArr[j] + " ");
		}
		System.out.println();
	}

	private boolean isTurn() {
		return front >= rear;
	}

	public T removeLeft() throws IOException {
		if (isEmpty())
			throw	 new IOException ("queue is empty");
		T ans = dequeArr[++front];
		if (front == size() - 1)
			front = -1;
		nItem--;
		return ans;
	}

	public T removeRight() throws IOException {
		if (isEmpty())
			throw	 new IOException ("queue is empty");
		T ans = dequeArr[--rear];
		if (rear == 0)
			rear = size();
		nItem--;
		return ans;
	}

	public boolean isEmpty() {
		return nItem == 0;
	}

	public boolean isFull() {
		return nItem == size();
	}
}

public class E_4_2_Deque {

	public static void main(String[] args) throws IOException {
		Deque<Integer> theQueue = new Deque(5);
	//	theQueue.removeLeft();    -queue is empty
		theQueue.insertLeft(10);
		theQueue.diplay();
		theQueue.insertLeft(20);
		theQueue.diplay();
		theQueue.insertRight(30);
		theQueue.diplay();
		theQueue.insertRight(40);
		theQueue.diplay();
		theQueue.insertRight(40);	
	//	theQueue.insertRight(40);  -queue is full
		theQueue.removeLeft();
		theQueue.removeLeft();
		theQueue.removeRight();
		theQueue.removeRight();
		theQueue.insertRight(50);
		theQueue.diplay();
		theQueue.insertRight(60);
		theQueue.diplay();
		theQueue.insertLeft(70);
		theQueue.diplay();
		theQueue.insertLeft(80);
		theQueue.diplay();
		while (!theQueue.isEmpty()) {
			System.out.print(theQueue.removeRight());
			System.out.print(" ");
		}
		System.out.println();
// for chek different variants
		for (int i = 0; i < 10000; i++) {
			theQueue.insertRight(i);			
			System.out.println(theQueue.removeLeft());

		}

	}

}
