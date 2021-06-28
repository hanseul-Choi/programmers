// class Solution { 
//     public char[] jinsu = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    
//     public String solution(int n, int t, int m, int p) {                
//         String say = "";
        
//         for(int i=0; ; i++) {
//             int tmp = i;
            
//             String s = "";            
//             if(tmp == 0) s += jinsu[tmp];
            
//             while(tmp != 0) {
//                 int num = tmp % n;
//                 tmp /= n;
//                 s = jinsu[num] + s;
//             }      
            
//             say += s;
            
//             if(say.length() > t*m) break;
//         }        
               
//         String answer = "";
                
//         for(int i=p-1;;i+=m) {
//             if(answer.length() == t) break;
            
//             answer += say.charAt(i);
//         }
                
//         return answer;
//     }
// }

import java.util.*;

class Solution {
  static char[] numeralSystem = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};    
  public String solution(int n, int t, int m, int p) {
      String answer = "";
      char[] sequence = new char[t * m];
      Stack<Character> stack = new Stack<>();
      int count = 0;
        int number = 0, temp = number;
        int limit = m * t;

        while(count < limit) {
            if(temp < n) {
                sequence[count++] = numeralSystem[temp];
                while(!stack.isEmpty() && count < limit) {
                    sequence[count++] = stack.pop();
                }
                temp = ++number;
            }else {
                stack.push(numeralSystem[temp % n]);
                temp /= n;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = p - 1; i < sequence.length; i+=m) {
            sb.append(sequence[i]);
        }
      return answer = sb.toString();
  }
}