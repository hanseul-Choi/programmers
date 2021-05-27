import java.util.*;

class Solution {
    public String solution(String p) {
                
        return check(p);
    }      
    
    public String check(String s) {
        int s_len = s.length();
        
        if(s_len == 0) return s;
        
        int cnt = 0;
        int pos = 0;
        
        for(int i=0; i<s_len; i++) {
            char cur = s.charAt(i);
            
            if(cur == '(') cnt++;
            else if(cur == ')') cnt--;
            
            if(cnt == 0) {
                pos = i;
                break;  
            } 
        }
        
        String u = s.substring(0,pos+1);
        String v = s.substring(pos+1,s_len);
        
        System.out.println("u : " + u + " , v : " + v);
        if(Correct(u)) {
            u += check(v);           
            return u;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(check(v));
            sb.append(")");
            
            u = u.substring(1,u.length()-1);
            int u_len = u.length();
            
            for(int i=0; i<u_len; i++) {
                char cur = u.charAt(i);
                if(cur == '(') sb.append(")");
                else if (cur == ')') sb.append("(");
            }
            
            return sb.toString();
        }       
    }
    
    public boolean Correct(String u) {
        int u_len = u.length();
        
        int cnt = 0;
        for(int i=0; i<u_len; i++) {
            char cur = u.charAt(i);
            
            if(cur == '(') cnt++;
            else if(cur == ')') cnt--;
            
            if(cnt < 0) return false;
        }
        
        return true;        
    }
}