
class Person {
	private String lastName;
	private String firstName;
	private int age;

	public Person(String lastName2, String firstName2, int age2) {
		lastName=lastName2;
		firstName=firstName2;
		age=age2;
	}

	void displayPerson() {
		System.out.println(lastName + " " + firstName + " " + age);
	}

	String getLastName() {
		return lastName;
	}
}

class ClassDataArray {
	private Person[] a;
	private int size;

	public ClassDataArray(int maxSize) {
		a = new Person[maxSize];
		size = 0;
	}

	void display() {
		for (int i = 0; i < size; i++)
			a[i].displayPerson();
	}

	public void insert(String lastName, String firstName, int age) {
		a[size++]=new Person(lastName,firstName,age);		
	}

	public Person find(String searchKey) {
		for(int i=0;i<size;i++)
			if(a[i].getLastName().equals(searchKey))
				return a[i];
		return null;
	}

	public void delete(String searchKey) {
		int i;
		for( i=0;i<size;i++)
			if(a[i].getLastName().equals(searchKey))
				break;
		for(;i<size;i++)
			a[i]=a[i+1];
		size--;
	}

	
	
}

public class A_2_5_ClassDataApp {

	public static void main(String[] args) {
		ClassDataArray arr = new ClassDataArray(100);
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
		
		arr.display();
		
		String searchKey = "Stimson"; // Поиск элемента
		Person found;
		found=arr.find(searchKey);
		if (found != null)
		{
		System.out.println("Found ");
		found.displayPerson();
		}
		else
		System.out.println("Can't find " + searchKey);
		
		System.out.println("Deleting Smith, Yee, and Creswell");
		arr.delete("Smith"); // Удаление трех элементов
		arr.delete("Yee");
		arr.delete("Creswell");
		arr.display(); // Повторный вывод содержимого
		
	}

}
