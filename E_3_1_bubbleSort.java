class ArrayBub {
private int size;
private int []a;
	public ArrayBub(int n) {
		size=n;
		a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=(int) (Math.random()*n);
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
public class E_3_1_bubbleSort {

	public static void main(String[] args) {
		ArrayBub	arr = new ArrayBub(10_00); 
		arr.display(); 
		arr.bubbleSort(); 
		arr.display(); 
	}

}
