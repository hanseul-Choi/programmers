import java.util.*;

class Solution {
    HashMap<String, Integer> wear = new HashMap<>(); 
    
    public int solution(String[][] clothes) {  
        int clothes_len = clothes.length;
        
        for(int i=0; i<clothes_len; i++) {
            if(wear.containsKey(clothes[i][1])) {
                wear.put(clothes[i][1], wear.get(clothes[i][1]) + 1);
            } else {
                wear.put(clothes[i][1], 1);
            }            
        } 
        
        //조합 만들기        
        int answer = 1;
        
        for(String s : wear.keySet()) {
            answer *= wear.get(s) + 1;            
        }      
        
        return answer - 1;
    }
}