import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int triangle_row = triangle.length;        
        int[][] dp = new int[triangle_row][triangle_row];
        
        dp[0][0] = triangle[0][0];
        
        for(int i=0; i<triangle_row-1; i++) {
            for(int j=0; j<=i; j++) {
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + triangle[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + triangle[i+1][j+1]);
            }
        }
        
        int max = 0;
        
        for(int i=0; i<triangle_row; i++) {
            if(max < dp[triangle_row-1][i]) max = dp[triangle_row-1][i];    
        }
        
        return max;
    }
}