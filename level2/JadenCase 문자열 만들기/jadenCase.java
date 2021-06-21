class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] s_set = s.split(" ");
        int s_len = s_set.length;               
        
        for(int i=0; i<s_len; i++) {            
            if(s_set[i].equals("")) {
                answer += " ";
            } else {
                char first = s_set[i].charAt(0);
                
                if(first >= 97 && first <= 122) {
                    first -= 32;
                }
                
                answer += first + s_set[i].substring(1, s_set[i].length()).toLowerCase() + " ";               
            }            
        }        
            
        if(s.charAt(s.length()-1) != ' ') answer = answer.substring(0, answer.length() - 1);  
        
        return answer;
    }
}