package may20;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class KeyValue_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		map.put('A', 1);
		map.put('B', 2);
		map.put('C', 3);
		map.put('D', 4);
		map.put('E', 5);
		long j =0;
		Iterator<Entry<Character, Integer>> i = map.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry<Character, Integer> pair= i.next();
			
			j += pair.getKey() + pair.getValue();
			
		}
	}

}
