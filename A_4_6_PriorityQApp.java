import java.io.IOException;

import javax.imageio.IIOException;

class PriorityQ {
	private int queueArr[];
	private int front;
	private int size;

	public PriorityQ(int n) {
		queueArr = new int[n];
		size = n;
		front = 0;
	}

	public void insert(int j) {
		if (isFull())
			new IOException("queue is full");
		int i = 0;
		for (; i < front; i++)
			if (j > queueArr[i])
				break;
		for(int y=front;y>i;y--)
			queueArr[y]=queueArr[y-1];
		queueArr[i] = j;
		front++;
	}

	public long remove() {
		if (isEmpty())
			new IOException("queue is empty");

		return queueArr[--front];
	}

	public boolean isEmpty() {
		return front == 0;
	}

	public boolean isFull() {
		return front == size ;
	}

}

public class A_4_6_PriorityQApp {
	public static void main(String[] args) throws IOException {
		PriorityQ thePQ = new PriorityQ(5);
		thePQ.insert(30);
		thePQ.insert(50);
		thePQ.insert(10);
		thePQ.insert(40);
		thePQ.insert(20);
		while (!thePQ.isEmpty()) {
			long item = thePQ.remove();
			System.out.print(item + " "); // 10, 20, 30, 40, 50
		}

		System.out.println("");
	}
}