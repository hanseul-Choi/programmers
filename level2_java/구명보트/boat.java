import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);       
        
        int people_len = people.length;      
        int end = 0;
        
        for(int i=people_len-1; i >= end; i--) {
            if(people[i] + people[end] <= limit) {
                end++;
            }
            answer++;
        }
                
        return answer;
    }
}