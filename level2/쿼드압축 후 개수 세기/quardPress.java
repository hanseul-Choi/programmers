import java.util.*;

class Solution {
    public int[] answer;   
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
                        
        dfs(0, 0, arr.length, arr);
        
        return answer;
    }
    
    public void dfs(int x, int y, int len, int[][] arr) {
        boolean isZero = true;
        boolean isOne = true;
        
        for(int i = x; i < x + len; i++) {
            for(int j = y; j < y + len; j++) {
                if(arr[i][j] == 0) isOne = false;
                if(arr[i][j] == 1) isZero = false;
            }
        }
        
        if(isOne) {
            answer[1]++;
            return;
        }
        
        if(isZero) {
            answer[0]++;
            return;
        }
        
        dfs(x, y, len/2, arr);
        dfs(x + len/2, y, len/2, arr);
        dfs(x, y + len/2, len/2, arr);
        dfs(x + len/2, y + len/2, len/2, arr);
    }    
}