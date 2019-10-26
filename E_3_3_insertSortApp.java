class ArrayIns {
	private int size;
	private int[] a;
	private int count;
	public ArrayIns(int n) {
		size = n;
		a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = (int) (Math.random() * n);
		count=1;
	}

	public ArrayIns(int n, String s) {
		size = n;
		a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = i;
	}

	public ArrayIns(int n, String string, int max2) {
		size = n;
		a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = n - i;
	}

	public void insert(int key) {
		a[size++] = key;

	}

	public void display() {
		for (int i = 0; i < size; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	private void swap(int in, int in2) {
		int q = a[in];
		a[in] = a[in2];
		a[in2] = q;

	}

	public void bubbleSort() {
		for (int out = size - 1; out >= 0; out--)
			for (int in = 0; in < out; in++)
				if (a[in + 1] < a[in])
					swap(in, in + 1);

	}

	public void selectionSort() {
		for (int i = 0; i < size; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (a[min] > a[j])
					min = j;
			}
			swap(min, i);
		}

	}

	public void insertionSort() {
		for (int i = 1; i < size; i++) {
			int min = a[i];
			while (i > 0 && min < a[i - 1]) {
				a[i] = a[i - 1];
				i--;
			}
			a[i] = min;
		}

	}



	public void noDups() {
	int aa[]=new int[a.length];
	int newSize=0;
	int cur=-1;
	for(int i=0;i<size;i++) {
		if(a[i]==cur)
			continue;
		aa[newSize++]=cur=a[i];
	}
		size=newSize;
		a=aa;
	}

	public void bubbleSort2() {
		int q=1;
		while(q!=0) {
			q=0;
			q+=bubbleSortEven(1);
			q+=bubbleSortEven(0);
			count++;
		}
		
	}

	private int bubbleSortEven(int even) {
		int q=0;
		for (int out = size - 1; out >= 0; out--) {
			if(out%2==even)
				continue;
			for (int in = 0; in < out; in++)
				if (a[in + 1] < a[in]) {
					swap(in, in + 1);
					q++;
				}
		}
		return q;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

}

public class E_3_3_insertSortApp {

	public static void main(String[] args) {
		int max = 100_00;
		ArrayIns arr = new ArrayIns(max);
		System.out.println("Random");
		arr = new ArrayIns(max);
		long start = System.currentTimeMillis();
		arr.bubbleSort();
		long end = System.currentTimeMillis();
		System.out.println((end - start));

		arr = new ArrayIns(max);
		start = System.currentTimeMillis();
		arr.selectionSort();
		end = System.currentTimeMillis();
		System.out.println((end - start));

		arr = new ArrayIns(max);
		start = System.currentTimeMillis();
		arr.insertionSort();
		end = System.currentTimeMillis();
		System.out.println((end - start));

///////////////////////////////////////
		System.out.println("From Zero 1,2,3,4...max");
		arr = new ArrayIns(max, "From Zero 1,2,3,4...max");
		start = System.currentTimeMillis();
		arr.bubbleSort();
		end = System.currentTimeMillis();
		System.out.println((end - start));

		arr = new ArrayIns(max, "From Zero 1,2,3,4...max");
		start = System.currentTimeMillis();
		arr.selectionSort();
		end = System.currentTimeMillis();
		System.out.println((end - start));

		arr = new ArrayIns(max, "From Zero 1,2,3,4...max");
		start = System.currentTimeMillis();
		arr.insertionSort();
		end = System.currentTimeMillis();
		System.out.println((end - start));

///////////////////////////////////////
		System.out.println("From max, max-1,max-2....0");
		arr = new ArrayIns(max, "From Zero 1,2,3,4...max", max);
		start = System.currentTimeMillis();
		arr.bubbleSort();
		end = System.currentTimeMillis();
		System.out.println((end - start));

		arr = new ArrayIns(max, "From Zero 1,2,3,4...max", max);
		start = System.currentTimeMillis();
		arr.selectionSort();
		end = System.currentTimeMillis();
		System.out.println((end - start));

		arr = new ArrayIns(max, "From Zero 1,2,3,4...max", max);
		start = System.currentTimeMillis();
		arr.insertionSort();
		end = System.currentTimeMillis();
		System.out.println((end - start));
		
	////////////////////////////////	
		max=500;
		arr = new ArrayIns(max);
		arr.display();
		arr.insertionSort();
		arr.display();
		arr.noDups();
		arr.display();
		
		
		////////////////////////////////	
		max=500;
		arr = new ArrayIns(max);
		arr.display();
		arr.bubbleSort2();
		arr.display();
		arr.noDups();
		arr.display();
		System.out.println(arr.getCount());
		
	}

}
