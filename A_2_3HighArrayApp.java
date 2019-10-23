class higyArray {
	private int a[];
	private int size;

	public higyArray(int maxSize) {
		a = new int[maxSize];
		size = 0;
	}

	public void insert(int n) {
		a[size++] = n;
	}

	public void display() {
		for (int i = 0; i < size; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public void delete(int key) {
		if (delete2(key))
			System.out.println(key + " - deleted");
		else
			System.out.println(key + " - absent");

	}

	private boolean delete2(int key) {
		int i;
		for (i = 0; i < size; i++)
			if (key == a[i])
				break;
		if (i == size)
			return false;
		for (; i < size; i++)
			a[i] = a[i + 1];
		size--;
		return true;

	}

	public void find(int key) {
		if (find2(key))
			System.out.println(key + " - have");
		else
			System.out.println(key + " - absent");

	}

	private boolean find2(int key) {
		int i;
		for (i = 0; i < size; i++)
			if (key == a[i])
				break;
		if (i == size)
			return false;
		return true;
	}

}

public class A2_3HighArrayApp {

	public static void main(String[] args) {
		higyArray arr = new higyArray(100);

		arr.insert(77); // Вставка 10 элементов
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		arr.display();

		arr.find(35);
		arr.find(11);
		arr.delete(22);
		arr.delete(77);
		arr.delete(99);

		arr.display();

	}

}
