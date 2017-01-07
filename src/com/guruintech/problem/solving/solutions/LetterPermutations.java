package com.guruintech.problem.solving.solutions;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string eg. "ABC", finding all permutations 
 * i.e ABC, ACB, BAC, BCA, CAB, CBA * 
 * 
 * this program is based on non-recursion
 * 
 * @author srihari konakanchi
 *
 */
public class LetterPermutations {

	public static void main(String[] args) {
		LetterPermutations stringCombo = new LetterPermutations();
		List<String> permutations = stringCombo.combo("ABC");
		System.out.println(permutations);
	}
	
	public List<String> combo(String s) {
		if (s == null || s.isEmpty()) {
			return Collections.emptyList();
		}
		
		char[] letters = s.toCharArray();
		LinkedList<String> permutations = new LinkedList<>();
		permutations.add(String.valueOf(letters[0]));
		
		for (char letter : s.substring(1,s.length()).toCharArray()) {
			int currentPermutations = permutations.size();
			while (currentPermutations-- > 0) {
				String permutation = permutations.removeFirst();
				permutations.addLast(letter + permutation);
				for (int i=0; i<permutation.length(); i++) {
					String newCombination = permutation.substring(0, i+1) + letter + permutation.substring(i+1);
					permutations.addLast(newCombination);
				}
			}
		}
		
		return permutations;
	}

}
