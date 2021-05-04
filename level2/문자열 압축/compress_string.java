import java.util.*;

class Solution {
    public int solution(String s) {        
        int s_length = s.length();
        int answer = s.length();
        
        //why? 반절이상 부터는 압축이 불가능
        for(int i=1; i<= s_length/2; i++) {
            int compress = CompressString(s, i);            
            
            if(compress < answer) {
                answer = compress;
            }
        }
        
        return answer;
    }
    
    public int CompressString(String str, int slice) {
        StringBuffer sb = new StringBuffer();
        String last_str = str.substring(0,slice);
        str = str.substring(slice, str.length());
        int cnt = 1;
        
        while(str.length() >= slice) {
            String cur_str = str.substring(0,slice);
            str = str.substring(slice, str.length());
            
            if(last_str.equals(cur_str)) {
                cnt++;
            } else {
                if(cnt == 1) {
                    sb.append(last_str);
                } else {
                    sb.append(cnt);
                    sb.append(last_str);
                    
                    cnt = 1;
                }
                
                last_str = cur_str;
            }
        }
        
        if(cnt == 1) {           
            sb.append(last_str);
            sb.append(str);            
        } else {
            sb.append(cnt);
            sb.append(last_str);            
            sb.append(str);
        }
                
        return sb.toString().length();
    }
}