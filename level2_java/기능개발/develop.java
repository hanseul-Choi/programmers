import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {              
        ArrayList<Integer> al = new ArrayList<>();
        int progress_len = progresses.length;
    
        int cur = 0;
        int cnt = 0;
        
        while(true) {            
            for(int i=cur; i<progress_len; i++) {
                progresses[i] += speeds[i];
            }
        
            if(progresses[cur] >= 100) {
                for(int i=cur; i<progress_len; i++) {
                    if(progresses[i] >= 100) {
                        cnt++;
                        
                        if(i == progress_len-1) {
                            cur = i;
                        }
                    } else {
                        cur = i;
                        break;
                    }
                }
                
                al.add(cnt);
                cnt = 0;
            }
            
            if(cur >= progress_len-1) break;
        }
        
        if(progresses[cur] < 100) al.add(1);
        
        int al_size = al.size();
        int[] answer = new int[al_size];
        
        for(int i=0; i<al_size; i++) {
            answer[i] = al.get(i);
        }
        
        return answer;
    }
}