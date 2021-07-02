import java.util.*;

// priorityqueu방식 -> 테케 6,7,8,9 시간초과
// class Solution {
//     public class Wait implements Comparable<Wait>{
//         int t; //시간 정보
//         long dur_t; // 지금까지 곱해진 시간정보
        
//         Wait(int t, long dur_t) {
//             this.t = t;
//             this.dur_t = t;
//         }
        
//         @Override
//         public int compareTo(Wait o) {                        
//             return Long.valueOf(this.dur_t - o.dur_t).intValue();
//         }
//     }
    
//     public long solution(int n, int[] times) {
//         long answer = 0;
//         int times_len = times.length;
//         PriorityQueue<Wait> pq = new PriorityQueue<>();
        
//         for(int i=0; i<times_len; i++) {
//             pq.add(new Wait(times[i], times[i]));
//         }
        
//         n--; //처음을 빼준 이유는 초기에 들어오는 시간을 구한 값
//         while(n > 0) {
//             Wait cur = pq.poll();
//             cur.dur_t += cur.t;
            
//             n--;
            
//             pq.add(cur);            
//         }
        
//         return pq.poll().dur_t;
//     }
// }

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        int times_len = times.length;
        
        long sum = 0; // 총 심사위원의 수
        long left = 0;
        long right = (long)n * times[times_len - 1]; //최대의 시간
        long mid = (left + right) / 2; 
        
        //방식? 이분탐색을 이용하여 시간을 두어 심사위원 수 체크 
        //심사위원 수 가 최소여도 시간을 기준으로 계속 탐색해 최적의 시간 구하기
        
        while(left <= right) {            
            for(int i=0; i<times_len; i++) {
                sum += mid/times[i]; //심사위원이 체크 가능한 사람 수를 더함
            }
            
            if(sum < n) {//가능한 사람 수가 적은 경우
                left = mid + 1;
            } else { //가능한 사람을 초과한 경우
                right = mid - 1;
                answer = mid;  
            } 
            
            mid = (left + right) / 2;
            sum = 0;
        }
        
        return answer;
    }
}