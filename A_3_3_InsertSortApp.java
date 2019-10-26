class ArrayIns {
private int size;
private int []a;
	public ArrayIns(int n) {
		size=0;
		a=new int[n];
	}
	public void insert(int key) {
		a[size++]=key;
		
	}
	public void display() {
		for(int i=0;i<size;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	public void bubbleSort() {
		for(int out=size-1;out>=0;out--) 
			for(int in=0;in<out;in++) 
				if(a[in+1]<a[in])
					swap(in,in+1);
			
		
	}
	private void swap(int in, int in2) {
		int q=a[in];
		a[in]=a[in2];
		a[in2]=q;
		
	}
	public void selectionSort() {
		for(int i=0;i<size;i++) {
			int min=i;
			for(int j=i+1;j<size;j++) {
				if(a[min]>a[j])
					min=j;
			}
		swap(min,i);
		}
		
	}
	public void insertionSort() {
	for(int i=1;i<size;i++) {
		int min=a[i];
		while(i>0&&min<a[i-1]) {
			a[i]=a[i-1];
			i--;
		}
		a[i]=min;
	}
		
	}
	
	
}
public class InsertSortApp {

	public static void main(String[] args) {
		ArrayIns	arr = new ArrayIns(200); 
		arr.insert(77); 
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
	//	arr.bubbleSort();
	//	arr.selectionSort(); 
		arr.insertionSort();
		arr.display(); 
	}

}
