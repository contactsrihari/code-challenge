package com.guruintech.codility.practice;
import java.math.BigInteger;

/**
 ** 
 *  challenge source: codility.com/demo/take-sample-test/ 
 *	A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e. 

		A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
		
		Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.
		
		For example, consider the following array A consisting of N = 8 elements:
		
		  A[0] = -1
		  A[1] =  3
		  A[2] = -4
		  A[3] =  5
		  A[4] =  1
		  A[5] = -6
		  A[6] =  2
		  A[7] =  1
		P = 1 is an equilibrium index of this array, because:
		
		A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7]
		P = 3 is an equilibrium index of this array, because:
		
		A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7]
		P = 7 is also an equilibrium index, because:
		
		A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0
		and there are no elements with indices greater than 7.
		
		P = 8 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.
		
		Write a function:
		
		class Solution { public int solution(int[] A); }
		
		that, given a zero-indexed array A consisting of N integers, returns any of its equilibrium indices. The function should return −1 if no equilibrium index exists.
		
		For example, given array A shown above, the function may return 1, 3 or 7, as explained above.
		
		Assume that:
		
		N is an integer within the range [0..100,000];
		each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
		Complexity:
		
		expected worst-case time complexity is O(N);
		expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
		Elements of input arrays can be modified.
 * 
 * @author srihari
 *
 */
public class EquilibriumIndexPoint {

	public static void main(String[] args) {
		int a[] = new int[] {-1, 3, -4, 5, 1, -6, 2, 1};
		
		EquilibriumIndexPoint test1 = new EquilibriumIndexPoint();
		System.out.println(test1.solution(a));
	}
	
	//verified : correctness/performance/scored 100% / 100% / 100
    public int solution(int[] A) {
    	if (A.length == 0) {    		
    		return -1;
    	} else if (A.length == 0) {
    		return 0;
    	}
    	
    	BigInteger left = BigInteger.ZERO;
    	BigInteger right = BigInteger.ZERO;
    	for (int i=1; i<A.length; i++) {
    		right = right.add(BigInteger.valueOf(A[i]));    		
    	}
    	
    	if (right.signum() == 0) {
    		return 0;
    	}
    	
    	int maxIndex = A.length - 1;
    	for (int i=1; i<maxIndex; i++) {
    		left = left.add(BigInteger.valueOf(A[i-1]));
    		right = right.subtract(BigInteger.valueOf(A[i]));
			if (left.compareTo(right) == 0 ){
				return i;
			}
    	}
    	left = left.add(BigInteger.valueOf(A[maxIndex-1]));
    	if (left.signum()  == 0) {
    		return maxIndex;
    	}
    	
    	return -1;
    }	
}
