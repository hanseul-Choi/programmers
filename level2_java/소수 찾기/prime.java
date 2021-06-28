import java.util.*;

class Solution {   
    public String number;
    public int number_len;
    public boolean check[];
    public String ans = "";
    public HashSet<Integer> hs;
    
    public int solution(String numbers) {
        
        number = numbers;
        number_len = number.length();   
        check = new boolean[number_len];
        hs = new HashSet<Integer>();
        
        for(int i=1; i<=number_len; i++) {
            dfs(0, i);
        }
        
        return hs.size();
    }
    
    public void dfs(int cnt, int max) {
        if(cnt == max) {
            Integer tmp = Integer.parseInt(ans); 
            
            if(isPrime(tmp)) hs.add(tmp);      
                
            return;
        }
        
        for(int i=0; i<number_len; i++) {
            if(check[i]) continue;
            check[i] = true;
            ans += number.charAt(i);
            
            dfs(cnt +1, max);
            ans = ans.substring(0, ans.length()-1);
            check[i] = false;
        }        
    }
    
    public boolean isPrime(int num) {
        if(num == 0) return false;
        if(num == 1) return false;
        
        for(int i=2; i*i<=num; i++) {
            if(num%i == 0) return false;
        }
        
        return true;
    }
}