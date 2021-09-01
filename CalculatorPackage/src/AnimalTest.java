import java.util.Arrays;



interface IWalkable {
	void walk();
}

interface ICanSwim {
	void swim();
}

 abstract class Animal implements Comparable {
	
	
	private String name;
	private int age;

	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public abstract void speak();


	
	public int compareTo(Object obj) {
		Animal a = (Animal) obj;
		if (age < a.age)
			return -1;
		else if (age > a.age)
			return 1;
		else
			return 0;
	
	}

	

//	public abstract void speak();
//
//	public void walk() {
//		System.out.println("");
//	}
//	public abstract void walk();
//
//	public abstract void swim();
}

 class Person extends Animal implements IWalkable, ICanSwim {
	public Person(String name, int age) {
		super(name, age);
	}

	
	public void speak() {
		System.out.println("나는 사람(" + super.getName() + ")이고 말을 할 수 있다");
	}

	public void walk() {
		System.out.println("나는 사람(" + super.getName() + ")이고 두발로 걸을 수 있다");
	}

	public void swim() {
		System.out.println("나는 사람(" + super.getName() + ")이고 수영할 수 있다");
	}

	public String toString() {
		return "Person: "+getName()+" "+getAge()+"살"; 
	}



}

 class Fish extends Animal implements ICanSwim{
	public Fish(String name, int age) {
		super(name, age);
	}

	public void speak() {
		System.out.println("나는 물고기(" + super.getName() + ")이고 뻐끔뻐끔 말을 할 수 있다");
	}



	public void swim() {
		System.out.println("나는 물고기(" + super.getName() + ")이고 수영할 수 있다");
	}


	
	public String toString() {
		return "Fish: "+getName()+" "+getAge()+"살"; 
	}


	
}


public class AnimalTest {
	public interface Comparable {
		int comparableTo(Object obj);
	}
	public static void main(String[] args) {
		Animal[] animals = { new Person("홍길동", 12), new Fish("금붕어", 1), new Person("김철수", 4), };
		
		for (Animal animal : animals) {
			System.out.println("[" + animal + "]");
			
			System.out.print("Speak: ");
			animal.speak();
			
			System.out.print("Walk: ");
			if (animal instanceof IWalkable) 
				((IWalkable) animal).walk();
			else
				System.out.println("cannot");
			
			System.out.print("Swim: ");
			if (animal instanceof ICanSwim)
				((ICanSwim) animal).swim();
			else
				System.out.println("cannot");
			
			System.out.println("End of Iteration" + "\n");
		}
		
		Arrays.sort(animals);
		System.out.println("After sorting the array animals in ascending order by age");
		for (Animal animal : animals) 
			System.out.println("[" + animal + "]");
	}

}
