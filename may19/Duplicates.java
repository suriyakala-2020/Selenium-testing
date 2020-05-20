package may19;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Duplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	char[] input = {'A','B','C','D','A','D','E','F'};
	ArrayList<Character> lis = new ArrayList<Character>();
	for (int i = 0; i < input.length; i++) {
	lis.add(input[i]);
		}
	System.out.println(lis);
	Set<Character> set = new LinkedHashSet<Character>();
	for (Character j : lis) {
		if (!set.add(j)) {
			System.out.println("Duplicate:"+j);
		}
	}
		
	}

}
