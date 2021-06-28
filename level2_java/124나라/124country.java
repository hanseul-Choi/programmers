import java.util.*;

class Solution {
    public String[] one_two_four = {"4", "1", "2"}; 

    public String solution(int n) {
        String answer = "";
        StringBuffer sb = new StringBuffer();

        int rest = 0;

        while(n > 3) {
            if(n%3 == 0) {
                sb.append(one_two_four[n%3]); 
                n= n/3 - 1;
            } else {
                sb.append(one_two_four[n%3]); 
                n= n/3;
            }            
        } 
        sb.append(one_two_four[n%3]);

        answer = sb.reverse().toString();

        return answer;
    }
}