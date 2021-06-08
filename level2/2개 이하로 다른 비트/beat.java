class Solution {
    public long[] solution(long[] numbers) {
        int numbers_len = numbers.length;
        long[] answer = new long[numbers_len];
                
        for(int i=0; i<numbers_len; i++) {  
            if(numbers[i] % 2 == 0) answer[i] = numbers[i] + 1;
            else {
                String bString = Long.toBinaryString(numbers[i]);
                int zero_idx =  bString.lastIndexOf("0");
                int one_idx = bString.indexOf("1", zero_idx);
                
                if(zero_idx == -1) {
                    numbers[i]++;
                    bString = Long.toBinaryString(numbers[i]);
                    bString = bString.substring(0, 2) + bString.substring(2, bString.length()).replace("0", "1");
                } else {
                    bString = bString.substring(0, zero_idx) + "1" + bString.substring(zero_idx+1, one_idx) + "0" + bString.substring(one_idx+1, bString.length());
                }
                
                answer[i] = Long.parseLong(bString, 2);
            }
        }
        
        return answer;
    }    
}