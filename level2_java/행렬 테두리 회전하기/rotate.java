import java.util.*;

class Solution {
    public int[][] map;
    public int[][] map2;
    public ArrayList<Integer> al = new ArrayList<>();
    
    public int[] solution(int rows, int columns, int[][] queries) {        
        
        map = new int[rows][columns]; 
        map2 = new int[rows][columns];
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                map[i][j] = i*columns + j + 1;
            }
        }        
                
        int quer_row = queries.length;        
        
        for(int i=0; i<quer_row; i++) {            
            rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3], rows, columns);
        }       
        
        int al_size = al.size();
        int[] answer = new int[al_size];

        for(int i=0; i<al_size; i++) {
            answer[i] = al.get(i);
        }               
        
        return answer;
    }
    
    public void rotate(int x1, int y1, int x2, int y2,int row, int col) {      
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        
        //map2 복사
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) map2[i][j] = map[i][j];
        }
        
        //위쪽 rotate
        for(int i=y1; i<y2; i++) {
            map[x1-1][i] = map2[x1-1][i-1];
            pq2.add(map[x1-1][i]);
        }
        
        
        //오른쪽 rotate
        for(int i=x1-1; i<x2-1; i++) {
            map[i+1][y2-1] = map2[i][y2-1];
            pq2.add(map[i+1][y2-1]);
        }
        
        //아래쪽 rotate
        for(int i=y2-1; i>y1-1; i--) {
            map[x2-1][i-1] = map2[x2-1][i];
            pq2.add(map[x2-1][i-1]);
        }
        
        //왼쪽 rotate
        for(int i=x2-1; i>x1-1; i--) {
            map[i-1][y1-1] = map2[i][y1-1];
            pq2.add(map[i-1][y1-1]);
        }
        
        al.add(pq2.poll());
    }
}