package may26;

public class CreateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/* Declaring array as literal*/
int[] a = new int[] {1,2,3,4};
//int[] a = {1,2,3,4};
for (int i : a) {
	System.out.print(i+ " ");
}
System.out.println("");

/* Declaring array as object */
int[] b = new int[4];
b[0]=1;
b[1]=2;
b[2]=3;
b[3]=4;
for (int i : b) {
	System.out.print(i+ " ");
}
	}

}
