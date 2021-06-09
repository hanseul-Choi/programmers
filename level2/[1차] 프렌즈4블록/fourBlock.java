import java.util.*;

class Solution {
    public Character[][] map;
    public boolean[][] check; 
    public int wx, wy;
    public int[] dx = {1, 1, 0};
    public int[] dy = {0, 1, 1};
    
    public class Node {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        wx = n;
        wy = m;
        
        map = new Character[m][n];  
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) map[i][j] = board[i].charAt(j);
        }
        
        boolean flag = true;
        
        while(flag) {
            flag = false;
            check = new boolean[m][n];
            
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    bfs(j, i);
                }
            }                       
            
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(check[i][j]) {
                        map[i][j] = 'a';
                        flag = true;
                    } 
                }
            }
            
            for(int i=0; i<n; i++) {
                for(int j=m-1; j>=0; j--) {
                    if(map[j][i] == 'a') {
                        for(int k=j-1; k>=0; k--) {
                            if(map[k][i] != 'a') {
                                map[j][i] = map[k][i];
                                map[k][i] = 'a';
                                break;
                            }
                        } 
                    }
                }
            }           
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 'a') answer++;
            }            
        }       
        
        return answer;
    }
    
    public void bfs(int x, int y) {
        Character select = map[y][x];
        ArrayList<Node> al = new ArrayList<>();
        int cnt = 1;
        
        for(int i=0; i<3; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if(nextY < 0 || nextX < 0 || nextY >= wy || nextX >= wx) continue;
            if(select != map[nextY][nextX] || map[nextY][nextX] == 'a') continue;
            
            cnt++;
            al.add(new Node(nextX, nextY));
        }
                
        if(cnt == 4) {
            for(int i=0; i<al.size(); i++) {
                Node cur = al.get(i);                
                check[cur.y][cur.x] = true;
            }
            check[y][x] = true;
        }        
    }
}