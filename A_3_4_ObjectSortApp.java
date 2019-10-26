class Person {
	private String lastName;
	private String firstName;
	private int age;

	public Person(String last, String first, int a) {
		lastName = last;
		firstName = first;
		age = a;
	}

	public void displayPerson() {
		System.out.println(lastName + " " + firstName + " " + age);

	}

	public String getLast() {
		return lastName;

	}
}

class ArrayInOb {
	private Person[] a;
	private int size;

	public ArrayInOb(int n) {
		size = 0;
		a = new Person[n];
	}

	public void insert(String last, String first, int ag) {
		a[size++] = new Person(last, first, ag);

	}

	public void display() {
		for (int i = 0; i < size; i++)
			a[i].displayPerson();
		System.out.println();

	}

	public void insertionSort() {
		for (int i = 1; i < size; i++) {
			Person min = a[i];
			while (i > 0 && (a[i-1].getLast().compareTo(min.getLast())>0)) {
				a[i] = a[i - 1];
				i--;
			}
			a[i] = min;
		}
	}
}

public class A_3_4_ObjectSortApp {

	public static void main(String[] args) {
		ArrayInOb arr = new ArrayInOb(100); // Создание массива
		arr.insert("Evans", "Patty", 24);
		arr.insert("Smith", "Lorraine", 37);
		arr.insert("Yee", "Tom", 43);
		arr.insert("Adams", "Henry", 63);
		arr.insert("Hashimoto", "Sato", 21);
		arr.insert("Stimson", "Henry", 29);
		arr.insert("Velasquez", "Jose", 72);
		arr.insert("Lamarque", "Henry", 54);
		arr.insert("Vang", "Minh", 22);
		arr.insert("Creswell", "Lucinda", 18);
		System.out.println("Before sorting:");
		arr.display(); // Вывод содержимого
		arr.insertionSort(); // Сортировка методом вставки
		System.out.println("After sorting:");
		arr.display();

	}

}
