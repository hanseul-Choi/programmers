import java.util.*;

class Solution {
    public boolean[][][][] visit = new boolean[11][11][11][11];
    public int answer = 0;
    
    public class Node {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
           
    public int solution(String dirs) {
        
        move(5,5,dirs);        
        
        return answer;
    }  
    
    public void move(int starty, int startx, String dir) {
                
        for(int i=0; i<dir.length(); i++) {
            char c = dir.charAt(i);
            int nextx = startx;
            int nexty = starty;
                        
            switch(c) {
                case 'U':
                    nexty++;
                    break;
                case 'D':
                    nexty--;
                    break;
                case 'L':
                    nextx--;
                    break;
                case 'R':
                    nextx++;
                    break;
            }
                        
            if(nexty < 0) {
                nexty = 0;
                continue;
            } else if(nexty > 10) {
                nexty = 10;
                continue;
            } else if(nextx < 0) {
                nextx = 0;
                continue;
            } else if(nextx > 10) {
                nextx = 10;
                continue;
            } 
                        
            if(visit[starty][startx][nexty][nextx] || visit[nexty][nextx][starty][startx]) {
                startx = nextx;
                starty = nexty; 
                continue;
            } 
            
            
            visit[starty][startx][nexty][nextx] = true;
            visit[nexty][nextx][starty][startx] = true;
            startx = nextx;
            starty = nexty; 
            answer++;            
        }
    }
}