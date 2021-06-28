import java.util.*;

class Solution {  
    public int ans = 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
       
        bfs(numbers, target, 0, 0);
        answer = ans;
        
        return answer;
    }
    
    public void bfs(int[] number, int goal, int cnt, int sum) {
        if(cnt == number.length) {      
            if(sum == goal) {
                ans++;
            }
            
            return;
        }
        
        sum += number[cnt];
        bfs(number, goal, cnt+1, sum);
        sum -= number[cnt];
        
        sum -= number[cnt];
        bfs(number, goal, cnt+1, sum);        
    }
}