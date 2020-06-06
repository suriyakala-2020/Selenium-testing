package may26;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArray_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] array = {5,1,11,22,33,45,79};
Arrays.sort(array);
System.out.print("Sorted Array: ");
for (int i : array) {
	System.out.print(i+ " ");
}
Collections.reverse(Arrays.asList(array));
System.out.print("\nReverse Sorted Array: ");
for (int i : array) {
	System.out.print(i+ " ");
}
	}

}
