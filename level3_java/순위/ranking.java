class Solution {
    public boolean[][] d;    
    
    public int solution(int n, int[][] results) {       
        int answer = 0;
        
        d = new boolean[n+1][n+1];
        int results_row = results.length;
        
        for(int i=0; i<results_row; i++) {            
            d[results[i][0]][results[i][1]] = true;            
        }
        
        for(int i=1; i<=n; i++) { // i 기준
            for(int j=1; j<=n; j++) {// j 시작점
                for(int k=1; k<=n; k++) { // k 시작점
                    if(d[j][i] && d[i][k]) d[j][k] = true;
                }
            }
        }                        
        for(int i=1; i<=n; i++) {
            int cnt = 0;
            
            for(int j=1; j<=n; j++) {
                if(d[i][j] || d[j][i]) cnt++;
            }
            
            if(cnt == n-1) answer++;
        }
        
        return answer;
    }        
}