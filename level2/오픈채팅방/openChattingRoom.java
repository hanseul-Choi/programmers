import java.util.*;

class Solution {
    public String[] solution(String[] record) {        
        ArrayList<String> al = new ArrayList<>();
        
        HashMap<String, String> hm = new HashMap<>();
        
        int record_len = record.length;
        
        for(int i=0; i<record_len; i++) {
            String[] str = record[i].split(" ");
            
            if(str[0].equals("Enter")) {                
                hm.put(str[1], str[2]);                
            } else if(str[0].equals("Change")) {
                hm.put(str[1], str[2]);
            }            
        }
        
        for(int i=0; i<record_len; i++) {
            String[] str = record[i].split(" ");
            
            if(str[0].equals("Enter")) {
                al.add(hm.get(str[1]) + "님이 들어왔습니다.");
            } else if(str[0].equals("Leave")) {
                al.add(hm.get(str[1]) + "님이 나갔습니다.");
            }
        }
        
        int al_len = al.size();
        
        String[] answer = new String[al_len];
        
        for(int i=0; i<al_len; i++) {
            answer[i] = al.get(i);    
        }   
        
        return answer;
    }
}