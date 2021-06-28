class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String binary_n = Integer.toBinaryString(n);
        int n_cnt = Count_one(binary_n);
        
        for(int i=n+1;;i++) {
            if(n_cnt == Count_one(Integer.toBinaryString(i))) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public int Count_one(String s) {
        char[] s_set = s.toCharArray();
        int s_len = s_set.length;
        int cnt = 0;
        
        for(int i=0; i<s_len; i++) {
            if(s_set[i] == '1') cnt++;    
        }
        
        return cnt;
    }
}