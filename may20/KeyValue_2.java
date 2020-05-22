package may20;

import java.util.LinkedHashMap;
import java.util.Map;

public class KeyValue_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		map.put('A', 1);
		map.put('B', 2);
		map.put('C', 3);
		map.put('D', 4);
		map.put('E', 5);
		for (Map.Entry<Character, Integer> i : map.entrySet()) {
			System.out.println(i.getKey()+" = "+i.getValue());
		}
		
	}

}
