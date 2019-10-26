class ArrayBub {
private int size;
private int []a;
	public ArrayBub(int n) {
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
					swap(in);
			
		
	}
	private void swap(int in) {
		int q=a[in];
		a[in]=a[in+1];
		a[in+1]=q;
		
	}
	
	
}
public class BubbleSortApp {

	public static void main(String[] args) {
		ArrayBub	arr = new ArrayBub(200); 
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
		arr.bubbleSort(); 
		arr.display(); 
	}

}
