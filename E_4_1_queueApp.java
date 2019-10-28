
class Queue<T> {
	private T[] queueArr;
	private int rear;
	private int front;
	private int nItem;

	public Queue(int len) {
		queueArr = (T[]) new Object[len];
		rear = -1;
		front = 0;
		nItem = 0;
	}

	public void insert(T j) {
		if (rear == size() - 1)
			rear = -1;
		queueArr[++rear] = j;
		nItem++;
	}

	private int size() {
		return queueArr.length;
	}

	public T remove() {
		T ans = queueArr[front++];
		if (front == size())
			front = 0;
		nItem--;
		return ans;

	}
	public T peek() {		
		return queueArr[front];
	}
	public boolean isEmpty() {
		return nItem==0;
	}

	public void diplay() {
		for(int i=front;i<size();i++) {			
			System.out.print(queueArr[i]+" ");
			if(i==rear)
				break;
		}
		if(rear<front)
			for(int i=0;i<=rear;i++) {	
				System.out.print(queueArr[i]+" ");
			}
		System.out.println();
	}

}

public class E_4_1_queueApp {

	public static void main(String[] args) {
		Queue<Integer> theQueue = new Queue(5); // Очередь из 5 ячеек
		theQueue.insert(10); // Вставка 4 элементов
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);
		theQueue.diplay();
		theQueue.remove(); // Извлечение 3 элементов
		theQueue.remove(); // (10, 20, 30)
		theQueue.remove();
		theQueue.insert(50); // Вставка еще 4 элементов
		theQueue.insert(60); // (с циклическим переносом)
		theQueue.insert(70);
		theQueue.insert(80);
		while (!theQueue.isEmpty()) // Извлечение и вывод
		{ // всех элементов

			System.out.print(theQueue.remove());// (40, 50, 60, 70, 80)
			System.out.print(" ");
		}
		theQueue.diplay();
		System.out.println("");
		
		Queue<String> theQueue2 = new Queue(5); // Очередь из 5 ячеек
		theQueue2.insert("q"); // Вставка 4 элементов
		theQueue2.insert("w");
		theQueue2.insert("e");
		theQueue2.insert("r");
		theQueue2.diplay();
		theQueue2.remove(); // Извлечение 3 элементов
		theQueue2.remove(); // (10, 20, 30)
		theQueue2.remove();
		theQueue2.insert("t"); // Вставка еще 4 элементов
		theQueue2.insert("y"); // (с циклическим переносом)
		theQueue2.insert("u");
		theQueue2.insert("i");
		while (!theQueue2.isEmpty()) // Извлечение и вывод
		{ // всех элементов

			System.out.print(theQueue2.remove());// (40, 50, 60, 70, 80)
			System.out.print(" ");
		}
		theQueue2.diplay();
		System.out.println("");

	}

}
