import java.util.*;

class Solution {
    public class Node {
        int loc;
        int v;
        
        Node(int loc, int v) {
            this.loc = loc;
            this.v = v;
        }
    }
      
    public int solution(int[] priorities, int location) {
        int answer = 0;
                
        int priorities_len = priorities.length;
        Queue<Node> q = new LinkedList<>();
        
        for(int i=0; i<priorities_len; i++) {
            q.add(new Node(i, priorities[i]));                
        }
        
        Integer[] loc = new Integer[priorities_len]; 
        
        for(int i=0; i<priorities_len; i++) loc[i] = priorities[i];
        
        Arrays.sort(loc, Collections.reverseOrder());
                
        while(!q.isEmpty()) {
            Node cur = q.poll();            
            
            if(cur.v == loc[answer]) {                
                answer++;
                
                if(cur.loc == location) {
                    return answer;
                }
            } else {
                q.add(cur);
            }            
        }
        
        return answer;
    }
}