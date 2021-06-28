import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
       
        answer = up_down(name) + left_right(name);
        
        return answer;
    }
   
    public int up_down(String n) {
        char[] c = n.toCharArray();
        int c_len = c.length;
        
        int cnt = 0;
        
        for(int i=0; i<c_len; i++) {
            if(c[i] <= 78) {
                cnt += (int)c[i] - 65;
            } else {
                cnt+= 90 - (int)c[i] + 1;
            }
        }
        
        return cnt;
    }
    
    public int left_right(String n) {
        char[] c = n.toCharArray();
        int c_len = c.length;
        
        int r_cnt = 0;
        int l_cnt = 0;
        
        //오른쪽 방향
        for(int i=0; i<c_len; i++) {
            if(c[i] == 'A') continue;
            else r_cnt = i;
        }
        
        //왼쪽 방향
        for(int i=1; i<c_len; i++) {
            if(c[i] == 'A') continue;
            else {
                l_cnt = c_len - i;
                break;
            }
        }
        
        //왼쪽으로 갔다가 다시 오른쪽으로 가는 경우
        int start = 0;
        int end = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<c_len; i++) {
            if(c[i] == 'A') { 
                start = i;
                for(int j=i; j<c_len; j++) {
                    if(c[j] == 'A') continue;
                    else {
                        end = j;
                        break;
                    }
                }
                break;
            }           
        }
        
        String s = n.substring(0,start) + n.substring(end, n.length()); 
        
        int cnt = s.length();
        
        cnt = Math.min(Math.min(l_cnt, r_cnt), cnt);
        
        return cnt;
    }
}