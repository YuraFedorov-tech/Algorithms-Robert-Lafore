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

	public int getMax() {
		if (size == 0)
			return -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++)
			if (a[i] > max)
				max = a[i];
		return max;
	}

	public int removeMax() {
		if (size == 0)
			return -1;
		int i = 1;
		int max = 0;
		for (; i < size; i++)
			if (a[i] > a[max])
				max = i;
		int ans = a[max];
		for (int j = max; j < size; j++)
			a[j] = a[j + 1];
		size--;
		return ans;

	}

}

public class A2_3HighArrayApp {

	public static void main(String[] args) {
		higyArray arr = new higyArray(100);
		System.out.println(arr.getMax() == -1 ? "Max absent" : arr.getMax());
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
		System.out.println(arr.getMax() == -1 ? "Max absent" : arr.getMax());
		System.out.println(arr.getMax() == -1 ? "Max absent" : arr.removeMax());
		arr.display();

	}

}
