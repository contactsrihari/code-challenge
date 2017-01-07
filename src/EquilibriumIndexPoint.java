import java.math.BigInteger;

public class EquilibriumIndexPoint {

	public static void main(String[] args) {
		int a[] = new int[] {-1, 3, -4, 5, 1, -6, 2, 1};
		
		EquilibriumIndexPoint test1 = new EquilibriumIndexPoint();
		System.out.println(test1.solution(a));
	}
	
	//100% 100% 100
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
