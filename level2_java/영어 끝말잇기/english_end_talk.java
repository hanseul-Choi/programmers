import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        HashSet<String> hs = new HashSet<>();
        
        int words_len = words.length;
                        
        Character last = words[0].charAt(0);
        int cnt = 0;
        
        for(int i=0; i<words_len; i++) {
            String cur = words[i];
                                    
            if(last != cur.charAt(0)) break;            
            last = cur.charAt(cur.length() - 1);
            
            if(hs.contains(cur)) break;
            else hs.add(cur);    
            
            if(cur.length() == 1) break;
            
            cnt++;
        }
        
        if(cnt != words_len) {
            answer[0] = (cnt+1) % n;
            if(answer[0] == 0) answer[0] = n;
            
            answer[1] = (cnt / n) + 1;
        }
        
        return answer;
    }
    
}