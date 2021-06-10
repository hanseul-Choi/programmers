import java.util.*;

class Solution {
    public int[] solution(String s) {        
        int zero = 0;
        int cnt = 0;
        
        while(!s.equals("1")) {
            cnt++;
            
            int s_len = s.length();
            StringBuilder sb = new StringBuilder();
            
            // 0 제거
            for(int i=0; i<s_len; i++) {
                if(s.charAt(i) == '1') sb.append("1");
                else zero++;
            }
                      
            s_len = sb.toString().length();
                        
            s = Integer.toBinaryString(s_len);
        }
        
        int[] answer = {cnt, zero};

        return answer;
    }
}