import java.util.ArrayList;

class ordArray {
	private int a[];
	private int size;

	public ordArray(int maxSize) {
		a = new int[maxSize];
		size = 0;
	}

	private int getSize() {
		return size;
	}

	public void insert(int n) {
		int i;
		for (i = 0; i < size; i++)
			if (a[i] > n)
				break;
		int j = i;
		for (i = size; i > j; i--)
			a[i] = a[i - 1];
		a[j] = n;
		size++;
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

		int i = find(key);
		if (i == size)
			return false;
		for (; i < size; i++)
			a[i] = a[i + 1];
		size--;
		return true;

	}

	private int find(int key) {
		int i;
		int le = 0;
		int re = size - 1;
		while (le <= re) {
			int mid = le + (re - le) / 2;
			if (a[mid] == key)
				return mid;
			if (a[mid] > key)
				re = mid - 1;
			else
				le = mid + 1;
		}

		return size;
	}

	public void fillRandom() {
		int newSize=(int) (Math.random()*100);
		for(int i=0;i<newSize;i++)
			insert((int) (Math.random()*15));
	}

	public void merg(ordArray arr2) {
		int newSize=size+arr2.size;
		int []aNew=new int[200];
		int th=0;
		int ar2=0;
		for(int i=0;i<newSize;i++) {
			if(th==size) aNew[i]=arr2.a[ar2++];
			else if(ar2==arr2.size)aNew[i]=a[th++];
			else if(a[th]>arr2.a[ar2]) aNew[i]=arr2.a[ar2++];
			else aNew[i]=a[th++];
		}
		a=aNew;
		size=newSize;
	}

	public void NoDubs() {
		ArrayList<Integer> list=new ArrayList<Integer> ();
		FindDubs(list);
		DeleteDubs(list);
	}

	private void DeleteDubs(ArrayList<Integer> list) {
		for(int i=list.size()-1;i>=0;i--) {
			int j=list.get(i);
			for(;j<size;j++)
				a[j]=a[j+1];
			size--;
		}
		
	}

	private void FindDubs(ArrayList<Integer> list) {		
		for(int i=1;i<size;i++) {
			if(a[i]==a[i-1])
				list.add(i);
		}
		
	}

}

public class A_2_4_OrderedApp {

	public static void main(String[] args) {
		ordArray arr = new ordArray(100);

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

		arr.delete(35);
		arr.delete(22);
		arr.delete(77);
		arr.delete(99);

		arr.display();

		ordArray arr2 = new ordArray(100);
		arr2.fillRandom();
		arr2.display();
		arr.merg(arr2);
		arr.display();
		arr.NoDubs();
		arr.display();
	}

}
