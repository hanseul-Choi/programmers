import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> al = new ArrayList<>();    
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i=1; i<=26; i++) {
            hm.put(Character.toString(64 + i), i);            
        }
        
        int idx = 0;
        int out = 27;
        
        String w = "";
        
        int[] answer;
            
        if(msg.length() == 1) {
            answer = new int[1];
            answer[0] = hm.get(msg);
        } else {
            while(true) {
                w += msg.charAt(idx);            
                Character c = msg.charAt(idx+1);

                if(idx+1 == msg.length() - 1) {
                    if(hm.containsKey(w+c)) {
                        al.add(hm.get(w+c));
                    } else {
                        al.add(hm.get(w));
                        al.add(hm.get(Character.toString(c)));
                    }                                    
                    break;
                }

                if(!hm.containsKey(w + c)) {            
                    hm.put(w+c, out);
                    al.add(hm.get(w));
                    out++;
                    w = "";
                }

                idx++;
            }


            int al_size = al.size();
            answer = new int[al_size];

            for(int i=0; i<al_size; i++) answer[i] = al.get(i);
        }
        
        return answer;
    }
}