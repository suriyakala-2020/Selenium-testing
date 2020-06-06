package may26;

import java.util.Arrays;

public class ReverseArray_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5,1,11,22,33,45,79};
		Arrays.sort(array);
		System.out.println("Sorted Array: ");
		for (int i : array) {
		System.out.print(i+" ");	
		}
		System.out.println("");
		System.out.println("Reverse Sorted Array: ");
		for (int j = array.length-1; j>=0; j--) {
			System.out.print(array[j]+" ");
		}
	}
	

}
