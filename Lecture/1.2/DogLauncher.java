public class DogLauncher {
	public static void main(String[] args) {
		Dog[] dogs = new Dog[2];
		dogs[0] = new Dog(6);
		dogs[1] = new Dog(34);
		dogs[1].makeNoise();
	}
}