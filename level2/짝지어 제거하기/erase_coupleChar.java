import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;      
        int s_len = s.length();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s_len; i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                Character last = stack.peek();
                Character cur = s.charAt(i);
                
                if(last == cur) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            }
        }
        
        if(stack.isEmpty()) {
            answer = 1;
        }
              
        return answer;
    }
}