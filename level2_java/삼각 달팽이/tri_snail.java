class Solution {
    public int[] solution(int n) {        
        int[][] tri = new int[n+1][n+1];
        
        int cnt = 1;
        int k = n;
        int x = 0, y = 1;
        
        for(int i=1; i<=n; i++) { 
            for(int j=i; j<=n; j++){
                if(i%3 == 1) {
                    x++;
                } else if(i%3 == 2) {
                    y++;
                } else {
                    x--;
                    y--;
                }
                tri[x][y] = cnt++;                
            }            
        }
        
        int[] answer = new int[(n*(n+1))/2];
        
        int tmp = 0;
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                answer[tmp] = tri[i][j];
                tmp++;
            }            
        }
        
        return answer;
    }
}