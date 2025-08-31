public class DogProblem {

	private static final int SCOPE = 2;

	private static boolean isValidIndex(Dog[] dogs, int i) {
		return i > 0 && i < dogs.length;
	}

	private static boolean isBiggestInCurrentScope(Dog[] dogs, int current_index) {
		boolean state = true;

		for (int i = current_index - SCOPE; i < current_index + SCOPE + 1; i += 1) {
			if (!isValidIndex(dogs, i) || i == current_index)
				continue;

			if (Dog.bigger(dogs[i], dogs[current_index])) {
				state = false;
				break;
			}
		}

		return state;
	}

	public static Dog[] largerThanFourNeighbors(Dog[] dogs) throws IllegalArgumentException {
		//	parameter checks.
		if (dogs == null)
			throw new IllegalArgumentException("parameter \"dogs\" can't be null.");

		//	temporary store the result.
		int count = 0;
		Dog[] store_array = new Dog[dogs.length];

		//	check element one by one.
		for (int i = 0; i < dogs.length; i += 1) {
			if (isBiggestInCurrentScope(dogs, i)) {
				store_array[count] = dogs[i];
				count += 1;
			}
		}

		//	according the count make a new array to store result.
		Dog[] result_array = new Dog[count];
		for (int i = 0; i < count; i += 1) {
			result_array[i] = store_array[i];
		}

		return result_array;
	}

	public static void main(String[] args) {
		Dog[] dogs = new Dog[10];
		dogs[0] = new Dog(10);
		dogs[1] = new Dog(15);
		dogs[2] = new Dog(20);
		dogs[3] = new Dog(15);
		dogs[4] = new Dog(10);
		dogs[5] = new Dog(5);
		dogs[6] = new Dog(10);
		dogs[7] = new Dog(15);
		dogs[8] = new Dog(22);
		dogs[9] = new Dog(20);

		Dog[] res = largerThanFourNeighbors(dogs);
		for (Dog dog : res)
			dog.print();
	}
}