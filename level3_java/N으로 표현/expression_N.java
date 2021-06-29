class Solution {
    public int min = Integer.MAX_VALUE;
    public int n,num;
    
    public int solution(int N, int number) {
        int answer = 0;
        n = N;
        num = number;     
        
        recursive(0, 0);
        
        if(min == Integer.MAX_VALUE) answer = -1;
        else answer = min;

        return answer;
    }
    
    public void recursive(int sum, int cnt) {
        if(cnt > 8) return; //cnt가 8보다 크면 return
        
        if(sum == num) { //sum이 같다면 정답
            if(min > cnt) min = cnt; 
            
            return;
        }
                  
        int tmp = 0;
        // *, +, -, / 진행
        for(int i=1; i<=8; i++) {
            tmp = tmp * 10 + n;
            
            recursive(sum*tmp, cnt+i);
            recursive(sum+tmp, cnt+i);
            recursive(sum-tmp, cnt+i);
            recursive(sum/tmp, cnt+i);
        }          
          
    }
}