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

	// Permutations with repetition (operators: count = 4)
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
			List<int[]> arrangedInts = new ArrayList<>();
			while (it.hasNext()) {
				int incrementor = 0;
				ICombinatoricsVector<Integer> nextItaration = it.next();
				int[] ints = new int[nextItaration.getSize()];
				for (Integer i : nextItaration) {
					System.out.print(i.intValue() + " ");
					ints[incrementor] = i;
					++incrementor;
				}
				System.out.println("==========================" + ints.length);
				arrangedInts.add(ints);
			}
			combinations.put(operatorCount, arrangedInts);
		}
		return combinations;
	}
	
	// Permutations without repetition (number combinations)
	private List<Integer[]> numberPermutations(Integer[] combination){
		List<Integer[]> combinations = new ArrayList<>();
		ICombinatoricsVector<Integer> permutationsVector = Factory.createVector(combination);
		Generator<Integer> gen = Factory.createPermutationGenerator(permutationsVector);
		Iterator<ICombinatoricsVector<Integer>> it = gen.iterator();
		while(it.hasNext()){
			int incrementor = 0;
			ICombinatoricsVector<Integer> nextIteration = it.next();
			Integer[] ints = new Integer[nextIteration.getSize()];
			for (Integer i : nextIteration) {
				ints[incrementor] = i;
				++incrementor;
			}
			combinations.add(ints);
		}
		
		return combinations;
	}

	//Number combinations permuted
	public Map<Integer, List<Integer[]>> numberCombinationsPermuted(Map<Integer, List<Integer[]>> numberCombinations){
		Map<Integer, List<Integer[]>> finalPermutations = new HashMap<>();
		for(Integer i : numberCombinations.keySet()){
			List<Integer[]> mapRowCombinations = numberCombinations.get(i);
			List<Integer[]> finalMapRowCombinations = new ArrayList<>();
			for (Integer[] js : mapRowCombinations) {
				List<Integer[]> permutedCombs = numberPermutations(js);
				finalMapRowCombinations.addAll(permutedCombs);
			}
			finalPermutations.put(i, finalMapRowCombinations);
		}
		return finalPermutations;
	}
}