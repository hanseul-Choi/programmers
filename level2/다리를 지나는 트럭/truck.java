import java.util.*;

class Solution {
    public static Queue<Integer> bridge = new LinkedList<>();
       
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge_weight = 0;       
       
        for(int t : truck_weights) {
            while(true) {
                if(bridge.isEmpty()) {
                    bridge.add(t);
                    bridge_weight += t;
                    answer++;
                    break;
                } else if(bridge_length == bridge.size()) {
                    bridge_weight -= bridge.poll();                    
                } else {
                    if(bridge_weight + t > weight) {
                        bridge.add(0);
                        answer++;
                    } else {
                        bridge.add(t);
                        bridge_weight += t;
                        answer++;
                        break;
                    }
                }
            }
        }
        
        answer += bridge_length;
        
        return answer;
    }
   
}