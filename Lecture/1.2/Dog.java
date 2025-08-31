public class Dog {
	private int weightInPound;

	/*  default consturctor  */
	public Dog() {
		System.out.println("call default constructor!");
	}

	/*  constructor by weight  */
	public Dog(int w) {
		System.out.println("call integer constructor!");
		weightInPound = w;
	}

	public void makeNoise() {
		String voice;

		if (weightInPound < 10)
			voice = "Yep!";
		else if (weightInPound < 30)
			voice = "Bark!";
		else 
			voice = "Wooooof!";

		System.out.println(voice);
	}

	public void print() {
		System.out.println(weightInPound);
	}

	//	static here
	public static String binomen = "Calis familiaris";
	public static Dog maxDog(Dog d1, Dog d2) {
		Dog bigger;

		if (d1.weightInPound > d2.weightInPound)
			bigger = d1;
		else 
			bigger = d2;

		return bigger;
	}

	public static boolean bigger(Dog d1, Dog d2) {
		return d1.weightInPound > d2.weightInPound;
	}
}