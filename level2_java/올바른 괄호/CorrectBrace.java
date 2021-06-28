import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        char[] s_set = s.toCharArray();
        int s_len = s_set.length;
                
        Queue<Character> q = new LinkedList<>();
        
        for(int i=0; i<s_len; i++) {
            if(s_set[i] == '(') q.add('(');
            else if(s_set[i] == ')') {
                if(q.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    q.poll();
                }
            }                                 
        }

        if(!q.isEmpty()) answer = false;
        
        return answer;
    }
}