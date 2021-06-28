import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE; 
        
        String[] s_set = s.split(" ");
        int s_len = s_set.length;
        //int[] arr = new int[s_len]; 
        
        for(int i=0; i<s_len; i++) {
            int tmp = Integer.parseInt(s_set[i]);
            if(tmp > max) max = tmp;
            if(tmp < min) min = tmp;
            //arr[i] = Integer.parseInt(s_set[i]);
        }
        
        //Arrays.sort(arr);
        
        //answer += arr[0] + " " + arr[s_len-1];        
        
        answer += min + " " + max;
        
        return answer;
    }
}