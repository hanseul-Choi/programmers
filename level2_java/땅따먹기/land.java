import java.util.*;

class Solution {        
    int solution(int[][] land) {
        int answer = 0;
              
        int land_row = land.length;             
        
        for(int i=1; i<land_row; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }
                 
        return Math.max(Math.max(land[land_row-1][0],land[land_row-1][1]), Math.max(land[land_row-1][2], land[land_row-1][3]));
    }
    
}