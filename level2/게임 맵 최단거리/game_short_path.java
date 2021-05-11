import java.util.*;

class Solution {
    public static int[] dx = {0, 1, -1, 0};
    public static int[] dy = {-1, 0, 0, 1}; //하 우 좌 상 (유리한 순서대로)
    public static int N,M;
    public static int[][] map;
    public static int[][] visit;
    
    public class Node {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        N = maps.length;
        M = maps[0].length;        
        
        map = maps;
        visit = new int[N][M];       
        
        bfs();
        
        if(visit[N-1][M-1] == 0) {
            answer = -1;
        } else answer = visit[N-1][M-1];
        
        return answer;
    }
    
    public void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        visit[0][0] = 1;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            for(int i=0; i<4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
                if(visit[nextY][nextX] != 0|| map[nextY][nextX] == 0) continue;
                
                q.add(new Node(nextX, nextY));
                visit[nextY][nextX] = visit[cur.y][cur.x] + 1;
            }
        }
    }
}