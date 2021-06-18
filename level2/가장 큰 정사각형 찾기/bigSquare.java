class Solution {
    public int board_row;
    public int board_col;
    
    public int[][] dp;
    
    public class Node {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] board) {
        board_row = board.length;
        board_col = board[0].length;
        
        dp = new int[board_row][board_col];
        
        for(int i=0; i<board_col; i++) dp[0][i] = board[0][i]; //초기화 작업
        
        for(int i=1; i<board_row; i++) {
            for(int j=0; j<board_col; j++) {
                if(j == 0) {
                    dp[i][j] = board[i][j];
                    continue;
                }
                
                if(board[i][j-1] == 1 && board[i-1][j-1] == 1 && board[i-1][j] == 1 && board[i][j] == 1) { //보드상에서 왼쪽, 왼쪽위, 위가 1인 경우
                    if(dp[i][j-1] == dp[i-1][j-1] && dp[i-1][j-1] == dp[i-1][j]) { // dp 상에서 왼쪽, 왼쪽위, 위가 다 같은 경우
                        dp[i][j] = dp[i][j-1] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j], dp[i][j-1])) + 1; //dp가 다르면 가장 작은 수 +1로 저장
                    }                    
                } else {
                    dp[i][j] = board[i][j];
                }
            }
        }
             
        int max = 0;
        
        for(int i=0; i<board_row; i++) {
            for(int j=0; j<board_col; j++) {
                if(max < dp[i][j]) max = dp[i][j];
            }          
        }
        
        return max * max;
    }
}