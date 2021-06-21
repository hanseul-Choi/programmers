import java.util.*;

class Solution {
    public int[] dp = new int[100001];
    
    public int solution(int n) {
                
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        dp[1] = 1;
        
        return fibonacci(n) % 1234567;
    }
    
    public int fibonacci(int n) {
        if(dp[n] == Integer.MAX_VALUE) {
            return dp[n] = (fibonacci(n-1) + fibonacci(n-2)) % 1234567;
        }
        
        return dp[n];
    }
}