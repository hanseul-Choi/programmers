class Solution {
    public int[] solution(int[] prices) {
        int prices_len = prices.length;        
        int[] answer = new int[prices_len];
        
        for(int i=0; i<prices_len-1; i++) {
            int cur = prices[i];
            
            int cnt = 0;
            
            for(int j=i+1; j<prices_len; j++) {
                cnt++;
                if(cur > prices[j]) { // 감소하는 경우                    
                    break;  
                } 
            } 
            
            if(cnt != 0) answer[i] = cnt;
        }            
        
        return answer;
    }
}