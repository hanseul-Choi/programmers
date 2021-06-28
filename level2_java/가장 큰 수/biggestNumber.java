import java.util.*;

class Solution {
    
    public class Number implements Comparable<Number>{
        String num;
        
        Number(String num) {
            this.num = num;
        }
        
        @Override
        public int compareTo(Number n) {
            int a_num = Integer.parseInt((n.num + this.num));
            int b_num = Integer.parseInt((this.num + n.num));
            
            return a_num - b_num;                        
        }
    }
    
    public String solution(int[] numbers) {
        String answer = ""; 
        int numbers_len = numbers.length;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Number> pq = new PriorityQueue<>();
        
        for(int i=0; i<numbers_len; i++) {
            pq.add(new Number(Integer.toString(numbers[i])));
        }
        
        int pq_size = pq.size();
        for(int i=0; i<pq_size; i++) {
            sb.append(pq.poll().num);
        }
        
        answer = sb.toString();
        
        if(answer.charAt(0) == '0') {
            answer = "0";
        }
        
        return answer;
    }
}