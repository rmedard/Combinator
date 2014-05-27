import java.util.List;
import java.util.Map;


public class TestIt {

	public static void main(String[] args) {
		Combinator comb = new Combinator();
		Map<Integer, List<int[]>> combinations = comb.combine(6);
		System.out.println(combinations.size());
		for(int i = 0; i < combinations.size(); i++){
			for(int j = 0; j < combinations.get(i).size(); j++){
				
			}
		}
	}

}
