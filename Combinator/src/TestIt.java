import java.util.List;
import java.util.Map;

public class TestIt {

	public static void main(String[] args) {
		Combinator comb = new Combinator();
		Map<Integer, List<int[]>> combinations = comb.combine(6);
		System.out.println(combinations.size());
		for (int i = 0; i < combinations.size(); i++) { // To get to map row
			for (int j = 0; j < combinations.get(i).size(); j++) { // To get to
																	// list in
																	// map row
				for (int k = 0; k < combinations.get(i).get(j).length; k++) {
					System.out.print(combinations.get(i).get(j)[k] + " ");
				}
				System.out.println();
			}
			System.out.println("Map row ------" + i);
		}
	}

}
