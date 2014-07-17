import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.util.Combinations;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

class Combinator {

	// Combination without repetition
	public Map<Integer, List<int[]>> numberCombine(int count) {
		Map<Integer, List<int[]>> combinations = new HashMap<>();
		for (int i = 0; i < count; i++) {
			Iterator<int[]> it = new Combinations(count, i).iterator();
			List<int[]> combined = new ArrayList<>();
			while (it.hasNext()) {
				combined.add(it.next());
			}
			combinations.put(i, combined);
		}
		return combinations;
	}

	// Permutations with repetition
	public Map<Integer, List<int[]>> operatorCombine(int count) {
		Map<Integer, List<int[]>> combinations = new HashMap<>();
		ICombinatoricsVector<Integer> operatorsVectors = Factory
				.createVector(new Integer[] { 0, 1, 2, 3 });
		for (int operatorCount = 1; operatorCount <= 5; operatorCount++) {
			Generator<Integer> gen = Factory
					.createPermutationWithRepetitionGenerator(operatorsVectors,
							operatorCount);

			Iterator<ICombinatoricsVector<Integer>> it = gen.iterator();
			List<ICombinatoricsVector<Integer>> gens = gen.generateAllObjects();
			System.out.println("Permutations za " + operatorCount + " ni "
					+ gens.size());
			while (it.hasNext()) {
				for (Integer i : it.next()) {
					System.out.print(i.intValue() + " ");
				}
				System.out.println();
			}
		}
		return null;
	}

}