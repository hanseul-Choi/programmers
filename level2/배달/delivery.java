import java.util.*;

class Solution {
    public class Node implements Comparable<Node>{
        int s;        
        int v;
        
        Node(int s, int v) {
            this.s = s;
            this.v = v;
        }
        
        @Override
        public int compareTo(Node a) {
            return this.v - a.v;
        }
    }
    
    public int solution(int N, int[][] road, int K) {        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N+1]; //방문 체크
        int[] dist = new int[N+1]; // 최솟값 계산 배열
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        int road_len = road.length;
        int[][] val = new int[N+1][N+1];       
        
        for(int i=0; i<road_len; i++) {
            if(val[road[i][0]][road[i][1]] != 0 && val[road[i][0]][road[i][1]] < road[i][2]) continue;
            
            val[road[i][0]][road[i][1]] = road[i][2];
            val[road[i][1]][road[i][0]] = road[i][2];
        }
                
        pq.add(new Node(1,0));
        dist[1] = 0;
        
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.s;       
            
            if(!check[cur]) check[cur] = true;
            else continue;
            
            for(int i=1; i<=N; i++) {
                if(val[cur][i] != 0) {                    
                    if(dist[i] > dist[cur] + val[cur][i]) {
                        dist[i] = dist[cur] + val[cur][i];
                        pq.add(new Node(i, dist[i]));
                    }
                }
            }
        }
        
        int answer = 0;
        
        for(int i=1; i<dist.length; i++) {
            if(dist[i] <= K) answer++;
        }
        
        return answer;
    }
}