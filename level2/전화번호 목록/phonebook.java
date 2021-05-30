import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        int phone_book_len = phone_book.length;
        
        Arrays.sort(phone_book, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });
        
        for(int i=0; i<phone_book_len; i++) {
            String cur = phone_book[i];
            int cur_len = cur.length();
            
            for(int j=0; j<cur_len; j++) {
                String s = cur.substring(0,j+1);
                if(hm.containsKey(s)) {
                    answer = false;
                    return answer;
                } 
            }  
            
            hm.put(cur, 0);
        }
        
        return answer;
    }
}