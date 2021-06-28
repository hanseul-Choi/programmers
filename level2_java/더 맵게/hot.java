import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int scoville_len = scoville.length;
        PriorityQueue<Integer> scov = new PriorityQueue<>();
        
        for(int i=0; i<scoville_len; i++) {
            scov.add(scoville[i]);
        }     
        
        int scov1, scov2, new_scov;
        
        while(true) {   
            if(scov.size() < 2 && scov.peek() < K) return -1;
            
            if(scov.peek() < K) {
                scov1 = scov.poll();
                scov2 = scov.poll();
                
                new_scov = scov1 + (scov2 * 2);
                
                scov.add(new_scov);
                answer++;                
            } else {
                break; 
            }  
        }
        
        return answer;
    }    
}