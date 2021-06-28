import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int s_len = s.length();
        
        for(int i=0; i<s_len; i++) {
            s = s.substring(1, s_len) + s.substring(0,1);
            
            Stack<Character> stack = new Stack<>();
            
            for(int j=0; j<s_len; j++) {
                Character cur = s.charAt(j);
                
                if(cur == '(' || cur == '{' || cur == '[') {
                    stack.push(cur);
                    continue;
                } else {
                    if(stack.isEmpty()) break;
                    else {
                        Character check = stack.pop();
                        
                        if(check == '(') {
                            if(cur != ')') break;
                        } else if(check == '{') {
                            if(cur != '}') break;
                        } else {
                            if(cur != ']') break;
                        }                        
                    }
                }  
                
                if(j == s_len -1 && stack.isEmpty()) answer++;
            }
            
        }
        
        return answer;
    }
}