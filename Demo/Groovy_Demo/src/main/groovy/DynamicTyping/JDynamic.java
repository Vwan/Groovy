package DynamicTyping;

public class JDynamic {
	public static void main(String[] args){
		AnimalTestJ at = new AnimalTestJ();
		at.walkTest(new Cat());
		at.walkTest(new Dog());
	}
}
