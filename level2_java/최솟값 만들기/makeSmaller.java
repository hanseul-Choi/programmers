import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int len = A.length;
        
        Integer[] C = new Integer[len];
        Integer[] D = new Integer[len];        
    
        for(int i=0; i<len; i++) {
            C[i] = A[i];
        }
        
        Arrays.sort(C);
        
        for(int i=0; i<len; i++) {
            D[i] = B[i];
        }
        
        Arrays.sort(D, Collections.reverseOrder());
        
        for(int i=0; i<len; i++) {
            answer += C[i] * D[i];
        }

        return answer;
    }
}