class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int all = brown + yellow;
        
        for(int i=3; i<=all; i++) {
            if(all % i == 0) {
                int col = i;
                int row = all / i;
                
                int y_col = col-2;
                int y_row = row-2;
                
                if(y_col >= y_row) {
                    if(y_col * y_row == yellow) {
                        return new int[] {col, row};
                    }
                }
            }
        }
        
        return answer;
    }
}