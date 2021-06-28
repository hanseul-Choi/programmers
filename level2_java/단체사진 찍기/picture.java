import java.util.*;

class Solution {
    public int[] ch = new int[8];
    public char[] list = new char[8];
    public boolean[] visit = new boolean[8];
    public String[] d;
    public HashMap<Character, Integer> hm = new HashMap<>();
    
    public int ans = 0;
    
    public int solution(int n, String[] data) {
        int answer = 0;        
        
        d = data;
        hm.put('A', 0);
        hm.put('C', 1);
        hm.put('F', 2);
        hm.put('J', 3);
        hm.put('M', 4);
        hm.put('N', 5);
        hm.put('R', 6);
        hm.put('T', 7);
        //조합
        comb(0);
                   
        answer = ans;
        
        return answer;
    }
    
    public void comb(int cnt) {
        if(cnt == 8) {   
            if(check()) ans++;            
            return;
        }
        
        for(int i=0; i<8; i++) {
            if(visit[i]) continue;
            
            visit[i] = true;
            ch[cnt] = i;            
            comb(cnt+1);
            visit[i] = false;
        }
    }
    
    public boolean check() {
        int f1, f2, res;
        char op;
        
        for(String s : d) {
            f1 = ch[hm.get(s.charAt(0))];
            f2 = ch[hm.get(s.charAt(2))];
            op = s.charAt(3);
            res = s.charAt(4) - '0' + 1;
            
            if(op == '=') {
                if(Math.abs(f1 - f2) != res) return false;
            } else if(op == '>') {
                if(Math.abs(f1 - f2) <= res) return false;
            } else {
                if(Math.abs(f1 - f2) >= res) return false;
            }
        }
        
        return true;
    }
}