package may26;

public class AvgNo_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] array= {20, 30, 25, 35, -16, 60, -100};
double m =0;
for (int i : array) {	
	m+=i;
	System.out.println(m);
}
double avg = m / array.length;
System.out.format("Average:%.3f", avg);
	}

}
