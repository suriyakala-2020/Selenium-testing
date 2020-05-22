package may20;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class KeyValue_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
map.put('A', 1);
map.put('B', 2);
map.put('C', 3);
map.put('D', 4);
map.put('E', 5);
ArrayList<Character> lis1 = new ArrayList<Character>(map.keySet());
for (char c : lis1) {
	System.out.print(c);
}
System.out.println(" ");
ArrayList<Integer> lis2 = new ArrayList<Integer>(map.values());
for (Integer i : lis2) {
	System.out.print(i);
}
	}

}
