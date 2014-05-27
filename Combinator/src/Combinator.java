import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.util.Combinations;


class Combinator {
	
	private Map<Integer, List<int[]>> combinations = new HashMap<>();
	
	public Map<Integer, List<int[]>> combine(int count){
		for(int i = 0; i < count; i++){
			Iterator<int[]> it = new Combinations(count, i).iterator();
			List<int[]> combined = new ArrayList<>();
			while(it.hasNext()){
				combined.add(it.next());
			}
			combinations.put(i, combined);
		}
		return combinations;
	}
	
}	