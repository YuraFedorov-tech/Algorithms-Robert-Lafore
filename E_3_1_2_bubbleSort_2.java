class ArrayBub {
private int size;
private int []a;
	public ArrayBub(int n) {
		size=n;
		a=new int[n];
		String []s="0 1 2 5 5 5 8 8 9 9".split("\\ ",-1);
		for(int i=0;i<n;i++)
		//	a[i]=Integer.parseInt(s[i]);
			a[i]=(int) (Math.random()*n);
		//	a[i]=n-i;
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
		for(int out=size-1;out>=0;out--) {
			for(int in=0;in<out;in++) 
				if(a[in+1]<a[in])
					swap(in,in+1);
			for(int i=out-1;i>0;i--) {			
				if(a[i]<a[i-1])
					swap(i,i-1);
			}
		}
	}
	private void swap(int in, int in2) {
		int q=a[in];
		a[in]=a[in2];
		a[in2]=q;
		
	}
	public int median() {
		int med=-1;
		for(int i=0;i<size;i++) {
			med=0;
			
			for(int j=0;j<size;j++) {
				if(i==j)
					continue;
				if(a[i]<=a[j])
					med++;
			}
			med--;
			if(med==size/2)
				return a[i];
		}
		return -1;
	}
	
	
}
public class E_3_1_2_bubbleSort_2 {

	public static void main(String[] args) {
		ArrayBub	arr = new ArrayBub(1_0); 		
		int mediana=arr.median();
		System.out.println(mediana);
		arr.display(); 
		arr.bubbleSort(); 
		arr.display(); 
	}

}
