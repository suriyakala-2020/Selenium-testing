package may19;



import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RetrieveValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] input= {1,2,3,4,5,6,7,8,9};
Set<Integer> set = new LinkedHashSet<Integer>();
for (int j = 0; j < input.length; j++) {
	set.add(input[j]);	
}
List<Integer> l = new ArrayList<Integer>(set);
System.out.println(l.get(6));

	}

}
