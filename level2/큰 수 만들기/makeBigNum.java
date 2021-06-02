import java.util.*;

class Solution {
        
    public String solution(String number, int k) {        
        StringBuilder sb = new StringBuilder();
               
        int number_len = number.length();
        
        int idx = 0;
        char max;
        int end = number_len - k;
        
        if(number.charAt(0) == '0') return "0";
        
        for(int i = 0; i < number.length() - k; i++) {
            max = '0';
            for(int j = idx; j <= k + i; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j); 
                    idx = j + 1;
                }
            }			
            sb.append(max);
        }
            
        return sb.toString();
    }
    
}