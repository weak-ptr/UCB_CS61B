public class DrawTriangle {
	private int row;

	/*  constructor by Interger  */
	public DrawTriangle(int r) {
		row = r;
	}

	/*  draw triangle by row  */
	public void draw() {
		if (row > 0)
		{
			for(int temp = 1; temp != row + 1; temp = temp + 1)
			{
				int current_temp = temp;
				while (current_temp != 0)
				{
					System.out.print("*");
					current_temp = current_temp - 1;
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		DrawTriangle r4 = new DrawTriangle(4);
		r4.draw();

		DrawTriangle r10 = new DrawTriangle(10);
		r10.draw();
	}
}