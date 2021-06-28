import java.util.*;

class Solution {
    public int[][] pictures;
    public boolean[][] visit;
    public int M,N;
    public int maxSize = 0;
    public int areaSize;
    public int[] dx = {0, 0, -1, 1};
    public int[] dy = {-1, 1, 0, 0};
    
    public class Node{
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(int m, int n, int[][] picture) {                
        
        M = m;
        N = n;
        
        visit = new boolean[m][n];
        pictures = picture;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visit[i][j] && picture[i][j] != 0) {
                    int val = bfs(i, j);
                    if(val > maxSize) {
                        maxSize = val;
                    }
                    areaSize++;
                }
            }
        }
        
        int[] answer = new int[2];
        
        answer[0] = areaSize;
        answer[1] = maxSize;
        
        return answer;
    }
    
    public int bfs(int startY, int startX) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY));
        visit[startY][startX] = true;
        int cnt = 1;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            for(int i=0; i<4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if(visit[nextY][nextX] || pictures[nextY][nextX] != pictures[cur.y][cur.x]) continue;
                
                q.add(new Node(nextX, nextY));
                visit[nextY][nextX] = true;
                cnt++;
            }
        }
        
        return cnt;
    }
}