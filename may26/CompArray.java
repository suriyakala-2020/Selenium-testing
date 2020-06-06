package may26;

public class CompArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = { 1, 2, 5, 5, 8, 9, 7, 10 };
		int[] array2 = { 1, 0, 6, 15, 6, 4, 7, 0 };
		System.out.println("Common Number between 2 arrays:");
		for (int i : array1) {
			for (int j : array2) {
				if(i==j) {
					System.out.print(i+" ");
				}
			}
		}
	}

}
